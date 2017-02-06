package model.connection;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class DBConnection {
	public static java.sql.Connection connection;
	
	public static boolean ConnectDataBase() throws SQLException{
		String db = "testmvc";
		String user = "root";
		String pwd = "1234";
		String url = "jdbc:mysql://localhost/"+db;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
			
			if (connection!=null){
	            System.out.println("Conexión a base de datos "+db+" OK\n");
	            return true;
	         }else{
	        	 return false;
	         }
		}catch(SQLException e){
		 	 System.out.println(e);
		}catch(ClassNotFoundException e){
		     System.out.println(e);
		}catch(Exception e){
		     System.out.println(e);
		}
		return false;
	}//end of method
	
	public static void DisconnectDB(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}//end of class
