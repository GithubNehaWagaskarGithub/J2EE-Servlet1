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

@WebServlet("/link3")
public class DeleteProduct extends HttpServlet{

	Connection con=null;
	PreparedStatement pStmt=null;
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
	//--------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		String deleteQuery="delete from productservlet where Id=?";
		
		PrintWriter pw=resp.getWriter();
		
		try {
			pStmt=con.prepareStatement(deleteQuery);
			pStmt.setInt(1, id);
			int count=pStmt.executeUpdate();
			if(count>0)
			{
				pw.print("<h1>Data Deleted Successfully</h1>");
			}
			else
			{
				pw.print("<h1>Data Not Added</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
