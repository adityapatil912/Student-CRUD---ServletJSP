package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.DBUtility;

public class StudentDAO {

	DBUtility utilty;

	public StudentDAO() {

		utilty = new DBUtility();
	}

	// ADD Student
	public int insertStudent(Student student, String url, String username, String password) {

		Connection con = utilty.getDBConnection(url, username, password);
		String sql = "insert into student values(?,?,?)";
		int res = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setDouble(3, student.getMarks());

			res = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		if (res > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	// READ ALL Student
	public List<Student> getAllStudents(String url, String username, String password) {
		Connection con = utilty.getDBConnection(url, username, password);
		String sql = "SELECT * FROM STUDENT";
		List<Student> list = new ArrayList<Student>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student s1 = new Student();
				s1.setId(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setMarks(rs.getDouble(3));

				list.add(s1);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	// GET STUDET BY ID
	public Student getStudentById(int id, String url, String username, String password) {

		Connection con = utilty.getDBConnection(url, username, password);
		String sql = "SELECT * FROM STUDENT where id=?";
		Student s1 = new Student();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s1.setId(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setMarks(rs.getDouble(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return s1;
	}

	// DELETE STUDENT BY ID

	public int deleteStudentById(int id, String url, String username, String password) {
		int i = 0;
		try {
			Connection con = utilty.getDBConnection(url, username, password);
			String sql = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			i = ps.executeUpdate();
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return i;
	}

	// UPDATE STUDENT

	public int updateStudent(Student student, String url, String username, String password) {

		Connection con = utilty.getDBConnection(url, username, password);
		String sql = "update student set name=? , marks=? where id=?";
		int res = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, student.getId());
			ps.setString(1, student.getName());
			ps.setDouble(2, student.getMarks());

			res = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		if (res > 0) {
			return 1;
		} else {
			return 0;
		}

	}

}
