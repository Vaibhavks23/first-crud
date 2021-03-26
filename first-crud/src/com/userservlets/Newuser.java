package com.userservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.User;
import com.userdao.UserDao;

/**
 * Servlet implementation class Newuser
 */
@WebServlet("/user-new")
public class Newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserDao ud;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newuser() {
      this.ud = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String username = request.getParameter("username");		
		String pass = request.getParameter("pass");
		System.out.println(name);
		System.out.println(username);
		
		User newuser = new User(name,username, pass);

		
		try {
			UserDao.insertpass(newuser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("user-login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
