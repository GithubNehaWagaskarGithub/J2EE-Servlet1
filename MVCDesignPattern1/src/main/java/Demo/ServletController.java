package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addlink","/updatelink","/deletelink","/displaylink"})
public class ServletController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		switch (path) {
		case "/addlink": {
			addData(req,resp);
			break;
		}
		case "/updatelink":{
			updateData(req,resp);
			break;
		}
		case "/deletelink":{
			deleteData(req,resp);
			break;
		}
		case "/displaylink":{
			displayData(req,resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " +path);
		}
	}
	//-----------------------------------------------------------------------------------------------
	private void addData(HttpServletRequest req, HttpServletResponse resp) {
		
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			pw.print("<h1>Data Added</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------------------
	private void updateData(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>Data Updated</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//--------------------------------------------------------------------------------------------------
	private void deleteData(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>Data Deleted</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void displayData(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>Data Displayed</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
