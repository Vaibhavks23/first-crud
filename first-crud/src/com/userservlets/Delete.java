package com.userservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userdao.UserDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/user-delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao ud;

	public Delete() {
		this.ud = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emp = request.getParameter("empid");
		if (emp != null) {
			int empid = Integer.parseInt(emp);// empid from user-delete.jsp
			System.out.println(request.getParameter("empid"));

			try {

				UserDao.delete(empid);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			String message = "hello";
			request.getSession().setAttribute("message", message);
		
		response.sendRedirect("");
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
