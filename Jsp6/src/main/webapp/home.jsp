<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@
page import="java.sql.*" 
%><!-- directives which is used for to import package or libraries  -->
<%!
Connection con;
PreparedStatement pStmt;
	
<%--  public void jspinit() throws JspException
{
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/opeartion");
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	public void jspdestory() throws JspException
	{
		
	} 
}--%>
%> 
<%
	int id=Integer.parseInt(request.getParameter("eid"));
	String name=request.getParameter("ename");
	double sal=Double.parseDouble(request.getParameter("esal"));
	
	String insertQuery="insert into employeeservlet values(?,?,?)";
	pStmt=con.prepareStatement(insertQuery);
	pStmt.setInt(1,id);
	pStmt.setString(2, name);
	pStmt.setDouble(3,sal);
	int count=pStmt.executeUpdate();
	PrintWriter pw=response.getWriter();
	if(count>0)
	{
		pw.print("<h1>Data Added</h1>");
	}
	else
	{
		pw.print("<h1>Data Not Added</h1>");
	}
%>
<%@include file="index.html" %>
</body>
</html>