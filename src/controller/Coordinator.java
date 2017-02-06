package controller;

import model.vo.PersonVO;
import modelo.logic.Logic;
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
public class Coordinator {
	private Logic myLogic;
	private RegisterWindow rw;
	
	/** gettters and setters **/
	
	public void setMyLogic(Logic myLogic) {
		this.myLogic = myLogic;
	}
	public void setRw(RegisterWindow rw) {
		this.rw = rw;
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
	
	/**
	 * 
	 * @param person
	 * esta es una actividad del sistema que ordena
	 * la ejecucion de una actividad de la logica del negocio
	 */
	public void savePersonRecord(PersonVO person){
		myLogic.confirmRegistration(person);
	}
	/***************************/
	
}//end of class
