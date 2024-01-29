package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class DisplayData extends HttpServlet{
	Connection con;
	PreparedStatement pStmt;
	ResultSet rs;
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
	//-------------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String que=req.getParameter("que");
		String displayQuery="select Answer from questionanswerservlet where Question=?";
		try {
			pStmt=con.prepareStatement(displayQuery);
			pStmt.setString(1,que);
			rs=pStmt.executeQuery();
			PrintWriter pw=resp.getWriter();
			//req.setAttribute("rs", rs);
			//RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			
			if(rs.next())
			{
				pw.print("<table border='1' rules='all'><th>Answer</th></tr>");
				pw.print("<tr>");
				pw.print("<td>"+rs.getString(1)+"</td>");
				pw.print("</tr>");
				pw.print("</table>");
			}
			
			else
			{
				resp.sendRedirect("https://www.google.com/search?"+que);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
