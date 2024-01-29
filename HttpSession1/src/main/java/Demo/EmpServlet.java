package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/link2")
public class EmpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Welcome "+name+"</h1>");
		pw.print("<h1>Your Password Is :"+pass+"</h1>");
		
		HttpSession ses=req.getSession(false);//false means it get a Reference of active Session
		pw.print("<h1>session Id Is :"+ses.getId()+"</h1>");
		
		long l1=ses.getCreationTime();
		Date d1=new Date(l1);
		pw.print("<h1>Session Creation Time :"+d1+"</h1>");
		
		long l2=ses.getLastAccessedTime();
		Date d2=new Date(l2);
		pw.print("<h1>Session Last accessed Time :"+d2+"</h1>");
	}
	
}
