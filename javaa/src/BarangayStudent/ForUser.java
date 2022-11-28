package BarangayStudent;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.border.MatteBorder;

import BarangayStudent.MenuDashboard.PanelButtonMouseAdapter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForUser {

	public JFrame frmSanRoqueStudent;
	
	private String accountPassword;
	private JPasswordField passwordField;
	private Home panelhome;
	private UserManagement paneluser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForUser window = new ForUser();
					window.frmSanRoqueStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ForUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSanRoqueStudent = new JFrame();
		frmSanRoqueStudent.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Project\\Javaa\\img\\barangay.png"));
		frmSanRoqueStudent.setTitle("San  Roque Student Database");
		frmSanRoqueStudent.setBounds(100, 100, 1538, 870);
		frmSanRoqueStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSanRoqueStudent.setLocationRelativeTo(null);
		frmSanRoqueStudent.setUndecorated(true);
		frmSanRoqueStudent.getContentPane().setLayout(null);
		
		panelhome = new Home();
		paneluser = new UserManagement();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(0, 26, 352, 844);
		frmSanRoqueStudent.getContentPane().add(panel_1);
		
		JPanel Home = new JPanel();
		Home.addMouseListener(new PanelButtonMouseAdapter(Home));
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					menuClicked(panelhome);
				
				
			}
		});
		Home.setLayout(null);
		Home.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		Home.setBackground(new Color(240, 255, 240));
		Home.setBounds(0, 282, 352, 76);
		panel_1.add(Home);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon home = new ImageIcon(this.getClass().getResource("/home.png"));
		Image home1 = home.getImage();	
		Image home2= home1.getScaledInstance(77,76, Image.SCALE_SMOOTH);
		ImageIcon home3 = new ImageIcon(home2);
		lblNewLabel.setIcon(home3);
		lblNewLabel.setBounds(29, 0, 77, 76);
		Home.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("HOME");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(126, 11, 216, 54);
		Home.add(lblNewLabel_5);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.addMouseListener(new PanelButtonMouseAdapter(panel_2_4));
		panel_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					menuClicked(paneluser);
				
				
			}
		});
		panel_2_4.setLayout(null);
		panel_2_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2_4.setBackground(new Color(240, 255, 240));
		panel_2_4.setBounds(0, 380, 352, 76);
		panel_1.add(panel_2_4);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		ImageIcon admin = new ImageIcon(this.getClass().getResource("/admin.png"));
		Image admin1 = admin.getImage();	
		Image admin2= admin1.getScaledInstance(77,76, Image.SCALE_SMOOTH);
		ImageIcon admin3 = new ImageIcon(admin2);
		lblNewLabel_4.setIcon(admin3);
		lblNewLabel_4.setBounds(29, 0, 77, 76);
		panel_2_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_4 = new JLabel("USER MANAGEMENT");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5_4.setBounds(126, 11, 216, 54);
		panel_2_4.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		ImageIcon barangay = new ImageIcon(this.getClass().getResource("/barangay.png"));
		Image barangay1 = barangay.getImage();	
		Image barangay2= barangay1.getScaledInstance(330,242, Image.SCALE_SMOOTH);
		ImageIcon barangay3 = new ImageIcon(barangay2);
		lblNewLabel_6.setIcon(barangay3);
		lblNewLabel_6.setBounds(10, 11, 330, 242);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_2_4_1 = new JPanel();
		panel_2_4_1.addMouseListener(new PanelButtonMouseAdapter(panel_2_4_1));
		panel_2_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				Login.main(null);
				frmSanRoqueStudent.setVisible(false);
				
			}
		});
		panel_2_4_1.setLayout(null);
		panel_2_4_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2_4_1.setBackground(new Color(240, 255, 240));
		panel_2_4_1.setBounds(0, 719, 352, 76);
		panel_1.add(panel_2_4_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("New label");
		ImageIcon Logout = new ImageIcon(this.getClass().getResource("/logout.png"));
		Image Logout1 = Logout.getImage();	
		Image Logout2 = Logout1.getScaledInstance(77,76, Image.SCALE_SMOOTH);
		ImageIcon Logout3 = new ImageIcon(Logout2);
		lblNewLabel_4_1.setIcon(Logout3);
		lblNewLabel_4_1.setBounds(29, 0, 77, 76);
		panel_2_4_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_4_1 = new JLabel("LOGOUT");
		lblNewLabel_5_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5_4_1.setBounds(126, 11, 216, 54);
		panel_2_4_1.add(lblNewLabel_5_4_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 1538, 26);
		frmSanRoqueStudent.getContentPane().add(panel_3);
		
		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "ARE YOU SURE?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					frmSanRoqueStudent.dispose();
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
		lblExit.setFont(new Font("Arial", Font.BOLD, 24));
		lblExit.setBounds(1519, 0, 17, 26);
		panel_3.add(lblExit);
		
		JPanel paneMenuAdmin = new JPanel();
		paneMenuAdmin.setBounds(351, 26, 1187, 844);
		frmSanRoqueStudent.getContentPane().add(paneMenuAdmin);
		paneMenuAdmin.setLayout(null);
		
		
		
		paneMenuAdmin.add(panelhome);
		paneMenuAdmin.add(paneluser);
		
		
		menuClicked(panelhome);
		
		
	}
	public void menuClicked(JPanel panel) {
		
		panelhome.setVisible(false);
		paneluser.setVisible(false);
		
		
		panel.setVisible(true);
		
	}
		
	
	public void setPassword(String password) {
		accountPassword = password;
		
	}
	public String getPassword() {
		
		return accountPassword;
	}
	public class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(245, 222, 179));
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 255, 240));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255, 0, 0));
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(245, 222, 179));
		}
	
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}
}

