package BarangayStudent;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class StudentReports extends JPanel {

	
	 private JLabel date;
	 private JLabel time;
	 	Connection conn;
		PreparedStatement pst;	
		Statement st;
		ResultSet rs;
		DefaultTableModel model;
		private JTextField textField;
		private JTable table;
		private JTable table_1;
		private JTable table_2;
		JLabel txtstudent = new JLabel("");
	/**
	 * Create the panel.
	 */
		public void connection() {
			
		 try
			{
				 	Class.forName("com.mysql.cj.jdbc.Driver");
				 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");			
				
			}
			catch (Exception e)	
			{
				System.out.println("Not Connected");
			
			}
	}	
		
	public StudentReports() {
		initialize();
		connection();
		Customer();
		showDate();
		showTime();
		showBasic();
		showFamily();
		showEducational();
		
	}

/**
 * Create the panel.
 */
	public void initialize() {
		setBackground(new Color(245, 245, 220));
		setBounds(0, 0, 1187, 844);
		setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 0, 1187, 79);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(null);
		panel_1_1.setBackground(new Color(255, 218, 185));
		add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("REPORTS");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_3.setBounds(253, 11, 626, 58);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date :");
		ImageIcon datee = new ImageIcon(this.getClass().getResource("/date.png"));
		Image date1 = datee.getImage();	
		Image date2 = date1.getScaledInstance(36,24, Image.SCALE_SMOOTH);
		ImageIcon date3 = new ImageIcon(date2);
		lblNewLabel_1_1.setIcon(date3);
		lblNewLabel_1_1.setBounds(1036, 11, 36, 24);
		panel_1_1.add(lblNewLabel_1_1);
		
		date = new JLabel("08/11/2022");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Tahoma", Font.BOLD, 12));
		date.setBounds(1075, 11, 91, 24);
		panel_1_1.add(date);
		
		time = new JLabel("New label");
		time.setForeground(Color.BLACK);
		time.setFont(new Font("Tahoma", Font.BOLD, 12));
		time.setBounds(1075, 40, 91, 24);
		panel_1_1.add(time);
		
		JLabel lblNewLabel_1_4 = new JLabel("Time :");
		ImageIcon timee = new ImageIcon(this.getClass().getResource("/time.png"));
		Image time1 = timee.getImage();	
		Image time2 = time1.getScaledInstance(36,24, Image.SCALE_SMOOTH);
		ImageIcon time3 = new ImageIcon(time2);
		lblNewLabel_1_4.setIcon(time3);
		lblNewLabel_1_4.setBounds(1036, 40, 36, 24);
		panel_1_1.add(lblNewLabel_1_4);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 138, 1120, 633);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("BASIC INFORMATION", null, panel, null);
		panel.setLayout(null);
		ImageIcon add = new ImageIcon(this.getClass().getResource("/printer.png"));
		Image add1 = add.getImage();	
		Image add2= add1.getScaledInstance(40, 40 ,Image.SCALE_SMOOTH);
		ImageIcon add3 = new ImageIcon(add2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 39, 1060, 555);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Registration No", "Firstname", "Middlename", "Lastname", "Suffix", "Birthdate", "Age","Birth Place", "Gender", "Contact No", "Civil Status", "Height", "Weight", "Religion", "Sports", "Vaccinated", "Vaccine","Purok","House No", "Barangay","Email", "Image",
				}
			));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("FAMILY BACKGROUND", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 23, 1058, 551);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Father","FatherBirthdate","FatherAge","FatherContact","FatherOccupation","FatherIncome","Mother","MotherBirthdate","MotherAge","MotherContact","MotherOccupation","MotherIncome","Siblings","FamilyStatus","BirthOrder"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("EDUCATIONAL BACKGROUND", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(32, 31, 1052, 544);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"LRN", "Remarks","Elementary", "Elem_Level", "Elem_SY", "HighSchool", "High_Level", "High_SY","SeniorHigh","Senior_Level", "Senior_SY", "College", "College_Level", "College_SY", "Vocational", "Voc_Level", "Voc_SY","Date"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.setBounds(1012, 782, 136, 46);
		add(btnNewButton);
		btnNewButton.setIcon(add3);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(255, 250, 205));
		 
		 textField = new JTextField();
		 textField.setBounds(112, 96, 305, 31);
		 add(textField);
		 textField.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyReleased(KeyEvent e) {
		 		try {
		 			Class.forName("com.mysql.cj.jdbc.Driver");
				 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
		 			String sql = "SELECT * FROM studentrecord WHERE RegistrationNo=?";
		 			pst = conn.prepareStatement(sql);
		 			pst.setString(1, textField.getText());
		 			rs = pst.executeQuery();
		 			
		 			DefaultTableModel df = (DefaultTableModel)table_2.getModel();
		 			String search = textField.getText();
		 			TableRowSorter <DefaultTableModel> rs = new TableRowSorter <DefaultTableModel>(df);
		 			table_2.setRowSorter(rs);
		 			rs.setRowFilter(RowFilter.regexFilter(search));
		 			
		 		}
		 		catch(Exception ee) {
		 			
		 		}
		 	}
		 });
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel = new JLabel("SEARCH");
		 lblNewLabel.setBounds(32, 96, 79, 31);
		 add(lblNewLabel);
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		 
		 
		 txtstudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		 txtstudent.setBounds(972, 112, 176, 38);
		 add(txtstudent);
	}
	public void showDate() {
		Date d = new Date();
		SimpleDateFormat  s = new SimpleDateFormat("dd/MM/yyyy");
		String dat = s.format(d);
		date.setText(dat);
	}

	public void showTime() {
		new Timer (0,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
			Date d = new Date();
			SimpleDateFormat  s = new SimpleDateFormat("hh:mm:ss aa");
			String tim = s.format(d);
			time.setText(tim);
				
			}
		}).start();
		
	}
	private void showBasic() {
		
	
		
		String sql ="Select RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Vaccinated,Vaccine,Purok,HouseNo,Barangay,Email,Image from studentrecord";
		try
		{
		
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));;
			}
		catch(Exception e)
		{

	}finally {
		try {
			rs.close();
			pst.close();
		}catch(Exception e) {
			
		}
	}
	}
	private void showFamily() {
	
		
		String sql ="Select Father,FatherBirthdate,FatherAge,FatherContact,FatherOccupation,FatherIncome,Mother,MotherBirthdate,MotherAge,MotherContact,MotherOccupation,MotherIncome,Siblings,FamilyStatus,BirthOrder from studentrecord";
		try
		{
		
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));		
			}
		catch(Exception e)
		{

	}finally {
		try {
			rs.close();
			pst.close();
		}catch(Exception e) {
			
		}
	}
	}


private void showEducational() {
	

	
	String sql ="Select  LRN,Remarks,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date from studentrecord";
	try
	{
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		table_2.setModel(DbUtils.resultSetToTableModel(rs));	
		
		
		}
	catch(Exception e)
	{

}finally {
	try {
		rs.close();
		pst.close();
	}catch(Exception e) {
		
	}
}
}
public void Customer() {
	try
	{

		pst = conn.prepareStatement("SELECT COUNT (*)  FROM studentrecord");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int count = rs.getInt(1);
			txtstudent.setText(String.valueOf(count));
		}
	}catch(Exception ee) {
		
	}
}
}

