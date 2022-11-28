package BarangayStudent;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.Blob;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SchoolInformation extends JPanel{

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_no;
	private JTextField txt_street;
	private JTextField txt_barangay;
	private JTextField txt_name;
	private JTextField txt_muni;
	private JTextField txt_prov;
	private JTable table;
	private JLabel date;
	private JLabel time;
	
	Connection conn;
	PreparedStatement pst;	
	Statement st;
	ResultSet rs;
	
	File f = null;
	String path = null;
	private ImageIcon format = null;
	String filename= null;
	int s= 0;
	byte[]img = null;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public SchoolInformation() {
		initialize();
		showTable();
		showDate();
		showTime();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(245, 222, 179));
		panel_1.setBounds(36, 102, 1119, 301);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("School ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(35, 36, 116, 36);
		panel_1.add(lblNewLabel);
		
		txt_id = new JTextField();
		txt_id.setEnabled(false);
		txt_id.setColumns(10);
		txt_id.setBounds(35, 66, 256, 36);
		panel_1.add(txt_id);
		
		JLabel lblSchoolPhoneNo = new JLabel("Contact No");
		lblSchoolPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSchoolPhoneNo.setBounds(577, 36, 185, 36);
		panel_1.add(lblSchoolPhoneNo);
		
		txt_no = new JTextField();
		txt_no.setEnabled(false);
		txt_no.setColumns(10);
		txt_no.setBounds(576, 66, 256, 36);
		panel_1.add(txt_no);
		
		JLabel lblHouseNo = new JLabel("Purok/Street");
		lblHouseNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHouseNo.setBounds(35, 195, 169, 36);
		panel_1.add(lblHouseNo);
		
		txt_street = new JTextField();
		txt_street.setEnabled(false);
		txt_street.setColumns(10);
		txt_street.setBounds(35, 225, 256, 36);
		panel_1.add(txt_street);
		
		txt_barangay = new JTextField();
		txt_barangay.setEnabled(false);
		txt_barangay.setColumns(10);
		txt_barangay.setBounds(301, 225, 268, 36);
		panel_1.add(txt_barangay);
		
		JLabel lblBarangay = new JLabel("Barangay");
		lblBarangay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBarangay.setBounds(301, 195, 144, 36);
		panel_1.add(lblBarangay);
		
		JComboBox jcat = new JComboBox();
		jcat.setModel(new DefaultComboBoxModel(new String[] {"Select", "Elementary", "HighSchool", "SeniorHigh", "College", "Vocational-TESDA"}));
		jcat.setEnabled(false);
		jcat.setBounds(35, 148, 256, 36);
		panel_1.add(jcat);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCategories.setBounds(35, 118, 185, 36);
		panel_1.add(lblCategories);
		
		txt_name = new JTextField();
		txt_name.setEnabled(false);
		txt_name.setColumns(10);
		txt_name.setBounds(301, 66, 263, 36);
		panel_1.add(txt_name);
		
		JLabel lblStudentName = new JLabel("School Name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentName.setBounds(301, 36, 144, 36);
		panel_1.add(lblStudentName);
		
		JLabel lblSchoolType = new JLabel("School Type");
		lblSchoolType.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSchoolType.setBounds(301, 118, 144, 36);
		panel_1.add(lblSchoolType);
		
		JComboBox jtype = new JComboBox();
		jtype.setModel(new DefaultComboBoxModel(new String[] {"Select", "Public", "Private"}));
		jtype.setEnabled(false);
		jtype.setBounds(301, 148, 268, 36);
		panel_1.add(jtype);
		
		JLabel lblCityprovince = new JLabel("Municipality");
		lblCityprovince.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCityprovince.setBounds(579, 196, 169, 36);
		panel_1.add(lblCityprovince);
		
		txt_muni = new JTextField();
		txt_muni.setEnabled(false);
		txt_muni.setColumns(10);
		txt_muni.setBounds(579, 226, 253, 36);
		panel_1.add(txt_muni);
		
		JLabel lblClar = new JLabel("Classification");
		lblClar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClar.setBounds(577, 118, 255, 36);
		panel_1.add(lblClar);
		
		JComboBox jclass = new JComboBox();
		jclass.setModel(new DefaultComboBoxModel(new String[] {"Select", "All", "Grade 1-6", "Grade 7- 10", "Grade 11-12", "Grade 1-6 to Grade 7-10", "Grade 1-6 to Grade 11-12", "Grade 7-10  to Grade 12", "Grade 7-10 to College", "Grade 1-6 to College", "Grade 11-12  ", "Grade 11-12 to College", "College", "TESDA"}));
		jclass.setMaximumRowCount(13);
		jclass.setEnabled(false);
		jclass.setBounds(577, 148, 255, 36);
		panel_1.add(jclass);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProvince.setBounds(842, 196, 144, 36);
		panel_1.add(lblProvince);
		
		txt_prov = new JTextField();
		txt_prov.setEnabled(false);
		txt_prov.setColumns(10);
		txt_prov.setBounds(842, 226, 241, 36);
		panel_1.add(txt_prov);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(null);
		panel_1_1.setBackground(new Color(255, 218, 185));
		panel_1_1.setBounds(0, 0, 1187, 79);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("SCHOOL INFORMATION");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(377, 37, 361, 42);
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		ImageIcon bar = new ImageIcon(this.getClass().getResource("/barangay.png"));
		Image bar1 = bar.getImage();	
		Image bar2 = bar1.getScaledInstance(98,79, Image.SCALE_SMOOTH);
		ImageIcon bar3 = new ImageIcon(bar2);
		lblNewLabel_1.setIcon(bar3);
		lblNewLabel_1.setBounds(151, 0, 98, 79);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("BARANGAY STUDENT DATABASE");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3_1.setBounds(215, 0, 708, 46);
		panel_1_1.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 518, 1119, 262);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				
				txt_id.setText(model.getValueAt(i, 0).toString());
				txt_name.setText(model.getValueAt(i, 1).toString());
				String Categories = model.getValueAt(i, 2).toString();
				switch(Categories) {
				case "Select":
					jcat.setSelectedIndex(0);
					break;
				case "Elementary":
					jcat.setSelectedIndex(1);
					break;
				case "HighSchool":
					jcat.setSelectedIndex(2);
					break;
				case "Senior High":
					jcat.setSelectedIndex(3);
						break;
				case "College":
					jcat.setSelectedIndex(4);
					break;
				case "Vocational-TESDA":
					jcat.setSelectedIndex(5);
					break;		
				}
				
				String SchoolType = model.getValueAt(i, 3).toString();
				switch(SchoolType) {
				case "Select":
					jtype.setSelectedIndex(0);
				break;	
					case "Public":
						jtype.setSelectedIndex(1);
					break;	
					case "Private":
						jtype.setSelectedIndex(2);
					break;	
				}
				
				String classification = model.getValueAt(i, 4).toString();
				switch(classification) {
					case "All":
						jclass.setSelectedIndex(0);
					break;
					case "Kinder":
						jclass.setSelectedIndex(1);
					break;	
					case "Kinder to Grade 1-6":
						jclass.setSelectedIndex(2);
						break;
					case "Kinder to Grade 7-10":
						jclass.setSelectedIndex(3);
						break;
					case "kinder to grade 11-12":
						jclass.setSelectedIndex(4);
						break;
					case "kinder to College":
						jclass.setSelectedIndex(5);
						break;
					case "Grade 1-6":
						jclass.setSelectedIndex(6);
						break;
					case "Grade 7- 10":
						jclass.setSelectedIndex(7);
						break;
					case "Grade 1-6 to Grade 7-10":
						jclass.setSelectedIndex(8);
						break;
					case "Grade 1-6 to Grade 11-12":
						jclass.setSelectedIndex(9);
						break;
					case "Grade 1-6 to College":
						jclass.setSelectedIndex(10);
						break;
					case "College":
						jclass.setSelectedIndex(11);
						break;
					case "TESDA":
						jclass.setSelectedIndex(12);
						break;	
				}	
				
				txt_street.setText(model.getValueAt(i,5).toString());
				txt_barangay.setText(model.getValueAt(i, 6).toString());
				txt_muni.setText(model.getValueAt(i, 7).toString());
				txt_prov.setText(model.getValueAt(i, 8).toString());
				
				
				
				}catch(Exception ee) {
					System.out.println(ee);
				}

				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"SchoolID", "SchoolName",  "Categories", "SchoolType", "Classification", "PurokStreet", "Barangay", "Municipality", "Province"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(255, 250, 205));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		ImageIcon add = new ImageIcon(this.getClass().getResource("/add.png"));
		Image add1 = add.getImage();	
		Image add2= add1.getScaledInstance(40, 40 ,Image.SCALE_SMOOTH);
		ImageIcon add3 = new ImageIcon(add2);
		btnNewButton.setIcon(add3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_id.setEnabled(true);
				txt_name.setEnabled(true);
				txt_no.setEnabled(true);
				txt_street.setEnabled(true);
				txt_barangay.setEnabled(true);
				txt_muni.setEnabled(true);
				txt_prov.setEnabled(true);
				jclass.setEnabled(true);
				jtype.setEnabled(true);
				jcat.setEnabled(true);
				txt_id.setText("");
				txt_name.setText("");
				txt_no.setText("");
				jcat.setSelectedIndex(0);
				jtype.setSelectedIndex(0);
				jclass.setSelectedIndex(0);
				txt_street.setText("");
				txt_barangay.setText("");
				txt_muni.setText("");
				txt_prov.setText("");
			}
		});
		btnNewButton.setBounds(51, 431, 160, 47);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setBackground(new Color(255, 250, 205));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		ImageIcon save = new ImageIcon(this.getClass().getResource("/save.png"));
		Image save1 = save.getImage();	
		Image save2= save1.getScaledInstance(40, 40 ,Image.SCALE_SMOOTH);
		ImageIcon save3 = new ImageIcon(save2);
		btnNewButton_1.setIcon(save3);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO schoolinfo(SchoolID,SchoolName,ContactNo,Categories,SchoolType,Classification,PurokStreet,Barangay,Municipality,Province)VALUES(?,?,?,?,?,?,?,?,?,?)";
				   try {
			            
						pst = conn.prepareStatement(sql);
						pst.setString(1, txt_id.getText());
						pst.setString(2, txt_name.getText());
						pst.setString(3, txt_name.getText());
						pst.setString(4, (String) jcat.getSelectedItem());
						pst.setString(5, (String) jtype.getSelectedItem());
						pst.setString(6, (String) jclass.getSelectedItem());
						pst.setString(7, txt_street.getText());
						pst.setString(8, txt_barangay.getText());
						pst.setString(9, txt_muni.getText());
						pst.setString(10, txt_prov.getText());
						
						
						
						
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Successfully Added");
			            
			        	DefaultTableModel model = (DefaultTableModel) table.getModel();
						model .addRow(new Object[] {
						txt_id.getText(),
						txt_name.getText(),
						txt_no.getText(),
						jcat.getSelectedItem(),
						jtype.getSelectedItem(),
						jclass.getSelectedItem(),
						txt_street.getText(),
						txt_barangay.getText(),
						txt_muni.getText(),
						txt_prov.getText(),
						
						});	
						txt_id.setText("");
						txt_name.setText("");
						txt_no.setText("");
						jcat.setSelectedIndex(0);
						jtype.setSelectedIndex(0);
						jclass.setSelectedIndex(0);
						txt_street.setText("");
						txt_barangay.setText("");
						txt_muni.setText("");
						txt_prov.setText("");
				   }catch(Exception ee) {
					   JOptionPane.showMessageDialog(null, ee);
					   txt_id.setText("");
						txt_name.setText("");
						txt_no.setText("");
						jcat.setSelectedIndex(0);
						jtype.setSelectedIndex(0);
						jclass.setSelectedIndex(0);
						txt_street.setText("");
						txt_barangay.setText("");
						txt_muni.setText("");
						txt_prov.setText("");
						
				   }
				   

	
				
			}
		});
		btnNewButton_1.setBounds(981, 431, 160, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("UPDATE");
		btnNewButton_1_1.setBackground(new Color(255, 250, 205));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		ImageIcon update = new ImageIcon(this.getClass().getResource("/update.png"));
		Image update1 = update.getImage();	
		Image update2= update1.getScaledInstance(40, 40 ,Image.SCALE_SMOOTH);
		ImageIcon update3 = new ImageIcon(update2);
		btnNewButton_1_1.setIcon(update3);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(239, 431, 160, 47);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("DELETE");
		btnNewButton_1_2.setBackground(new Color(255, 250, 205));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		ImageIcon delete = new ImageIcon(this.getClass().getResource("/delete.png"));
		Image delete1 = delete.getImage();	
		Image delete2= delete1.getScaledInstance(40, 40 ,Image.SCALE_SMOOTH);
		ImageIcon delete3 = new ImageIcon(delete2);
		btnNewButton_1_2.setIcon(delete3);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setBounds(426, 431, 160, 47);
		panel.add(btnNewButton_1_2);
		
		
		
		
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
	private void showTable() {
		
		
		
		String sql ="Select * from schoolinfo";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 	conn	 = DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			model.addColumn("SchoolID");
			model.addColumn("schoolName");
			model.addColumn("ContactNo");
			model.addColumn("Categories");
			model.addColumn("SchoolType");
			model.addColumn("Classification");
			model.addColumn("PurokStreet");
			model.addColumn("Barangay");
			model.addColumn("Municipality");
			model.addColumn("Province");
	
			int table1size = 0;
			while(rs.next()) {
				String schoolid= rs.getString("SchoolID");
				String schoolname= rs.getString("SchoolName");
				String contact= rs.getString("ContactNo");
				String categories = rs.getString("Categories");
				String schooltype = rs.getString("SchoolType");
				String classification = rs.getString("Classification");
				String purok = rs.getString("PurokStreet");
				String barangay= rs.getString("Barangay");
				String municipality = rs.getString("Municipality");
				String province = rs.getString("Province");
				model.insertRow(0, new Object[] {schoolid,schoolname,contact,categories,schooltype,classification,purok,barangay,municipality,province});
				table1size++;
			}
			
			table.getTableHeader().setReorderingAllowed(false);
			table.setCellEditor(null);
			table.setModel(model);
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
