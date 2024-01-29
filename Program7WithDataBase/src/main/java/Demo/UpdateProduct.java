package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class UpdateProduct extends HttpServlet{
	Connection con;
	PreparedStatement pStmt;
	@Override
	public void init() throws ServletException 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//-----------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name="";String category="";String qty="";String price=""; 
		int id=Integer.parseInt(req.getParameter("id"));
		name=req.getParameter("name");
		category=req.getParameter("category");
		qty=req.getParameter("qty");
		price=req.getParameter("price");
		
		PrintWriter pw=resp.getWriter();
		if(!name.isEmpty())
		{
			String updateName="update Productservlet set Name=? where Id=?";
			try {
				pStmt=con.prepareStatement(updateName);
				pStmt.setString(1,name);
				pStmt.setInt(2, id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>Name Updeted successfully</h1>");
				}
				else
				{
					pw.print("<h1>Name Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!category.isEmpty())
		{
			String updateCategory="update productservlet set Category=? where Id=?";
			try {
				pStmt=con.prepareStatement(updateCategory);
				pStmt.setString(1, category);
				pStmt.setInt(2, id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>Category Updeted successfully</h1>");
				}
				else
				{
					pw.print("<h1>Category Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!qty.isEmpty())
		{
			String updateQty="update productservlet set Qty=? where Id=?";
			try {
				pStmt=con.prepareStatement(updateQty);
				pStmt.setInt(1, Integer.parseInt(qty));
				pStmt.setInt(2, id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>Qty Updeted successfully</h1>");
				}
				else
				{
					pw.print("<h1>Qty Not Updeted</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			String updatePrice="update productservlet set Price=? where Id=?";
			try {
				pStmt=con.prepareStatement(updatePrice);
				pStmt.setDouble(1, Double.parseDouble(price));
				pStmt.setInt(2, id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>Price Updeted successfully</h1>");
				}
				else
				{
					pw.print("<h1>Price Not Updeted</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
