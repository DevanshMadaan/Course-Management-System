import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField dobd;
	private JTextField dobm;
	private JTextField doby;
	private JTextField phoneno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 923, 573);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(34, 89, 119, 32);
		panel.add(lblNewLabel);
		
		firstname = new JTextField();
		firstname.setBounds(189, 87, 191, 33);
		panel.add(firstname);
		firstname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(464, 89, 110, 32);
		panel.add(lblNewLabel_1);
		
		lastname = new JTextField();
		lastname.setBounds(639, 87, 191, 33);
		panel.add(lastname);
		lastname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DOB");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(34, 230, 110, 32);
		panel.add(lblNewLabel_2);
		
		dobd = new JTextField();
		dobd.setBounds(177, 230, 45, 33);
		panel.add(dobd);
		dobd.setColumns(10);
		
		dobm = new JTextField();
		dobm.setColumns(10);
		dobm.setBounds(242, 230, 45, 33);
		panel.add(dobm);
		
		doby = new JTextField();
		doby.setColumns(10);
		doby.setBounds(307, 230, 78, 33);
		panel.add(doby);
		
		JLabel lblNewLabel_3 = new JLabel("Phone No.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(464, 230, 110, 32);
		panel.add(lblNewLabel_3);
		
		phoneno = new JTextField();
		phoneno.setBounds(639, 230, 191, 33);
		panel.add(phoneno);
		phoneno.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=firstname.getText();
				String lname=lastname.getText();
				//java.util.Date dt=new Date();
				//java.sql.Date dtsql=new java.sql.Date(dt.getYear(),dt.getMonth(),dt.getDate());
				java.sql.Date dtsql=new java.sql.Date(Integer.valueOf(doby.getText())-1900,Integer.parseInt(dobm.getText())-1,Integer.parseInt(dobd.getText()));
				
				String phno=phoneno.getText();
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagesys","root", "");

					
					Statement stmt=con.createStatement();
					stmt.executeUpdate("create database if not exists coursemanagesys");
					stmt.executeUpdate("create table if not exists studentsdata"+"(First_Name varchar(50),Last_Name varchar(50),DOB date,Phone_No varchar(11))");
					if(fname.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter First Name");
						}
					else if( phno.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter Phone No.");
					}
					else {
					PreparedStatement pstmt=con.prepareStatement("Insert into studentsdata(First_Name,Last_Name,DOB,Phone_No) values(?,?,?,?)");
					
				
						
					
					pstmt.setString(1, fname);
					pstmt.setString(2, lname);
					pstmt.setDate(3, dtsql);
					pstmt.setString(4, phno);
					pstmt.executeUpdate();
					}
						con.close();
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(368, 376, 142, 46);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Add Student");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_4.setBounds(340, 10, 191, 46);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(226, 230, 13, 33);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("/");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5_1.setBounds(289, 230, 13, 33);
		panel.add(lblNewLabel_5_1);
	}
}
