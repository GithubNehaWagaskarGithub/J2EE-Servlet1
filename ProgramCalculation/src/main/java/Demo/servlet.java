package Demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/link")
public class servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mName=req.getParameter("mname");
		String tName=req.getParameter("tname");
		int qty=Integer.parseInt(req.getParameter("qty"));
		
		Calculation c1=new Calculation();
		double result=c1.calculate(mName, tName, qty);
		RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
		req.setAttribute("Result", result);
		rd.forward(req, resp);
	}
}
