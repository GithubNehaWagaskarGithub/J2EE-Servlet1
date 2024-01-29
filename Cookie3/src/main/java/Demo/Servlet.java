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

@WebServlet("/link1")
public class Servlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String add=req.getParameter("add");
		String view=req.getParameter("view");
		
		
		PrintWriter pw=resp.getWriter();
		if(add != null)
		{
			Cookie c1=new Cookie(name, price);//
			resp.addCookie(c1);
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		else
		{
			Cookie[] ck=req.getCookies();
			for(int i=0;i<ck.length;i++)
			{
				pw.print("<h1>Prodict Name Is ::"+ck[i].getName()+"Product Price Is :"+ck[i].getValue()+"</h1>");
			}
		}
	}

}
