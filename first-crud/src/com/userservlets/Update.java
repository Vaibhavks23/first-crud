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
 * Servlet implementation class update
 */
@WebServlet("/user-update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao ud;
	/** 
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		this.ud = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int empid = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");
		System.out.println(name);
		System.out.println(age);
		System.out.println(position);

		User users = new User(empid, name, age, position);

		try {
			ud.update(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
