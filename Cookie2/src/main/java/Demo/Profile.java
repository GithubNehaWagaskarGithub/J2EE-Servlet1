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

@WebServlet("/profile")
public class Profile extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//String name=req.getParameter("username");
		//String pass=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		Cookie[] ck=req.getCookies();
		
		//String username="";
		//String password="";
	
//		for(int i=0;i<ck.length-1;i++)
//		{
			//username=ck[i].getValue();
			//password=ck[i].getValue();
		//}
		if(ck!=null && !ck[0].getValue().isEmpty()&& !ck[1].getValue().isEmpty())
		{
			pw.print("<h1>Login Successfully</h1>");
			pw.print("<h1>Welcome To Dashboard</h1>");
			pw.print("<h1>Welcome"+ck[0].getValue()+"</h1>");
			pw.print("<h1>Your Username Is :"+ck[0].getValue()+"</h1>");
			pw.print("<h1>Your Password Is :"+ck[1].getValue()+"</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		else
		{
			pw.print("<h1>First Login then Visit Profile</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	
	}
}