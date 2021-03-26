package com.userservlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.User;
import com.userdao.UserDao;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/user-insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao ud;

	public Insert() {
		this.ud = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("empid"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		int emp_id = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");
		
		
		User newuser = new User(emp_id, name, age, position);

		
		try {
			UserDao.insert(newuser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}