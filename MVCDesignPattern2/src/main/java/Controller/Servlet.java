package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAOClass;
import Model.DTOClass;
@WebServlet(urlPatterns = {"/link1","/link2","/link3","/link4"})
public class Servlet extends HttpServlet
{
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String path=req.getServletPath();
		switch (path) {
		case "/link1" : {
			addData(req,resp);
			break;
		}
		case "/link2" :{
			updateData(req,resp);
			break;
		}
		case "/link3" :{
			deleteData(req,resp);
			break;
		}
		case "/link4" :{
			displayData(req,resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
	
//----------------------------------------------------------------------------------------	
private void addData(HttpServletRequest req, HttpServletResponse resp) {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("sal"));
		
		DTOClass d1=new DTOClass();
		d1.setId(id);;
		d1.setName(name);;
		d1.setSal(sal);;
		
		DAOClass d2=new DAOClass();
		int res=d2.addData(d1);
		
		RequestDispatcher rd=req.getRequestDispatcher("add.jsp");
		req.setAttribute("Result", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//-------------------------------------------------------------------------------------------------------	
private void updateData(HttpServletRequest req, HttpServletResponse resp) {
		String name=null; double sal=0.0;
		int id=Integer.parseInt(req.getParameter("id"));
		name=req.getParameter("name");
		sal=Double.parseDouble(req.getParameter("sal"));
		
		DTOClass d1=new DTOClass();
		d1.setId(id);
		d1.setName(name);
		d1.setSal(sal);
		
		DAOClass d2=new DAOClass();
		int res=d2.updateData(d1);
		
		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
		req.setAttribute("Result", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//--------------------------------------------------------------------------------------	
	private void deleteData(HttpServletRequest req, HttpServletResponse resp) {
		int id=Integer.parseInt(req.getParameter("id"));
		DTOClass d1=new DTOClass();
		d1.setId(id);;
		
		DAOClass d2=new DAOClass();
		int res=d2.deleteData(d1);
		
		RequestDispatcher rd=req.getRequestDispatcher("delete.jsp");
		req.setAttribute("Result", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//-------------------------------------------------------------------------------------------------------------------
	private void displayData(HttpServletRequest req, HttpServletResponse resp) {
		
		DAOClass d2=new DAOClass();
		ArrayList<DTOClass> res=d2.displayData();
		
		RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
		req.setAttribute("Result", res);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
