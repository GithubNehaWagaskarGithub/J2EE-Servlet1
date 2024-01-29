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
		double km=Double.parseDouble(req.getParameter("km"));
		double wt=Double.parseDouble(req.getParameter("wt"));
		String type=req.getParameter("type");
		Calculation c1=new Calculation();
		double result=c1.calculate(km, wt,type );
		
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		req.setAttribute("km", km);
		req.setAttribute("wt", wt);
		req.setAttribute("type",type);
		req.setAttribute("result", result);
		rd.forward(req, resp);
	}
}
