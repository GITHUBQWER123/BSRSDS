package BarangayStudent;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Prints {

	public JFrame frame;
	public JTable table;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prints window = new Prints();
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
	public Prints() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 748);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 61, 622, 558);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Registration No", "Firstname", "Middlename", "Lastname", "Name Of School ", "Student Level", "School Year"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(98);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printJavaJFrameJTable();
			}
		});
		btnNewButton.setBounds(564, 630, 109, 33);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 734, 26);
		frame.getContentPane().add(panel_3);
		
		JLabel lblExit = new JLabel("X");
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
		lblExit.setFont(new Font("Arial", Font.BOLD, 24));
		lblExit.setBounds(717, 0, 17, 26);
		panel_3.add(lblExit);
		
		
	}
	public void printJavaJFrameJTable() {
		 MessageFormat head = new MessageFormat("STUDENT INFORMATION");
		 MessageFormat foot = new MessageFormat("");
        try {
        	        	
            boolean print = table.print(JTable.PrintMode.FIT_WIDTH,head,foot);
            if (!print) {
                JOptionPane.showMessageDialog(null, "Unable To Print !!..");
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}
}
