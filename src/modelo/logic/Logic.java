package modelo.logic;

import controller.Coordinator;
import model.dao.PersonDAO;
import model.vo.PersonVO;
/**
 * 
 * @author Moises
 * En esta clase se agreagan todos los metodos que representen las reglas
 * del negocio. Por ejemplo:
 * -Los numeros de identificacion deben ser unicos para cada registro
 * -Solo se aceptan registros de personas que cumplas ciertos requierimientos
 */
public class Logic {
	private Coordinator myCordinator;
	private PersonDAO personDao;

	public Logic(){
		personDao = new PersonDAO();
	}
	public void setMyCordinator(Coordinator myCordinator) {
		this.myCordinator = myCordinator;
	}//end of method
	
	
	/**
	 * @param person
	 * en este metodo se deben aplicar las reglas de negocio para
	 * que sea aceptado el registro de una persona
	 */
	public void confirmRegistration(PersonVO person){
		personDao.savePersonRecord(person);
	}//end of method
	
}//end of class
