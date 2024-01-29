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
public class UpdateQA extends HttpServlet{
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
	//---------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String que=""; String ans="";
		int id=Integer.parseInt(req.getParameter("id"));
		que=req.getParameter("que");
		ans=req.getParameter("ans");
		
		PrintWriter pw=resp.getWriter();
		
		if(!que.isEmpty())
		{
			String updateQuestionQurey="update questionanswerservlet set Question=? where Id=?";
			try {
				pStmt=con.prepareStatement(updateQuestionQurey);
				pStmt.setString(1, que);
				pStmt.setInt(2, id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>Question Updated</h1>");
				}
				else
				{
					pw.print("<h1>Question Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			String updateAnswerQuery="update questionanswerservlet set Answer=? where Id=?";
			try {
				pStmt=con.prepareStatement(updateAnswerQuery);
				pStmt.setString(1, ans);
				pStmt.setInt(2, id);
				int count=pStmt.executeUpdate();
				if(count>0)
				{
					pw.print("<h1>Answer Updated</h1>");
				}
				else
				{
					pw.print("<h1>Answer Not Updated</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
