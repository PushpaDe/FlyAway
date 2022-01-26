package com.flyaway.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;
		System.out.println("Me in Do");
		String username = request.getParameter("UserName");
		String password = request.getParameter("Password");
		if(dao.validate(username, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			if(dao.validateRole(username).equals("admin"))
			{
				dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
			}
			else {
				dispatcher = request.getRequestDispatcher("UserDashboard.jsp");
			}
			
			
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.include(request, response);
			out.println("<h3 style='color:red'>Login Failed.. Try Again..!!</h3>");
		}
	}

}
