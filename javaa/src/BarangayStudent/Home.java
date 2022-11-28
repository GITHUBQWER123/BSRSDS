package BarangayStudent;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Home extends JPanel{

	JLabel UserPosition;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
		UserPosition.setText(String.valueOf(Emp.UserPos).toString());
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(0, 0, 1187, 844);
		setVisible(true);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 1187, 844);
		add(panel);
		panel.setLayout(null);
		
		ImageIcon barangay = new ImageIcon(this.getClass().getResource("/barangay.png"));
		Image barangay1 = barangay.getImage();	
		Image barangay2= barangay1.getScaledInstance(244,201, Image.SCALE_SMOOTH);
		ImageIcon barangay3 = new ImageIcon(barangay2);
		ImageIcon barangayy = new ImageIcon(this.getClass().getResource("/barangay1.png"));
		Image barangayy1 = barangayy.getImage();	
		Image barangayy2= barangayy1.getScaledInstance(224,201, Image.SCALE_SMOOTH);
		ImageIcon barangayy3 = new ImageIcon(barangayy2);
	
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		ImageIcon barangayyt = new ImageIcon(this.getClass().getResource("/bh1.png"));
		Image barangayyy1 = barangayyt.getImage();	
		Image barangayyy2= barangayyy1.getScaledInstance(1187,844, Image.SCALE_SMOOTH);
		ImageIcon barangayyy3 = new ImageIcon(barangayyy2);
		lblNewLabel_6.setIcon(barangayyy3);
		lblNewLabel_6.setBounds(0, 0, 1187, 844);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(947, 11, 230, 69);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		 UserPosition = new JLabel("New label");
		 UserPosition.setFont(new Font("Times New Roman", Font.BOLD, 20));
		UserPosition.setBounds(105, 9, 121, 47);
		panel_1.add(UserPosition);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		ImageIcon user = new ImageIcon(this.getClass().getResource("/profile-user.png"));
		Image user1 = user.getImage();	
		Image user2= user1.getScaledInstance(58,47, Image.SCALE_SMOOTH);
		ImageIcon user3 = new ImageIcon(user2);
		lblNewLabel_1.setIcon(user3);
		lblNewLabel_1.setBounds(37, 11, 58, 47);
		panel_1.add(lblNewLabel_1);
	}
}
