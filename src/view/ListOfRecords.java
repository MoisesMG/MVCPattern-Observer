package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.dao.PersonDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListOfRecords extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	public ListOfRecords() {
		initialize();
		fillTable();
	}//end of method
	
	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		model = new DefaultTableModel();
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Edad");
		model.addColumn("Sexo");
		model.addColumn("Fecha de nacimiento");
		model.addColumn("Departamento de nacimiento");
		model.addColumn("Municipio de nacimiento");
		model.addColumn("Identificación");
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(194);
		table.getColumnModel().getColumn(5).setPreferredWidth(180);
		table.getColumnModel().getColumn(6).setPreferredWidth(180);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		
	}//end of method
	
	private void fillTable(){
		PersonDAO p = new PersonDAO();
		ResultSet rs = p.listRecord();
		try {
			while(rs.next()){
				Object [] temp = new Object[8];
				temp[0] = rs.getString("name");
				temp[1] = rs.getString("lastname");
				temp[2] = rs.getString("age");
				temp[3] = rs.getString("gender");
				temp[4] = rs.getString("born_date");
				temp[5] = rs.getString("born_dapartment");
				temp[6] = rs.getString("born_municipaly");
				temp[7] = rs.getString("identification");
				model.addRow(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}//end of class






