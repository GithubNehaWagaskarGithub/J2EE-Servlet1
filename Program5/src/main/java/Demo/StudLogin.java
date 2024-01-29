package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class StudLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email="nehawagaskar@gmail.com";
		String cno="9673922516";
		String pass="Neha@123";
		String eMailIdcNo=req.getParameter("emailcno");
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		
		if(eMailIdcNo.equals(email)&& password.equals(pass))
		{
			pw.print("<h1>Login Succefully</h1>");
		}
		else if(eMailIdcNo.equals(cno)&& password.equals(pass))
		{
			pw.print("<h1>Login Successfully</h1>");
		}
		else
		{
			pw.print("Invalid Username And Password");
		}
	}
}
