package controller;

import model.dao.PersonDAO;
import model.vo.PersonVO;
import modelo.logic.Logic;
import view.RegisterWindow;

public class Principal {
	
	Logic myLogic;
	Coordinator myCoordinator;
	RegisterWindow myRegisterWindow;
	
	public static void main(String[] args) {
		
	}//end of main

	
	/**
	 * En este metodo se realizan todas las instacias y relaciones
	 * necesarias para la ejecucion del sistema
	 */
	public void beguin(){
		/** se instacion las clases **/
		myLogic = new Logic();
		myCoordinator = new Coordinator();
		myRegisterWindow = new RegisterWindow();
		
		/** se crean las realciones entre clases **/
		myLogic.setMyCordinator(myCoordinator);
		myRegisterWindow.setMyCoordinator(myCoordinator);
		
		/** se establecen las relaciones con la clase coordinator **/
		myCoordinator.setMyLogic(myLogic);
		myCoordinator.setRw(myRegisterWindow);
		
		/** se muesta la ventana principal del sistema **/
		myRegisterWindow.setVisible(true);
	}//end of method
	
}//end of class
