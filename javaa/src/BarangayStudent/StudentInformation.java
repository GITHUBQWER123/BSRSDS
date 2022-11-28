package BarangayStudent;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.ComponentOrientation;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;

public class StudentInformation extends JPanel{

	private JFrame frame;
	private JLabel time;
	private JLabel date;
	
	public JTextField regno;
	public JTextField fn;
	public JTextField mn;
	public JTextField ln;
	private JTextField suf;
	public JTextField age;
	private JTextField email;
	private JTextField wei;
	private JTextField hei;
	private JTextField txt_no;
	private JTextField reli;
	private JTextField house;
	private JTextField barangay;
	private JLabel imgDis;
	private String vacc;
	
	public JLabel lblRe;
	private JTextField ffn;
	private JTextField fcon;
	private JTextField foccu;
	private JTextField mmn;
	private JTextField mage;
	private JTextField mcon;
	private JTextField moccu;
	private JTextField siblings;
	private JTextField order;
	private JTextField lrn;
	private JTextField txt_elem_year;
	private JTextField txt_high_year;
	private JTextField txt_senior_year;
	private JTextField txt_college_year;
	
	private ButtonGroup buttongroup = new ButtonGroup();
	private JTextField bp;
	private JTextField txt_voc_year;
	
	private JComboBox gender;
	private JComboBox vac ;
	private JComboBox stat;
	
	JComboBox	purok = new JComboBox();
	JButton btnNewButton_1_2_1 = new JButton("DROP");
	JButton btnNewButton_1_2 = new JButton("UPDATE");
	JComboBox comboBox_high = new JComboBox();
	JComboBox comboBox_senior = new JComboBox();
	JComboBox comboBox_voc = new JComboBox();
	JComboBox comboBox_elem = new JComboBox();
	JComboBox comboBox_college = new JComboBox();
	
	JComboBox comboBox_high_level = new JComboBox();
	JComboBox comboBox_senior_level = new JComboBox();
	JComboBox comboBox_college_level = new JComboBox();
	JComboBox comboBox_voc_level = new JComboBox();
	JComboBox comboBox_elem_level = new JComboBox();
	
	JComboBox comboBox_fatherincome = new JComboBox();
	JComboBox comboBox_motherincome = new JComboBox();
	JComboBox comboBox_familystatus = new JComboBox();
	
	JComboBox comboBoxMonthPersonal = new JComboBox();
	JComboBox comboBoxDatePersonal = new JComboBox();
	JComboBox comboBoxYearPersonal = new JComboBox();
	
	JComboBox comboBoxMonthFather = new JComboBox();
	JComboBox comboBoxDateFather = new JComboBox();
	JComboBox comboBoxYearFather = new JComboBox();
	
	JComboBox comboBoxMonthMother = new JComboBox();
	JComboBox comboBoxDateMother = new JComboBox();
	JComboBox comboBoxYearMother = new JComboBox();
	
	JComboBox vacstat = new JComboBox();
	JComboBox seconddose = new JComboBox();
	JComboBox booster = new JComboBox();
	JComboBox hobbi = new JComboBox();
	JComboBox gov = new JComboBox();
	JComboBox firstdose = new JComboBox();
	private JComboBox hob;
	
	
	
	
	
		private JButton btnNewButton_2;
		
		Connection conn = null;
		PreparedStatement pst = null;	
		Statement st = null;
		ResultSet rs  = null;
		DefaultTableModel model = new DefaultTableModel();

		File f = null;
		String path = null;
		private ImageIcon format = null;
		String filename= null;
		int s= 0;
		byte[]img = null;
		private JTextField fage1;
		private JTextField txtSearch;
		private JPanel panel_7;
		private JTextField txtreason;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInformation window = new StudentInformation();
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
	public void getElemSchoolList() {
		try{ 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SchoolName FROM schoolinfo WHERE Categories='Elementary'");
			DefaultComboBoxModel elemSchoolModel = new DefaultComboBoxModel();
			elemSchoolModel.addElement("Select");
			while(rs.next()) {
				elemSchoolModel.addElement(rs.getString("SchoolName"));
			}
			comboBox_elem.setBounds(130, 122, 202, 30);
			panel_7.add(comboBox_elem);
			comboBox_elem.setModel(elemSchoolModel);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void getHighSchoolList() {
		try{ 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SchoolName FROM schoolinfo WHERE Categories='HighSchool'");
			DefaultComboBoxModel highSchoolModel = new DefaultComboBoxModel();
			highSchoolModel.addElement("Select");
			while(rs.next()) {
				highSchoolModel.addElement(rs.getString("SchoolName"));
			}
			comboBox_high.setBounds(130, 192, 202, 30);
			panel_7.add(comboBox_high);
			comboBox_high.setModel(highSchoolModel);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void getSeniorSchoolList() {
		try{ 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SchoolName FROM schoolinfo WHERE Categories='SeniorHigh'");
			DefaultComboBoxModel elemSchoolModel = new DefaultComboBoxModel();
			elemSchoolModel.addElement("Select");
			while(rs.next()) {
				elemSchoolModel.addElement(rs.getString("SchoolName"));
			}
			comboBox_senior.setBounds(130, 262, 202, 30);
			panel_7.add(comboBox_senior);
			comboBox_senior.setModel(elemSchoolModel);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void getCollegeSchoolList() {
		try{ 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SchoolName FROM schoolinfo WHERE Categories='College'");
			DefaultComboBoxModel elemSchoolModel = new DefaultComboBoxModel();
			elemSchoolModel.addElement("Select");
			while(rs.next()) {
				elemSchoolModel.addElement(rs.getString("SchoolName"));
			}
			comboBox_college.setBounds(130, 329, 202, 30);
			panel_7.add(comboBox_college);
			comboBox_college.setModel(elemSchoolModel);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void getVocationalSchoolList() {
		try{ 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SchoolName FROM schoolinfo WHERE Categories='Vocational'");
			DefaultComboBoxModel elemSchoolModel = new DefaultComboBoxModel();
			elemSchoolModel.addElement("Select");
			while(rs.next()) {
				elemSchoolModel.addElement(rs.getString("SchoolName"));
			}
			comboBox_voc.setBounds(130, 399, 202, 30);
			panel_7.add(comboBox_voc);
			comboBox_voc.setModel(elemSchoolModel);
			
			JLabel lblNewLabel_2_2_2_2_2_1 = new JLabel("Student Level");
			lblNewLabel_2_2_2_2_2_1.setBounds(366, 370, 152, 36);
			panel_7.add(lblNewLabel_2_2_2_2_2_1);
			lblNewLabel_2_2_2_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			
			
			
			
			
			
			
			JLabel lblNewLabel_2_2_1_1_2 = new JLabel("Vocational");
			lblNewLabel_2_2_1_1_2.setBounds(130, 370, 152, 36);
			panel_7.add(lblNewLabel_2_2_1_1_2);
			lblNewLabel_2_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
			
	
			
			JLabel lblNewLabel_2_2_2_2_1 = new JLabel("School Year ");
			lblNewLabel_2_2_2_2_1.setBounds(600, 370, 152, 36);
			panel_7.add(lblNewLabel_2_2_2_2_1);
			lblNewLabel_2_2_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			
			txt_voc_year = new JTextField();
			txt_voc_year.setBounds(600, 399, 202, 30);
			panel_7.add(txt_voc_year);
			txt_voc_year.setEnabled(false);
			txt_voc_year.setColumns(10);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
			rdbtnNewRadioButton.setBounds(106, 401, 21, 23);
			panel_7.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBackground(new Color(245, 245, 220));
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox_voc.setEnabled(true);
				}
			});
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public StudentInformation() {
		initialize();
		getElemSchoolList();
		getHighSchoolList();
		getSeniorSchoolList();
		getCollegeSchoolList();
		getVocationalSchoolList();
		showDate();
		showTime();
		groupRadio();
		showBasic();
		showFamily();
		showEducational();
		
	}

	public void groupRadio() {
	}
	public void addPlaceholderStyle(JTextField jtextfield) {
		Font font = jtextfield.getFont();
		font = font.deriveFont(Font.ITALIC);
		jtextfield.setFont(font);
		jtextfield.setForeground(Color.black);
	}
	public void removePlaceholderStyle(JTextField jtextfield) {
		Font font = jtextfield.getFont();
		font = font.deriveFont(Font.PLAIN|font.BOLD);
		jtextfield.setFont(font);
		jtextfield.setForeground(Color.black);
	}
	
public void autoID() {
		
	    try {

	    	Class.forName("com.mysql.cj.jdbc.Driver");
		 	conn	 = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			Statement pst = conn.createStatement();  
	        ResultSet rs = pst.executeQuery("select Max(RegistrationNo) from studentrecord");
	        rs.next();
	        
	        rs.getString("Max(RegistrationNo)");
	        
	        
	        
			
			if(rs.getString("Max(RegistrationNo)")==null)
	        {
	            
	        	
				regno.setText("S-00001");
	        }
	        else
	        {
	            Long id = Long.parseLong(rs.getString("Max(RegistrationNo)").substring(2,rs.getString("Max(RegistrationNo)").length()));
	            id++;
	            regno.setText("S-" + String.format("%05d", id));
	        }

	    } catch (ClassNotFoundException ex) {
	    	 
	    } catch (SQLException ex) {
	      
	    }
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(0, 0, 1187, 844);
		setVisible(true);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(0, 0, 1187, 844);
		add(panel);
		panel.setLayout(null);
		
				
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(null);
		panel_1_1.setBackground(new Color(255, 218, 185));
		panel_1_1.setBounds(0, 0, 1187, 79);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("STUDENT INFORMATION");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(403, 44, 311, 35);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date :");
		ImageIcon datee = new ImageIcon(this.getClass().getResource("/date.png"));
		Image date1 = datee.getImage();	
		Image date2 = date1.getScaledInstance(36,24, Image.SCALE_SMOOTH);
		ImageIcon date3 = new ImageIcon(date2);
		lblNewLabel_1_1.setIcon(date3);
		lblNewLabel_1_1.setBounds(1036, 11, 36, 24);
		panel_1_1.add(lblNewLabel_1_1);
		
		date = new JLabel("07/11/2022");
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		ImageIcon bar = new ImageIcon(this.getClass().getResource("/barangay.png"));
		Image bar1 = bar.getImage();	
		Image bar2 = bar1.getScaledInstance(98,79, Image.SCALE_SMOOTH);
		ImageIcon bar3 = new ImageIcon(bar2);
		lblNewLabel_1.setIcon(bar3);
		lblNewLabel_1.setBounds(151, 0, 98, 79);
		panel_1_1.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 111, 1167, 640);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("Basic Information", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("Family Background", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_5.setBackground(new Color(245, 245, 220));
		panel_5.setBounds(10, 11, 1142, 590);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_6.setBackground(new Color(245, 245, 220));
		panel_6.setBounds(103, 39, 932, 442);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Father's Fullname");
		lblNewLabel_8.setBounds(116, 38, 156, 37);
		panel_6.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		ffn = new JTextField();
		ffn.setBounds(116, 66, 232, 33);
		panel_6.add(ffn);
		ffn.setEnabled(false);
		ffn.setColumns(10);
		
		JLabel lblNewLabel_8_2 = new JLabel("Age");
		lblNewLabel_8_2.setBounds(647, 38, 149, 37);
		panel_6.add(lblNewLabel_8_2);
		lblNewLabel_8_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		 fcon = new JTextField();
		 fcon.setBounds(116, 131, 232, 33);
		 panel_6.add(fcon);
		 fcon.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyPressed(KeyEvent e) {
		 		char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					fcon.setEditable(false);
				}else {
					fcon.setEditable(true);
				}
		 	}
		 });
		fcon.setEnabled(false);
		fcon.setColumns(10);
		
		JLabel lblNewLabel_8_3 = new JLabel("Contact No");
		lblNewLabel_8_3.setBounds(116, 103, 156, 37);
		panel_6.add(lblNewLabel_8_3);
		lblNewLabel_8_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		foccu = new JTextField();
		foccu.setBounds(358, 131, 278, 33);
		panel_6.add(foccu);
		foccu.setEnabled(false);
		foccu.setColumns(10);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("Occupation");
		lblNewLabel_8_3_1.setBounds(362, 103, 156, 37);
		panel_6.add(lblNewLabel_8_3_1);
		lblNewLabel_8_3_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		JLabel lblNewLabel_8_3_2 = new JLabel("MonthlyIncome");
		lblNewLabel_8_3_2.setBounds(647, 103, 156, 37);
		panel_6.add(lblNewLabel_8_3_2);
		lblNewLabel_8_3_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		JLabel lblNewLabel_8_4 = new JLabel("Mother's Fullname");
		lblNewLabel_8_4.setBounds(116, 188, 171, 37);
		panel_6.add(lblNewLabel_8_4);
		lblNewLabel_8_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		mmn = new JTextField();
		mmn.setBounds(116, 216, 232, 33);
		panel_6.add(mmn);
		mmn.setEnabled(false);
		mmn.setColumns(10);
		
		mage = new JTextField();
		mage.setBounds(647, 216, 180, 33);
		panel_6.add(mage);
		mage.setEnabled(false);
		mage.setColumns(10);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Age");
		lblNewLabel_8_2_1.setBounds(647, 188, 149, 37);
		panel_6.add(lblNewLabel_8_2_1);
		lblNewLabel_8_2_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		mcon = new JTextField();
		mcon.setBounds(116, 284, 232, 33);
		panel_6.add(mcon);
		mcon.addKeyListener(new KeyAdapter() {
			 	@Override
			 	public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					mcon.setEditable(false);
				}else {
					mcon.setEditable(true);
				}
			}
		});
		mcon.setEnabled(false);
		mcon.setColumns(10);
		
		JLabel lblNewLabel_8_3_3 = new JLabel("Contact No");
		lblNewLabel_8_3_3.setBounds(116, 256, 156, 37);
		panel_6.add(lblNewLabel_8_3_3);
		lblNewLabel_8_3_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		moccu = new JTextField();
		moccu.setBounds(358, 284, 278, 33);
		panel_6.add(moccu);
		moccu.setEnabled(false);
		moccu.setColumns(10);
		
		JLabel lblNewLabel_8_3_1_1 = new JLabel("Occupation");
		lblNewLabel_8_3_1_1.setBounds(362, 256, 156, 37);
		panel_6.add(lblNewLabel_8_3_1_1);
		lblNewLabel_8_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		JLabel lblNewLabel_8_3_2_1 = new JLabel("MonthlyIncome");
		lblNewLabel_8_3_2_1.setBounds(647, 256, 156, 37);
		panel_6.add(lblNewLabel_8_3_2_1);
		lblNewLabel_8_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		JLabel lblNewLabel_8_3_3_1 = new JLabel("No. of Siblings");
		lblNewLabel_8_3_3_1.setBounds(116, 341, 171, 37);
		panel_6.add(lblNewLabel_8_3_3_1);
		lblNewLabel_8_3_3_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		siblings = new JTextField();
		siblings.setBounds(116, 369, 232, 33);
		panel_6.add(siblings);
		siblings.setEnabled(false);
		siblings.setColumns(10);
		
		order = new JTextField();
		order.setBounds(358, 369, 278, 33);
		panel_6.add(order);
		order.setEnabled(false);
		order.setColumns(10);
		
		JLabel lblNewLabel_8_3_3_1_1 = new JLabel("Birth Order");
		lblNewLabel_8_3_3_1_1.setBounds(358, 341, 232, 37);
		panel_6.add(lblNewLabel_8_3_3_1_1);
		lblNewLabel_8_3_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		fage1 = new JTextField();
		fage1.setBounds(647, 66, 180, 32);
		panel_6.add(fage1);
		fage1.setEnabled(false);
		fage1.setColumns(10);
		
		JLabel lblNewLabel_8_3_3_1_1_1 = new JLabel("Family Status");
		lblNewLabel_8_3_3_1_1_1.setBounds(647, 341, 163, 37);
		panel_6.add(lblNewLabel_8_3_3_1_1_1);
		lblNewLabel_8_3_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		comboBox_fatherincome.setBounds(647, 131, 180, 33);
		panel_6.add(comboBox_fatherincome);
		comboBox_fatherincome.setEnabled(false);
		
	
		comboBox_fatherincome.setModel(new DefaultComboBoxModel(new String[] {"Select ", "N/A", "10,000", "20,000", "30,000", "40,000"}));
		comboBox_motherincome.setBounds(647, 284, 180, 33);
		panel_6.add(comboBox_motherincome);
		comboBox_motherincome.setEnabled(false);
		
		comboBox_motherincome.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "10,000", "15,000", "20,000", "25,000"}));
		comboBox_familystatus.setBounds(647, 369, 180, 33);
		panel_6.add(comboBox_familystatus);
		comboBox_familystatus.setEnabled(false);
		
		comboBox_familystatus.setModel(new DefaultComboBoxModel(new String[] {"Select", "Indigenous", "Low Income Class", "Midlle Income Class", "Upper Income Class", "Rich"}));
		comboBoxMonthFather.setBounds(358, 66, 97, 33);
		panel_6.add(comboBoxMonthFather);
		comboBoxMonthFather.setEnabled(false);
		comboBoxMonthFather.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearFather.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthFather.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthFather.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthFather.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthFather.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				fage1.setText(Integer.toString(ageString));
			}
		});

		comboBoxMonthFather.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBoxDateFather.setBounds(465, 66, 84, 33);
		panel_6.add(comboBoxDateFather);
		comboBoxDateFather.setEnabled(false);
		comboBoxDateFather.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearFather.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthFather.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthFather.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthFather.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthFather.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				fage1.setText(Integer.toString(ageString));
			}
		});
		
		comboBoxDateFather.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxYearFather.setBounds(561, 66, 77, 33);
		panel_6.add(comboBoxYearFather);
		comboBoxYearFather.setEnabled(false);
		comboBoxYearFather.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearFather.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthFather.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthFather.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthFather.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthFather.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				fage1.setText(Integer.toString(ageString));
			}
		});
		
		comboBoxYearFather.setModel(new DefaultComboBoxModel(new String[] {"2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"}));
		comboBoxMonthMother.setBounds(357, 216, 97, 33);
		panel_6.add(comboBoxMonthMother);
		comboBoxMonthMother.setEnabled(false);
		comboBoxMonthMother.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearMother.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthMother.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthMother.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthMother.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthMother.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				mage.setText(Integer.toString(ageString));
			}
		});
		
		
		comboBoxMonthMother.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBoxDateMother.setBounds(464, 216, 84, 33);
		panel_6.add(comboBoxDateMother);
		comboBoxDateMother.setEnabled(false);
		comboBoxDateMother.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearMother.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthMother.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthMother.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthMother.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthMother.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				mage.setText(Integer.toString(ageString));
			}
		});
		
		comboBoxDateMother.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxYearMother.setBounds(560, 216, 77, 33);
		panel_6.add(comboBoxYearMother);
		comboBoxYearMother.setEnabled(false);
		comboBoxYearMother.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearMother.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthMother.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthMother.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthMother.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthMother.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				mage.setText(Integer.toString(ageString));
			}
		});
		
		comboBoxYearMother.setModel(new DefaultComboBoxModel(new String[] {"2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"}));
		
		JLabel lblYear_1 = new JLabel("Year");
		lblYear_1.setBounds(559, 43, 50, 25);
		panel_6.add(lblYear_1);
		lblYear_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblDate_1_2 = new JLabel("/");
		lblDate_1_2.setBounds(444, 43, 10, 25);
		panel_6.add(lblDate_1_2);
		lblDate_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblDate_1_1_1 = new JLabel("/");
		lblDate_1_1_1.setBounds(539, 43, 10, 25);
		panel_6.add(lblDate_1_1_1);
		lblDate_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblDate_2 = new JLabel("Date");
		lblDate_2.setBounds(466, 43, 66, 25);
		panel_6.add(lblDate_2);
		lblDate_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblBirthdate_1 = new JLabel("Month");
		lblBirthdate_1.setBounds(358, 43, 66, 25);
		panel_6.add(lblBirthdate_1);
		lblBirthdate_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblDate_1_1_1_1 = new JLabel("/");
		lblDate_1_1_1_1.setBounds(539, 193, 10, 25);
		panel_6.add(lblDate_1_1_1_1);
		lblDate_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblYear_1_1 = new JLabel("Year");
		lblYear_1_1.setBounds(561, 193, 50, 25);
		panel_6.add(lblYear_1_1);
		lblYear_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblDate_2_1 = new JLabel("Date");
		lblDate_2_1.setBounds(466, 193, 66, 25);
		panel_6.add(lblDate_2_1);
		lblDate_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblDate_1_2_1 = new JLabel("/");
		lblDate_1_2_1.setBounds(445, 193, 10, 25);
		panel_6.add(lblDate_1_2_1);
		lblDate_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblBirthdate_1_1 = new JLabel("Month");
		lblBirthdate_1_1.setBounds(358, 193, 66, 25);
		panel_6.add(lblBirthdate_1_1);
		lblBirthdate_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnNewButton_4 = new JButton("NEXT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBackground(new Color(222, 184, 135));
		btnNewButton_4.setBounds(1039, 516, 72, 44);
		panel_5.add(btnNewButton_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("Educational Background", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_stud = new JPanel();
		panel_stud.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_stud.setBackground(new Color(245, 245, 220));
		panel_stud.setBounds(10, 11, 1142, 590);
		panel_3.add(panel_stud);
		panel_stud.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(245, 245, 220));
		panel_7.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_7.setBounds(107, 59, 934, 456);
		panel_stud.add(panel_7);
		panel_7.setLayout(null);
		
		lrn = new JTextField();
		lrn.setBounds(130, 52, 202, 30);
		panel_7.add(lrn);
		lrn.setEnabled(false);
		lrn.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("LRN/Student No");
		lblNewLabel_2_1.setBounds(130, 23, 152, 36);
		panel_7.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txt_elem_year = new JTextField();
		txt_elem_year.setBounds(600, 122, 202, 30);
		panel_7.add(txt_elem_year);
		txt_elem_year.setEnabled(false);
		txt_elem_year.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Elementary");
		lblNewLabel_2_2.setBounds(130, 93, 152, 36);
		panel_7.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Highschool");
		lblNewLabel_2_2_1.setBounds(130, 163, 152, 36);
		panel_7.add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("SeniorHigh");
		lblNewLabel_2_2_1_1.setBounds(130, 233, 152, 36);
		panel_7.add(lblNewLabel_2_2_1_1);
		lblNewLabel_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("College");
		lblNewLabel_2_2_1_1_1.setBounds(130, 300, 152, 36);
		panel_7.add(lblNewLabel_2_2_1_1_1);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_2 = new JLabel("School Year ");
		lblNewLabel_2_2_2.setBounds(600, 93, 152, 36);
		panel_7.add(lblNewLabel_2_2_2);
		lblNewLabel_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("School Year ");
		lblNewLabel_2_2_2_1.setBounds(600, 163, 152, 36);
		panel_7.add(lblNewLabel_2_2_2_1);
		lblNewLabel_2_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txt_high_year = new JTextField();
		txt_high_year.setBounds(600, 192, 202, 30);
		panel_7.add(txt_high_year);
		txt_high_year.setEnabled(false);
		txt_high_year.setColumns(10);
		
		JLabel lblNewLabel_2_2_2_2 = new JLabel("School Year ");
		lblNewLabel_2_2_2_2.setBounds(600, 233, 152, 36);
		panel_7.add(lblNewLabel_2_2_2_2);
		lblNewLabel_2_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txt_senior_year = new JTextField();
		txt_senior_year.setBounds(600, 262, 202, 30);
		panel_7.add(txt_senior_year);
		txt_senior_year.setEnabled(false);
		txt_senior_year.setColumns(10);
		
		JLabel lblNewLabel_2_2_2_3 = new JLabel("School Year ");
		lblNewLabel_2_2_2_3.setBounds(600, 300, 152, 36);
		panel_7.add(lblNewLabel_2_2_2_3);
		lblNewLabel_2_2_2_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txt_college_year = new JTextField();
		txt_college_year.setBounds(600, 329, 202, 30);
		panel_7.add(txt_college_year);
		txt_college_year.setEnabled(false);
		txt_college_year.setColumns(10);
		
		JLabel lblNewLabel_2_2_2_4 = new JLabel("Student Level");
		lblNewLabel_2_2_2_4.setBounds(366, 93, 152, 36);
		panel_7.add(lblNewLabel_2_2_2_4);
		lblNewLabel_2_2_2_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_2_1_1 = new JLabel("Student Level");
		lblNewLabel_2_2_2_1_1.setBounds(366, 163, 152, 36);
		panel_7.add(lblNewLabel_2_2_2_1_1);
		lblNewLabel_2_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_2_2_2 = new JLabel("Student Level");
		lblNewLabel_2_2_2_2_2.setBounds(366, 233, 152, 36);
		panel_7.add(lblNewLabel_2_2_2_2_2);
		lblNewLabel_2_2_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("Student Level");
		lblNewLabel_2_2_1_1_1_1.setBounds(366, 300, 152, 36);
		panel_7.add(lblNewLabel_2_2_1_1_1_1);
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
	
		comboBox_elem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_elem.getSelectedItem().toString().equals("Select")) {
					comboBox_elem_level.setEnabled(false);
				}
				else {
					comboBox_elem_level.setEnabled(true);
				}
			}
		});
		comboBox_elem.setEnabled(false);
		comboBox_elem.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2"}));
		comboBox_high.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_high.getSelectedItem().toString().equals("Select")) {
					comboBox_high_level.setEnabled(false);
				}
				else {
					comboBox_high_level.setEnabled(true);
				}
			}
		});
		
		
		comboBox_high.setEnabled(false);
		comboBox_high.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2"}));
		comboBox_voc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_voc.getSelectedItem().toString().equals("Select")) {
					comboBox_voc_level.setEnabled(false);
				}
				else {
					comboBox_voc_level.setEnabled(true);
				}
			}
		});
		
		
		comboBox_voc.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2"}));
		comboBox_voc.setEnabled(false);
		comboBox_voc_level.setBounds(366, 399, 202, 30);
		panel_7.add(comboBox_voc_level);
		comboBox_voc_level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_voc_level.getSelectedItem().toString().equals("Select")) {
					txt_voc_year.setEnabled(true);
				}
				else
				{
					txt_voc_year.setEnabled(true);
				}
			}
		});
		
		comboBox_voc_level.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "TESDA", "ALS"}));
		comboBox_voc_level.setEnabled(false);
		comboBox_senior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_senior.getSelectedItem().toString().equals("Select")) {
					comboBox_senior_level.setEnabled(false);
				}
				else {
					comboBox_senior_level.setEnabled(true);
				}
			}
		});
		
		comboBox_senior.setEnabled(false);
		comboBox_senior.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2"}));
		comboBox_college_level.setBounds(366, 329, 202, 30);
		panel_7.add(comboBox_college_level);
		comboBox_college_level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_college_level.getSelectedItem().toString().equals("Select")) {
					txt_college_year.setEnabled(false);
				}
				else {
					txt_college_year.setEnabled(true);
				}
				
			}
		});
		
		
		comboBox_college_level.setEnabled(false);
		comboBox_college_level.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "1st year", "2nd year", "3rd year", "4th year", "CollegeGraduate"}));
		comboBox_college.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_college.getSelectedItem().toString().equals("Select")) {
					comboBox_college_level.setEnabled(false);
				}
				else {
					comboBox_college_level.setEnabled(true);
				}
			}
		});
		
		comboBox_college.setEnabled(false);
		comboBox_college.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2"}));
		comboBox_senior_level.setBounds(366, 262, 202, 30);
		panel_7.add(comboBox_senior_level);
		
		
		comboBox_senior_level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_senior_level.getSelectedItem().toString().equals("SeniorHigh Graduate")) {
					comboBox_college.setEnabled(true);
					txt_senior_year.setEnabled(true);
				}
				else
				{
					txt_senior_year.setEnabled(true);
				}
			}
		});
		comboBox_senior_level.setEnabled(false);
		comboBox_senior_level.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "Grade 11", "Grade 12", "SeniorHigh Graduate"}));
		comboBox_high_level.setBounds(366, 192, 202, 30);
		panel_7.add(comboBox_high_level);
		
		
		comboBox_high_level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_high_level.getSelectedItem().toString().equals("Completer")) {
					comboBox_senior.setEnabled(true);
					txt_high_year.setEnabled(true);
				}
				else
				{
					txt_high_year.setEnabled(true);
				}
				
			}
		});
		comboBox_high_level.setEnabled(false);
		comboBox_high_level.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "Grade 7", "Grade 8", "Grade 9", "Grade 10","Completer"}));
		comboBox_elem_level.setBounds(366, 122, 202, 30);
		panel_7.add(comboBox_elem_level);
		
		comboBox_elem_level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_elem_level.getSelectedItem().toString().equals("Elementary Graduate")) {
					comboBox_high.setEnabled(true);
					txt_elem_year.setEnabled(true);
				}
				else
				{
					txt_elem_year.setEnabled(true);
				}
			}
		});
		comboBox_elem_level.setEnabled(false);
		comboBox_elem_level.setModel(new DefaultComboBoxModel(new String[] {"Select", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6", "Elementary Graduate"}));
		panel_1.setLayout(null);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(245, 245, 220));
		panel_4.setBounds(10, 11, 1142, 590);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration No");
		lblNewLabel.setBounds(39, 31, 151, 31);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblNewLabel);
		
		regno = new JTextField();
		regno.setBounds(39, 57, 190, 37);
		regno.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		regno.setEnabled(false);
		panel_4.add(regno);
		regno.setColumns(10);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(39, 105, 119, 25);
		lblFirstname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblFirstname);
		
		fn = new JTextField();
		fn.setBounds(39, 127, 190, 37);
		fn.setEnabled(false);
		fn.setColumns(10);
		panel_4.add(fn);
		
		JLabel lblMiddlename = new JLabel("Middle Name");
		lblMiddlename.setBounds(240, 105, 119, 25);
		lblMiddlename.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblMiddlename);
		
		mn = new JTextField();
		mn.setBounds(239, 127, 190, 37);
		mn.setEnabled(false);
		mn.setColumns(10);
		panel_4.add(mn);
		
		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setBounds(439, 105, 119, 25);
		lblLastname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblLastname);
		
		ln = new JTextField();
		ln.setBounds(439, 127, 190, 37);
		ln.setEnabled(false);
		ln.setColumns(10);
		panel_4.add(ln);
		
		JLabel lblSuffix = new JLabel("Suffix");
		lblSuffix.setBounds(639, 105, 119, 25);
		lblSuffix.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblSuffix);
		
		suf = new JTextField();
		suf.setBounds(639, 127, 190, 37);
		suf.setEnabled(false);
		suf.setColumns(10);
		panel_4.add(suf);
		
		JLabel lblBirthdate = new JLabel("Month");
		lblBirthdate.setBounds(39, 179, 66, 25);
		lblBirthdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblBirthdate);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(309, 179, 84, 25);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(639, 179, 119, 25);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(439, 318, 119, 25);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblEmail);
		
		age = new JTextField();
		age.setBounds(309, 201, 120, 37);
		age.setEnabled(false);
		age.setColumns(10);
		panel_4.add(age);
		
		email = new JTextField();
		email.setBounds(439, 343, 189, 37);
		email.setEnabled(false);
		email.setColumns(10);
		panel_4.add(email);
		
		JComboBox gender = new JComboBox();
		gender.setBounds(639, 201, 190, 37);
		gender.setModel(new DefaultComboBoxModel(new String[] {"Select", "MALE", "FEMALE"}));
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setEnabled(false);
		panel_4.add(gender);
		
		JLabel lblContactno = new JLabel("Contact No");
		lblContactno.setBounds(39, 249, 119, 25);
		lblContactno.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblContactno);
		
		JLabel lblStatus = new JLabel("Civil Status");
		lblStatus.setBounds(240, 249, 119, 25);
		lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblStatus);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(439, 249, 119, 25);
		lblHeight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(639, 249, 119, 25);
		lblWeight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblWeight);
		
		wei = new JTextField();
		wei.setBounds(639, 272, 190, 37);
		wei.setEnabled(false);
		wei.setColumns(10);
		panel_4.add(wei);
		
		hei = new JTextField();
		hei.setBounds(439, 272, 190, 37);
		hei.setEnabled(false);
		hei.setColumns(10);
		panel_4.add(hei);
		
		txt_no = new JTextField();
		txt_no.setBounds(39, 272, 190, 37);
		txt_no.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					txt_no.setEditable(false);
				}else {
					txt_no.setEditable(true);
				}
			}
		});
		txt_no.setEnabled(false);
		txt_no.setColumns(10);
		panel_4.add(txt_no);
		
		 stat = new JComboBox();
		 stat.setBounds(240, 272, 190, 37);
		stat.setModel(new DefaultComboBoxModel(new String[] {"Select", "single", "married", "separated", "widowed"}));
		stat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stat.setEnabled(false);
		panel_4.add(stat);
		
		reli = new JTextField();
		reli.setBounds(39, 343, 190, 37);
		reli.setEnabled(false);
		reli.setColumns(10);
		panel_4.add(reli);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setBounds(39, 320, 119, 25);
		lblReligion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblReligion);
		
		JLabel lblHobbies = new JLabel("Sports");
		lblHobbies.setBounds(240, 320, 119, 25);
		lblHobbies.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblHobbies);
		
		JLabel lblVaccinated = new JLabel("Vaccination Status");
		lblVaccinated.setBounds(39, 389, 178, 25);
		lblVaccinated.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblVaccinated);
		
		JLabel lblVaccine = new JLabel("1st Dose");
		lblVaccine.setBounds(240, 389, 119, 25);
		lblVaccine.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblVaccine);
		
		JComboBox hob = new JComboBox();
		hob.setBounds(240, 343, 190, 37);
		hob.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "Basketball", "Volletyball"}));
		hob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hob.setEnabled(false);
		panel_4.add(hob);
		
		house = new JTextField();
		house.setBounds(240, 483, 189, 37);
		house.setEnabled(false);
		house.setColumns(10);
		panel_4.add(house);
		
		JLabel lblHouseno = new JLabel("House No");
		lblHouseno.setBounds(240, 460, 119, 25);
		lblHouseno.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblHouseno);
		
		JLabel lblBarangay = new JLabel("Barangay");
		lblBarangay.setBounds(439, 460, 119, 25);
		lblBarangay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblBarangay);
		
		barangay = new JTextField();
		barangay.setBounds(439, 483, 190, 37);
		barangay.setText("San Roque");
		barangay.setEnabled(false);
		barangay.setColumns(10);
		panel_4.add(barangay);
		
		 imgDis = new JLabel("");
		 imgDis.setHorizontalAlignment(SwingConstants.CENTER);
		 imgDis.setBounds(851, 131, 259, 235);
		imgDis.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_4.add(imgDis);
		firstdose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(firstdose.getSelectedItem().toString().equals("Select")) {
					seconddose.setEnabled(false);
					
				} else if (firstdose.getSelectedItem().toString().equals("Jansen")) {
					seconddose.setEnabled(false);
					booster.setEnabled(true);
				}	else {
					seconddose.setEnabled(true);
					booster.setEnabled(false);
				}
			}
		});
		
		firstdose.setBounds(240, 412, 190, 37);
		firstdose.setModel(new DefaultComboBoxModel(new String[] {"Select", "Sinovac", "Pfizer", "Astra", "Sputnik", "Jansen"}));
		firstdose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstdose.setEnabled(false);
		panel_4.add(firstdose);
		
		bp = new JTextField();
		bp.setBounds(439, 201, 190, 37);
		bp.setEnabled(false);
		bp.setColumns(10);
		panel_4.add(bp);
		
		JLabel lblBirthPlace = new JLabel("Birth Place");
		lblBirthPlace.setBounds(439, 179, 119, 25);
		lblBirthPlace.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblBirthPlace);
		
		JLabel lblPurok = new JLabel("Purok");
		lblPurok.setBounds(39, 460, 119, 25);
		lblPurok.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblPurok);
		purok.setBounds(39, 483, 190, 37);
		
		
		purok.setModel(new DefaultComboBoxModel(new String[] {"Select", "Purok 1", "Purok 2", "Purok 3", "Purok 4", "Purok 5", "Purok 6", "Purok 7"}));
		purok.setFont(new Font("Tahoma", Font.PLAIN, 14));
		purok.setEnabled(false);
		panel_4.add(purok);
		comboBoxMonthPersonal.setMaximumRowCount(11);
		comboBoxMonthPersonal.setEnabled(false);
		comboBoxMonthPersonal.setBounds(39, 201, 97, 37);
		comboBoxMonthPersonal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearPersonal.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				
				System.out.println(monthString);
				System.out.println((comboBoxMonthPersonal.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthPersonal.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
					
				}else if (Integer.parseInt(monthString) == (comboBoxMonthPersonal.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthPersonal.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				age.setText(Integer.toString(ageString));
			}
		});
		
		
		comboBoxMonthPersonal.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		panel_4.add(comboBoxMonthPersonal);
		comboBoxDatePersonal.setEnabled(false);
		comboBoxDatePersonal.setBounds(146, 201, 66, 37);
		comboBoxDatePersonal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearPersonal.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthPersonal.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthPersonal.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthPersonal.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthPersonal.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				age.setText(Integer.toString(ageString));
			}
		});
		
		comboBoxDatePersonal.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		panel_4.add(comboBoxDatePersonal);
		comboBoxYearPersonal.setEnabled(false);
		comboBoxYearPersonal.setBounds(222, 201, 77, 37);
		comboBoxYearPersonal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int ageString = 0;
				Date d = new Date();
				SimpleDateFormat  yearDateFormat = new SimpleDateFormat("yyyy");
				String yearString = yearDateFormat.format(d);
				ageString = Integer.parseInt(yearString) - Integer.parseInt(comboBoxYearPersonal.getSelectedItem().toString());
				System.out.println(ageString);
				SimpleDateFormat monthDateFormat = new SimpleDateFormat("mm");
				String monthString = monthDateFormat.format(d);
				System.out.println(monthString);
				System.out.println((comboBoxMonthPersonal.getSelectedIndex() + 1));
				if(Integer.parseInt(monthString) < (comboBoxMonthPersonal.getSelectedIndex() + 1)) {
					ageString--;
					System.out.println("Age : " + ageString);
				}else if (Integer.parseInt(monthString) == (comboBoxMonthPersonal.getSelectedIndex() + 1)) {
					SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
					String dateString = dayDateFormat.format(d);
					if(Integer.parseInt(dateString) < Integer.parseInt(comboBoxMonthPersonal.getSelectedItem().toString())) {
						ageString--;
						System.out.println(ageString);
					}
				}
				if(ageString < 0) {
					ageString = 0;
				}
				age.setText(Integer.toString(ageString));
			}
		});
		
		comboBoxYearPersonal.setModel(new DefaultComboBoxModel(new String[] {"2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"}));
		panel_4.add(comboBoxYearPersonal);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setBounds(146, 179, 66, 25);
		panel_4.add(lblDate);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYear.setBounds(222, 179, 50, 25);
		panel_4.add(lblYear);
		
		JLabel lblDate_1 = new JLabel("/");
		lblDate_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDate_1.setBounds(115, 179, 19, 25);
		panel_4.add(lblDate_1);
		
		JLabel lblDate_1_1 = new JLabel("/");
		lblDate_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDate_1_1.setBounds(204, 179, 25, 25);
		panel_4.add(lblDate_1_1);
		vacstat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vacstat.getSelectedItem().toString().equals("Select")) {
					firstdose.setEnabled(false);
				} else if (vacstat.getSelectedItem().toString().equals("NO")) {
					firstdose.setEnabled(false);
				}	else {
					firstdose.setEnabled(true);
				}
			}
		});
		
		vacstat.setModel(new DefaultComboBoxModel(new String[] {"Select", "YES ", "NO"}));
		vacstat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vacstat.setEnabled(false);
		vacstat.setBounds(39, 414, 190, 37);
		panel_4.add(vacstat);
		
		JLabel lblndDose = new JLabel("2nd Dose");
		lblndDose.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblndDose.setBounds(439, 391, 119, 25);
		panel_4.add(lblndDose);
		seconddose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seconddose.getSelectedItem().toString().equals("Select")) {
					booster.setEnabled(false);
				}
				else
				{
					booster.setEnabled(true);
				}
			}
		});
		
		seconddose.setModel(new DefaultComboBoxModel(new String[] {"Select", "Sinovac", "Pfizer", "Astra", "Sputnik"}));
		seconddose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seconddose.setEnabled(false);
		seconddose.setBounds(439, 414, 190, 37);
		panel_4.add(seconddose);
		
		
		booster.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "Sinovac", "Pfizer", "Astra", "Sputnik"}));
		booster.setFont(new Font("Tahoma", Font.PLAIN, 14));
		booster.setEnabled(false);
		booster.setBounds(639, 412, 190, 37);
		panel_4.add(booster);
		
		JLabel lblBooster = new JLabel("Booster");
		lblBooster.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBooster.setBounds(639, 389, 119, 25);
		panel_4.add(lblBooster);
		
		hobbi.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "Dancer", "Singer"}));
		hobbi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hobbi.setEnabled(false);
		hobbi.setBounds(639, 341, 190, 37);
		panel_4.add(hobbi);
		
		JLabel lblHobbies_2 = new JLabel("Hobbies");
		lblHobbies_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHobbies_2.setBounds(639, 318, 119, 25);
		panel_4.add(lblHobbies_2);
		
		gov.setModel(new DefaultComboBoxModel(new String[] {"Select", "N/A", "Scholarship", "4P's"}));
		gov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gov.setEnabled(false);
		gov.setBounds(639, 483, 190, 37);
		panel_4.add(gov);
		
		JLabel lblGov = new JLabel("Gov. Programs");
		lblGov.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGov.setBounds(639, 460, 139, 25);
		panel_4.add(lblGov);
		
		JButton btnNewButton_3 = new JButton("BROWSE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
		  		chooser.showOpenDialog(null);
		  		File f = chooser.getSelectedFile();
		  		filename = f.getAbsolutePath();
		  		ImageIcon ImageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(imgDis.getWidth(),imgDis.getHeight(),Image.SCALE_SMOOTH));
		  		imgDis.setIcon(ImageIcon);
		  		
		  		
		  		try {
		  			File image = new File(filename);
		  			FileInputStream fis = new FileInputStream(image);
		  			ByteArrayOutputStream bos = new ByteArrayOutputStream();
		  			byte [] buf = new byte[1204];
		  			for(int readNum;(readNum=fis.read(buf))!=-1;){
		  	        bos.write(buf,0,readNum);
		  			}
		  			img = bos.toByteArray();
		  		}catch(Exception ev) {
		  			
		  		}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.setBounds(927, 390, 119, 37);
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setBounds(1038, 516, 72, 44);
		panel_4.add(btnNewButton);
		
		txtreason = new JTextField();
		
		
		
		txtreason.setText("");
		txtreason.setVisible(false);
		txtreason.setBounds(639, 57, 190, 37);
		panel_4.add(txtreason);
		txtreason.setColumns(10);
		
		lblRe = new JLabel("Reason");
		lblRe.setVisible(false);
		lblRe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRe.setBounds(639, 31, 151, 31);
		panel_4.add(lblRe);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.setBackground(new Color(255, 250, 205));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(33, 762, 170, 63);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_1_2.setEnabled(false);
		btnNewButton_1_2.setBackground(new Color(255, 250, 205));
		ImageIcon update = new ImageIcon(this.getClass().getResource("/update.png"));
		Image update1 = update.getImage();	
		Image update2= update1.getScaledInstance(45, 45 ,Image.SCALE_SMOOTH);
		ImageIcon update3 = new ImageIcon(update2);
		btnNewButton_1_2.setIcon(update3);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				fn.setEnabled(true);
				 mn.setEnabled(true);
				 ln.setEnabled(true);
				suf.setEnabled(true);
				 age.setEnabled(true);
				 email.setEnabled(true);
				 wei.setEnabled(true);
				 hei.setEnabled(true);
				txt_no.setEnabled(true);
				reli.setEnabled(true);
				house.setEnabled(true);
				 barangay.setEnabled(true);
				 
				stat.setEnabled(true);
				gender.setEnabled(true);
				hob.setEnabled(true);
				vacstat.setEnabled(true);
				 firstdose.setEnabled(true);;
				 seconddose.setEnabled(true);
				 booster.setEnabled(true);
				 gov.setEnabled(true);
				 hobbi.setEnabled(true);
				bp.setEnabled(true);
				purok.setEnabled(true);
				
				comboBoxDatePersonal.setEnabled(true);
				comboBoxYearPersonal.setEnabled(true);
				comboBoxMonthPersonal.setEnabled(true);
				
				ffn.setEnabled(true);
				fage1.setEnabled(true);
				fcon.setEnabled(true);
				foccu.setEnabled(true);
				 mmn.setEnabled(true);
				 mage.setEnabled(true);
				mcon.setEnabled(true);
				 moccu.setEnabled(true);
				siblings.setEnabled(true);
				order.setEnabled(true);
				comboBoxDateFather.setEnabled(true);
				comboBoxYearFather.setEnabled(true);
				comboBoxMonthFather.setEnabled(true);
				
				comboBoxDateMother.setEnabled(true);
				comboBoxYearMother.setEnabled(true);
				comboBoxMonthMother.setEnabled(true);
				
				comboBox_fatherincome.setEnabled(true);
				comboBox_motherincome.setEnabled(true);
				comboBox_familystatus.setEnabled(true);
				
			
			 	lrn.setEnabled(true);
	
			 	 comboBox_elem.setEnabled(true);
			 	 comboBox_high.setEnabled(true);
			 	 comboBox_senior.setEnabled(true);
			 	 comboBox_college.setEnabled(true);
			 	 
			 	 comboBox_elem_level.setEnabled(true);
			 	 comboBox_high_level.setEnabled(true);
			 	 comboBox_senior_level.setEnabled(true);
			 	 comboBox_college_level.setEnabled(true);
			 	
			 	 txt_elem_year.setEnabled(true);
			 	txt_high_year.setEnabled(true);
			 	txt_senior_year.setEnabled(true);
			 	txt_college_year.setEnabled(true);
			 	
			 	
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1_2.setBounds(213, 762, 170, 63);
		panel.add(btnNewButton_1_2);
		ImageIcon delete = new ImageIcon(this.getClass().getResource("/delete.png"));
		Image delete1 = delete.getImage();	
		Image delete2= delete1.getScaledInstance(45, 45 ,Image.SCALE_SMOOTH);
		ImageIcon delete3 = new ImageIcon(delete2);
		
		JButton btnNewButton_2_1 = new JButton("SAVE");
		btnNewButton_2_1.setBackground(new Color(255, 250, 205));
		ImageIcon save = new ImageIcon(this.getClass().getResource("/save.png"));
		Image save1 = save.getImage();	
		Image save2= save1.getScaledInstance(45, 45 ,Image.SCALE_SMOOTH);
		ImageIcon save3 = new ImageIcon(save2);
		btnNewButton_2_1.setIcon(save3);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2_1.setBounds(988, 762, 170, 63);
		panel.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int res =  JOptionPane.showConfirmDialog(null, "Do you want to save this information?","Option",JOptionPane.YES_NO_CANCEL_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					try {
						String sql1 = "Select * from studentrecord where RegistrationNo=?";
						conn	 = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
						pst = conn.prepareStatement(sql1);
						pst.setString(1, regno.getText());
						ResultSet rs1 = pst.executeQuery();
						if(rs1.next()) {
							try {
								pst = conn.prepareStatement("UPDATE studentrecord set RegistrationNo=?,Firstname=?,Middlename=?,Lastname=?,Suffix=?,Birthdate=?,Age=?,BirthPlace=?,Gender=?,ContactNo=?,CivilStatus=?,Height=?,Weight=?,Religion=?,Sports=?,Email=?,Hobbies=?,VaccinationStatus=?,FirstDose=?,SecondDose=?,Booster=?,Purok=?,HouseNo=?,Barangay=?,GovProgram=?,Image=?,Father=?,FatherBirthdate=?,FatherAge=?,FatherContact=?,FatherOccupation=?,FatherIncome=?,Mother=?,MotherBirthdate=?,MotherAge=?,MotherContact=?,MotherOccupation=?,MotherIncome=?,Siblings=?,FamilyStatus=?,BirthOrder=?,LRN=?,Elementary=?,ElemLevel=?,ElemSY=?,JuniorHighSchool=?,JuniorHighLevel=?,JuniorHighSY=?,SeniorHighSchool=?,SeniorHighLevel=?,SeniorHighSY=?,College=?,CollegeLevel=?,CollegeSY=?,Vocational=?,VocCategories=?,VocSY=? where RegistrationNo=?");
								pst.setString(1,regno.getText());
				  				pst.setString(2,fn.getText());
				  				pst.setString(3,mn.getText());
				  				pst.setString(4,ln.getText());
				  				pst.setString(5,suf.getText());
				  				
				  				String datePersonal = comboBoxDatePersonal.getSelectedItem().toString();
				  				if(datePersonal.length() <= 1) {
				  					datePersonal = "0" + datePersonal;
				  				}
				  				String monthPersonal = Integer.toString(comboBoxMonthPersonal.getSelectedIndex()+1);
				  				if(monthPersonal.length()<= 1) {
				  					monthPersonal = "0" + monthPersonal ;
				  				}
				  				String yearPersonal = comboBoxYearPersonal.getSelectedItem().toString();
				  				
				  				String birthday = yearPersonal + "/" + datePersonal + "/" + monthPersonal;
				  				pst.setString(6,  birthday);
				  				
				  				
				  				pst.setString(7,age.getText());
				  				pst.setString(8,bp.getText());
				  				String gen;
				  				gen = gender.getSelectedItem().toString();
				  				pst.setString(9,gen);
				  				pst.setString(10,txt_no.getText());
				  				String status;
				  				status = stat.getSelectedItem().toString();
				  				pst.setString(11,status);
				  				pst.setString(12,hei.getText());
				  				pst.setString(13,wei.getText());
				  				pst.setString(14,reli.getText());
				  				String hobbies;
				  				hobbies = hob.getSelectedItem().toString();
				  				pst.setString(15,hobbies);
				  				pst.setString(16,email.getText());
				  				String talent;
				  				talent = hobbi.getSelectedItem().toString();
				  				pst.setString(17,talent);
				  				String vacstatus;
				  				vacstatus = vacstat.getSelectedItem().toString();
				  				pst.setString(18, vacstatus);
				  				String first;
				  				first = firstdose.getSelectedItem().toString();
				  				pst.setString(19,first);
				  				String second;
				  				second = seconddose.getSelectedItem().toString();
				  				pst.setString(20,second);
				  				String booster1;
				  				booster1 = booster.getSelectedItem().toString();
				  				pst.setString(21,booster1);

				  				String purok1;
				  				purok1 = purok.getSelectedItem().toString();
				  				pst.setString(22,purok1);
				  				pst.setString(23,house.getText());
				  				pst.setString(24,barangay.getText());
				  				String gov1;
				  				gov1 = gov.getSelectedItem().toString();
				  				pst.setString(25,gov1);
				  				pst.setBytes(26,img);
				  				
				  				
				  				pst.setString(27,ffn.getText());
				  				String fatherdatePersonal = comboBoxDateFather.getSelectedItem().toString();
				  				if(fatherdatePersonal.length() <= 1) {
				  					fatherdatePersonal = "0" + fatherdatePersonal;
				  				}
				  				String fathermonthPersonal = Integer.toString(comboBoxMonthFather.getSelectedIndex()+1);
				  				if(fathermonthPersonal.length()<=1) {
				  					fathermonthPersonal = "0" + fathermonthPersonal;
				  				}
				  				String fatheryearPersonal = comboBoxYearFather.getSelectedItem().toString();
				  				String fatherbirthday = fatheryearPersonal + "/" + fatherdatePersonal + "/" + fathermonthPersonal;
				  				pst.setString(28,  fatherbirthday);
				  				pst.setString(29,fage1.getText());
				  				pst.setString(30,fcon.getText());
				  				pst.setString(31,foccu.getText());
				  				pst.setString(32, (String) comboBox_fatherincome.getSelectedItem());
				  				pst.setString(33,mmn.getText());
				  				
				  				String  motherdatePersonal = comboBoxDateMother.getSelectedItem().toString();
				  				if(motherdatePersonal.length() <= 1) {
				  					motherdatePersonal = "0" + motherdatePersonal;
				  				}
				  				String mothermonthPersonal = Integer.toString(comboBoxMonthMother.getSelectedIndex()+1);
				  				if(mothermonthPersonal.length()<=1) {
				  					mothermonthPersonal = "0" + mothermonthPersonal;
				  				}
				  				String motheryearPersonal = comboBoxYearMother.getSelectedItem().toString();
				  				String motherbirthdate = motheryearPersonal + "/" + motherdatePersonal + "/" + mothermonthPersonal;
				  				pst.setString(34,  motherbirthdate);
				  				
				  				
				  				
				  				pst.setString(35,mage.getText());
				  				pst.setString(36,mcon.getText());
				  				pst.setString(37,moccu.getText());
				  				pst.setString(38, (String) comboBox_motherincome.getSelectedItem());
				  				pst.setString(39,siblings.getText());
				  				pst.setString(40, (String) comboBox_familystatus.getSelectedItem());
				  				pst.setString(41,order.getText());
				  				pst.setString(42,lrn.getText());
				  				
				  				
				  				String elem = comboBox_elem.getSelectedItem().toString();
				  				if(elem.equals("Select")) {
				  					elem = "N/A";
				  				}
				  				String elem_level = comboBox_elem_level.getSelectedItem().toString();
				  				if(elem_level.equals("Select")) {
				  					elem_level = "N/A";
				  				}
				  				pst.setString(43, elem);
				  				pst.setString(44, elem_level);
				  				
				  				String ElemSchoolYear = "N/A";
				  				if(!txt_elem_year.getText().equals("")) {
				  					ElemSchoolYear = txt_elem_year.getText();
				  				}
				  				pst.setString(45, ElemSchoolYear);
				  				
				  				String high = comboBox_high.getSelectedItem().toString();
				  				if(high.equals("Select")) {
				  					high = "N/A";
				  				}
				  				String high_level = comboBox_high_level.getSelectedItem().toString();
				  				if(high_level.equals("Select")) {
				  					high_level = "N/A";
				  				}
				  				pst.setString(46, high);
				  				pst.setString(47, high_level);
				  				
				  				String HighSchoolYear = "N/A";
				  				if(!txt_high_year.getText().equals("")) {
				  					HighSchoolYear = txt_high_year.getText();
				  				}
				  				pst.setString(48, HighSchoolYear);
				  				
				  				String senior = comboBox_senior.getSelectedItem().toString();
				  				if(senior.equals("Select")) {
				  					senior = "N/A";
				  				}
				  				String senior_level = comboBox_senior_level.getSelectedItem().toString();
				  				if(senior_level.equals("Select")) {
				  					senior_level = "N/A";
				  				}
				  				pst.setString(49, senior);
				  				pst.setString(50, senior_level);
				  				
				  				String SeniorSchoolYear = "N/A";
				  				if(!txt_senior_year.getText().equals("")) {
				  					SeniorSchoolYear = txt_senior_year.getText();
				  				}
				  				pst.setString(51, SeniorSchoolYear);
				  				
				  				String college = comboBox_college.getSelectedItem().toString();
				  				if(college.equals("Select")) {
				  					college = "N/A";
				  				}
				  				String college_level = comboBox_college_level.getSelectedItem().toString();
				  				if(college_level.equals("Select")) {
				  					college_level = "N/A";
				  				}
				  				pst.setString(52, college);
				  				pst.setString(53, college_level);
				  				
				  				String collegeSchoolYear = "N/A";
				  				if(!txt_college_year.getText().equals("")) {
				  					collegeSchoolYear = txt_college_year.getText();
				  				}
				  				pst.setString(54, collegeSchoolYear);
				  				
				  				
				  				String voc = comboBox_voc.getSelectedItem().toString();
				  				if(voc.equals("Select")) {
				  					voc = "N/A";
				  				}
				  				String voc_level = comboBox_voc_level.getSelectedItem().toString();
				  				if(voc_level.equals("Select")) {
				  					voc_level = "N/A";
				  				}
				  				pst.setString(55, voc);
				  				pst.setString(56, voc_level);
				  				
				  				String VocSchoolYear = "N/A";
				  				if(!txt_voc_year.getText().equals("")) {
				  					VocSchoolYear = txt_voc_year.getText();
				  				}
				  				pst.setString(57, VocSchoolYear);
				  				pst.setString(58,regno.getText());
				  				
				  				pst.executeUpdate();
				  				JOptionPane.showMessageDialog(null, "UPDATE SUCCESS");
				  				
				  				 regno.setText("");
								 fn.setText("");
								 mn.setText("");
								 ln.setText("");
								suf.setText("");
								 age.setText("");
								 email.setText("");
								 wei.setText("");
								 hei.setText("");
								txt_no.setText("");
								reli.setText("");
								house.setText("");
							
								vacstat.setSelectedIndex(0);
								firstdose.setSelectedIndex(0);
								seconddose.setSelectedIndex(0);
								booster.setSelectedIndex(0);
								gov.setSelectedIndex(0);
								
								stat.setSelectedIndex(0);
								gender.setSelectedIndex(0);
								hob.setSelectedIndex(0);			
								imgDis.setIcon(null);
								
								comboBoxDatePersonal.setSelectedIndex(0);
								comboBoxMonthPersonal.setSelectedIndex(0);
								comboBoxYearPersonal.setSelectedIndex(0);
								
								
								comboBoxDateFather.setSelectedIndex(0);
								comboBoxMonthFather.setSelectedIndex(0);
								comboBoxYearFather.setSelectedIndex(0);
								
								comboBoxDateMother.setSelectedIndex(0);
								comboBoxMonthMother.setSelectedIndex(0);
								comboBoxYearMother.setSelectedIndex(0);
								
								
								
							//family 
								ffn.setText("");
								
								fage1.setText("");
								fcon.setText("");
								foccu.setText("");
								
								 mmn.setText("");
								
								 mage.setText("");
								mcon.setText("");
								 moccu.setText("");
								
								siblings.setText("");
								order.setText("");
					
								 
							//education info
								
							 		lrn.setText("");
								 txt_elem_year.setText("");
								 txt_high_year.setText("");
								 txt_senior_year.setText("");
								 txt_college_year.setText("");
								 txt_voc_year.setText("");
								
								 comboBox_elem_level.setSelectedIndex(0);
								 comboBox_high_level.setSelectedIndex(0);
								 comboBox_senior_level.setSelectedIndex(0);
								 comboBox_college_level.setSelectedIndex(0);
								 comboBox_voc_level.setSelectedIndex(0);
								 
								 comboBox_elem.setSelectedIndex(0);
								 comboBox_high.setSelectedIndex(0);
								 comboBox_senior.setSelectedIndex(0);
								 comboBox_college.setSelectedIndex(0);
								 comboBox_voc.setSelectedIndex(0);
								 
							}catch(Exception ee) {
								JOptionPane.showMessageDialog(null, ee);
							}
						}
						else {
							String sql = "INSERT INTO studentrecord(RegistrationNo,Firstname,Middlename,Lastname,Suffix,Birthdate,Age,BirthPlace,Gender,ContactNo,CivilStatus,Height,Weight,Religion,Sports,Email,Hobbies,VaccinationStatus,FirstDose,SecondDose,Booster,Purok,HouseNo,Barangay,GovProgram,Image,Father,FatherBirthdate,FatherAge,FatherContact,FatherOccupation,FatherIncome,Mother,MotherBirthdate,MotherAge,MotherContact,MotherOccupation,MotherIncome,Siblings,FamilyStatus,BirthOrder,LRN,Elementary,ElemLevel,ElemSY,JuniorHighSchool,JuniorHighLevel,JuniorHighSY,SeniorHighSchool,SeniorHighLevel,SeniorHighSY,College,CollegeLevel,CollegeSY,Vocational,VocCategories,VocSY,Date)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
							  try {
								  Class.forName("com.mysql.cj.jdbc.Driver");
								 	conn	 = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
					  				pst = conn.prepareStatement(sql);
					  				pst.setString(1,regno.getText());
					  				pst.setString(2,fn.getText());
					  				pst.setString(3,mn.getText());
					  				pst.setString(4,ln.getText());
					  				pst.setString(5,suf.getText());
					  				
					  				String datePersonal = comboBoxDatePersonal.getSelectedItem().toString();
					  				if(datePersonal.length() <= 1) {
					  					datePersonal = "0" + datePersonal;
					  				}
					  				String monthPersonal = Integer.toString(comboBoxMonthPersonal.getSelectedIndex()+1);
					  				if(monthPersonal.length()<= 1) {
					  					monthPersonal = "0" + monthPersonal ;
					  				}
					  				String yearPersonal = comboBoxYearPersonal.getSelectedItem().toString();
					  				
					  				String birthday = yearPersonal + "/" + datePersonal + "/" + monthPersonal;
					  				pst.setString(6,  birthday);
					  				
					  				
					  				pst.setString(7,age.getText());
					  				pst.setString(8,bp.getText());
					  				String gen;
					  				gen = gender.getSelectedItem().toString();
					  				pst.setString(9,gen);
					  				pst.setString(10,txt_no.getText());
					  				String status;
					  				status = stat.getSelectedItem().toString();
					  				pst.setString(11,status);
					  				pst.setString(12,hei.getText());
					  				pst.setString(13,wei.getText());
					  				pst.setString(14,reli.getText());
					  				String hobbies;
					  				hobbies = hob.getSelectedItem().toString();
					  				pst.setString(15,hobbies);
					  				pst.setString(16,email.getText());
					  				String talent;
					  				talent = hobbi.getSelectedItem().toString();
					  				pst.setString(17,talent);
					  				String vacstatus;
					  				vacstatus = vacstat.getSelectedItem().toString();
					  				pst.setString(18, vacstatus);
					  				String first;
					  				first = firstdose.getSelectedItem().toString();
					  				pst.setString(19,first);
					  				String second;
					  				second = seconddose.getSelectedItem().toString();
					  				pst.setString(20,second);
					  				String booster1;
					  				booster1 = booster.getSelectedItem().toString();
					  				pst.setString(21,booster1);

					  				String purok1;
					  				purok1 = purok.getSelectedItem().toString();
					  				pst.setString(22,purok1);
					  				pst.setString(23,house.getText());
					  				pst.setString(24,barangay.getText());
					  				String gov1;
					  				gov1 = gov.getSelectedItem().toString();
					  				pst.setString(25,gov1);
					  				pst.setBytes(26,img);
					  				
					  				
					  				pst.setString(27,ffn.getText());
					  				String fatherdatePersonal = comboBoxDateFather.getSelectedItem().toString();
					  				if(fatherdatePersonal.length() <= 1) {
					  					fatherdatePersonal = "0" + fatherdatePersonal;
					  				}
					  				String fathermonthPersonal = Integer.toString(comboBoxMonthFather.getSelectedIndex()+1);
					  				if(fathermonthPersonal.length()<=1) {
					  					fathermonthPersonal = "0" + fathermonthPersonal;
					  				}
					  				String fatheryearPersonal = comboBoxYearFather.getSelectedItem().toString();
					  				String fatherbirthday = fatheryearPersonal + "/" + fatherdatePersonal + "/" + fathermonthPersonal;
					  				pst.setString(28,  fatherbirthday);
					  				pst.setString(29,fage1.getText());
					  				pst.setString(30,fcon.getText());
					  				pst.setString(31,foccu.getText());
					  				pst.setString(32, (String) comboBox_fatherincome.getSelectedItem());
					  				pst.setString(33,mmn.getText());
					  				
					  				String  motherdatePersonal = comboBoxDateMother.getSelectedItem().toString();
					  				if(motherdatePersonal.length() <= 1) {
					  					motherdatePersonal = "0" + motherdatePersonal;
					  				}
					  				String mothermonthPersonal = Integer.toString(comboBoxMonthMother.getSelectedIndex()+1);
					  				if(mothermonthPersonal.length()<=1) {
					  					mothermonthPersonal = "0" + mothermonthPersonal;
					  				}
					  				String motheryearPersonal = comboBoxYearMother.getSelectedItem().toString();
					  				String motherbirthdate = motheryearPersonal + "/" + motherdatePersonal + "/" + mothermonthPersonal;
					  				pst.setString(34,  motherbirthdate);
					  				
					  				
					  				
					  				pst.setString(35,mage.getText());
					  				pst.setString(36,mcon.getText());
					  				pst.setString(37,moccu.getText());
					  				pst.setString(38, (String) comboBox_motherincome.getSelectedItem());
					  				pst.setString(39,siblings.getText());
					  				pst.setString(40, (String) comboBox_familystatus.getSelectedItem());
					  				pst.setString(41,order.getText());
					  				pst.setString(42,lrn.getText());
					  				
					  				String elem = comboBox_elem.getSelectedItem().toString();
					  				if(elem.equals("Select")) {
					  					elem = "N/A";
					  				}
					  				String elem_level = comboBox_elem_level.getSelectedItem().toString();
					  				if(elem_level.equals("Select")) {
					  					elem_level = "N/A";
					  				}
					  				pst.setString(43, elem);
					  				pst.setString(44, elem_level);
					  				
					  				String ElemSchoolYear = "N/A";
					  				if(!txt_elem_year.getText().equals("")) {
					  					ElemSchoolYear = txt_elem_year.getText();
					  				}
					  				pst.setString(45, ElemSchoolYear);
					  				
					  				String high = comboBox_high.getSelectedItem().toString();
					  				if(high.equals("Select")) {
					  					high = "N/A";
					  				}
					  				String high_level = comboBox_high_level.getSelectedItem().toString();
					  				if(high_level.equals("Select")) {
					  					high_level = "N/A";
					  				}
					  				pst.setString(46, high);
					  				pst.setString(47, high_level);
					  				
					  				String HighSchoolYear = "N/A";
					  				if(!txt_high_year.getText().equals("")) {
					  					HighSchoolYear = txt_high_year.getText();
					  				}
					  				pst.setString(48, HighSchoolYear);
					  				
					  				String senior = comboBox_senior.getSelectedItem().toString();
					  				if(senior.equals("Select")) {
					  					senior = "N/A";
					  				}
					  				String senior_level = comboBox_senior_level.getSelectedItem().toString();
					  				if(senior_level.equals("Select")) {
					  					senior_level = "N/A";
					  				}
					  				pst.setString(49, senior);
					  				pst.setString(50, senior_level);
					  				
					  				String SeniorSchoolYear = "N/A";
					  				if(!txt_senior_year.getText().equals("")) {
					  					SeniorSchoolYear = txt_senior_year.getText();
					  				}
					  				pst.setString(51, SeniorSchoolYear);
					  				
					  				String college = comboBox_college.getSelectedItem().toString();
					  				if(college.equals("Select")) {
					  					college = "N/A";
					  				}
					  				String college_level = comboBox_college_level.getSelectedItem().toString();
					  				if(college_level.equals("Select")) {
					  					college_level = "N/A";
					  				}
					  				pst.setString(52, college);
					  				pst.setString(53, college_level);
					  				
					  				String collegeSchoolYear = "N/A";
					  				if(!txt_college_year.getText().equals("")) {
					  					collegeSchoolYear = txt_college_year.getText();
					  				}
					  				pst.setString(54, collegeSchoolYear);
					  				
					  				
					  				String voc = comboBox_voc.getSelectedItem().toString();
					  				if(voc.equals("Select")) {
					  					voc = "N/A";
					  				}
					  				String voc_level = comboBox_voc_level.getSelectedItem().toString();
					  				if(voc_level.equals("Select")) {
					  					voc_level = "N/A";
					  				}
					  				pst.setString(55, voc);
					  				pst.setString(56, voc_level);
					  				
					  				String VocSchoolYear = "N/A";
					  				if(!txt_voc_year.getText().equals("")) {
					  					VocSchoolYear = txt_voc_year.getText();
					  				}
					  				pst.setString(57, VocSchoolYear);
					  				pst.setString(58,date.getText());
					  				pst.executeUpdate();
					  				
					  				JOptionPane.showMessageDialog(null,"Successfully Add");
					  				
					  				autoID();
	
					  			//basic
									 regno.setText("");
									 fn.setText("");
									 mn.setText("");
									 ln.setText("");
									suf.setText("");
									 age.setText("");
									 email.setText("");
									 wei.setText("");
									 hei.setText("");
									txt_no.setText("");
									reli.setText("");
									house.setText("");
									
								
									 comboBoxDatePersonal.setSelectedIndex(0);
									 comboBoxMonthPersonal.setSelectedIndex(0);
									 comboBoxYearPersonal.setSelectedIndex(0);
									 
									 	stat.setSelectedIndex(0);
									 	vacstat.setSelectedIndex(0);
										firstdose.setSelectedIndex(0);
										seconddose.setSelectedIndex(0);
										booster.setSelectedIndex(0);
										gov.setSelectedIndex(0);
									
									
								//family 
									ffn.setText("");
									fage1.setText("");
									fcon.setText("");
									foccu.setText("");
									 mmn.setText("");
									 mage.setText("");
									mcon.setText("");
									 moccu.setText("");
									siblings.setText("");
									order.setText("");
									 comboBoxDateFather.setSelectedIndex(0);
									 comboBoxMonthFather.setSelectedIndex(0);
									 comboBoxYearFather.setSelectedIndex(0);
									 comboBoxDateMother.setSelectedIndex(0);
									 comboBoxMonthMother.setSelectedIndex(0);
									 comboBoxYearMother.setSelectedIndex(0);
						
									 
								//education info
									 
								 		lrn.setText("");
									 txt_elem_year.setText("");
									 txt_high_year.setText("");
									 txt_senior_year.setText("");
									 txt_college_year.setText("");
									 txt_voc_year.setText("");
									
									 comboBox_elem_level.setSelectedIndex(0);
									 comboBox_high_level.setSelectedIndex(0);
									 comboBox_senior_level.setSelectedIndex(0);
									 comboBox_college_level.setSelectedIndex(0);
									 comboBox_voc_level.setSelectedIndex(0);
									 
									 comboBox_elem.setSelectedIndex(0);
									 comboBox_high.setSelectedIndex(0);
									 comboBox_senior.setSelectedIndex(0);
									 comboBox_college.setSelectedIndex(0);
									 comboBox_voc.setSelectedIndex(0);
									 
									 imgDis.setIcon(null);
									 
					  				
							  } catch (Exception ex) {
								  JOptionPane.showMessageDialog(null,ex);
									
					  	          
							  }
						}
					}catch(Exception e1) {
						
					}
					
					
					
					
					
					
					
				}else if(res == JOptionPane.NO_OPTION) {
					
					
				}else if(res == JOptionPane.CANCEL_OPTION) {
					//basic
					 regno.setText("");
					 fn.setText("");
					 mn.setText("");
					 ln.setText("");
					suf.setText("");
					 age.setText("");
					 email.setText("");
					 wei.setText("");
					 hei.setText("");
					txt_no.setText("");
					reli.setText("");
					house.setText("");
				
					vacstat.setSelectedIndex(0);
					firstdose.setSelectedIndex(0);
					seconddose.setSelectedIndex(0);
					booster.setSelectedIndex(0);
					gov.setSelectedIndex(0);
					
					stat.setSelectedIndex(0);
					gender.setSelectedIndex(0);
					hob.setSelectedIndex(0);			
					imgDis.setIcon(null);
					
					
				//family 
					ffn.setText("");
					
					fage1.setText("");
					fcon.setText("");
					foccu.setText("");
					
					 mmn.setText("");
					
					 mage.setText("");
					mcon.setText("");
					 moccu.setText("");
					
					siblings.setText("");
					order.setText("");
		
					 
				//education info
					
				 		lrn.setText("");
					 txt_elem_year.setText("");
					 txt_high_year.setText("");
					 txt_senior_year.setText("");
					 txt_college_year.setText("");
					 txt_voc_year.setText("");
					
					 comboBox_elem_level.setSelectedIndex(0);
					 comboBox_high_level.setSelectedIndex(0);
					 comboBox_senior_level.setSelectedIndex(0);
					 comboBox_college_level.setSelectedIndex(0);
					 comboBox_voc_level.setSelectedIndex(0);
					 
					 comboBox_elem.setSelectedIndex(0);
					 comboBox_high.setSelectedIndex(0);
					 comboBox_senior.setSelectedIndex(0);
					 comboBox_college.setSelectedIndex(0);
					 comboBox_voc.setSelectedIndex(0);
					 
					 
					
				}
				
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 autoID();
				//basic info
				 
				 fn.setEnabled(true);
				 mn.setEnabled(true);
				 ln.setEnabled(true);
				suf.setEnabled(true);
				 age.setEnabled(true);
				 email.setEnabled(true);
				 wei.setEnabled(true);
				 hei.setEnabled(true);
				txt_no.setEnabled(true);
				reli.setEnabled(true);
				house.setEnabled(true);
				 barangay.setEnabled(true);
			
				 vacstat.setEnabled(true);
				 gov.setEnabled(true);
				 hobbi.setEnabled(true);
				 
				stat.setEnabled(true);
				gender.setEnabled(true);
				hob.setEnabled(true);
				bp.setEnabled(true);
				purok.setEnabled(true);
				comboBoxDatePersonal.setEnabled(true);
				comboBoxYearPersonal.setEnabled(true);
				comboBoxMonthPersonal.setEnabled(true);
				
				
				 fn.setText("");
				 mn.setText("");
				 ln.setText("");
				suf.setText("");
				 age.setText("");
				 email.setText("");
				 wei.setText("");
				 hei.setText("");
				txt_no.setText("");
				reli.setText("");
				house.setText("");
				
				 
				imgDis.setIcon(null);
				 vacstat.setSelectedIndex(0);
				 firstdose.setSelectedIndex(0);
				 seconddose.setSelectedIndex(0);
				 booster.setSelectedIndex(0);
				 gov.setSelectedIndex(0);
				 hobbi.setSelectedIndex(0); 
				stat.setSelectedIndex(0);
				gender.setSelectedIndex(0);
				hob.setSelectedIndex(0);
				firstdose.setSelectedIndex(0);
				bp.setText("");
				purok.setSelectedIndex(0);
				imgDis.setText("");;
				comboBoxDatePersonal.setSelectedIndex(0);
				comboBoxYearPersonal.setSelectedIndex(0);
				comboBoxMonthPersonal.setSelectedIndex(0);
				
				
				
				//familyinfo
				ffn.setEnabled(true);
				fage1.setEnabled(true);
				fcon.setEnabled(true);
				foccu.setEnabled(true);
				 mmn.setEnabled(true);
				 mage.setEnabled(true);
				mcon.setEnabled(true);
				 moccu.setEnabled(true);
				siblings.setEnabled(true);
				order.setEnabled(true);
				comboBoxDateFather.setEnabled(true);
				comboBoxYearFather.setEnabled(true);
				comboBoxMonthFather.setEnabled(true);
				
				comboBoxDateMother.setEnabled(true);
				comboBoxYearMother.setEnabled(true);
				comboBoxMonthMother.setEnabled(true);
				
				comboBox_fatherincome.setEnabled(true);
				comboBox_motherincome.setEnabled(true);
				comboBox_familystatus.setEnabled(true);
				
				ffn.setText("");
				fage1.setText("");
				fcon.setText("");
				foccu.setText("");
				 mmn.setText("");
				 mage.setText("");
				mcon.setText("");
				 moccu.setText("");
				siblings.setText("");
				order.setText("");
				
				comboBoxDateFather.setSelectedIndex(0);
				comboBoxYearFather.setSelectedIndex(0);
				comboBoxMonthFather.setSelectedIndex(0);
				
				comboBoxDateMother.setSelectedIndex(0);
				comboBoxYearMother.setSelectedIndex(0);
				comboBoxMonthMother.setSelectedIndex(0);
				
				comboBox_fatherincome.setSelectedIndex(0);
				comboBox_motherincome.setSelectedIndex(0);
				comboBox_familystatus.setSelectedIndex(0);
				
				 //educinfo
				 
					
				 	lrn.setEnabled(true);
				 	
				 	lrn.setText("");
				 	 comboBox_elem.setEnabled(true);
				 	comboBox_elem.setSelectedIndex(0);
					 /*txt_elem_year.setEnabled(true);
					 txt_high_year.setEnabled(true);
					 txt_senior_year.setEnabled(true);
					 txt_college_year.setEnabled(true);
					 txt_voc_year.setEnabled(true);*/
					
					
					 
					
					
					 regno.setEditable(false);
					 
				
				
			}
		});
		ImageIcon add = new ImageIcon(this.getClass().getResource("/add.png"));
		Image add1 = add.getImage();	
		Image add2= add1.getScaledInstance(45, 45 ,Image.SCALE_SMOOTH);
		ImageIcon add3 = new ImageIcon(add2);
		btnNewButton_1.setIcon(add3);
		btnNewButton_1_2_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_1_2_1.getText().equals("Set Dropped")) {
					txtreason.setVisible(true);
  					lblRe.setVisible(true);
  					txtreason.addKeyListener(new KeyAdapter() {
  						@Override
  						public void keyPressed(KeyEvent e) {
  							if(e.getKeyCode()==KeyEvent.VK_ENTER) {		  							
  							JOptionPane.showMessageDialog(null, "ARE YOU SURE YOU WANT TO SET THIS STUDENT AS DROPPED?");
  							txtreason.setVisible(false);
  		  					lblRe.setVisible(false);
		  					btnNewButton_1_2_1.setText("Set Active");
		  					String sql1 = "UPDATE studentrecord SET RegistrationNo=?,studentStatus='Dropped',Reason=? WHERE RegistrationNo=?";
							try {
								 Class.forName("com.mysql.cj.jdbc.Driver");
								 	conn	 = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
					  				pst = conn.prepareStatement(sql1);
					  				pst.setString(1,regno.getText());
					  				pst.setString(2,txtreason.getText());
					  				pst.setString(3,regno.getText());
					  				
					  				try {
					  					pst.execute();
					  					
					  				}catch(Exception updateException) {
					  					JOptionPane.showMessageDialog(frame, updateException);
					  					txtreason.setText("");
					  				}
							}
							catch(Exception updateError) {
								JOptionPane.showMessageDialog(null, updateError);
							}
						}
  							}
  						
  					});
					String sql1 = "UPDATE studentrecord SET RegistrationNo=?,studentStatus='Dropped',Reason=? WHERE RegistrationNo=?";
					try {
						 Class.forName("com.mysql.cj.jdbc.Driver");
						 	conn	 = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			  				pst = conn.prepareStatement(sql1);
			  				pst.setString(1,regno.getText());
			  				pst.setString(2,txtreason.getText());
			  				pst.setString(3,regno.getText());
			  				try {
			  					pst.execute();
					
			  				}catch(Exception updateException) {
			  					
			  					JOptionPane.showMessageDialog(frame, updateException);
			  				}
					}
					catch(Exception updateError) {
						JOptionPane.showMessageDialog(null, updateError);
					}
				}
				else if (btnNewButton_1_2_1.getText().equals("Set Active")){
					txtreason.setVisible(false);
  					lblRe.setVisible(false);
					String sql1 = "UPDATE studentrecord SET studentStatus='Active',Reason='' WHERE RegistrationNo=?";
					try {
						 Class.forName("com.mysql.cj.jdbc.Driver");
						 	conn	 = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			  				pst = conn.prepareStatement(sql1);
			  				pst.setString(1,regno.getText());
			  				try {
			  					pst.execute();
			  					JOptionPane.showMessageDialog(null, "STUDENT SUCCESFULLY SET TO ACTIVE!");
			  					btnNewButton_1_2_1.setText("Set Dropped");
			  				}catch(Exception updateException) {
			  					JOptionPane.showMessageDialog(frame, updateException);
			  				}
					}
					catch(Exception updateError) {
						JOptionPane.showMessageDialog(null, updateError);
					}
				}
			}
		});	
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1_2_1.setEnabled(false);
		btnNewButton_1_2_1.setBackground(new Color(255, 250, 205));
		btnNewButton_1_2_1.setBounds(393, 762, 170, 63);
		panel.add(btnNewButton_1_2_1);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(961, 84, 205, 44);
		panel.add(txtSearch);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNewButton_1_2.setEnabled(true);
				 btnNewButton_1_2_1.setEnabled(true);
				
				try { 
					Class.forName("com.mysql.cj.jdbc.Driver");
				 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
				 	String sql = "Select * from studentrecord where RegistrationNo=?";	
					pst = conn.prepareStatement(sql);
					pst.setString(1, txtSearch.getText());
					rs = pst.executeQuery();
					if(rs.next()) {
					String setid  = rs.getString("RegistrationNo");
					regno.setText(setid);
					String setname  = rs.getString("Firstname");
					fn.setText(setname);
					String setaddress  = rs.getString("Middlename");
					mn.setText(setaddress);
					String setcontact  = rs.getString("Lastname");
					ln.setText(setcontact);
					String setsuf  = rs.getString("Suffix");
					suf.setText(setsuf);
					
					String birthdate = rs.getString("Birthdate");
					String year = birthdate.substring(0, 4);
					comboBoxYearPersonal.setSelectedItem(year);
					int date = Integer.parseInt(birthdate.substring(5, 7)) - 1 + 1;
					
					comboBoxDatePersonal.setSelectedItem(Integer.toString(date));
					int month = Integer.parseInt(birthdate.substring(9, birthdate.length())) - 1 ;
					switch(month) {
					case 0:
						comboBoxMonthPersonal.setSelectedItem("January");
						break;
					case 1:
						comboBoxMonthPersonal.setSelectedItem("February");
						break;
					case 2:
						comboBoxMonthPersonal.setSelectedItem("March");
						break;
					case 3:
						comboBoxMonthPersonal.setSelectedItem("April");
						break;
					case 4:
						comboBoxMonthPersonal.setSelectedItem("May");
						break;
					case 5:
						comboBoxMonthPersonal.setSelectedItem("June");
						break;
					case 6:
						comboBoxMonthPersonal.setSelectedItem("July");
						break;
					case 7:
						comboBoxMonthPersonal.setSelectedItem("August");
						break;
					case 8:
						comboBoxMonthPersonal.setSelectedItem("September");
						break;
					case 9:
						comboBoxMonthPersonal.setSelectedItem("October");
						break;
					case 10:
						comboBoxMonthPersonal.setSelectedItem("November");
						break;
					case 11:
						comboBoxMonthPersonal.setSelectedItem("December");
						break;
					}
					
					
					String setage = rs.getString("Age");
					age.setText(setage);
					
					String setplace = rs.getString("BirthPlace");
					bp.setText(setplace);
					
					String gen1 = rs.getString("Gender");
			  		switch(gen1) {
			  		case "Select":
			  			gender.setSelectedIndex(0);
			  			break;
			  		case "MALE":
			  			gender.setSelectedIndex(1);
			  			break;
			  		case "FEMALE":
			  			gender.setSelectedIndex(2);
			  			break;
			  		}	
			  		
			  		String setcon = rs.getString("ContactNo");
					txt_no.setText(setcon);
					
					String civil= rs.getString("CivilStatus");
			  		switch(civil) {
			  		case "Select":
			  			stat.setSelectedIndex(0);
			  			break;
			  		case "single":
			  			stat.setSelectedIndex(1);
			  			break;
			  		case "married":
			  			stat.setSelectedIndex(2);
			  			break;
			  		case "seperated":
			  			stat.setSelectedIndex(3);
			  			break;
			  		case "widowed":
			  			stat.setSelectedIndex(4);
			  			break;
			  		}
			  		String sethei = rs.getString("Height");
					hei.setText(sethei);
					String setwei = rs.getString("Weight");
					wei.setText(setwei);
					
					String setreli = rs.getString("Religion");
					reli.setText(setreli);
					
					String sports = rs.getString("Sports");
			  		switch(sports) {
			  		case "Select":
			  			hob.setSelectedIndex(0);
			  			break;
			  		case "N/A":
			  			hob.setSelectedIndex(1);
			  			break;
			  		case "Basketball":
			  			hob.setSelectedIndex(2);
			  			break;
			  		case "Volleyball":
			  			hob.setSelectedIndex(3);
			  			break;
			  		}	
			  		
			  		String setemail = rs.getString("Email");
					email.setText(setemail);
					
					String hob1 = rs.getString("Hobbies");
			  		switch(hob1) {
			  		case "Select":
			  			hobbi.setSelectedIndex(0);
			  			break;
			  		case "N/A":
			  			hobbi.setSelectedIndex(1);
			  			break;
			  		case "Singing":
			  			hobbi.setSelectedIndex(2);
			  			break;
			  		case "Dancing":
			  			hobbi.setSelectedIndex(3);
			  			break;
			  		
			  		}	
					
			  		String norma = rs.getString("VaccinationStatus");
			  		switch(norma) {
			  		case "Select":
			  			gender.setSelectedIndex(0);
			  			break;
			  		case "YES":
			  			gender.setSelectedIndex(1);
			  			break;
			  		case "NO":
			  			gender.setSelectedIndex(2);
			  			break;
			  		}	
			  	
			  		
			  		
			  		String vac11 = rs.getString("FirstDose");
			  		switch(vac11) {
			  		case "select":
		  				firstdose.setSelectedIndex(0);
		  			break;
			  			case "Sinovac":
			  				firstdose.setSelectedIndex(1);
			  			break;
			  			case "Pfizer":
			  				firstdose.setSelectedIndex(2);
			  			break;	
			  			case "AstraZ":
			  				firstdose.setSelectedIndex(3);
			  				break;
			  			case "Sputnik":
			  				firstdose.setSelectedIndex(4);
			  				break;
			  			case "Jansen":
			  				firstdose.setSelectedIndex(5);
			  				break;
			  		}
			  		
			  		String vac12 = rs.getString("SecondDose");
			  		switch(vac12) {
			  		case "select":
		  				seconddose.setSelectedIndex(0);
		  			break;
			  			case "Sinovac":
			  				seconddose.setSelectedIndex(1);
			  			break;
			  			case "Pfizer":
			  				seconddose.setSelectedIndex(2);
			  			break;	
			  			case "AstraZ":
			  				seconddose.setSelectedIndex(3);
			  				break;
			  			case "Sputnik":
			  				seconddose.setSelectedIndex(4);
			  				break;
			  			
			  		}
			  		
			  		String boos = rs.getString("Booster");
			  		switch(boos) {
			  		case "select":
		  				booster.setSelectedIndex(0);
		  			break;
			  			case "Sinovac":
			  				booster.setSelectedIndex(1);
			  			break;
			  			case "Pfizer":
			  				booster.setSelectedIndex(2);
			  			break;	
			  			case "AstraZ":
			  				booster.setSelectedIndex(3);
			  				break;
			  			case "Sputnik":
			  				booster.setSelectedIndex(4);
			  				break;
			  			
			  		}
			  		
			  		
			  		String pur = rs.getString("Purok");
			  		switch(pur) {
			  			case "Select":
			  				purok.setSelectedIndex(0);
			  			break;
			  			case "Purok 1":
			  				purok.setSelectedIndex(1);
			  			break;
			  			case "Purok 2":
			  				purok.setSelectedIndex(2);
			  			break;
			  			case "Purok 3":
			  				purok.setSelectedIndex(3);
			  			break;
			  			case "Purok 4":
			  				purok.setSelectedIndex(4);
			  			break;
			  			case "Purok 5":
			  				purok.setSelectedIndex(5);
			  			break;
			  			case "Purok 6":
			  				purok.setSelectedIndex(6);
			  			break;
			  			case "Purok 7":
			  				purok.setSelectedIndex(7);
			  			break;
			  			
			  		}
			  		String sethouse = rs.getString("HouseNo");
					house.setText(sethouse);
			  		String setbar = rs.getString("Barangay");
					barangay.setText(setbar);
					
					String gov1 = rs.getString("GovProgram");
			  		switch(gov1) {
			  		case "select":
		  				gov.setSelectedIndex(0);
		  			break;
			  			case "N/A":
			  				gov.setSelectedIndex(1);
			  			break;
			  			case "Scholarship":
			  				gov.setSelectedIndex(2);
			  			break;	
			  			case "4ps":
			  				gov.setSelectedIndex(3);
			  				break; 
			  			
			  		}
					
			  		 try {
			  			byte[] ImageData = rs.getBytes("Image");
				  		 ImageIcon format1 = new ImageIcon(ImageData);
	                     Image mm = format1.getImage();
	                     Image img1 = mm.getScaledInstance(imgDis.getWidth(), imgDis.getHeight(), Image.SCALE_SMOOTH);
	                     ImageIcon image1 = new ImageIcon(img1);
	                     imgDis.setIcon(image1);
			  		 }
			  		 catch(Exception ex) {
			  			 imgDis.setIcon(null);
			  		 }
				
					
	        
					 //FAMILY
					 
					 String setfather= rs.getString("Father");
					 ffn.setText(setfather);
					 
						String fatherbirtdate = rs.getString("FatherBirthdate");
						String fyear = fatherbirtdate.substring(0, 4);
						comboBoxYearFather.setSelectedItem(fyear);
						int fdate = Integer.parseInt(fatherbirtdate.substring(5, 7)) - 1 + 1;
						
						comboBoxDateFather.setSelectedItem(Integer.toString(fdate));
						int fmonth = Integer.parseInt(fatherbirtdate.substring(9, fatherbirtdate.length())) - 1;
						switch(fmonth) {
						case 0:
							comboBoxMonthFather.setSelectedItem("January");
							break;
						case 1:
							comboBoxMonthFather.setSelectedItem("February");
							break;
						case 2:
							comboBoxMonthFather.setSelectedItem("March");
							break;
						case 3:
							comboBoxMonthFather.setSelectedItem("April");
							break;
						case 4:
							comboBoxMonthFather.setSelectedItem("May");
							break;
						case 5:
							comboBoxMonthFather.setSelectedItem("June");
							break;
						case 6:
							comboBoxMonthFather.setSelectedItem("July");
							break;
						case 7:
							comboBoxMonthFather.setSelectedItem("August");
							break;
						case 8:
							comboBoxMonthFather.setSelectedItem("September");
							break;
						case 9:
							comboBoxMonthFather.setSelectedItem("October");
							break;
						case 10:
							comboBoxMonthFather.setSelectedItem("November");
							break;
						case 11:
							comboBoxMonthFather.setSelectedItem("December");
							break;
						}
						
						 String setfatherage = rs.getString("FatherAge");
						 fage1.setText(setfatherage);
						 
						 String setfathercontact = rs.getString("FatherContact");
						 fcon.setText(setfathercontact);
						 
						 String setfatheroccu = rs.getString("FatherOccupation");
						 foccu.setText(setfatheroccu);
						 
							String fatherincome = rs.getString("FatherIncome");
					  		switch(fatherincome) {
					  		case "Select":
					  			comboBox_fatherincome.setSelectedIndex(0);
					  			break;
					  		case "N/A":
					  			comboBox_fatherincome.setSelectedIndex(1);
					  			break;
					  		case "10,000":
					  			comboBox_fatherincome.setSelectedIndex(2);
					  			break;
					  		case "20,000":
					  			comboBox_fatherincome.setSelectedIndex(3);
					  			break;
					  		case "30,000":
					  			comboBox_fatherincome.setSelectedIndex(4);
					  			break;
					  		case "40,000":
					  			comboBox_fatherincome.setSelectedIndex(5);
					  			break;
					  		}
					  		
					  			String setmother= rs.getString("Mother");
					  			mmn.setText(setmother);
							 
							 	String motherbirtdate = rs.getString("MotherBirthdate");
								String myear = motherbirtdate.substring(0, 4);
								comboBoxYearMother.setSelectedItem(myear);
								int mdate = Integer.parseInt(motherbirtdate.substring(5, 7)) - 1 + 1;
								
								comboBoxDateMother.setSelectedItem(Integer.toString(mdate));
								int mmonth = Integer.parseInt(motherbirtdate.substring(9, motherbirtdate.length())) - 1;
								switch(mmonth) {
								case 0:
									comboBoxMonthMother.setSelectedItem("January");
									break;
								case 1:
									comboBoxMonthMother.setSelectedItem("February");
									break;
								case 2:
									comboBoxMonthMother.setSelectedItem("March");
									break;
								case 3:
									comboBoxMonthMother.setSelectedItem("April");
									break;
								case 4:
									comboBoxMonthMother.setSelectedItem("May");
									break;
								case 5:
									comboBoxMonthMother.setSelectedItem("June");
									break;
								case 6:
									comboBoxMonthMother.setSelectedItem("July");
									break;
								case 7:
									comboBoxMonthMother.setSelectedItem("August");
									break;
								case 8:
									comboBoxMonthMother.setSelectedItem("September");
									break;
								case 9:
									comboBoxMonthMother.setSelectedItem("October");
									break;
								case 10:
									comboBoxMonthMother.setSelectedItem("November");
									break;
								case 11:
									comboBoxMonthMother.setSelectedItem("December");
									break;
								}
								
								 String setmotherage = rs.getString("MotherAge");
								 mage.setText(setmotherage);
								 
								 String setmothercontact = rs.getString("MotherContact");
								 mcon.setText(setmothercontact);
								 
								 String setmotheroccu = rs.getString("MotherOccupation");
								 moccu.setText(setmotheroccu);
								 
								 String motherincome = rs.getString("MotherIncome");
							  		switch(motherincome) {
							  		case "Select":
							  			comboBox_motherincome.setSelectedIndex(0);
							  			break;
							  		case "N/A":
							  			comboBox_motherincome.setSelectedIndex(1);
							  			break;
							  		case "10,000":
							  			comboBox_motherincome.setSelectedIndex(2);
							  			break;
							  		case "15,000":
							  			comboBox_motherincome.setSelectedIndex(3);
							  			break;
							  		case "20,000":
							  			comboBox_motherincome.setSelectedIndex(4);
							  			break;
							  		case "25,000":
							  			comboBox_motherincome.setSelectedIndex(5);
							  			break;
							  		}
							  		 String setsiblings = rs.getString("Siblings");
									 siblings.setText(setsiblings);
									 
									 String setfstatus = rs.getString("FamilyStatus");
								  		switch(setfstatus) {
								  		case "Select":
								  			comboBox_familystatus.setSelectedIndex(0);
								  			break;
								  		case "Indigenous":
								  			comboBox_familystatus.setSelectedIndex(1);
								  			break;
								  		case "Low Income Class":
								  			comboBox_familystatus.setSelectedIndex(2);
								  			break;
								  		case "Middle Income Class":
								  			comboBox_familystatus.setSelectedIndex(3);
								  			break;
								  		case "Upper Income Class":
								  			comboBox_familystatus.setSelectedIndex(4);
								  			break;
								  		case "Rich":
								  			comboBox_familystatus.setSelectedIndex(5);
								  			break;
								  		}
								  		 String setorder = rs.getString("BirthOrder");
										 order.setText(setorder);	
										 
										 
								//EDUCATIONAL		 
								 String setlrn = rs.getString("LRN");
								 lrn.setText(setlrn);	
								 
							
							  		
							  		String elem = rs.getString("Elementary");
							  		comboBox_elem.setSelectedItem(elem);
							  		comboBox_elem.setEnabled(false);
							  		String elemlevel = rs.getString("ElemLevel");
							  		comboBox_elem_level.setSelectedItem(elemlevel);
							  		comboBox_elem_level.setEnabled(false);
							  		String elemyear = rs.getString("ElemSY");
							  		txt_elem_year.setText(elemyear);
							  		txt_elem_year.setEnabled(false);
							  		
							  		String high = rs.getString("JuniorHighSchool");
							  		comboBox_high.setSelectedItem(high);
							  		comboBox_high.setEnabled(false);
							  		String highlevel = rs.getString("JuniorHighLevel");
							  		comboBox_high_level.setSelectedItem(highlevel);
							  		comboBox_high_level.setEnabled(false);
							  		String highyear = rs.getString("JuniorHighSY");
							  		txt_high_year.setText(highyear);
							  		txt_high_year.setEnabled(false);
							  		
							  		String senior = rs.getString("SeniorHighSchool");
							  		comboBox_senior.setSelectedItem(senior);
							  		comboBox_senior.setEnabled(false);
							  		String seniorlevel = rs.getString("SeniorHighLevel");
							  		comboBox_senior_level.setSelectedItem(seniorlevel);
							  		comboBox_senior_level.setEnabled(false);
							  		String senioryear = rs.getString("SeniorHighSY");
							  		txt_senior_year.setText(senioryear);
							  		txt_senior_year.setEnabled(false);
							  		
							  		String college = rs.getString("College");
							  		comboBox_college.setSelectedItem(college);
							  		comboBox_college.setEnabled(false);
							  		String collegelevel = rs.getString("CollegeLevel");
							  		comboBox_college_level.setSelectedItem(collegelevel);
							  		comboBox_college_level.setEnabled(false);
							  		String collegeyear = rs.getString("CollegeSY");
							  		txt_college_year.setText(collegeyear);
							  		txt_college_year.setEnabled(false);
							  		
							  		String voc = rs.getString("College");
							  		comboBox_voc.setSelectedItem(voc);
							  		comboBox_voc.setEnabled(false);
							  		String voclevel = rs.getString("CollegeLevel");
							  		comboBox_voc_level.setSelectedItem(voclevel);
							  		comboBox_voc_level.setEnabled(false);
							  		String vocyear = rs.getString("CollegeSY");
							  		txt_voc_year.setText(vocyear);
							  		txt_voc_year.setEnabled(false);
							  		
							  		String studentStatus = rs.getString("studentStatus");
							  		if(studentStatus.equals("Dropped")) {
							  			btnNewButton_1_2_1.setText("Set Active");
							  		}
							  		else if(studentStatus.equals("Active")) {
							  			btnNewButton_1_2_1.setText("Set Dropped");
							  		}
						
						 	
					
					}	 
								 
					
		
				}catch(Exception ev) {
					
					System.out.println(ev);
					
					
				}
				
				
				
			}
		});
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearch.setText("Search");
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearch.getText().equals("Search")) {
					txtSearch.setText(null);
					txtSearch.requestFocus();
					removePlaceholderStyle(txtSearch);
				}
				btnNewButton_1_2.setEnabled(false);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearch.getText().length()==0) {
					
					addPlaceholderStyle(txtSearch);
					txtSearch.setText("Search");
				}
				
			}
		});
		txtSearch.setColumns(10);
		ImageIcon drop = new ImageIcon(this.getClass().getResource("/delete.png"));
		Image drop1 = drop.getImage();	
		Image drop2 = drop1.getScaledInstance(45, 45 ,Image.SCALE_SMOOTH);
		ImageIcon drop3 = new ImageIcon(drop2);
		
	}
	
	public void showDate() {
		Date d = new Date();
		SimpleDateFormat  s = new SimpleDateFormat("yyyy/dd/mm");
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
			Class.forName("com.mysql.cj.jdbc.Driver");
		 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();;
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
			Class.forName("com.mysql.cj.jdbc.Driver");
		 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
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
		Class.forName("com.mysql.cj.jdbc.Driver");
	 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		
		
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
}

