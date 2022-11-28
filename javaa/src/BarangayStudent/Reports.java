package BarangayStudent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.MatteBorder;



import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.exceptions.RSAException;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class Reports extends JPanel {


	
	 private JLabel date;
	 private JLabel time;
	 private JTable table;
	 private JTextField txtFirst;
	 
	
	 
	 	DefaultTableModel model1 = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	 
		Connection conn = null;
		PreparedStatement pst = null;	
		Statement st = null;
		ResultSet rs  = null;
		private JTextField txtSecond;
		JComboBox comboBox = new JComboBox();
		private JTable table_1;
		private JTable table_2;
		private JTable table_3;
		JButton btnNewButton_5 = new JButton("GET COLLEGE");
		JButton btnNewButton_3 = new JButton("GET JUNIOR");
		JButton btnNewButton_2 = new JButton("GET ELEM");
		JButton btnNewButton_4 = new JButton("GET SENIOR");
		JButton btnNewButton_6 = new JButton("GET VOC");
		JLabel allelem = new JLabel("0");
		JLabel alljunior = new JLabel("0");
		JLabel allsenior = new JLabel("0");
		JLabel allcollege = new JLabel("0");
		JLabel allvoc = new JLabel("0");
		
		JLabel allstudent = new JLabel("0");
		JLabel allsport = new JLabel("0");
		JLabel allmale = new JLabel("0");
		JLabel allfemale = new JLabel("0");
		JLabel allactive = new JLabel("0");
		JLabel alldrop = new JLabel("0");
		private JTextField textField;
		
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
		
		
		/**
	 * Create the panel.
	 */
	public Reports() {
		initialize();
		allstudent();
		connection();
		AllMale();	
		AllFemale();
		allActive();
		allSports();
		info();
		search();
		alldrop();
		allElemLevel();
		alljuniorLevel();
		allseniorLevel();
		allcollegeLevel();
		allvocLevel();
		showDate();
		showTime();
		 
	}
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
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(437, 40, 242, 40);
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
		
		JLabel lblNewLabel_3_1 = new JLabel("BARANGAY STUDENT DATABASE");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3_1.setBounds(215, 0, 708, 46);
		panel_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_8 = new JLabel("New label");
		ImageIcon bar = new ImageIcon(this.getClass().getResource("/barangay.png"));
		Image bar1 = bar.getImage();	
		Image bar2 = bar1.getScaledInstance(98,79, Image.SCALE_SMOOTH);
		ImageIcon bar3 = new ImageIcon(bar2);
		lblNewLabel_1_8.setIcon(bar3);
		lblNewLabel_1_8.setBounds(151, 0, 98, 79);
		panel_1_1.add(lblNewLabel_1_8);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(32, 90, 1127, 754);
		add(tabbedPane_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(245, 222, 179));
		tabbedPane_1.addTab("SEARCHING INFORMATION", null, panel_13, null);
		panel_13.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 71, 1018, 207);
		panel_13.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPane.setViewportView(table);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(52, 21, 125, 38);
		panel_13.add(txtFirst);
		txtFirst.setColumns(10);
		
		txtSecond = new JTextField();
		txtSecond.setBounds(209, 21, 125, 38);
		panel_13.add(txtSecond);
		txtSecond.setColumns(10);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setBounds(174, 23, 37, 38);
		panel_13.add(lblTo);
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 19));
		comboBox.setBounds(344, 21, 134, 38);
		panel_13.add(comboBox);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Age", "Purok"}));
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBounds(488, 21, 101, 38);
		panel_13.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String val1= txtFirst.getText();
				String val2= txtSecond.getText();
				String tmp = comboBox.getSelectedItem().toString();
				
				if(tmp.equals("Age")) {
				try {
					 
					String sql = "Select * from studentrecord where Age between '"+val1+"' and '"+val2+"'";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					DefaultTableModel model = new DefaultTableModel() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					
					model.addColumn("Registration No.");
					model.addColumn("Firstname");
					model.addColumn("Middlename.");
					model.addColumn("Lastname.");
					model.addColumn("Suffix.");
					model.addColumn("Birthdate.");
					model.addColumn("Age.");
					model.addColumn("BirthPlace.");
					model.addColumn("Gender.");
					model.addColumn("ContactNo.");
					model.addColumn("CivilStatus.");
					model.addColumn("Height.");
					model.addColumn("Weight.");
					model.addColumn("Religion.");
					model.addColumn("Sports.");
					model.addColumn("Email.");
					model.addColumn("Hobbies.");
					model.addColumn("VaccinationStatus.");
					model.addColumn("FirstDose.");
					model.addColumn("SecondDose.");
					model.addColumn("Booster.");
					model.addColumn("Purok.");
					model.addColumn("HouseNo.");
					model.addColumn("Barangay.");
					model.addColumn("GovProgram.");
					model.addColumn("FamilyStatus.");
					
					model.addColumn("LRN.");
					
					
					model.addColumn("Elementary.");
					model.addColumn("ElemLevel.");
					model.addColumn("ElemSY.");
					
					
					model.addColumn("JuniorHighSchool.");
					model.addColumn("JuniorHighLevel.");
					model.addColumn("JuniorHighSY.");
					
					model.addColumn("SeniorHighSchool.");
					model.addColumn("SeniorHighLevel.");
					model.addColumn("SeniorHighSY.");
					
					
					model.addColumn("College.");
					model.addColumn("CollegeLevel.");
					model.addColumn("CollegeSY.");
					
					
					model.addColumn("Vocational.");
					model.addColumn("VocCategories.");
					model.addColumn("VocSY.");
					model.addColumn("Date.");
					int tableModel=0;
					while(rs.next()) {
						 if(rs.getString("studentStatus").equals("Active")) {
							 String RegistrationNo = rs.getString("RegistrationNo");
							 String Firstname = rs.getString("Firstname");
							 String Middlename = rs.getString("Middlename");
							 String Lastname = rs.getString("Lastname");
							 String suffix = rs.getString("Suffix");
							 String birthdate = rs.getString("Birthdate");
							 String age = rs.getString("Age");
							 String bp = rs.getString("BirthPlace");
							 String gender = rs.getString("Gender");
							 String cn = rs.getString("ContactNo");
							 String cs = rs.getString("CivilStatus");
							 String h = rs.getString("Height");
							 String w = rs.getString("Weight");
							 String Religion = rs.getString("Religion");
							 String sport = rs.getString("Sports");
							 String email = rs.getString("Email");
							 String hob = rs.getString("Hobbies");
							 String vs = rs.getString("VaccinationStatus");
							 String fd = rs.getString("FirstDose");
							 String sd = rs.getString("SecondDose");
							 String bos = rs.getString("Booster");
							 String purok = rs.getString("Purok");
							 String hn = rs.getString("HouseNo");
							 String barangay = rs.getString("Barangay");
							 String gp = rs.getString("GovProgram");
							 String familyStatus = rs.getString("FamilyStatus");
							 String lrn = rs.getString("LRN");
							 String elem = rs.getString("Elementary");
							 String elem1 = rs.getString("ElemLevel");
							 String elem2 = rs.getString("ElemSY"); 
							 String junior = rs.getString("JuniorHighSchool");
							 String junior1 = rs.getString("JuniorHighLevel");
							 String junior2 = rs.getString("JuniorHighSY");
							 String senior = rs.getString("SeniorHighSchool");
							 String senior1 = rs.getString("SeniorHighLevel");
							 String senior2 = rs.getString("SeniorHighSY");
							 String college = rs.getString("College");
							 String college1 = rs.getString("CollegeLevel");
							 String college2 = rs.getString("CollegeSY");
							 String voc = rs.getString("Vocational");
							 String voc1 = rs.getString("VocCategories");
							 String voc2 = rs.getString("VocSY");
							 String date = rs.getString("Date");
							 
							 model.insertRow(tableModel, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
									 familyStatus,lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,voc,voc1,voc2,date
									 });
							 tableModel++;
						 }
					}
					table.setModel(model);
					
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
				}
				else if(tmp.equals("Purok")) {
					try {
						
						String sql = "Select * from studentrecord where Purok between '"+val1+"' and '"+val2+"'";
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();
						DefaultTableModel model = new DefaultTableModel() {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						
						model.addColumn("Registration No.");
						model.addColumn("Firstname");
						model.addColumn("Middlename.");
						model.addColumn("Lastname.");
						model.addColumn("Suffix.");
						model.addColumn("Birthdate.");
						model.addColumn("Age.");
						model.addColumn("BirthPlace.");
						model.addColumn("Gender.");
						model.addColumn("ContactNo.");
						model.addColumn("CivilStatus.");
						model.addColumn("Height.");
						model.addColumn("Weight.");
						model.addColumn("Religion.");
						model.addColumn("Sports.");
						model.addColumn("Email.");
						model.addColumn("Hobbies.");
						model.addColumn("VaccinationStatus.");
						model.addColumn("FirstDose.");
						model.addColumn("SecondDose.");
						model.addColumn("Booster.");
						model.addColumn("Purok.");
						model.addColumn("HouseNo.");
						model.addColumn("Barangay.");
						model.addColumn("GovProgram.");
						model.addColumn("FamilyStatus.");
						
						model.addColumn("LRN.");
						
						
						model.addColumn("Elementary.");
						model.addColumn("ElemLevel.");
						model.addColumn("ElemSY.");
						
						
						model.addColumn("JuniorHighSchool.");
						model.addColumn("JuniorHighLevel.");
						model.addColumn("JuniorHighSY.");
						
						model.addColumn("SeniorHighSchool.");
						model.addColumn("SeniorHighLevel.");
						model.addColumn("SeniorHighSY.");
						
						
						model.addColumn("College.");
						model.addColumn("CollegeLevel.");
						model.addColumn("CollegeSY.");
						
						
						model.addColumn("Vocational.");
						model.addColumn("VocCategories.");
						model.addColumn("VocSY.");
						model.addColumn("Date.");
						int tableModel=0;
						while(rs.next()) {
							 if(rs.getString("studentStatus").equals("Active")) {
								 String RegistrationNo = rs.getString("RegistrationNo");
								 String Firstname = rs.getString("Firstname");
								 String Middlename = rs.getString("Middlename");
								 String Lastname = rs.getString("Lastname");
								 String suffix = rs.getString("Suffix");
								 String birthdate = rs.getString("Birthdate");
								 String age = rs.getString("Age");
								 String bp = rs.getString("BirthPlace");
								 String gender = rs.getString("Gender");
								 String cn = rs.getString("ContactNo");
								 String cs = rs.getString("CivilStatus");
								 String h = rs.getString("Height");
								 String w = rs.getString("Weight");
								 String Religion = rs.getString("Religion");
								 String sport = rs.getString("Sports");
								 String email = rs.getString("Email");
								 String hob = rs.getString("Hobbies");
								 String vs = rs.getString("VaccinationStatus");
								 String fd = rs.getString("FirstDose");
								 String sd = rs.getString("SecondDose");
								 String bos = rs.getString("Booster");
								 String purok = rs.getString("Purok");
								 String hn = rs.getString("HouseNo");
								 String barangay = rs.getString("Barangay");
								 String gp = rs.getString("GovProgram");
								 String familyStatus = rs.getString("FamilyStatus");
								 
								 String lrn = rs.getString("LRN");
								
								 
								 String elem = rs.getString("Elementary");
								 String elem1 = rs.getString("ElemLevel");
								 String elem2 = rs.getString("ElemSY");
								 
								 String junior = rs.getString("JuniorHighSchool");
								 String junior1 = rs.getString("JuniorHighLevel");
								 String junior2 = rs.getString("JuniorHighSY");
								 
								 String senior = rs.getString("SeniorHighSchool");
								 String senior1 = rs.getString("SeniorHighLevel");
								 String senior2 = rs.getString("SeniorHighSY");
								 
								 String college = rs.getString("College");
								 String college1 = rs.getString("CollegeLevel");
								 String college2 = rs.getString("CollegeSY");
								 
								 String voc = rs.getString("Vocational");
								 String voc1 = rs.getString("VocCategories");
								 String voc2 = rs.getString("VocSY");
								 String date = rs.getString("Date");
								 
								 model.insertRow(tableModel, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
										 familyStatus,lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,voc,voc1,voc2,date
										 });
								 tableModel++;
							 }
						}
						table.setModel(model);
						
					}catch(Exception ee) {
						JOptionPane.showMessageDialog(null, ee);
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("REFRESH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFirst.setText("");
				txtSecond.setText("");
				info();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(593, 21, 101, 38);
		panel_13.add(btnNewButton_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(245, 245, 220));
		panel_6.setBounds(51, 289, 1018, 409);
		panel_13.add(panel_6);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(140, 11, 180, 165);
		panel_6.add(panel);
		
		JLabel lblNewLabel = new JLabel("ALL STUDENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel.setBounds(0, 11, 180, 46);
		panel.add(lblNewLabel);
		
		
		allstudent.setHorizontalAlignment(SwingConstants.CENTER);
		allstudent.setFont(new Font("Tahoma", Font.BOLD, 21));
		allstudent.setBounds(0, 68, 180, 86);
		panel.add(allstudent);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(140, 231, 180, 165);
		panel_6.add(panel_1);
	
		allsport.setHorizontalAlignment(SwingConstants.CENTER);
		allsport.setFont(new Font("Tahoma", Font.BOLD, 21));
		allsport.setBounds(0, 68, 180, 86);
		panel_1.add(allsport);
		
		JLabel lblSchool = new JLabel("SPORTS");
		lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchool.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSchool.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblSchool.setBounds(0, 11, 180, 46);
		panel_1.add(lblSchool);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(409, 11, 180, 165);
		panel_6.add(panel_2);
		
		allmale.setHorizontalAlignment(SwingConstants.CENTER);
		allmale.setFont(new Font("Tahoma", Font.BOLD, 21));
		allmale.setBounds(0, 68, 180, 86);
		panel_2.add(allmale);
		
		JLabel lblMale = new JLabel("MALE");
		lblMale.setHorizontalAlignment(SwingConstants.CENTER);
		lblMale.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMale.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblMale.setBounds(0, 11, 180, 46);
		panel_2.add(lblMale);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(682, 11, 180, 165);
		panel_6.add(panel_3);
		
		allfemale.setHorizontalAlignment(SwingConstants.CENTER);
		allfemale.setFont(new Font("Tahoma", Font.BOLD, 21));
		allfemale.setBounds(0, 68, 180, 86);
		panel_3.add(allfemale);
		
		JLabel lblFemale = new JLabel("FEMALE");
		lblFemale.setHorizontalAlignment(SwingConstants.CENTER);
		lblFemale.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFemale.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblFemale.setBounds(0, 11, 180, 46);
		panel_3.add(lblFemale);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBounds(409, 231, 180, 165);
		panel_6.add(panel_4);
		
		allactive.setHorizontalAlignment(SwingConstants.CENTER);
		allactive.setFont(new Font("Tahoma", Font.BOLD, 21));
		allactive.setBounds(0, 68, 180, 86);
		panel_4.add(allactive);
		
		JLabel lblActive = new JLabel("ACTIVE");
		lblActive.setHorizontalAlignment(SwingConstants.CENTER);
		lblActive.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblActive.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblActive.setBounds(0, 11, 180, 46);
		panel_4.add(lblActive);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_5.setBounds(682, 231, 180, 165);
		panel_6.add(panel_5);
		
		alldrop.setHorizontalAlignment(SwingConstants.CENTER);
		alldrop.setFont(new Font("Tahoma", Font.BOLD, 21));
		alldrop.setBounds(0, 68, 180, 86);
		panel_5.add(alldrop);
		
		JLabel lblDrop = new JLabel("DROP");
		lblDrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrop.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDrop.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblDrop.setBounds(0, 11, 180, 46);
		panel_5.add(lblDrop);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(245, 222, 179));
		tabbedPane_1.addTab("ALL STUDENT", null, panel_16, null);
		panel_16.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(245, 245, 220));
		panel_7.setBounds(54, 291, 1013, 409);
		panel_16.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_8.setBounds(115, 11, 180, 165);
		panel_7.add(panel_8);
		
		JLabel lblElementary = new JLabel("ELEMENTARY");
		lblElementary.setHorizontalAlignment(SwingConstants.CENTER);
		lblElementary.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElementary.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblElementary.setBounds(0, 11, 180, 46);
		panel_8.add(lblElementary);
		allelem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_2.setVisible(true);
				btnNewButton_3.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_5.setVisible(false);
				btnNewButton_6.setVisible(false);
				elem();
				
				
			}
		});
		
	
		allelem.setHorizontalAlignment(SwingConstants.CENTER);
		allelem.setFont(new Font("Tahoma", Font.BOLD, 21));
		allelem.setBorder(null);
		allelem.setBounds(0, 57, 180, 108);
		panel_8.add(allelem);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_9.setBounds(398, 11, 180, 165);
		panel_7.add(panel_9);
		
		JLabel lblJuniorHigh = new JLabel("JUNIOR HIGH");
		lblJuniorHigh.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuniorHigh.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblJuniorHigh.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblJuniorHigh.setBounds(0, 11, 180, 46);
		panel_9.add(lblJuniorHigh);
		alljunior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					btnNewButton_3.setVisible(true);
					btnNewButton_2.setVisible(false);
					btnNewButton_4.setVisible(false);
					btnNewButton_5.setVisible(false);
					btnNewButton_6.setVisible(false);
					junior();
			}
		});
		
		alljunior.setHorizontalAlignment(SwingConstants.CENTER);
		alljunior.setFont(new Font("Tahoma", Font.BOLD, 21));
		alljunior.setBorder(null);
		alljunior.setBounds(0, 57, 180, 108);
		panel_9.add(alljunior);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_10.setBounds(678, 11, 180, 165);
		panel_7.add(panel_10);
		
		JLabel lblSeniorHigh = new JLabel("SENIOR HIGH");
		lblSeniorHigh.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeniorHigh.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSeniorHigh.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblSeniorHigh.setBounds(0, 11, 180, 46);
		panel_10.add(lblSeniorHigh);
		allsenior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_4.setVisible(true);
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				btnNewButton_5.setVisible(false);
				btnNewButton_6.setVisible(false);
				senior();
			}
		});
		
		allsenior.setHorizontalAlignment(SwingConstants.CENTER);
		allsenior.setFont(new Font("Tahoma", Font.BOLD, 21));
		allsenior.setBorder(null);
		allsenior.setBounds(0, 56, 180, 108);
		panel_10.add(allsenior);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_11.setBounds(262, 222, 180, 165);
		panel_7.add(panel_11);
		
		JLabel lblCollege = new JLabel("COLLEGE");
		lblCollege.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollege.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCollege.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblCollege.setBounds(0, 11, 180, 46);
		panel_11.add(lblCollege);
		allcollege.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_5.setVisible(true);
				btnNewButton_4.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				btnNewButton_6.setVisible(false);
				college();
			}
		});
		
		allcollege.setHorizontalAlignment(SwingConstants.CENTER);
		allcollege.setFont(new Font("Tahoma", Font.BOLD, 21));
		allcollege.setBorder(null);
		allcollege.setBounds(0, 56, 180, 108);
		panel_11.add(allcollege);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_12.setBounds(547, 222, 180, 165);
		panel_7.add(panel_12);
		
		JLabel lblVocational = new JLabel("VOCATIONAL");
		lblVocational.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocational.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVocational.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblVocational.setBounds(0, 11, 180, 46);
		panel_12.add(lblVocational);
		allvoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_6.setVisible(true);
				btnNewButton_5.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				voc();
			}
		});
		
		allvoc.setHorizontalAlignment(SwingConstants.CENTER);
		allvoc.setFont(new Font("Tahoma", Font.BOLD, 21));
		allvoc.setBorder(null);
		allvoc.setBounds(0, 56, 180, 108);
		panel_12.add(allvoc);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(54, 55, 1013, 225);
		panel_16.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_3.setViewportView(table_3);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
		            String query =" SELECT * FROM studentrecord WHERE RegistrationNo = ?";
		            pst=conn.prepareStatement(query);
		            pst.setString(1, textField.getText().toLowerCase());
		            rs = pst.executeQuery();

		            DefaultTableModel Df = (DefaultTableModel)table_3.getModel();
		            String search = textField.getText();
		            TableRowSorter< DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(Df);
		            table_3.setRowSorter(trs);
		            trs.setRowFilter(RowFilter.regexFilter(search));

		        }catch (Exception ee){

		        }
				
				
			}
		});
		textField.setBounds(867, 11, 199, 35);
		panel_16.add(textField);
		textField.setColumns(10);
		btnNewButton_2.setVisible(false);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//printJavaJFrameJTable();
				
					TableModel model1 = table_3.getModel();
					int indexs[] = table_3.getSelectedRows();
					
					Object[] row  =new Object[30];
					
					Prints print1123 = new Prints();
					DefaultTableModel model2 = (DefaultTableModel)print1123.table.getModel();

						for(int i=0; i< indexs.length; i++)
						{
						
							row[0] = model1.getValueAt(indexs[i], 0);
							row[1] = model1.getValueAt(indexs[i], 1);
							row[2] = model1.getValueAt(indexs[i], 2);
							row[3] = model1.getValueAt(indexs[i], 3);
							row[4] = model1.getValueAt(indexs[i], 26);
							row[5] = model1.getValueAt(indexs[i], 27);
							row[6] = model1.getValueAt(indexs[i], 28);
							model2.addRow(row);
							}
						print1123.frame.setVisible(true);
						
			}
				
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(54, 11, 142, 33);
		panel_16.add(btnNewButton_2);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setVisible(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel model1 = table_3.getModel();
				int indexs[] = table_3.getSelectedRows();
				
				Object[] row  =new Object[30];
				
				Prints print1 = new Prints();
				DefaultTableModel model2 = (DefaultTableModel)print1.table.getModel();

					for(int i=0; i< indexs.length; i++)
					{
					
						row[0] = model1.getValueAt(indexs[i], 0);
						row[1] = model1.getValueAt(indexs[i], 1);
						row[2] = model1.getValueAt(indexs[i], 2);
						row[3] = model1.getValueAt(indexs[i], 3);
						row[4] = model1.getValueAt(indexs[i], 29);
						row[5] = model1.getValueAt(indexs[i], 30);
						row[6] = model1.getValueAt(indexs[i], 31);
						model2.addRow(row);
						}
					print1.frame.setVisible(true);
					
			}
		});

		btnNewButton_3.setBounds(54, 11, 142, 33);
		panel_16.add(btnNewButton_3);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel model1 = table_3.getModel();
				int indexs[] = table_3.getSelectedRows();
				
				Object[] row  =new Object[30];
				
				Prints print1 = new Prints();
				DefaultTableModel model2 = (DefaultTableModel)print1.table.getModel();

					for(int i=0; i< indexs.length; i++)
					{
					
						row[0] = model1.getValueAt(indexs[i], 0);
						row[1] = model1.getValueAt(indexs[i], 1);
						row[2] = model1.getValueAt(indexs[i], 2);
						row[3] = model1.getValueAt(indexs[i], 3);
						row[4] = model1.getValueAt(indexs[i], 32);
						row[5] = model1.getValueAt(indexs[i], 33);
						row[6] = model1.getValueAt(indexs[i], 34);
						model2.addRow(row);
						}
					print1.frame.setVisible(true);
					
				
			}
		});

		btnNewButton_4.setVisible(false);
		btnNewButton_4.setBounds(54, 11, 142, 33);
		panel_16.add(btnNewButton_4);
		
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableModel model1 = table_3.getModel();
				int indexs[] = table_3.getSelectedRows();
				
				Object[] row  =new Object[30];
				
				Prints print1 = new Prints();
				DefaultTableModel model2 = (DefaultTableModel)print1.table.getModel();

					for(int i=0; i< indexs.length; i++)
					{
					
						row[0] = model1.getValueAt(indexs[i], 0);
						row[1] = model1.getValueAt(indexs[i], 1);
						row[2] = model1.getValueAt(indexs[i], 2);
						row[3] = model1.getValueAt(indexs[i], 3);
						row[4] = model1.getValueAt(indexs[i], 35);
						row[5] = model1.getValueAt(indexs[i], 36);
						row[6] = model1.getValueAt(indexs[i], 37);
						model2.addRow(row);
						}
					print1.frame.setVisible(true);
					
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(54, 11, 142, 33);
		btnNewButton_5.setVisible(false);
		panel_16.add(btnNewButton_5);
		
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel model1 = table_3.getModel();
				int indexs[] = table_3.getSelectedRows();
				
				Object[] row  =new Object[30];
				
				Prints print1 = new Prints();
				DefaultTableModel model2 = (DefaultTableModel)print1.table.getModel();

					for(int i=0; i< indexs.length; i++)
					{
					
						row[0] = model1.getValueAt(indexs[i], 0);
						row[1] = model1.getValueAt(indexs[i], 1);
						row[2] = model1.getValueAt(indexs[i], 2);
						row[3] = model1.getValueAt(indexs[i], 3);
						row[4] = model1.getValueAt(indexs[i], 38);
						row[5] = model1.getValueAt(indexs[i], 39);
						row[6] = model1.getValueAt(indexs[i], 40);
						model2.addRow(row);
						}
					print1.frame.setVisible(true);
					
				
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.setBounds(56, 11, 140, 33);
		btnNewButton_6.setVisible(false);
		panel_16.add(btnNewButton_6);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(245, 222, 179));
		tabbedPane_1.addTab("ACTIVE STUDENT", null, panel_14, null);
		panel_14.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(77, 62, 967, 540);
		panel_14.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(245, 222, 179));
		tabbedPane_1.addTab("DROPPED STUDENT", null, panel_15, null);
		panel_15.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(77, 62, 967, 540);
		panel_15.add(scrollPane_2);
		
		table_2 = new JTable();
		
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_2.setViewportView(table_2);
		
		
		
		
	}
	

	public void allstudent()  {
		  try {
		    
				connection();
			  pst = conn.prepareStatement("SELECT COUNT(*) AS student FROM studentrecord");
			  rs = pst.executeQuery();
			  while(rs.next()) {
				  int count = rs.getInt("student");
				  allstudent.setText(String.valueOf(count));
			  }
			  
		  }catch(Exception ee) {
			  
		  }
	}
		public void AllMale() {
		try {
			connection();
			 String sql = "SELECT count(*) as Male from studentrecord where Gender = 'MALE'";
			 pst = conn.prepareStatement(sql);
			  rs = pst.executeQuery();
			  while(rs.next()) {
			
			  int gender = rs.getInt ("Male");
				allmale.setText(String.valueOf(gender));
				 
				 
			  }
			 
			 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
		public void AllFemale() {
			try {
				connection();
				 String sql = "SELECT count(*) as Female from studentrecord where Gender = 'FEMALE'";
				 pst = conn.prepareStatement(sql);
				  rs = pst.executeQuery();
				  while(rs.next()) {
				
				  int gender = rs.getInt ("Female");
					allfemale.setText(String.valueOf(gender));
					 
					 
				  }
				 
				 
			}catch(Exception e) {
				System.out.println(e);
			}
			
}
		
		public void info() {
			String sql ="Select * from studentrecord WHERE studentStatus='Active'";
	        try {
	        	connection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				DefaultTableModel model = new DefaultTableModel() {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				
				model.addColumn("Registration No.");
				model.addColumn("Firstname");
				model.addColumn("Middlename.");
				model.addColumn("Lastname.");
				model.addColumn("Suffix.");
				model.addColumn("Birthdate.");
				model.addColumn("Age.");
				model.addColumn("BirthPlace.");
				model.addColumn("Gender.");
				model.addColumn("ContactNo.");
				model.addColumn("CivilStatus.");
				model.addColumn("Height.");
				model.addColumn("Weight.");
				model.addColumn("Religion.");
				model.addColumn("Sports.");
				model.addColumn("Email.");
				model.addColumn("Hobbies.");
				model.addColumn("VaccinationStatus.");
				model.addColumn("FirstDose.");
				model.addColumn("SecondDose.");
				model.addColumn("Booster.");
				model.addColumn("Purok.");
				model.addColumn("HouseNo.");
				model.addColumn("Barangay.");
				model.addColumn("GovProgram.");
				
				model.addColumn("LRN.");
				
				
				model.addColumn("Elementary.");
				model.addColumn("ElemLevel.");
				model.addColumn("ElemSY.");
				
				
				model.addColumn("JuniorHighSchool.");
				model.addColumn("JuniorHighLevel.");
				model.addColumn("JuniorHighSY.");
				
				model.addColumn("SeniorHighSchool.");
				model.addColumn("SeniorHighLevel.");
				model.addColumn("SeniorHighSY.");
				
				
				model.addColumn("College.");
				model.addColumn("CollegeLevel.");
				model.addColumn("CollegeSY.");
				
				
				model.addColumn("Vocational.");
				model.addColumn("VocCategories.");
				model.addColumn("VocSY.");
				model.addColumn("Date.");
				int tableModel=0;
				while(rs.next()) {
					 if(rs.getString("studentStatus").equals("Active")) {
						 String RegistrationNo = rs.getString("RegistrationNo");
						 String Firstname = rs.getString("Firstname");
						 String Middlename = rs.getString("Middlename");
						 String Lastname = rs.getString("Lastname");
						 String suffix = rs.getString("Suffix");
						 String birthdate = rs.getString("Birthdate");
						 String age = rs.getString("Age");
						 String bp = rs.getString("BirthPlace");
						 String gender = rs.getString("Gender");
						 String cn = rs.getString("ContactNo");
						 String cs = rs.getString("CivilStatus");
						 String h = rs.getString("Height");
						 String w = rs.getString("Weight");
						 String Religion = rs.getString("Religion");
						 String sport = rs.getString("Sports");
						 String email = rs.getString("Email");
						 String hob = rs.getString("Hobbies");
						 String vs = rs.getString("VaccinationStatus");
						 String fd = rs.getString("FirstDose");
						 String sd = rs.getString("SecondDose");
						 String bos = rs.getString("Booster");
						 String purok = rs.getString("Purok");
						 String hn = rs.getString("HouseNo");
						 String barangay = rs.getString("Barangay");
						 String gp = rs.getString("GovProgram");
						
						 
						 String lrn = rs.getString("LRN");
						 
						 
						 String elem = rs.getString("Elementary");
						 String elem1 = rs.getString("ElemLevel");
						 String elem2 = rs.getString("ElemSY");
						 
						 String junior = rs.getString("JuniorHighSchool");
						 String junior1 = rs.getString("JuniorHighLevel");
						 String junior2 = rs.getString("JuniorHighSY");
						 
						 String senior = rs.getString("SeniorHighSchool");
						 String senior1 = rs.getString("SeniorHighLevel");
						 String senior2 = rs.getString("SeniorHighSY");
						 
						 String college = rs.getString("College");
						 String college1 = rs.getString("CollegeLevel");
						 String college2 = rs.getString("CollegeSY");
						 
						 String voc = rs.getString("Vocational");
						 String voc1 = rs.getString("VocCategories");
						 String voc2 = rs.getString("VocSY");
						 String date = rs.getString("Date");
						 
						 model.insertRow(tableModel, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
								 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,voc,voc1,voc2,date
								 });
						 tableModel++;
					 }
				}
				table.setModel(model);		

	        } catch (Exception ex) {

	        }finally {
	try {
		rs.close();
		pst.close();
	}catch(Exception e) {
		
	}
	        }
		}
	        public void allActive() {
				try {
					connection();
					 String sql = "SELECT count(*) as Active from studentrecord where studentStatus='Active'";
					 pst = conn.prepareStatement(sql);
					  rs = pst.executeQuery();
					  while(rs.next()) {
					
					  int gender = rs.getInt("Active");
						allactive.setText(String.valueOf(gender));
						 
						 
					  }
					 
					 
				}catch(Exception e) {
					System.out.println(e);
				}
	

		}
	        public void allSports() {
				try {
					connection();
					 String sql = "SELECT COUNT(*) as sports from studentrecord WHERE Sports IN ('Basketball','Volleyball')";
					 
					 pst = conn.prepareStatement(sql);
					  rs = pst.executeQuery();
					  while(rs.next()) {
					
					  int sport = rs.getInt ("sports");
						allsport.setText(String.valueOf(sport));
						 
						 
					  }
					 
					 
				}catch(Exception e) {
					System.out.println(e);
				}
	        }
	        
	        public void search() {
				String sql ="Select RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Email,Hobbies,VaccinationStatus,FirstDose,SecondDose,Booster,Purok,HouseNo,Barangay,GovProgram,"
						+ "Father,FatherBirthdate,FatherAge,FatherContact,FatherOccupation,FatherIncome,Mother,MotherBirthdate,MotherAge,MotherContact,MotherOccupation,MotherIncome,Siblings,FamilyStatus,BirthOrder,"
						+ "LRN,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date,studentStatus,Reason from studentrecord";
		        try {
		        	connection();
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					
					DefaultTableModel model = new DefaultTableModel() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					
					DefaultTableModel modelTable2 = new DefaultTableModel(){
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					
					model.addColumn("Registration No.");
					model.addColumn("Firstname");
					model.addColumn("Middlename.");
					model.addColumn("Lastname.");
					model.addColumn("Suffix.");
					model.addColumn("Birthdate.");
					model.addColumn("Age.");
					model.addColumn("BirthPlace.");
					model.addColumn("Gender.");
					model.addColumn("ContactNo.");
					model.addColumn("CivilStatus.");
					model.addColumn("Height.");
					model.addColumn("Weight.");
					model.addColumn("Religion.");
					model.addColumn("Sports.");
					model.addColumn("Email.");
					model.addColumn("Hobbies.");
					model.addColumn("VaccinationStatus.");
					model.addColumn("FirstDose.");
					model.addColumn("SecondDose.");
					model.addColumn("Booster.");
					model.addColumn("Purok.");
					model.addColumn("HouseNo.");
					model.addColumn("Barangay.");
					model.addColumn("GovProgram.");
					
					
					model.addColumn("Father.");
					model.addColumn("FatherBirthdate.");
					model.addColumn("FatherAge.");
					model.addColumn("FatherContact.");
					model.addColumn("FatherOccupation.");
					model.addColumn("FatherIncome.");
					
					
					model.addColumn("Mother.");
					model.addColumn("MotherBirthdate.");
					model.addColumn("MotherAge.");
					model.addColumn("MotherContact.");
					model.addColumn("MotherOccupation.");
					model.addColumn("MotherIncome.");
					
					model.addColumn("Siblings.");
					model.addColumn("BirthOrder.");
					model.addColumn("FamilyStatus.");
					
					model.addColumn("LRN.");	
					model.addColumn("Elementary.");
					model.addColumn("ElemLevel.");
					model.addColumn("ElemSY.");
					
					
					model.addColumn("JuniorHighSchool.");
					model.addColumn("JuniorHighLevel.");
					model.addColumn("JuniorHighSY.");
					
					model.addColumn("SeniorHighSchool.");
					model.addColumn("SeniorHighLevel.");
					model.addColumn("SeniorHighSY.");
					
					
					model.addColumn("College.");
					model.addColumn("CollegeLevel.");
					model.addColumn("CollegeSY.");
					
					
					model.addColumn("Vocational.");
					model.addColumn("VocCategories.");
					model.addColumn("VocSY.");
					model.addColumn("Date.");
					model.addColumn("Status.");

					modelTable2.addColumn("Registration No.");
					modelTable2.addColumn("Firstname");
					modelTable2.addColumn("Middlename.");
					modelTable2.addColumn("Lastname.");
					modelTable2.addColumn("Suffix.");
					modelTable2.addColumn("Birthdate.");
					modelTable2.addColumn("Age.");
					modelTable2.addColumn("BirthPlace.");
					modelTable2.addColumn("Gender.");
					modelTable2.addColumn("ContactNo.");
					modelTable2.addColumn("CivilStatus.");
					modelTable2.addColumn("Height.");
					modelTable2.addColumn("Weight.");
					modelTable2.addColumn("Religion.");
					modelTable2.addColumn("Sports.");
					modelTable2.addColumn("Email.");
					modelTable2.addColumn("Hobbies.");
					modelTable2.addColumn("VaccinationStatus.");
					modelTable2.addColumn("FirstDose.");
					modelTable2.addColumn("SecondDose.");
					modelTable2.addColumn("Booster.");
					modelTable2.addColumn("Purok.");
					modelTable2.addColumn("HouseNo.");
					modelTable2.addColumn("Barangay.");
					modelTable2.addColumn("GovProgram.");
					
					
					modelTable2.addColumn("Father.");
					modelTable2.addColumn("FatherBirthdate.");
					modelTable2.addColumn("FatherAge.");
					modelTable2.addColumn("FatherContact.");
					modelTable2.addColumn("FatherOccupation.");
					modelTable2.addColumn("FatherIncome.");
					
					
					modelTable2.addColumn("Mother.");
					modelTable2.addColumn("MotherBirthdate.");
					modelTable2.addColumn("MotherAge.");
					modelTable2.addColumn("MotherContact.");
					modelTable2.addColumn("MotherOccupation.");
					modelTable2.addColumn("MotherIncome.");
					
					modelTable2.addColumn("Siblings.");
					modelTable2.addColumn("BirthOrder.");
					modelTable2.addColumn("FamilyStatus.");
					
					modelTable2.addColumn("LRN.");
					
					
					modelTable2.addColumn("Elementary.");
					modelTable2.addColumn("ElemLevel.");
					modelTable2.addColumn("ElemSY.");
					
					
					modelTable2.addColumn("JuniorHighSchool.");
					modelTable2.addColumn("JuniorHighLevel.");
					modelTable2.addColumn("JuniorHighSY.");
					
					modelTable2.addColumn("SeniorHighSchool.");
					modelTable2.addColumn("SeniorHighLevel.");
					modelTable2.addColumn("SeniorHighSY.");
					
					
					modelTable2.addColumn("College.");
					modelTable2.addColumn("CollegeLevel.");
					modelTable2.addColumn("CollegeSY.");
					
					
					modelTable2.addColumn("Vocational.");
					modelTable2.addColumn("VocCategories.");
					modelTable2.addColumn("VocSY.");
					modelTable2.addColumn("Date.");
					modelTable2.addColumn("Status.");
					modelTable2.addColumn("Reason.");

					
					int table1size = 0;
					int table2size = 0;
					while(rs.next()) {
					 String RegistrationNo = rs.getString("RegistrationNo");
					 String Firstname = rs.getString("Firstname");
					 String Middlename = rs.getString("Middlename");
					 String Lastname = rs.getString("Lastname");
					 String suffix = rs.getString("Suffix");
					 String birthdate = rs.getString("Birthdate");
					 String age = rs.getString("Age");
					 String bp = rs.getString("BirthPlace");
					 String gender = rs.getString("Gender");
					 String cn = rs.getString("ContactNo");
					 String cs = rs.getString("CivilStatus");
					 String h = rs.getString("Height");
					 String w = rs.getString("Weight");
					 String Religion = rs.getString("Religion");
					 String sport = rs.getString("Sports");
					 String email = rs.getString("Email");
					 String hob = rs.getString("Hobbies");
					 String vs = rs.getString("VaccinationStatus");
					 String fd = rs.getString("FirstDose");
					 String sd = rs.getString("SecondDose");
					 String bos = rs.getString("Booster");
					 String purok = rs.getString("Purok");
					 String hn = rs.getString("HouseNo");
					 String barangay = rs.getString("Barangay");
					 String gp = rs.getString("GovProgram");
					 
					 String father = rs.getString("Father");
					 String fatherbirthdate = rs.getString("FatherBirthdate");
					 String fatherage = rs.getString("FatherAge");
					 String fathercon= rs.getString("FatherContact");
					 String fatherocc = rs.getString("FatherOccupation");
					 String fatherincome = rs.getString("FatherIncome");
					
					 String mother = rs.getString("Mother");
					 String motherbirthdate = rs.getString("MotherBirthdate");
					 String motherage = rs.getString("MotherAge");
					 String mothercon= rs.getString("MotherContact");
					 String motherocc = rs.getString("MotherOccupation");
					 String motherincome = rs.getString("MotherIncome");
					 
					 String siblings = rs.getString("Siblings");
					 String birthorder = rs.getString("BirthOrder");
					 String familyStatus = rs.getString("FamilyStatus");
					 
					 String lrn = rs.getString("LRN");
					
					 
					 String elem = rs.getString("Elementary");
					 String elem1 = rs.getString("ElemLevel");
					 String elem2 = rs.getString("ElemSY");
					 
					 String junior = rs.getString("JuniorHighSchool");
					 String junior1 = rs.getString("JuniorHighLevel");
					 String junior2 = rs.getString("JuniorHighSY");
					 
					 String senior = rs.getString("SeniorHighSchool");
					 String senior1 = rs.getString("SeniorHighLevel");
					 String senior2 = rs.getString("SeniorHighSY");
					 
					 String college = rs.getString("College");
					 String college1 = rs.getString("CollegeLevel");
					 String college2 = rs.getString("CollegeSY");
					 
					 String voc = rs.getString("Vocational");
					 String voc1 = rs.getString("VocCategories");
					 String voc2 = rs.getString("VocSY");
					 String date = rs.getString("Date");		
					 String status = rs.getString("studentStatus");
					 String status1 = rs.getString("Reason");
					
					 
					 try {
						 if(status.equals("Active")) {
							 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
									 father,fatherbirthdate,fatherage,fathercon,fatherocc,fatherincome,mother,motherbirthdate,motherage,mothercon,motherocc,motherincome,siblings,familyStatus,birthorder,
									 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,voc,voc1,voc2,date,status
									 });
							 table1size++;
						 } else{
							 modelTable2.insertRow(table2size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
									 father,fatherbirthdate,fatherage,fathercon,fatherocc,fatherincome,mother,motherbirthdate,motherage,mothercon,motherocc,motherincome,siblings,familyStatus,birthorder,
									 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,voc,voc1,voc2,date,status,status1
									 });
							 table2size++;
						 }
					 }
					 catch(Exception e) {
						 
					 }
					}
					table_1.getTableHeader().setReorderingAllowed(false);
					table_2.getTableHeader().setReorderingAllowed(false);
					table_1.setCellEditor(null);
					table_2.setCellEditor(null);
					table_1.setModel(model);
					table_2.setModel(modelTable2);
		        } catch (Exception ex) {

		        }finally {
		try {
			rs.close();
			pst.close();
		}catch(Exception e) {
			
		}
		        }
	        }
	        
	        public void alldrop()  {
	  		  try {
	  		    
	  				connection();
	  			  pst = conn.prepareStatement("SELECT COUNT(*) AS studentdrop FROM studentrecord where studentStatus='Dropped'");
	  			  rs = pst.executeQuery();
	  			  while(rs.next()) {
	  				  int count = rs.getInt("studentdrop");
	  				  System.out.println(rs.getInt("studentdrop"));
	  				  alldrop.setText(String.valueOf(count));
	  			  }
	  			  
	  		  }catch(Exception ee) {
	  			  
	  		  }
	  	
		}
	      public void allElemLevel() {
				try {
					connection();
					 String sql = "SELECT COUNT(*) as elemcurrent from studentrecord WHERE studentStatus='Active' AND ElemLevel IN ('Grade 1','Grade 2','Grade 3','Grade 4','Grade 5','Grade 6')";
					 pst = conn.prepareStatement(sql);
					
					  rs = pst.executeQuery();
					  while(rs.next()) {
					
					  int sport = rs.getInt ("elemcurrent");
					  allelem.setText(String.valueOf(sport));
					   
					  }
						
				}catch(Exception e) {
					System.out.println(e);
				}
	        }
	     

	      public void alljuniorLevel() {
				try {
					connection();
					 String sql = "SELECT COUNT(*) as highcurrent from studentrecord WHERE studentStatus='Active' AND JuniorHighLevel IN ('Grade 7','Grade 8','Grade 9','Grade 10')";
					 pst = conn.prepareStatement(sql);
					
					  rs = pst.executeQuery();
					  while(rs.next()) {
					
					  int sport = rs.getInt ("highcurrent");
					  alljunior.setText(String.valueOf(sport));
					   
					  }
						
				}catch(Exception e) {
					System.out.println(e);
				}
	        }
	    
	      public void allseniorLevel() {
				try {
					connection();
					 String sql = "SELECT COUNT(*) as seniorcurrent from studentrecord WHERE studentStatus='Active' AND SeniorHighLevel IN ('Grade 11','Grade 12')";
					 pst = conn.prepareStatement(sql);
					
					  rs = pst.executeQuery();
					  while(rs.next()) {
					
					  int sport = rs.getInt ("seniorcurrent");
					  allsenior.setText(String.valueOf(sport));
					   
					  }
						
				}catch(Exception e) {
					System.out.println(e);
				}
	      }
	      
	    	  public void allcollegeLevel() {
					try {
						connection();
						 String sql = "SELECT COUNT(*) as collegecurrent from studentrecord WHERE studentStatus='Active' AND CollegeLevel IN ('1st year','2nd year','3rd year','4th year')";
						 pst = conn.prepareStatement(sql);
						
						  rs = pst.executeQuery();
						  while(rs.next()) {
						
						  int sport = rs.getInt ("collegecurrent");
						  allcollege.setText(String.valueOf(sport));
						   
						  }
							
					}catch(Exception e) {
						System.out.println(e);
					}
		      }
		      
	
		      public void allvocLevel() {
					try {
						connection();
						 String sql = "SELECT COUNT(*) as voccurrent from studentrecord WHERE studentStatus='Active' AND VocCategories IN ('ASL','TESDA')";
						 pst = conn.prepareStatement(sql);
						
						  rs = pst.executeQuery();
						  while(rs.next()) {
						
						  int sport = rs.getInt ("voccurrent");
						  allvoc.setText(String.valueOf(sport));
						   
						  }
							
					}catch(Exception e) {
						System.out.println(e);
					}
		      } 
		      
		      public void elem() {
		    	  String sql ="Select RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Email,Hobbies,VaccinationStatus,FirstDose,SecondDose,Booster,Purok,HouseNo,Barangay,GovProgram,"
							+ "LRN,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date,studentStatus from studentrecord";
			        try {
			        	connection();
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();
						
						DefaultTableModel model = new DefaultTableModel() {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						
						model.addColumn("Registration No.");
						model.addColumn("Firstname");
						model.addColumn("Middlename.");
						model.addColumn("Lastname.");
						model.addColumn("Suffix.");
						model.addColumn("Birthdate.");
						model.addColumn("Age.");
						model.addColumn("BirthPlace.");
						model.addColumn("Gender.");
						model.addColumn("ContactNo.");
						model.addColumn("CivilStatus.");
						model.addColumn("Height.");
						model.addColumn("Weight.");
						model.addColumn("Religion.");
						model.addColumn("Sports.");
						model.addColumn("Email.");
						model.addColumn("Hobbies.");
						model.addColumn("VaccinationStatus.");
						model.addColumn("FirstDose.");
						model.addColumn("SecondDose.");
						model.addColumn("Booster.");
						model.addColumn("Purok.");
						model.addColumn("HouseNo.");
						model.addColumn("Barangay.");
						model.addColumn("GovProgram.");
						
						model.addColumn("LRN.");	
						model.addColumn("Elementary.");
						model.addColumn("ElemLevel.");
						model.addColumn("ElemSY.");
						
						model.addColumn("Date.");
						model.addColumn("StudentStatus");
						
						int table1size = 0;
						while(rs.next()) {
							 String RegistrationNo = rs.getString("RegistrationNo");
							 String Firstname = rs.getString("Firstname");
							 String Middlename = rs.getString("Middlename");
							 String Lastname = rs.getString("Lastname");
							 String suffix = rs.getString("Suffix");
							 String birthdate = rs.getString("Birthdate");
							 String age = rs.getString("Age");
							 String bp = rs.getString("BirthPlace");
							 String gender = rs.getString("Gender");
							 String cn = rs.getString("ContactNo");
							 String cs = rs.getString("CivilStatus");
							 String h = rs.getString("Height");
							 String w = rs.getString("Weight");
							 String Religion = rs.getString("Religion");
							 String sport = rs.getString("Sports");
							 String email = rs.getString("Email");
							 String hob = rs.getString("Hobbies");
							 String vs = rs.getString("VaccinationStatus");
							 String fd = rs.getString("FirstDose");
							 String sd = rs.getString("SecondDose");
							 String bos = rs.getString("Booster");
							 String purok = rs.getString("Purok");
							 String hn = rs.getString("HouseNo");
							 String barangay = rs.getString("Barangay");
							 String gp = rs.getString("GovProgram");
							 
							
							 
							 String lrn = rs.getString("LRN");
							
							 
							 String elem = rs.getString("Elementary");
							 String elem1 = rs.getString("ElemLevel");
							 String elem2 = rs.getString("ElemSY");
							 
							 String date = rs.getString("Date");					 
							 String status = rs.getString("studentStatus");
							 
							 try {
								 if(status.equals("Active") && elem1.equals("Grade 1")) {
									 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,											 
											 lrn,elem,elem1,elem2,date,status
											 });
									 table1size++;
								 } else if(status.equals("Active") && elem1.equals("Grade 2")) {
										 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
												 lrn,elem,elem1,elem2,date,status
												 });
										 table1size++;
								 } else if (status.equals("Active") && elem1.equals("Grade 3")) {
									 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
											 lrn,elem,elem1,elem2,date,status
											 });
									 table1size++;
								 } else if (status.equals("Active") && elem1.equals("Grade 4")) { 
									 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
											 lrn,elem,elem1,elem2,date,status
										 });
								 table1size++;
							 
								 } else if (status.equals("Active") && elem1.equals("Grade 5")) { 
									 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
											 lrn,elem,elem1,elem2,date,status
										 });
								 table1size++;
							 } else if (status.equals("Active") && elem1.equals("Grade 6")) { 
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
										 lrn,elem,elem1,elem2,date,status
									 });
							 table1size++;
							 }
							 }
							 catch(Exception e) {
								 
							 }
							}
							table_3.getTableHeader().setReorderingAllowed(false);
							table_3.setCellEditor(null);
							table_3.setModel(model);
							
				        } catch (Exception ex) {

				        }finally {
				try {
					rs.close();
					pst.close();
				}catch(Exception e) {
					
				}
				        }
			        }
		  public void junior() {
			  String sql ="Select RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Email,Hobbies,VaccinationStatus,FirstDose,SecondDose,Booster,Purok,HouseNo,Barangay,GovProgram,"
		
						+ "LRN,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date,studentStatus from studentrecord";
		        try {
		        	connection();
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					
					DefaultTableModel model = new DefaultTableModel() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					
					model.addColumn("Registration No.");
					model.addColumn("Firstname");
					model.addColumn("Middlename.");
					model.addColumn("Lastname.");
					model.addColumn("Suffix.");
					model.addColumn("Birthdate.");
					model.addColumn("Age.");
					model.addColumn("BirthPlace.");
					model.addColumn("Gender.");
					model.addColumn("ContactNo.");
					model.addColumn("CivilStatus.");
					model.addColumn("Height.");
					model.addColumn("Weight.");
					model.addColumn("Religion.");
					model.addColumn("Sports.");
					model.addColumn("Email.");
					model.addColumn("Hobbies.");
					model.addColumn("VaccinationStatus.");
					model.addColumn("FirstDose.");
					model.addColumn("SecondDose.");
					model.addColumn("Booster.");
					model.addColumn("Purok.");
					model.addColumn("HouseNo.");
					model.addColumn("Barangay.");
					model.addColumn("GovProgram.");
					
					model.addColumn("LRN.");	
					model.addColumn("Elementary.");
					model.addColumn("ElemLevel.");
					model.addColumn("ElemSY.");
					
					
					model.addColumn("JuniorHighSchool.");
					model.addColumn("JuniorHighLevel.");
					model.addColumn("JuniorHighSY.");
									
				
					model.addColumn("Date.");
					model.addColumn("StudentStatus");
					
					int table1size = 0;
					while(rs.next()) {
						 String RegistrationNo = rs.getString("RegistrationNo");
						 String Firstname = rs.getString("Firstname");
						 String Middlename = rs.getString("Middlename");
						 String Lastname = rs.getString("Lastname");
						 String suffix = rs.getString("Suffix");
						 String birthdate = rs.getString("Birthdate");
						 String age = rs.getString("Age");
						 String bp = rs.getString("BirthPlace");
						 String gender = rs.getString("Gender");
						 String cn = rs.getString("ContactNo");
						 String cs = rs.getString("CivilStatus");
						 String h = rs.getString("Height");
						 String w = rs.getString("Weight");
						 String Religion = rs.getString("Religion");
						 String sport = rs.getString("Sports");
						 String email = rs.getString("Email");
						 String hob = rs.getString("Hobbies");
						 String vs = rs.getString("VaccinationStatus");
						 String fd = rs.getString("FirstDose");
						 String sd = rs.getString("SecondDose");
						 String bos = rs.getString("Booster");
						 String purok = rs.getString("Purok");
						 String hn = rs.getString("HouseNo");
						 String barangay = rs.getString("Barangay");
						 String gp = rs.getString("GovProgram");
						 
						 String lrn = rs.getString("LRN");
	 
						 String elem = rs.getString("Elementary");
						 String elem1 = rs.getString("ElemLevel");
						 String elem2 = rs.getString("ElemSY");
						 
						 String junior = rs.getString("JuniorHighSchool");
						 String junior1 = rs.getString("JuniorHighLevel");
						 String junior2 = rs.getString("JuniorHighSY");
						 

						 String date = rs.getString("Date");					 
						 String status = rs.getString("studentStatus");
						 
						 try {
							 if(status.equals("Active") && junior1.equals("Grade 7")) {
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,											 
										 lrn,elem,elem1,elem2,junior,junior1,junior2,date,status
										 });
								 table1size++;
							 } else if(status.equals("Active") && junior1.equals("Grade 8")) {
									 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
											 lrn,elem,elem1,elem2,junior,junior1,junior2,date,status
											 });
									 table1size++;
							 } else if (status.equals("Active") && junior1.equals("Grade 9")) {
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
										 lrn,elem,elem1,elem2,junior,junior1,junior2,date,status
										 });
								 table1size++;
							 } else if (status.equals("Active") && junior1.equals("Grade 10")) { 
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
										 lrn,elem,elem1,elem2,junior,junior1,junior2,date,status
									 });
							 table1size++;
						 
							
						 }
						 }
						 catch(Exception e) {
							 
						 }
						}
						table_3.getTableHeader().setReorderingAllowed(false);
						table_3.setCellEditor(null);
						table_3.setModel(model);
						
			        } catch (Exception ex) {

			        }finally {
			try {
				rs.close();
				pst.close();
			}catch(Exception e) {
				
			}
			        }
			  
			  
		  }
		  public void senior() {
			  String sql ="Select RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Email,Hobbies,VaccinationStatus,FirstDose,SecondDose,Booster,Purok,HouseNo,Barangay,GovProgram,"
						+ "LRN,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date,studentStatus from studentrecord";
		        try {
		        	connection();
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					
					DefaultTableModel model = new DefaultTableModel() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					
					model.addColumn("Registration No.");
					model.addColumn("Firstname");
					model.addColumn("Middlename.");
					model.addColumn("Lastname.");
					model.addColumn("Suffix.");
					model.addColumn("Birthdate.");
					model.addColumn("Age.");
					model.addColumn("BirthPlace.");
					model.addColumn("Gender.");
					model.addColumn("ContactNo.");
					model.addColumn("CivilStatus.");
					model.addColumn("Height.");
					model.addColumn("Weight.");
					model.addColumn("Religion.");
					model.addColumn("Sports.");
					model.addColumn("Email.");
					model.addColumn("Hobbies.");
					model.addColumn("VaccinationStatus.");
					model.addColumn("FirstDose.");
					model.addColumn("SecondDose.");
					model.addColumn("Booster.");
					model.addColumn("Purok.");
					model.addColumn("HouseNo.");
					model.addColumn("Barangay.");
					model.addColumn("GovProgram.");
					
					model.addColumn("LRN.");	
					model.addColumn("Elementary.");
					model.addColumn("ElemLevel.");
					model.addColumn("ElemSY.");
					
					
					model.addColumn("JuniorHighSchool.");
					model.addColumn("JuniorHighLevel.");
					model.addColumn("JuniorHighSY.");
					
					model.addColumn("SeniorHighSchool.");
					model.addColumn("SeniorHighLevel.");
					model.addColumn("SeniorHighSY.");
				
					model.addColumn("Date.");
					model.addColumn("StudentStatus");
					
					int table1size = 0;
					while(rs.next()) {
						 String RegistrationNo = rs.getString("RegistrationNo");
						 String Firstname = rs.getString("Firstname");
						 String Middlename = rs.getString("Middlename");
						 String Lastname = rs.getString("Lastname");
						 String suffix = rs.getString("Suffix");
						 String birthdate = rs.getString("Birthdate");
						 String age = rs.getString("Age");
						 String bp = rs.getString("BirthPlace");
						 String gender = rs.getString("Gender");
						 String cn = rs.getString("ContactNo");
						 String cs = rs.getString("CivilStatus");
						 String h = rs.getString("Height");
						 String w = rs.getString("Weight");
						 String Religion = rs.getString("Religion");
						 String sport = rs.getString("Sports");
						 String email = rs.getString("Email");
						 String hob = rs.getString("Hobbies");
						 String vs = rs.getString("VaccinationStatus");
						 String fd = rs.getString("FirstDose");
						 String sd = rs.getString("SecondDose");
						 String bos = rs.getString("Booster");
						 String purok = rs.getString("Purok");
						 String hn = rs.getString("HouseNo");
						 String barangay = rs.getString("Barangay");
						 String gp = rs.getString("GovProgram");
						 
						 String lrn = rs.getString("LRN");
	 
						 String elem = rs.getString("Elementary");
						 String elem1 = rs.getString("ElemLevel");
						 String elem2 = rs.getString("ElemSY");
						 
						 String junior = rs.getString("JuniorHighSchool");
						 String junior1 = rs.getString("JuniorHighLevel");
						 String junior2 = rs.getString("JuniorHighSY");
						 
						 String senior = rs.getString("SeniorHighSchool");
						 String senior1 = rs.getString("SeniorHighLevel");
						 String senior2 = rs.getString("SeniorHighSY");
						 
						 String date = rs.getString("Date");					 
						 String status = rs.getString("studentStatus");
						 
						 try {
							 if(status.equals("Active") && senior1.equals("Grade 11")) {
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,											 
										 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,date,status
										 });
								 table1size++;
							 } else if(status.equals("Active") && senior1.equals("Grade 12")) {
									 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
											 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,date,status
											 });
									 table1size++;
							 
						 
							
						 }
						 }
						 catch(Exception e) {
							 
						 }
						}
						table_3.getTableHeader().setReorderingAllowed(false);
						table_3.setCellEditor(null);
						table_3.setModel(model);
						
			        } catch (Exception ex) {

			        }finally {
			try {
				rs.close();
				pst.close();
			}catch(Exception e) {
				
			}
			        }
			  
			  
		  }
		  public void college() {
	    	  String sql ="Select RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Email,Hobbies,VaccinationStatus,FirstDose,SecondDose,Booster,Purok,HouseNo,Barangay,GovProgram,"
						+ "LRN,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date,studentStatus from studentrecord";
		        try {
		        	connection();
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					
					DefaultTableModel model = new DefaultTableModel() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					
					model.addColumn("Registration No.");
					model.addColumn("Firstname");
					model.addColumn("Middlename.");
					model.addColumn("Lastname.");
					model.addColumn("Suffix.");
					model.addColumn("Birthdate.");
					model.addColumn("Age.");
					model.addColumn("BirthPlace.");
					model.addColumn("Gender.");
					model.addColumn("ContactNo.");
					model.addColumn("CivilStatus.");
					model.addColumn("Height.");
					model.addColumn("Weight.");
					model.addColumn("Religion.");
					model.addColumn("Sports.");
					model.addColumn("Email.");
					model.addColumn("Hobbies.");
					model.addColumn("VaccinationStatus.");
					model.addColumn("FirstDose.");
					model.addColumn("SecondDose.");
					model.addColumn("Booster.");
					model.addColumn("Purok.");
					model.addColumn("HouseNo.");
					model.addColumn("Barangay.");
					model.addColumn("GovProgram.");
					
					model.addColumn("LRN.");	
					model.addColumn("Elementary.");
					model.addColumn("ElemLevel.");
					model.addColumn("ElemSY.");
					
					
					model.addColumn("JuniorHighSchool.");
					model.addColumn("JuniorHighLevel.");
					model.addColumn("JuniorHighSY.");
					
					model.addColumn("SeniorHighSchool.");
					model.addColumn("SeniorHighLevel.");
					model.addColumn("SeniorHighSY.");
					
					
					model.addColumn("College.");
					model.addColumn("CollegeLevel.");
					model.addColumn("CollegeSY.");
					

					model.addColumn("Date.");
					model.addColumn("StudentStatus");
					int table1size = 0;
					while(rs.next()) {
						 String RegistrationNo = rs.getString("RegistrationNo");
						 String Firstname = rs.getString("Firstname");
						 String Middlename = rs.getString("Middlename");
						 String Lastname = rs.getString("Lastname");
						 String suffix = rs.getString("Suffix");
						 String birthdate = rs.getString("Birthdate");
						 String age = rs.getString("Age");
						 String bp = rs.getString("BirthPlace");
						 String gender = rs.getString("Gender");
						 String cn = rs.getString("ContactNo");
						 String cs = rs.getString("CivilStatus");
						 String h = rs.getString("Height");
						 String w = rs.getString("Weight");
						 String Religion = rs.getString("Religion");
						 String sport = rs.getString("Sports");
						 String email = rs.getString("Email");
						 String hob = rs.getString("Hobbies");
						 String vs = rs.getString("VaccinationStatus");
						 String fd = rs.getString("FirstDose");
						 String sd = rs.getString("SecondDose");
						 String bos = rs.getString("Booster");
						 String purok = rs.getString("Purok");
						 String hn = rs.getString("HouseNo");
						 String barangay = rs.getString("Barangay");
						 String gp = rs.getString("GovProgram");
						 
						
						 
						 String lrn = rs.getString("LRN");
						
						 
						 String elem = rs.getString("Elementary");
						 String elem1 = rs.getString("ElemLevel");
						 String elem2 = rs.getString("ElemSY");
						 
						 String junior = rs.getString("JuniorHighSchool");
						 String junior1 = rs.getString("JuniorHighLevel");
						 String junior2 = rs.getString("JuniorHighSY");
						 
						 String senior = rs.getString("SeniorHighSchool");
						 String senior1 = rs.getString("SeniorHighLevel");
						 String senior2 = rs.getString("SeniorHighSY");
						 
						 String college = rs.getString("College");
						 String college1 = rs.getString("CollegeLevel");
						 String college2 = rs.getString("CollegeSY");
						 
						 String date = rs.getString("Date");					 
						 String status = rs.getString("studentStatus");
						 
						 try {
							 if(status.equals("Active") && college1.equals("1st year")) {
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,											 
										 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,date,status
										 });
								 table1size++;
							 } else if(status.equals("Active") && college1.equals("2nd year")) {
									 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
											 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,date,status
											 });
									 table1size++;
							 } else if (status.equals("Active") && college1.equals("3rd year")) {
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
										 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,date,status
										 });
								 table1size++;
							 } else if (status.equals("Active") && college1.equals("4th year")) { 
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,
									 lrn,elem,elem1,elem2,junior,junior1,junior2,senior,senior1,senior2,college,college1,college2,date,status
									 });
							 table1size++;
						 
							 }
						 }
						 catch(Exception e) {
							 
						 }
						}
						table_3.getTableHeader().setReorderingAllowed(false);
						table_3.setCellEditor(null);
						table_3.setModel(model);
						
			        } catch (Exception ex) {

			        }finally {
			try {
				rs.close();
				pst.close();
			}catch(Exception e) {
				
			}
			        }
		        }
		  public void voc() {
			  
		  String sql ="Select RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Email,Hobbies,VaccinationStatus,FirstDose,SecondDose,Booster,Purok,HouseNo,Barangay,GovProgram,"
					+ "LRN,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date,studentStatus from studentrecord";
	        try {
	        	connection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				
				DefaultTableModel model = new DefaultTableModel() {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				
				model.addColumn("Registration No.");
				model.addColumn("Firstname");
				model.addColumn("Middlename.");
				model.addColumn("Lastname.");
				model.addColumn("Suffix.");
				model.addColumn("Birthdate.");
				model.addColumn("Age.");
				model.addColumn("BirthPlace.");
				model.addColumn("Gender.");
				model.addColumn("ContactNo.");
				model.addColumn("CivilStatus.");
				model.addColumn("Height.");
				model.addColumn("Weight.");
				model.addColumn("Religion.");
				model.addColumn("Sports.");
				model.addColumn("Email.");
				model.addColumn("Hobbies.");
				model.addColumn("VaccinationStatus.");
				model.addColumn("FirstDose.");
				model.addColumn("SecondDose.");
				model.addColumn("Booster.");
				model.addColumn("Purok.");
				model.addColumn("HouseNo.");
				model.addColumn("Barangay.");
				model.addColumn("GovProgram.");
				
				model.addColumn("LRN.");	
				model.addColumn("Vacational.");
				model.addColumn("VocCategories.");
				model.addColumn("VocSY.");
				
				model.addColumn("Date.");
				model.addColumn("StudentStatus");
				
				int table1size = 0;
				while(rs.next()) {
					 String RegistrationNo = rs.getString("RegistrationNo");
					 String Firstname = rs.getString("Firstname");
					 String Middlename = rs.getString("Middlename");
					 String Lastname = rs.getString("Lastname");
					 String suffix = rs.getString("Suffix");
					 String birthdate = rs.getString("Birthdate");
					 String age = rs.getString("Age");
					 String bp = rs.getString("BirthPlace");
					 String gender = rs.getString("Gender");
					 String cn = rs.getString("ContactNo");
					 String cs = rs.getString("CivilStatus");
					 String h = rs.getString("Height");
					 String w = rs.getString("Weight");
					 String Religion = rs.getString("Religion");
					 String sport = rs.getString("Sports");
					 String email = rs.getString("Email");
					 String hob = rs.getString("Hobbies");
					 String vs = rs.getString("VaccinationStatus");
					 String fd = rs.getString("FirstDose");
					 String sd = rs.getString("SecondDose");
					 String bos = rs.getString("Booster");
					 String purok = rs.getString("Purok");
					 String hn = rs.getString("HouseNo");
					 String barangay = rs.getString("Barangay");
					 String gp = rs.getString("GovProgram");
					 
					
					 
					 String lrn = rs.getString("LRN");
					
					 
					 String elem = rs.getString("Vacational");
					 String elem1 = rs.getString("VocCategories");
					 String elem2 = rs.getString("VocSY");
					 
					 String date = rs.getString("Date");					 
					 String status = rs.getString("studentStatus");
					 
					 try {
						 if(status.equals("Active") && elem1.equals("TESDA")) {
							 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,											 
									 lrn,elem,elem1,elem2,date,status
									 });
							 table1size++;
						 } else if(status.equals("Active") && elem1.equals("ASL")) {
								 model.insertRow(table1size, new Object[]{RegistrationNo,Firstname,Middlename,Lastname,suffix,birthdate,age,bp,gender,cn,cs,h,w,Religion,sport,email,hob,vs,fd,sd,bos,purok,hn,barangay,gp,								
										 lrn,elem,elem1,elem2,date,status
										 });
								 table1size++;
		
					 }
					 }
					 catch(Exception e) {
						 
					 }
					}
					table_3.getTableHeader().setReorderingAllowed(false);
					table_3.setCellEditor(null);
					table_3.setModel(model);
					
		        } catch (Exception ex) {

		        }finally {
		try {
			rs.close();
			pst.close();
		}catch(Exception e) {
			
		}
		        }
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
		  	
		  	
}
