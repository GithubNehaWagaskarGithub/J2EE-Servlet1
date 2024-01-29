package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/link2")
public class Servlet2 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name= req.getParameter("name");
		String password=req.getParameter("password");
		
		HttpSession ses=req.getSession(false);
		if(ses!=null)
		{
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>Welcome"+name+"</h1>");
		}
		else
		{
			resp.sendRedirect("index.html");
		}
	}
}

