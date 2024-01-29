package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link4")
public class DisplayProduct extends HttpServlet{
	Connection con;
	PreparedStatement pStmt;
	ResultSet rs;
	@Override
	public void init() throws ServletException {
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
//---------------------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//int id=Integer.parseInt(req.getParameter("id"));
		
		PrintWriter pw=resp.getWriter();
		
		String displayQuery="select * from productservlet ";//where Id=?
		try {
			pStmt=con.prepareStatement(displayQuery);
			//pStmt.setInt(1, id);
			rs=pStmt.executeQuery();
			pw.print("<table border='1' rules='all'><tr><th>Id</th> <th>Name</th> <th>Category</th> <th>Qty</th> <th>Price</th></tr>");
			while(rs.next())
			{
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td>"+rs.getInt(4)+"</td>");
				pw.print("<td>"+rs.getDouble(5)+"</td>");
				pw.print("</tr>");
				
			}
			pw.print("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
