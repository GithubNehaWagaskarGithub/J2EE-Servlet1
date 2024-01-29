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
public class EmpAnnualSal extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 float sal=Float.parseFloat(req.getParameter("sal"));
		 
		 float annualSal=sal*12;
		 
		 req.setAttribute("as",annualSal);
		 PrintWriter pw=resp.getWriter();
		 //pw.print("<h1>Annual Sal Is :"+annualSal+"</h1>");
		 
		 RequestDispatcher rd= req.getRequestDispatcher("link3"); 
		 rd.forward(req,resp);
	}		 	
}
