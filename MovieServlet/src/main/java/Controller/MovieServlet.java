package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAOClass;
import Model.Movie;
@WebServlet(urlPatterns = {"/link1"})
public class MovieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String path=req.getServletPath();
		switch (path) {
		case "/link1" : {
			updateData(req,resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
	//----------------------------------------------------------------------------------------------------
	private void updateData(HttpServletRequest req, HttpServletResponse resp) {
		
		String mName=req.getParameter("mname");
		String tName=req.getParameter("tname");
		int qty=Integer.parseInt(req.getParameter("qty"));
		
		Movie m1=new Movie();
		m1.setName(mName);
		m1.setTheater(tName);
		m1.setQty(qty);
		
		DAOClass d1=new DAOClass();
		int res=d1.updateData(m1);
		
		Calculation c1=new Calculation();
		double res1=c1.calculate(mName, tName, qty);
		
		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
		req.setAttribute("Result1", res1);
		req.setAttribute("Result", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
