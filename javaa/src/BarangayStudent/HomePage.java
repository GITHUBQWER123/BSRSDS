package BarangayStudent;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
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

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

public class HomePage extends JPanel {

	private JFrame frame;
	 
	 private JLabel date;
	 private JLabel time;
	 	Connection conn;
		PreparedStatement pst;	
		Statement st;
		ResultSet rs;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	
		showTime();
		showDate();
	}

/**
 * Create the panel.
 */
	public void initialize() {
	
	setBackground(new Color(245, 245, 220));
	setBounds(0, 0, 1187, 844);
	setLayout(null);
	ImageIcon vision = new ImageIcon(this.getClass().getResource("/v.png"));
	Image vision1 = vision.getImage();	
	Image vision2= vision1.getScaledInstance(299,254, Image.SCALE_SMOOTH);
	ImageIcon vision3 = new ImageIcon(vision2);
	ImageIcon mission = new ImageIcon(this.getClass().getResource("/m.png"));
	Image mission1 = mission.getImage();	
	Image mission2= mission1.getScaledInstance(299,254, Image.SCALE_SMOOTH);
	ImageIcon mission3 = new ImageIcon(mission2);
	
	JPanel panel_1_1 = new JPanel();
	panel_1_1.setLayout(null);
	panel_1_1.setBorder(null);
	panel_1_1.setBackground(new Color(255, 218, 185));
	panel_1_1.setBounds(0, 0, 1187, 79);
	add(panel_1_1);
	
	JLabel lblNewLabel_3 = new JLabel("ABOUT US");
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3.setForeground(Color.BLACK);
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_3.setBounds(406, 39, 322, 40);
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
	
	JLabel lblNewLabel_1_2 = new JLabel("New label");
	ImageIcon bar = new ImageIcon(this.getClass().getResource("/barangay.png"));
	Image bar1 = bar.getImage();	
	Image bar2 = bar1.getScaledInstance(98,79, Image.SCALE_SMOOTH);
	ImageIcon bar3 = new ImageIcon(bar2);
	lblNewLabel_1_2.setIcon(bar3);
	lblNewLabel_1_2.setBounds(171, 0, 98, 79);
	panel_1_1.add(lblNewLabel_1_2);
	
	JLabel lblNewLabel_3_1 = new JLabel("BARANGAY STUDENT DATABASE");
	lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3_1.setForeground(Color.BLACK);
	lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblNewLabel_3_1.setBounds(235, 0, 708, 46);
	panel_1_1.add(lblNewLabel_3_1);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	ImageIcon barangay = new ImageIcon(this.getClass().getResource("/aboutus.jpg"));
	Image barangay1 = barangay.getImage();	
	Image barangay2= barangay1.getScaledInstance(1187,755, Image.SCALE_SMOOTH);
	ImageIcon barangay3 = new ImageIcon(barangay2);
	lblNewLabel_2.setIcon(barangay3);
	lblNewLabel_2.setBounds(0, 78, 1187, 755);
	add(lblNewLabel_2);
	
	
	

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

