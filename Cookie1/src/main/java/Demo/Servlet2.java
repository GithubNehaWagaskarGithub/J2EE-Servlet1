package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class Servlet2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] ck=req.getCookies();
		
		PrintWriter pw=resp.getWriter();
		String username="";
		String pass="";

		for(int i=0;i<ck.length-1;i++)
		{
			username=ck[0].getValue();
			pass=ck[1].getValue();
		}
		pw.print("<h1>UserName Is :"+username+"</h1>");
		pw.print("<h1>Password Is :"+pass+"</h1>");
	}
}
