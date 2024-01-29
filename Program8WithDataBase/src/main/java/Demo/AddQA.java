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



@WebServlet("/link1")
public class AddQA extends HttpServlet{
	Connection con;
	PreparedStatement pStmt;
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
//---------------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String que=req.getParameter("question");
		String ans=req.getParameter("answer");
		
		String insertQuery="insert into questionanswerservlet values(?,?,?)";
		PrintWriter pw=resp.getWriter();
		
		try {
			pStmt=con.prepareStatement(insertQuery);
			pStmt.setInt(1, id);
			pStmt.setString(2,que);
			pStmt.setString(3,ans);
			int count=pStmt.executeUpdate();
			if(count>0)
			{
				pw.print("<h1>Data Added</h1>");
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
