package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class EmpServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("sal"));
		String desig=req.getParameter("desig");
		
		PrintWriter pw=resp.getWriter();
		
		HikeSalClass hs=new HikeSalClass();
		double hikeSal=hs.hikeSal(desig, sal);
		
		pw.print("<h1>User Information Interface</h1>");
		pw.print("<h1>Emp Id Is :"+id+"</h1>");
		pw.print("<h1>Emp Name Is :"+name+"</h1>");
		pw.print("<h1>Emp Sal Is :"+sal+"</h1>");
		pw.print("<h1>Emp Designation Is :"+desig+"</h1>");
		pw.print("<h1>Emp Hike Sal Is :"+hikeSal+"</h1>");
		
		pw.print("<h1>Thanks For Visting<h1>");
	}
}
