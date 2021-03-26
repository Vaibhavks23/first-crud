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
 * Servlet implementation class edit
 */
@WebServlet("/user-edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private UserDao ud;
   
    public Edit() {
        this.ud = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int empid = Integer.parseInt(request.getParameter("empid"));
		User update = ud.select(empid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-update.jsp");
		request.setAttribute("user", update);
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
