package com.userservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.User;
import com.userdao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/user-login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao ud;
   
    public Login() {
    	super();
        this.ud = new UserDao();
        
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginBean = new User( 0, username, 0, password);
        loginBean.setUsername(username);
        loginBean.setPass(password);

        try {
			if (UserDao.validate(loginBean)) {
			    HttpSession session = request.getSession();
			     //|]session.setAttribute("username",username);
			    response.sendRedirect("welcome.jsp");
			} else if(loginBean == null) {
			    HttpSession session = request.getSession();
			   // session.setAttribute("user", username);
			    response.sendRedirect("user-new.jsp");
			}
			else {
				 HttpSession session = request.getSession();
				    session.setAttribute("user", username);
				    response.sendRedirect("user-new.jsp");
			}
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
