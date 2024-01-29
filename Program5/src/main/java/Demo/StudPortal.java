package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class StudPortal extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String cno=req.getParameter("cno");
		//int cno1=Integer.parseInt(cno);
		
		String[] courses=req.getParameterValues("course");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>Name Is :"+name+"</h1>");
		pw.print("<h1>Contact No Is :"+cno+"</h1>");
		
		for(int i=0;i<courses.length;i++)
		{
			pw.print("<h1>Courses Are :"+courses[i]+"</h1>");
		}
		
	}
	
}
