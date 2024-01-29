package Demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		Validation v1=new Validation();
		boolean res=v1.validate(name, pass);
		
		if(res)
		{
			req.setAttribute("name",name);
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("index.html");
		}
	}
}
