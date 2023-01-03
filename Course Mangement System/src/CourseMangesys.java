import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
public class CourseMangesys {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;
	private static final long serialVersionUID=1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseMangesys window = new CourseMangesys();
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
	public CourseMangesys() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 827, 600));
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 808, 557);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login\r\n");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(349, 10, 83, 56);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username  :\r\n\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(104, 177, 162, 37);
		panel.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		user.setBounds(296, 181, 309, 33);
		panel.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password  :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel_1_1.setBounds(104, 279, 162, 37);
		panel.add(lblNewLabel_1_1);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pass.setBounds(296, 283, 309, 33);
		panel.add(pass);
		
		JButton btnNewButton = new JButton("Sign In\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagesys","root", "");
					Statement stmt=con.createStatement();
				
					
					String sql= "SELECT * FROM logindata WHERE usname='"+user.getText()+"' and password='"+pass.getText().toString()+"'";
				ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
					HomePage hg=new HomePage();
					hg.show();
					//dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
				}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(319, 424, 141, 56);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Create New Account\r\n");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(472, 319, 131, 21);
		panel.add(lblNewLabel_2);
	}
}
