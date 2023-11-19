package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.customer;

@WebServlet("/viewcustomer")
public class AdminViewCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Session verification
		if(req.getSession().getAttribute("admin")==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else {
		
		// Logic to fetch Data from Database
		Mydao dao = new Mydao();
		List<customer> customers = dao.fetchAllCustomer();

		// Logic to Display data on front end
//		resp.getWriter().print("<html><body><h1>Menu</h1>");
//		resp.getWriter().print("<table border='1'>");
//		resp.getWriter().print(
//				"<tr><th>Name</th><th>Type</th><th>Price</th><th>Quantity</th><th>Edit</th><th>Delete</th></tr>");
//		for (Customer item : items) {
//			resp.getWriter()
//					.print("<tr><th>" + item.getName() + "</th><th>" + item.getType() + "</th><th>" + item.getPrice()
//							+ "</th><th>" + item.getQuantity()
//							+ "</th><th><button>Edit</button></th><th><button>Delete</button></th></tr>");
//		}
//		resp.getWriter().print("</table></body></html>");
		// Logic to carry data to front end

		if (customers.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red'>No Customers Found</h1>");
			req.getRequestDispatcher("AdminHome.html").include(req, resp);
		} else {
			req.setAttribute("list", customers);
			req.getRequestDispatcher("ViewCustomer.jsp").include(req, resp);
		}
	}
	}
}