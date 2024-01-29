package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.Calculation;

public class DAOClass {

	static Connection con;
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//---------------------------------------------------------------------------------------------------------------
	public int updateData(Movie m1) {
		
		String updateQuery="update movietestservlet set Qty=? where Name=? and Theater=?";
		
		PreparedStatement pStmt;
		
		try {
			pStmt=con.prepareStatement(updateQuery);
			pStmt.setInt(1,m1.getQty());
			pStmt.setString(2, m1.getName());
			pStmt.setString(3,m1.getTheater());
			int count=pStmt.executeUpdate();
			
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//--------------------------------------------------------------------------------------------------------------
}
