package model.connection;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class DBConnection {
	public static String url;
	static java.sql.Connection connection;
	
	public static boolean ConnectDataBase(String db, String user, String pwd) throws SQLException{
		url = "jdbc:mysql://localhost/"+db;
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
	}//fin del metodo static
}//fin de la clase
