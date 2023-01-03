import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 815);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 778);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Display Student Data\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsData sdt=new StudentsData();
				sdt.show();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton_1.setBounds(312, 493, 290, 62);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Display Staff Data\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffsData tdt=new StaffsData();
				tdt.show();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(822, 493, 265, 62);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Add Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent st=new AddStudent();
				st.show();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton_2.setBounds(330, 141, 225, 62);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_3 = new JButton("Add Staff\r\n");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff teachst=new AddStaff();
				teachst.show();
			}
		});
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton_2_3.setBounds(830, 141, 225, 62);
		panel.add(btnNewButton_2_3);
	}
}
