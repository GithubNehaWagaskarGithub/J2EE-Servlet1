package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/link1")
public class LoginDetails extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		
		if(name.equals("Neha") && pass.equals("Neha@123"))
		{
			HttpSession ses=req.getSession(true);
			RequestDispatcher rd=req.getRequestDispatcher("link2");//HttpSession is used for to store login Credentials
			rd.include(req, resp);
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>Welcome "+name+"</h1>");
			pw.print("<h1>Your Password Is :"+pass+"</h1>");
			
			pw.print("<h1 session Id Is :>"+ses.getId()+"</h1>");
			
			long l1=ses.getCreationTime();
			Date d1=new Date(l1);
			pw.print("<h1 Session Creation Time :>"+d1+"</h1>");
			
			long l2=ses.getLastAccessedTime();
			Date d2=new Date(l2);
			pw.print("<h1>Session Last accessed Time :"+d2+"</h1>");
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		
	}
	
}
