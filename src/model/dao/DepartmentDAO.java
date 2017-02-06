package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.connection.DBConnection;
import model.vo.DepartmentVO;

public class DepartmentDAO {
	/**
	 * @return
	 */
	public ArrayList<DepartmentVO> recoverDepartments(){
		String querySelect = "SELECT * FROM Departement";
		DepartmentVO tempDepartment = new DepartmentVO();
		ArrayList<DepartmentVO> ls = new ArrayList<DepartmentVO>();
		
		try{
			DBConnection.ConnectDataBase();
			PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(querySelect);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				tempDepartment.setIdDepartment(resultSet.getInt("id_departement"));
				tempDepartment.setDepartmentName(resultSet.getString("department_name"));
				System.out.println(tempDepartment.getIdDepartment());
				System.out.println(tempDepartment.getDepartmentName());
				ls.add(tempDepartment);
				
			}
			resultSet.close();
			DBConnection.DisconnectDB();
		}catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("No se recupero la lista de departamentos - DepartmentDAO");
		}//end try catch
		
		return ls;
	}//end of method
}//end of class
