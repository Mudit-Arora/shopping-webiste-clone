import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CreateEmployeeAccount {
	
	CreateEmployeeAccount(){
		//Frame
		JFrame frame = new JFrame("Create Employee Account");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(200,0));
		frame.setSize(1200,800);
		
		//Left hand panel with three buttons
		JPanel sideButtons = new JPanel();
		sideButtons.setLayout(null);
		sideButtons.setBackground(Color.GRAY);
		sideButtons.setPreferredSize(new Dimension(300,300));
		sideButtons.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

		JPanel labels = new JPanel();
		labels.setLayout(new BorderLayout());
		
		JPanel fields = new JPanel();
		fields.setLayout(null);
		
		JPanel text = new JPanel();
		text.setLayout(null);
		text.setPreferredSize(new Dimension(200,200));
		
		JButton login = new JButton("Login");
		login.setBounds(50,175,200,50);
		login.setFocusPainted(false);
		login.setForeground(Color.BLACK);
		login.setBackground(Color.BLUE);
		login.setBorder(new LineBorder(Color.BLACK));
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(50,350,200,50);
		createAccount.setFocusPainted(false);
		createAccount.setForeground(Color.BLACK);
		createAccount.setBackground(Color.BLUE);
		createAccount.setBorder(new LineBorder(Color.BLACK));
		
		JButton logout = new JButton("Logout");
		logout.setBounds(50,525,200,50);
		logout.setFocusPainted(false);
		logout.setForeground(Color.BLACK);
		logout.setBackground(Color.RED);
		logout.setBorder(new LineBorder(Color.BLACK));
		 
		Font f = new Font("serif", Font.BOLD, 25);
		
		JLabel fName = new JLabel("First Name :");
		fName.setFont(f);
		fName.setBounds(50, 50, 150, 75);
		
		JLabel lName = new JLabel("Last Name : ");
		lName.setFont(f);
		lName.setBounds(50, 150, 150, 75);
		
		JLabel uName = new JLabel("User Name :");
		uName.setFont(f);
		uName.setBounds(50, 250, 150, 75);
		
		JLabel pWord = new JLabel("Password :");
		pWord.setFont(f);
		pWord.setBounds(50, 350, 150, 75);
		
		JLabel eMail = new JLabel("Email :");
		eMail.setFont(f);
		eMail.setBounds(50, 450, 150, 75);
		
		JLabel ePosi = new JLabel("Position   :");
		ePosi.setFont(f);
		ePosi.setBounds(50, 550, 150, 75); 
		
		RoundedJTextField one = new RoundedJTextField(5);
		one.setBounds(50, 75, 200, 35);
		
		RoundedJTextField two = new RoundedJTextField(5);
		two.setBounds(50,175,200,35);
		
		RoundedJTextField three = new RoundedJTextField(5);
		three.setBounds(50,275,200,35);
		
		RoundedJPasswordField four = new RoundedJPasswordField(5);
		four.setBounds(50,375,200,35);
		
		RoundedJTextField five = new RoundedJTextField(5);
		five.setBounds(50,475,200,35);
		
		RoundedJTextField six = new RoundedJTextField(5);
		six.setBounds(50,575,200,35);	
		
		RoundedJTextField seven = new RoundedJTextField(5);
		seven.setBounds(50,675,200,35);
		
		//JButton register = new JButton("Register");
		//register.setFont(f);
		//register.setBounds(50, 775, 200, 35);
		
			ActionListener buttons = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(e.getSource() == login) {
						frame.setVisible(false);
						LoginScreen loginPage = new LoginScreen();						
						
					}if(e.getSource() == logout) {
						System.exit(0);
						
					}if(e.getSource() == createAccount) {
						String userFN = one.getText();
						String userLN = two.getText();
						String userUN = three.getText();
						String userPW = new String(four.getPassword());
						String userEM = five.getText();
						String userPO = six.getText();
						
					if((userFN.length() == 0)||(userLN.length() == 0)||(userUN.length() == 0)||(userPW.length() == 0)||
							(userEM.length() == 0)||(userPO.length() == 0)) {
						ErrorFrame error = new ErrorFrame();
					} else {
						//POSTGRES HERE
						Connection c = null;
						Statement stmt = null;
						
						try 
						{
							Class.forName("org.postgresql.Driver");
							c = DriverManager.getConnection(
									"jdbc:postgresql://localhost:5432/project",
									"postgres", "muditarora");
							c.setAutoCommit(false);
							stmt = c.createStatement();
							String sql = "INSERT INTO emp("
									+ "firstname, lastname, username, password, email, position )" 
									+ "VALUES (' "  + userFN + "','" + userLN + "','" + userUN + "','" + userPW + "','" + userEM + "','" 
									+ userPO + "')";
							stmt.executeQuery("select * from emp;");
							int x = stmt.executeUpdate(sql);
							if(x ==0)
							{
								JOptionPane.showMessageDialog(createAccount, "This account already exist");
							}
							else
							{
								JOptionPane.showMessageDialog(createAccount, "Your account has been registered");
							}
							stmt.close();
							c.commit();
							c.close();
						} catch(Exception ex) {
							ex.printStackTrace();
							System.err.println(ex.getClass().getName()+": "+ ex.getMessage());
							System.exit(0);
						}
						
						
						
					}
				  }					
				}
			};
		logout.addActionListener(buttons);
		login.addActionListener(buttons);
		createAccount.addActionListener(buttons);
		fields.add(one);
		fields.add(two);
		fields.add(three);
		fields.add(four);
		fields.add(five);
		fields.add(six);
		text.add(fName);
		text.add(lName);
		text.add(uName);
		text.add(pWord);
		text.add(eMail);
		text.add(ePosi);
		//text.add(register);
		//labels.add(register, BorderLayout.SOUTH);
		labels.add(fields, BorderLayout.CENTER);
		labels.add(text, BorderLayout.WEST);
		sideButtons.add(createAccount);
		sideButtons.add(logout);
		sideButtons.add(login);
		frame.add(labels, BorderLayout.CENTER);
		frame.add(sideButtons, BorderLayout.WEST);
		frame.setVisible(true);
	}
}
