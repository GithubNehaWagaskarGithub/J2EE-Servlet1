package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class Demo extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		//String sal=req.getParameter("sal");
		float sal=Float.parseFloat(req.getParameter("sal"));
		PrintWriter pw=resp.getWriter();
		
		req.setAttribute("n", name);
		req.setAttribute("s", sal); 
		RequestDispatcher rd=req.getRequestDispatcher("link2");
		rd.forward(req, resp);
			
//		RequestDispatcher rd1=req.getRequestDispatcher("link2");
//		rd1.include(req, resp);		
		
	}
	
}
