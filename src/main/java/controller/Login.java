package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.customer;

@WebServlet("/login")

public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Mydao dao=new Mydao();
		if(email.equals("admin@jsp.com") && password.equals("admin")) {
			resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
			req.getRequestDispatcher("AdminHome.html").include(req, resp);
			
		}else 
		{
		customer c=dao.fetchByEmail(email);
		if(c==null)
		{
			resp.getWriter().print("<h1 style='color:green'>Invalid email</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
			
		}
		else {
			if(password.equals(c.getPassword())) {
				resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1 style='color:green'>Invalid Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		
		
		}
	}
}


