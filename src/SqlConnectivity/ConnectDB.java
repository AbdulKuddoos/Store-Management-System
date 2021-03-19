/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlconnectivity;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectDB {
    
Connection con;
    
    static{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e);      
        }
    }
    
    public ConnectDB()
    {
        String url = "jdbc:sqlserver://localhost:1433;databaseName = Shop; user = root; password = root";
        try{
            con = DriverManager.getConnection(url);
            System.out.println("Connected");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static Connection getConnection()
    {
        String url = "jdbc:sqlserver://localhost:1433;databaseName = Shop; user = root; password = root";
        Connection con = null;
        try{
            con = DriverManager.getConnection(url);
            System.out.println("Connected");
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
    
    public void endConnection()
	{
		try {	
			con.close();
		}
		catch(SQLException e)
		{
                    JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean checkUser(String username)
	{
		try {	
			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("SELECT username FROM Staff WHERE Username='"+username+"'"); 
			if(rs.next())  
                            return true;
			else 
                            return false;
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public boolean getUser(String username, String password)
	{
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery("exec getUser @username = '"+username+"', @password = '"+password+"'"); 
			if(rs.next())  
				return true;
			else return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public boolean signUp(String staffID, String name,String username, String password, String position,String email, String address, String PhoneNo)
	{
		try {
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Staff (StaffID,name, username, password, position, email, address, phoneNo) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')",staffID, name ,username, password, position, email, address, PhoneNo));
			if(countUpdated > 0)
				return true;
			else return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}

}
