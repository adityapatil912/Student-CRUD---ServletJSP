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


@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDAO dao;
	ServletContext config;
	
	@Override
	public void init() throws ServletException {
		dao = new StudentDAO();
		config = getServletContext();
	}
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("uname");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		Student student = new Student(id, name, marks);
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		int i = dao.updateStudent(student,url,username,password);
		

		if (i > 0) {
			//RequestDispatcher rd=request.getRequestDispatcher("/DisplayServlet");
			//RequestDispatcher rd=request.getRequestDispatcher("jsp/display.jsp");
			//rd.forward(request, response);
			response.sendRedirect("jsp/display.jsp");
		}

	}

}
