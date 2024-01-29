package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie c1=new Cookie("name","");
		c1.setMaxAge(0);
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>LogOut Successfully</h1>");
		
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.include(req, resp);
	}
	
}
