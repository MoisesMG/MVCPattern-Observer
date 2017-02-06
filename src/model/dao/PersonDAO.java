package model.dao;
import model.vo.PersonVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.connection.*;

public class PersonDAO {
	public void savePersonRecord(PersonVO person){
		String query = "INSERT INTO person(name, lastname, age, gender, born_date,"+
		"born_dapartment, born_municipaly, identification) VALUES('" +
		person.getName() + "','" + person.getLastname() + "'," +
		person.getAge() + "," + person.getGender() + ",'" + person.getBornDate() + "',"+
		person.getBornDepartment() + "," + person.getBornMunicipally() + ",'" +
		person.getIdentification() + "');";
		
		try{
			DBConnection.ConnectDataBase();
			Statement statement = DBConnection.connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("se registro correctamente - PersonDAO");
			statement.close();
			DBConnection.DisconnectDB();
		}catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.print("No se realizo el registro - PersonaDAO");
		}
	}//end of method
	
	public ResultSet listRecord(){
		String query = "SELECT * FROM person";
		ResultSet rs = null;
		try{
			DBConnection.ConnectDataBase();
			PreparedStatement pst = DBConnection.connection.prepareStatement(query);
			rs = pst.executeQuery();
		}catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("No se resalizo la consulta - PersonaDAO");
		}
		
		return rs;
	}//end of method
}//end of class
