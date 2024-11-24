package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/register1")
public class RegisterServlet1 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String quali=req.getParameter("quali");
		
		String[] hobbies=req.getParameterValues("hb");
		List hobbi=Arrays.asList(hobbies);
		
		pw.print("<div class='container' align='center'>");
		pw.print("<h2>Registration From</h2>");
		pw.print("<table border='1' align='center'>");
		pw.print("<tr>");
		pw.print("<td>Name</td>");
		pw.print("<td>"+name+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>DOB</td>");
		pw.print("<td>"+dob+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>Gender</td>");
		pw.print("<td>"+gender+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>Qualification</td>");
		pw.print("<td>"+quali+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>Hobbies</td>");
		pw.print("<td>"+hobbi+"</td>");
		pw.print("</tr>");
		
		pw.print("</table>");
	}
}
