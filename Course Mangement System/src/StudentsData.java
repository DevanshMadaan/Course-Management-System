import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class StudentsData extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsData frame = new StudentsData();
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
	public StudentsData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 53, 588, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Student Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(234, 10, 187, 33);
		contentPane.add(lblNewLabel);
//		
//		btnNewButton = new JButton("New button");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagesys","root", "");
					Statement stmt=con.createStatement();
					String query="Select * From studentsdata";
					ResultSet rs=stmt.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					int col=rsmd.getColumnCount();
					String[] colname=new String[col];
					for(int i=0;i<col;i++) {
						colname[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
						String FirstName,LastName,DOB,PhoneNo;
						while(rs.next()) {
							FirstName=rs.getString(1);
							LastName=rs.getString(2);
							DOB=rs.getString(3);
							PhoneNo=rs.getString(4);
							String[] row= {FirstName,LastName,DOB,PhoneNo};
							model.addRow(row);
						}
					}
					
					
					
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//			}
//		});
//		btnNewButton.setBounds(291, 372, 85, 21);
//		contentPane.add(btnNewButton);
		
		
		
	}
}
