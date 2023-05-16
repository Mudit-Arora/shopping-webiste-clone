import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginScreen {
	
	LoginScreen(){
		JFrame frame = new JFrame("Login");
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
		
		JLabel uName = new JLabel("Username :");
		uName.setFont(f);
		uName.setBounds(50, 285, 150, 75);
		
		JLabel pWord = new JLabel("Password : ");
		pWord.setFont(f);
		pWord.setBounds(50, 385, 150, 75);
		
		RoundedJTextField userF = new RoundedJTextField(5);
		userF.setBounds(50,310,200,35);
		
		RoundedJPasswordField userP = new RoundedJPasswordField(5);
		userP.setBounds(50,410,200,35);
		
			ActionListener buttons = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if(e.getSource()==logout) {
						System.exit(0);
					}else if(e.getSource()==createAccount) {
						ChooseCreateAccount create = new ChooseCreateAccount();
					}else if(e.getSource()==login) {
						String userUN = userF.getText();
						String userPW = new String(userP.getPassword());
						
							if((userUN.length() == 0)||(userPW.length() == 0)) {
							ErrorFrame error = new ErrorFrame();
					}else {
						//POSTGRES HERE
						Connection c = null;
						Statement stmt = null;
						if ("projectbot".equals(userUN) && "helloworld".equals(userPW))
						{
							 //JOptionPane.showMessageDialog(login, "Welcome");
							ShoppingPage shoppingpage = new ShoppingPage();
							frame.setVisible(false);
						}
						else if("Karen".equals(userUN) && "covid19".equals(userPW))
						{
							guiEmployee gui = new guiEmployee();
						}
						else
						{
						JOptionPane.showMessageDialog(login, "Account does not exist");
						}
						try
						{
							Class.forName("org.postgresql.Driver");
							c = DriverManager.getConnection(
									"jdbc:postgresql://localhost:5432/project",
									"postgres", "muditarora");
							c.setAutoCommit(false);
							stmt = c.createStatement();
							String sql = "SELECT username, password from emp;";	
							String psql = "SELECT username, password from cust;";
							stmt.executeQuery(psql);
							stmt.execute(psql);
							stmt.executeQuery(sql);
							stmt.execute(sql);
							stmt.close();
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
		createAccount.addActionListener(buttons);
		logout.addActionListener(buttons);
		login.addActionListener(buttons);
		text.add(uName);
		text.add(pWord);
		fields.add(userF);
		fields.add(userP);
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
