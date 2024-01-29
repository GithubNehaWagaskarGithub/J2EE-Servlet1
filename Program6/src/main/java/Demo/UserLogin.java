package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class UserLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String UserName="nehawagaskar@gmail.com";
		String pass="Neha@123";
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		
		if(username.equals(UserName)&& password.equals(pass))
		{
			pw.print("<h1>Welcome "+UserName.substring(0, 12)+"</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("EmpDetails.html");
			rd.include(req, resp);
		}
		else
		{
			pw.print("<h1>Invalid Username And Password</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
	
}
