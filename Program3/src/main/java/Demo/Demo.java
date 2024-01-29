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
		
		String userName=req.getParameter("username");
	
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Welcome "+userName+"</h1>");
		
		RequestDispatcher rd=req.getRequestDispatcher("link2");
		rd.forward(req, resp);//it is directly shift the control from 1 servlet to another servlet.
		
		pw.print("<h1>Thanks For Visiting!!!</h1>");
		
	}

}
