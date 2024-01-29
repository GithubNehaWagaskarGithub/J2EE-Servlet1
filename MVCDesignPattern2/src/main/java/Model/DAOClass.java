package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOClass 
{
	static Connection con;
	static
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
//-----------------------------------------------------------------------------------
	public int addData(DTOClass d1) {
		String insertQuery="insert into employeeservlet values(?,?,?)";
		PreparedStatement pStmt;
		
		try {
			pStmt=con.prepareStatement(insertQuery);
			pStmt.setInt(1, d1.getId());
			pStmt.setString(2, d1.getName());
			pStmt.setDouble(3, d1.getSal());
			int count=pStmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}//394959
	
	//-----------------------------------------------------------------------------------------

	public int updateData(DTOClass d1) {
		
		PreparedStatement pStmt;
		if(!d1.getName().isEmpty())
		{
			String updateName="update employeeservlet set eName=? where eId=?";
			try {
				pStmt=con.prepareStatement(updateName);
				pStmt.setString(1,d1.getName());
				pStmt.setInt(2,d1.getId());
				int count=pStmt.executeUpdate();
				return count;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!(d1.getSal() == 0.0))
		{
			String updateSal="update employeeservlet set eSal=? where eId=?";
			try {
				pStmt=con.prepareStatement(updateSal);
				pStmt.setDouble(1, d1.getSal());
				pStmt.setInt(2, d1.getId());
				int count=pStmt.executeUpdate();
				return count;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	//----------------------------------------------------------------------------------------------------
	
	public int deleteData(DTOClass d1) {
		String deleteQuery="delete from employeeservlet where eId=?";
		PreparedStatement pStmt;
		try {
			pStmt=con.prepareStatement(deleteQuery);
			pStmt.setInt(1, d1.getId());
			int count=pStmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//--------------------------------------------------------------------------------------------------------------

	public ArrayList<DTOClass> displayData() {
		
		PreparedStatement pStmt;
		ResultSet rs;
		ArrayList<DTOClass> data=new ArrayList<DTOClass>();
		String displayQuery="select * from employeeservlet";
		try {
			pStmt=con.prepareStatement(displayQuery);
			rs=pStmt.executeQuery();
			
			DTOClass d1=null;
			while(rs.next())
			{
				d1=new DTOClass();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double sal=rs.getDouble(3);
				//d1=new DTOClass(id,name,sal);
				d1.setId(id);
				d1.setName(name);
				d1.setSal(sal);
				data.add(d1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
