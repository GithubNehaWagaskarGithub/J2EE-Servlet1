package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link3")
public class EmpPortal extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String bSal=req.getParameter("basicSal");
		String hra=req.getParameter("hra");
		String pf=req.getParameter("pf");
		String empType=req.getParameter("empType");
		
		double bsal1=Double.parseDouble(bSal);
		double hra1=Double.parseDouble(hra);
		double pf1=Double.parseDouble(pf);
		
		double YearlySal=bsal1+hra1+pf1;
		double incrementSal=0;
		
		if(empType.equals("Developer"))
		{
			pw.print("<h1>Type Is :"+empType+"<h1>");
			incrementSal=YearlySal+(YearlySal*10/100);
			pw.print("<h1>Increment Sal of "+empType+" Is :"+incrementSal+"</h1>");
		}
		else if (empType.equals("Tester")) 
		{
			pw.print("<h1>Type Is :"+empType+"<h1>");
			incrementSal=YearlySal+(YearlySal*5/100);
			pw.print("<h1>Increment Sal of "+empType+" Is :"+incrementSal+"</h1>");
		}
		else
		{
			pw.print("<h1>Type Is :"+empType+"<h1>");
			incrementSal=YearlySal+(YearlySal*3/100);
			pw.print("<h1>Increment Sal of "+empType+" Is :"+incrementSal+"</h1>");
		}
		
	}
}
