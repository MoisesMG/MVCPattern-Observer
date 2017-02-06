package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import javax.swing.table.DefaultTableModel;

import model.dao.PersonDAO;
import model.vo.PersonVO;
import modelo.logic.Logic;
import view.ListOfRecords;
import view.RegisterWindow;

/**
 * 
 * @author Moises
 * Esta clase se encarga del control de las actividades del sistema, por
 * ejemplo el CRUD(Create, Read, Update, Delete), mostrar los formularios,
 * y ordenar la ejecucion de las actividades
 * que lleven la logica del negocio
 * 
 * El coordinador es el controlador del sistema, funciona como el muentes
 * entre las vista y los modelos.
 */
public class Coordinator extends Observable{
	private Logic myLogic;
	private RegisterWindow rw;
	private ListOfRecords lr;
	private PersonDAO personDao;
	
	public Coordinator(){
		personDao = new PersonDAO();
	}
	
	/** gettters and setters **/
	public void setMyLogic(Logic myLogic) {
		this.myLogic = myLogic;
	}
	public void setRw(RegisterWindow rw) {
		this.rw = rw;
	}
	public void setMyListOfRecords(ListOfRecords listOfRecords){
		this.lr = listOfRecords;
	}
	/***************************/
	
	/** system activities **/
	
	
	/**
	 * Esta es una actividad propia de 
	 * los procesos del sistema
	 */
	public void ShowRegisterWindow(){
		rw.setVisible(true);
	}
	
	public void showListRecord(){
		lr.setVisible(true);
	}
	/**
	 * 
	 * @param person
	 * esta es una actividad del sistema que ordena
	 * la ejecucion de una actividad de la logica del negocio
	 */
	public void savePersonRecord(PersonVO person){
		myLogic.confirmRegistration(person);
		setChanged();
		notifyObservers();
	}
	
	
	/*public void addRecordsInTable(DefaultTableModel model){
		ResultSet rs = personDao.listRecord();
		try {
			while(rs.next()){
				Object[] row = new Object[8];
				row[0] = rs.getString("name");
				row[1] = rs.getString("lastname");
				row[2] = rs.getString("age");
				row[3] = rs.getString("gender");
				row[4] = rs.getString("born_date");
				row[5] = rs.getString("born_dapartment");
				row[6] = rs.getString("born_municipaly");
				row[7] = rs.getString("identification");
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("error - coordinador");
		}
	}//end of method*/
	
}//end of class
