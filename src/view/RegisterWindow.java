package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.Coordinator;
import model.connection.DBConnection;
import model.dao.DepartmentDAO;
import model.vo.DepartmentVO;
import model.vo.PersonVO;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterWindow extends JFrame implements ActionListener{
	private Coordinator myCoordinator;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JTextField txtIdentification;
	JLabel lblNewLabel;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_6;
	JLabel lblNewLabel_7;
	JLabel lblNewLabel_8;
	JComboBox cmbGender;
	JComboBox cmbDay;
	JComboBox cmbMonth;
	JComboBox cmbYear;
	JComboBox cmbDepartment;
	JComboBox cmbMunicipally;
	JButton btnSaveRecord;
	JButton btnClearDisplay;
	ArrayList<DepartmentVO> listOfDepartments;
	
	public RegisterWindow() {
		initialize();
		fillComboBoxes();
		
	}
	
	public void setMyCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}//end of method
	
	private void fillComboBoxes(){
		cmbDepartment.removeAll();
		listOfDepartments= new ArrayList<DepartmentVO>();
		DepartmentDAO depDao = new DepartmentDAO();
		listOfDepartments = depDao.recoverDepartments();
		for(int i = 0; i < listOfDepartments.size(); i++){
			DepartmentVO temp = listOfDepartments.get(i);
			System.out.println(temp.getDepartmentName());
			cmbDepartment.addItem(temp.getDepartmentName());
		}
	}//end of method
	
	private void initialize() {
		
		setBounds(100, 100, 356, 393);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Formulario de registro");
		lblNewLabel.setBounds(112, 11, 116, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(40, 71, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(40, 96, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setBounds(40, 121, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Sexo");
		lblNewLabel_4.setBounds(40, 146, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setBounds(40, 171, 139, 14);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Departamento de nacimento");
		lblNewLabel_6.setBounds(40, 196, 139, 14);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Municipio de nacimiento");
		lblNewLabel_7.setBounds(40, 221, 139, 14);
		getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Numero de identificaci\u00F3n");
		lblNewLabel_8.setBounds(40, 246, 139, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtName = new JTextField();
		txtName.setBounds(189, 68, 104, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(189, 93, 104, 20);
		getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(189, 118, 104, 20);
		getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		cmbGender = new JComboBox();
		cmbGender.setBounds(189, 143, 104, 20);
		getContentPane().add(cmbGender);
		
		cmbDay = new JComboBox();
		cmbDay.setBounds(189, 168, 28, 20);
		getContentPane().add(cmbDay);
		
		cmbMonth = new JComboBox();
		cmbMonth.setBounds(227, 168, 28, 20);
		getContentPane().add(cmbMonth);
		
		cmbYear = new JComboBox();
		cmbYear.setBounds(265, 168, 28, 20);
		getContentPane().add(cmbYear);
		
		cmbDepartment = new JComboBox();
		cmbDepartment.setBounds(189, 193, 104, 20);
		cmbDepartment.setModel(new DefaultComboBoxModel(new String[]{}));
		getContentPane().add(cmbDepartment);
		
		cmbMunicipally = new JComboBox();
		cmbMunicipally.setBounds(189, 218, 104, 20);
		getContentPane().add(cmbMunicipally);
		
		txtIdentification = new JTextField();
		txtIdentification.setBounds(189, 243, 104, 20);
		getContentPane().add(txtIdentification);
		txtIdentification.setColumns(10);
		
		btnSaveRecord = new JButton("Guardar Registro");
		btnSaveRecord.addActionListener(this);
		
		btnSaveRecord.setBounds(40, 288, 139, 23);
		getContentPane().add(btnSaveRecord);
		
		btnClearDisplay = new JButton("Limpiar pantalla");
		btnClearDisplay.setBounds(189, 288, 123, 23);
		getContentPane().add(btnClearDisplay);
	}// end of method

	@Override
	public void actionPerformed(ActionEvent even) {
		if(even.getSource()==btnSaveRecord){
			try{
				PersonVO myPerson = new PersonVO();
				myPerson.setName(txtName.getText());
				myPerson.setLastname(txtLastName.getText());
				myPerson.setAge(Integer.parseInt(txtAge.getText()));
				myPerson.setGender(1);
				myPerson.setBornDate("19971105");
				myPerson.setBornDepartment(1);
				myPerson.setBornMunicipally(1);
				myPerson.setIdentification(txtIdentification.getText());
				myCoordinator.savePersonRecord(myPerson);
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
		
	}//end of method

}//end of class