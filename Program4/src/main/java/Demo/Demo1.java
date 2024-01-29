package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class Demo1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 PrintWriter pw=resp.getWriter();
		 String name=(String) req.getAttribute("n");
		 float sal=(float) req.getAttribute("s");
		 float annualSal=sal*12;
		 float hikeSalTenPer=sal+sal*10/100;
		 
		 pw.print("<h1>Welcome "+name+"</h1>");
		 pw.print("<h1> Your Monthly Salary Is :"+sal+"</h1>");
		 pw.print("<h1>Annual Sslary Is :"+annualSal+"</h1>");
		 pw.print("<h1>Hike Salary Is :"+hikeSalTenPer+"</h1>");
		 pw.print("<h1>Thanks for Visting</h1>");
		 
	}
}
