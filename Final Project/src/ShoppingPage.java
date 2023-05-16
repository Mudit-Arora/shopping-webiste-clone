import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ShoppingPage {
	
	
	
	ShoppingPage(){
		
		Font f = new Font("serif", Font.BOLD, 15);
		Item.populateStore();
		String[] itemList = {Item.getNameAt(0)+" $"+Item.getPriceAt(0),Item.getNameAt(1)+" $"
		+Item.getPriceAt(1),Item.getNameAt(2)+" $"+Item.getPriceAt(2),Item.getNameAt(3)+" $"
		+Item.getPriceAt(3),Item.getNameAt(4)+" $"+Item.getPriceAt(4),Item.getNameAt(5)+" $"
		+Item.getPriceAt(5),Item.getNameAt(6)+" $"+Item.getPriceAt(6),Item.getNameAt(7)+" $"
		+Item.getPriceAt(7),Item.getNameAt(8)+" $"+Item.getPriceAt(8),Item.getNameAt(9)+" $"
		+Item.getPriceAt(9),Item.getNameAt(10)+" $"+Item.getPriceAt(10),Item.getNameAt(11)+" $"
		+Item.getPriceAt(11),Item.getNameAt(12)+" $"+Item.getPriceAt(12),Item.getNameAt(13)+" $"
		+Item.getPriceAt(13),Item.getNameAt(14)+" $"+Item.getPriceAt(14),Item.getNameAt(15)+" $"+Item.getPriceAt(15)};
		String [] numbers = {"1","2","3","4","5","6","7","8","9"};
		
		JComboBox<String> itemCombo = new JComboBox<String>(itemList);
		JComboBox<String> quantityCombo = new JComboBox<String>(numbers);
		itemCombo.setBounds(0, 350, 150, 35);
		quantityCombo.setBounds(350, 350, 150, 35);
		
		JLabel aboveItem = new JLabel();
		aboveItem.setText("Choose Your Item Below");
		aboveItem.setBounds(0, 300, 200, 35);
		aboveItem.setFont(f);
		
		JLabel aboveQuantity = new JLabel();
		aboveQuantity.setText("Choose The Quantity");
		aboveQuantity.setBounds(350, 300, 320, 35);
		aboveQuantity.setFont(f);
		
		
		JFrame frame = new JFrame("Shopping Page");
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

		
		JPanel center = new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(400,400));
		
		
		JButton addToCart = new JButton("Add To Cart");
		addToCart.setBounds(50,175,200,50);
		addToCart.setFocusPainted(false);
		addToCart.setForeground(Color.BLACK);
		addToCart.setBackground(Color.BLUE);
		addToCart.setBorder(new LineBorder(Color.BLACK));
		
		JButton checkOut = new JButton("Checkout");
		checkOut.setBounds(50,350,200,50);
		checkOut.setFocusPainted(false);
		checkOut.setForeground(Color.BLACK);
		checkOut.setBackground(Color.BLUE);
		checkOut.setBorder(new LineBorder(Color.BLACK));
		
		
		JButton logout = new JButton("Logout");
		logout.setBounds(50,525,200,50);
		logout.setFocusPainted(false);
		logout.setForeground(Color.BLACK);
		logout.setBackground(Color.RED);
		logout.setBorder(new LineBorder(Color.BLACK));
	
		
	
			ActionListener buttons = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==logout) {
						System.exit(0);
					}else if(e.getSource()==checkOut) {
						popUp popup = new popUp();
					} else if(e.getSource() == addToCart) {
						//POSTGRES
						//popUp popUpScreen = new popUp(***TOTAL***)
						//String item = " ";
						//int quantity = 0;
						//float price = 0 ;
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
		};
			center.add(aboveQuantity);
		center.add(aboveItem);
		center.add(itemCombo);
		center.add(quantityCombo);
		checkOut.addActionListener(buttons);
		logout.addActionListener(buttons);
		addToCart.addActionListener(buttons);		
		sideButtons.add(checkOut);
		sideButtons.add(logout);
		sideButtons.add(addToCart);
		frame.add(center, BorderLayout.CENTER);
		frame.add(sideButtons, BorderLayout.WEST);
		frame.setVisible(true);
	}
}
