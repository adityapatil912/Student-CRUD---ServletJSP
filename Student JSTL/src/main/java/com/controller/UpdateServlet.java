package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDAO dao;
	ServletContext config;

	@Override
	public void init() throws ServletException {
		dao = new StudentDAO();
		config = getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		Student student = dao.getStudentById(id, url, username, password);
		
		request.setAttribute("stud", student);
		
		request.getRequestDispatcher("jsp/updateStudentForm.jsp").forward(request, response);

	}

}
