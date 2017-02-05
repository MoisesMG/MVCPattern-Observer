package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.connection.DBConnection;

import javax.swing.Box;
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

public class RegisterWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 356, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formulario de registro");
		lblNewLabel.setBounds(112, 11, 116, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(40, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(40, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setBounds(40, 121, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo");
		lblNewLabel_4.setBounds(40, 146, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setBounds(40, 171, 139, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Departamento de nacimento");
		lblNewLabel_6.setBounds(40, 196, 139, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Municipio de nacimiento");
		lblNewLabel_7.setBounds(40, 221, 139, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Numero de identificaci\u00F3n");
		lblNewLabel_8.setBounds(40, 246, 139, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(189, 68, 104, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 93, 104, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 118, 104, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(189, 143, 104, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(189, 168, 28, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(227, 168, 28, 20);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(265, 168, 28, 20);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(189, 193, 104, 20);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(189, 218, 104, 20);
		frame.getContentPane().add(comboBox_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(189, 243, 104, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGuardarRegistro = new JButton("Guardar Registro");
		btnGuardarRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnGuardarRegistro.setBounds(40, 288, 139, 23);
		frame.getContentPane().add(btnGuardarRegistro);
		
		JButton btnLimpiarPantalla = new JButton("Limpiar pantalla");
		btnLimpiarPantalla.setBounds(189, 288, 123, 23);
		frame.getContentPane().add(btnLimpiarPantalla);
	}
}
