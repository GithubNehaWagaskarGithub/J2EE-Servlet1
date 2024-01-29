package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class Demo extends HttpServlet{
	//doPost method is not store a data inside  a URL means is secure method
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Welcome "+userName+"your Password is :"+password+"</h1>");
	}
	
}
