import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStaff extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField teachername;
	private JTextField subject;
	private JTextField emailid;
	private JTextField phoneno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaff frame = new AddStaff();
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
	public AddStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 989, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Staff");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(394, 10, 230, 52);
		panel.add(lblNewLabel);
		
		JLabel lblTeacherName = new JLabel("Teacher Name");
		lblTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTeacherName.setBounds(62, 119, 158, 32);
		panel.add(lblTeacherName);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEmailId.setBounds(573, 119, 119, 32);
		panel.add(lblEmailId);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSubject.setBounds(62, 292, 119, 32);
		panel.add(lblSubject);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPhoneNo.setBounds(573, 292, 119, 32);
		panel.add(lblPhoneNo);
		
		teachername = new JTextField();
		teachername.setColumns(10);
		teachername.setBounds(230, 118, 191, 33);
		panel.add(teachername);
		
		subject = new JTextField();
		subject.setColumns(10);
		subject.setBounds(230, 292, 191, 33);
		panel.add(subject);
		
		emailid = new JTextField();
		emailid.setColumns(10);
		emailid.setBounds(739, 118, 191, 33);
		panel.add(emailid);
		
		phoneno = new JTextField();
		phoneno.setColumns(10);
		phoneno.setBounds(739, 291, 191, 33);
		panel.add(phoneno);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tname=teachername.getText();
				String eid=emailid.getText();
				String sub=subject.getText();
				String phno=phoneno.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagesys","root", "");

					
					Statement stmt=con.createStatement();
					stmt.executeUpdate("create database if not exists coursemanagesys");
					stmt.executeUpdate("create table if not exists staffsdata"+"(Teacher_Name varchar(50),Email_Id varchar(50),Subject varchar(50),Phone_No varchar(11))");
					if(tname.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter Teacher Name");
						}
					else if( phno.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter Phone No.");
					}
					else {
					PreparedStatement pstmt=con.prepareStatement("Insert into staffsdata(Teacher_Name,Email_Id,Subject,Phone_No) values(?,?,?,?)");
					
				
						
					
					pstmt.setString(1, tname);
					pstmt.setString(2, eid);
					pstmt.setString(3, sub);
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(394, 395, 158, 52);
		panel.add(btnNewButton);
		
		
	}
}
