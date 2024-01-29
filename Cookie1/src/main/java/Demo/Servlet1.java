package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class Servlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		
		Cookie c1=new Cookie("username",name);
		Cookie c2=new Cookie("pass",pass);
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Welcome"+name+"</h1>");
		pw.print("<a href='link2'>Link2</a>");
	}
}
