package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import dao.Mydao;
import dto.customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//this is to map the action url to this class(should be same as action-case sensitive)
@WebServlet("/signup")
@MultipartConfig
//this is to make class as servlet class
public class signup extends HttpServlet {
	@Override
//this is when there is form and we want data to be secured so do post
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// logic to recieve values from front end
		String Name = req.getParameter("fullname");
		String password = req.getParameter("password");
		long number = Long.parseLong(req.getParameter("number"));
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		String gender = req.getParameter("gender");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		Part pic = req.getPart("picture");
		byte[] picture = null;
		picture = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);
		int age = Period.between(dob, LocalDate.now()).getYears();
		Mydao dao = new Mydao();
		if(dao.fetchByEmail(email)==null && dao.fetchByMobile(number)==null)
		{
		customer c=new customer();
		c.setAge(age);
		c.setFullname(Name);
		c.setEmail(email);
		c.setNumber(number);
		c.setPassword(password);
		c.setGender(gender);
		c.setCountry(country);
		c.setPicture(picture);
		c.setDob(dob);
		dao.save(c);
		resp.getWriter().print("<h1 style='color:green'>Account Created Successfully</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);
	}else {
			resp.getWriter().print("<h1 style='color:green'>Email and Mobile should be unique</h1>");
			req.getRequestDispatcher("signup.html").include(req, resp);
		}
	}
	}

