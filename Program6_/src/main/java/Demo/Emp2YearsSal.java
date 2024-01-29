package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link3")
public class Emp2YearsSal extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text.html");
		
		float annualSal=(float) req.getAttribute("as");
		//float annualSal=Float.parseFloat("as");
		float twoYearsSal=annualSal*2;
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>"+twoYearsSal+"</h1>");
	}
}
