package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class Demo1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Password is :"+password+"</h1>");
		
	}

}
