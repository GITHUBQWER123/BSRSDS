package BarangayStudent;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class Login {

	private JFrame frame;
	private JTextField txtuser;
	private JPasswordField txtpass;
	private JLabel lblNewLabel_3; 
	private String security_pass;
	private MenuDashboard dashboard;
	
	Connection conn = null;
	PreparedStatement pst = null;	
	Statement st;
	ResultSet rs = null;

	MenuDashboard  dash = new MenuDashboard();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					
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
	public Login() {
		initialize();
		
		addPlaceholderStyle(txtuser);
		addPlaceholderStyle(txtpass);
	}
	
	public void addPlaceholderStyle(JTextField textfield) {
		Font font = textfield.getFont();
		font = font.deriveFont(Font.ITALIC);
		textfield.setFont(font);
		textfield.setForeground(Color.gray);
	}
	public void removePlaceholderStyle(JTextField textfield) {
		Font font = textfield.getFont();
		font = font.deriveFont(Font.PLAIN|font.BOLD);
		textfield.setFont(font);
		textfield.setForeground(Color.black);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				frame.requestFocusInWindow();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		frame.setBounds(100, 100, 1538, 870);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 1538, 870);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1538, 31);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setForeground(Color.RED);
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "ARE YOU SURE?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					frame.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
			
		});
		lblExit.setBounds(1522, 0, 16, 31);
		panel_1.add(lblExit);
		
		JLabel lblNewLabel = new JLabel("BARANGAY STUDENT DATABASE");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 57));
		lblNewLabel.setBounds(514, 188, 946, 97);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon barangay = new ImageIcon(this.getClass().getResource("/barangay.png"));
		Image barangay1 = barangay.getImage();	
		Image barangay2= barangay1.getScaledInstance(378,368, Image.SCALE_SMOOTH);
		ImageIcon barangay3 = new ImageIcon(barangay2);
		lblNewLabel_1.setIcon(barangay3);
		lblNewLabel_1.setBounds(69, 68, 378, 368);
		panel.add(lblNewLabel_1);
		
		txtuser = new JTextField();
		txtuser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtuser.getText().equals("Username")) {
					txtuser.setText(null);
					txtuser.requestFocus();
					removePlaceholderStyle(txtuser);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtuser.getText().length()==0) {
					
					addPlaceholderStyle(txtuser);
					txtuser.setText("Username");
				}
				
			}
		});
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtuser.setForeground(new Color(255, 255, 255));
		txtuser.setText("Username");
		txtuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtuser.setBackground(new Color(245, 222, 179));
		txtuser.setBounds(788, 419, 378, 50);
		panel.add(txtuser);
		txtuser.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtpass.getText().equals("Password")) {
					txtpass.setText(null);
					txtpass.requestFocus();
					
					txtpass.setEchoChar('*');
					removePlaceholderStyle(txtpass);
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtpass.getText().length()==0) {
					
					addPlaceholderStyle(txtpass);
					txtpass.setText("Password");
				}
				
			}
		});
		txtpass.setEchoChar('*');
		txtpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpass.setText("Password");
		txtpass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtpass.setBackground(new Color(245, 222, 179));
		txtpass.setBounds(788, 494, 378, 50);
		panel.add(txtpass);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon user = new ImageIcon(this.getClass().getResource("/username1.png"));
		Image user1 = user.getImage();	
		Image user2= user1.getScaledInstance(62,61, Image.SCALE_SMOOTH);
		ImageIcon user3 = new ImageIcon(user2);
		lblNewLabel_2.setIcon(user3);
		lblNewLabel_2.setBounds(716, 407, 62, 61);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		ImageIcon pass = new ImageIcon(this.getClass().getResource("/password1.png"));
		Image pass1 = pass.getImage();	
		Image pass2= pass1.getScaledInstance(62,61, Image.SCALE_SMOOTH);
		ImageIcon pass3 = new ImageIcon(pass2);
		lblNewLabel_2_1.setIcon(pass3);
		lblNewLabel_2_1.setBounds(716, 483, 62, 61);
		panel.add(lblNewLabel_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				 	conn	= DriverManager.getConnection("jdbc:mysql://localhost:3306/barangay_student","root","student");
					security_pass = txtpass.getText();
					String query = "select * from signup where Username=? and Password=?";
					pst = conn.prepareStatement(query);
					pst.setString(1, txtuser.getText());
					pst.setString(2, txtpass.getText());
					rs = pst.executeQuery();
				

					
				if (rs.next()) {
					
					  String accountType = rs.getString("Position");
					  Emp.UserPos = accountType; 
						
					if(accountType.equals("Admin")){
						JOptionPane.showMessageDialog(null, "login succefully");
						ForUser dash = new ForUser();
						dash.frmSanRoqueStudent.setVisible(true);
						frame.setVisible(false);
						
						
						Emp.UserPos = accountType; 
							
						
					}else {
							String accountType1 = rs.getString("Position");
							Emp.UserPos = accountType1; 
							JOptionPane.showMessageDialog(null, "login succefully");
							MenuDashboard home = new MenuDashboard();  
							home.frmSanRoqueStudent.setVisible(true);
							home.setPassword(txtpass.getText());
	                        home.setVisible(true);
	                        frame.setVisible(false);
	                        
					}	
					
				}					
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid");
				}
				}catch(Exception ev){				
				System.out.println(ev);
				}
				
			}
		});
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_3.setBackground(new Color(245, 245, 220));
		panel_3.setBounds(788, 607, 378, 50);
		panel.add(panel_3);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(30, 144, 255));
		lblLogin.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogin.setBounds(152, 0, 85, 50);
		panel_3.add(lblLogin);
		
		JLabel lblNewLabel_3 = new JLabel("Show password");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {	
			@Override
			public void mousePressed(MouseEvent e) {
				if ( txtpass.getEchoChar() != '\u0000' ) {
					txtpass.setEchoChar('\u0000');
				} else {
					txtpass.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
				}
				
				
				
			}
		
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImageIcon show = new ImageIcon(this.getClass().getResource("/show.png"));
		Image show1 = show.getImage();	
		Image show2= show1.getScaledInstance(36,31, Image.SCALE_SMOOTH);
		ImageIcon show3 = new ImageIcon(show2);
		lblNewLabel_3.setIcon(show3);
		lblNewLabel_3.setBounds(892, 555, 164, 31);
		panel.add(lblNewLabel_3);
	}
	public String getSecuritypass() {
		return security_pass;
	}
}
