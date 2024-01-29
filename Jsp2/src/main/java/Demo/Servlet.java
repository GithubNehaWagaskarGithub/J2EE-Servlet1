package Demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class Servlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int qty=Integer.parseInt(req.getParameter("qty"));
		double price=Double.parseDouble(req.getParameter("price"));
		String category=req.getParameter("category");
		
		Logic l1=new Logic();
		double result=l1.logic(qty, price, category);
		
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		req.setAttribute("result", result);
		rd.forward(req, resp);
	}

}
