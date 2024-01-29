package MainApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondLink")
public class Demo1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tel=req.getParameter("tel");
		long tel1=Long.parseLong(tel);
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>Phone Number Is :"+tel1+" from Demo1</h1>");
		
	}
}
