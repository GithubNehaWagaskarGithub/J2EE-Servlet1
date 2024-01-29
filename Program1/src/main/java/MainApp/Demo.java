package MainApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstLink")
public class Demo extends HttpServlet{//it is class doGet and doPost method is actually from HttpServlet Class.
	//doGet method is store a data inside a URL means is not a secure method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName=req.getParameter("username");
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1> Welcome " +userName+"</h1>");
		
		RequestDispatcher rd=req.getRequestDispatcher("secondLink");
		RequestDispatcher rd1=req.getRequestDispatcher("thirdLink");
		rd.include(req, resp);//include() is used for to merge the response from multiple Servlet.
		rd1.include(req, resp);
		pw.print("<h1>Thanks For Visting</h1>");
	}
}
