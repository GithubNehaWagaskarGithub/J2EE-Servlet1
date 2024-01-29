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

@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		Cookie c1=new Cookie("name", name);
		Cookie c2=new Cookie("pass", pass);
		resp.addCookie(c1);
		resp.addCookie(c2);
		if(name.equals("Neha")&&pass.equals("Neha@123"))
		{
			pw.print("<h1>Login Successfully</h1>");
			pw.print("<h1>Welcome"+name+"</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		else
		{
			pw.print("<h1>Invalid Username and Password</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
	
}
