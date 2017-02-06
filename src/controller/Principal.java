package controller;

import model.dao.PersonDAO;
import model.vo.PersonVO;
import modelo.logic.Logic;
import view.ListOfRecords;
import view.RegisterWindow;

public class Principal {
	
	Logic myLogic;
	Coordinator myCoordinator;
	RegisterWindow myRegisterWindow;
	ListOfRecords myListRecords;
	
	public static void main(String[] args) {
		Principal myPrincipal = new Principal();
		myPrincipal.beguin();
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
		myListRecords = new ListOfRecords();
		
		/** se establecen las relaciones con la clase coordinator **/
		myCoordinator.setMyLogic(myLogic);
		myCoordinator.setRw(myRegisterWindow);
		myCoordinator.setMyListOfRecords(myListRecords);
		myCoordinator.addObserver(myListRecords);
		/** se crean las realciones entre clases **/
		myLogic.setMyCordinator(myCoordinator);
		myRegisterWindow.setMyCoordinator(myCoordinator);
		myListRecords.setMyCoordinator(myCoordinator);
		
		
		/** se muesta la ventana principal del sistema **/
		myCoordinator.ShowRegisterWindow();
		myCoordinator.showListRecord();
	}//end of method
	
}//end of class
