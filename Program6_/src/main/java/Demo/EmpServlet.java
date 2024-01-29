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
public class EmpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String name="Neha";
		String pass="Neha@123";
		
		PrintWriter pw=resp.getWriter();
		
		if(username.equals(name) && password.equals(pass))
		{
			pw.print("<h1>Login Successfully</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("Employee.html");
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
