import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class Customer {
	public static void main(String[] args)
	{
		new Customer().Customer();
	}
	
	private void Customer() {
		// TODO Auto-generated method stub
		
	}

	public Customer(){
	//Frame
	JFrame frame = new JFrame("Shopping Page");
	frame.setBackground(Color.WHITE);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setLayout(new BorderLayout(0,0));
	frame.setSize(1200,800);
	
	
	//Left hand panel with three buttons
	JPanel sideButtons = new JPanel();
	sideButtons.setLayout(null);
	sideButtons.setBackground(Color.GRAY);
	sideButtons.setPreferredSize(new Dimension(300,300));
	sideButtons.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
	
	/**
	 *
		Below arrays are populated from the pending order database 
	*
	**/
	
	
	Item.populateStore();
	
		Object[][] data = {
				
			    {Item.getSerialNumberAt(0), Item.getNameAt(0),
			     Item.getQuantityAt(0), Item.getPriceAt(0), new Boolean(false)},
			    
			    {Item.getSerialNumberAt(1), Item.getNameAt(1),
				Item.getQuantityAt(1), Item.getPriceAt(1), new Boolean(true)},
			    
			    {Item.getSerialNumberAt(2), Item.getNameAt(2),
				Item.getQuantityAt(2), Item.getPriceAt(2), new Boolean(false)},
			    
			    {Item.getSerialNumberAt(3), Item.getNameAt(3),
				Item.getQuantityAt(3), Item.getPriceAt(3), new Boolean(true)},
			    
			    {Item.getSerialNumberAt(4), Item.getNameAt(4),
				Item.getQuantityAt(4), Item.getPriceAt(4), new Boolean(false)},
			    
			   {Item.getSerialNumberAt(5), Item.getNameAt(5),
				Item.getQuantityAt(5), Item.getPriceAt(5), new Boolean(false)},
			     
			   {Item.getSerialNumberAt(6), Item.getNameAt(6),
				Item.getQuantityAt(6), Item.getPriceAt(6), new Boolean(true)},
				    
			   {Item.getSerialNumberAt(7), Item.getNameAt(7),
				Item.getQuantityAt(7), Item.getPriceAt(7), new Boolean(false)},
				    
			   {Item.getSerialNumberAt(8), Item.getNameAt(8),
				Item.getQuantityAt(8), Item.getPriceAt(8), new Boolean(true)},
				    
			   {Item.getSerialNumberAt(9), Item.getNameAt(9),
				Item.getQuantityAt(9), Item.getPriceAt(9), new Boolean(false)},
				    
			   {Item.getSerialNumberAt(10), Item.getNameAt(10),
				Item.getQuantityAt(10), Item.getPriceAt(10), new Boolean(false)},
				     
			   {Item.getSerialNumberAt(11), Item.getNameAt(11),
				 Item.getQuantityAt(11), Item.getPriceAt(11), new Boolean(true)},
					    
			   {Item.getSerialNumberAt(12), Item.getNameAt(12),
				Item.getQuantityAt(12), Item.getPriceAt(12), new Boolean(false)},
					    
			   {Item.getSerialNumberAt(13), Item.getNameAt(13),
				Item.getQuantityAt(13), Item.getPriceAt(13), new Boolean(true)},
					    
			   {Item.getSerialNumberAt(14), Item.getNameAt(14),
				Item.getQuantityAt(14), Item.getPriceAt(14), new Boolean(false)},
		};
		
		
	Object[] columnNames = {"Serial Number",
            "Item Name",
            "Quantity",
            "Price",
            };
	
	
	
	JPanel orderGrid = new JPanel();
	//Adding buttons
	

	JButton but1 = newButton("1", 40, 50);
	JButton but2 = newButton("2", 40, 50);
	JButton but3 = newButton("3", 40, 50);
	JButton but4 = newButton("4", 40, 50);
	JButton but5 = newButton("5", 40, 50);
	JButton but6 = newButton("6", 40, 50);
	JButton but7 = newButton("7", 40, 50);
	JButton but8 = newButton("8", 40, 50);
	JButton but9 = newButton("9", 40, 50);
	JButton but10 = newButton("10", 40, 50);
	JButton but11 = newButton("11", 40, 50);
	JButton but12 = newButton("12", 40, 50);
	JButton but13 = newButton("13", 40, 50);
	JButton but14 = newButton("14", 40, 50);
	JButton but15 = newButton("15", 40, 50);
	
	
	JTable orderS = new JTable(data, columnNames);
	orderS.setEnabled(false);
	
	orderS.setRowHeight(70);
	orderS.setAlignmentX(50);

	

	JScrollPane scrollpane = new JScrollPane(orderS);
	scrollpane.setPreferredSize(new Dimension(480, 700));
	scrollpane.setVisible(true);
	scrollpane.setViewportView(orderS);
	
	
	Font r = new Font("SansSerif", Font.PLAIN, 15);
	RoundedJTextField searchBar = new RoundedJTextField(7);
	searchBar.setBounds(50,45,200,50);
	searchBar.setBorder(new LineBorder(Color.BLACK));
	searchBar.setFont(r);
	
		
	JButton logout = new JButton("Logout");
	logout.setBounds(50,525,200,50);
	logout.setFocusPainted(false);
	logout.setForeground(Color.BLACK);
	logout.setBackground(Color.RED);
	logout.setBorder(new LineBorder(Color.BLACK));
	 
	Font f = new Font("serif", Font.BOLD, 25);

		
		JPanel rightButtons = new JPanel();
		rightButtons.setLayout(null);
		rightButtons.setBackground(Color.GRAY);
		rightButtons.setPreferredSize(new Dimension(300,300));
		rightButtons.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
		
		JButton confirmCharges = new JButton("Checkout -->");
		confirmCharges.setBounds(50,525,200,50);
		confirmCharges.setFocusPainted(false);
		confirmCharges.setForeground(Color.BLACK);
		confirmCharges.setBackground(Color.BLUE);
		confirmCharges.setBorder(new LineBorder(Color.BLACK));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		orderS.setDefaultRenderer(String.class, centerRenderer);
		
		ActionListener buttons = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == logout) {
					System.exit(0);
				} else if(e.getSource() == confirmCharges) {
					PendingOrders order = new PendingOrders();
				} else if(e.getSource() == but1 || e.getSource()== but2 ||e.getSource()== but3 || e.getSource()== but4 || e.getSource()== but5 )
				{
					Connection c= null;
					Statement stmt = null;
					
					try 
					{
						
						Class.forName("org.postgresql.Driver");
						c = DriverManager.getConnection(
								"jdbc:postgresql://localhost:5432/project",
								"postgres", "muditarora");
						c.setAutoCommit(false);
						stmt = c.createStatement();
						String sql = "INSERT INTO cart("
								+ "num, item, price, quantity )" 
								+ "VALUES ()";
						stmt.executeQuery(sql);
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
		
		
		
	orderGrid.add(scrollpane);

	sideButtons.add(searchBar);
	sideButtons.add(logout);
	orderGrid.add(but1);
	orderGrid.add(but2);
	orderGrid.add(but3);
	orderGrid.add(but4);
	orderGrid.add(but5);
	orderGrid.add(but6);
	orderGrid.add(but7);
	orderGrid.add(but8);
	orderGrid.add(but9);
	orderGrid.add(but10);
	orderGrid.add(but11);
	orderGrid.add(but12);
	orderGrid.add(but13);
	orderGrid.add(but14);
	orderGrid.add(but15);
	rightButtons.add(confirmCharges);
	frame.add(orderGrid, BorderLayout.CENTER);
	frame.add(sideButtons, BorderLayout.WEST);
	frame.add(rightButtons, BorderLayout.EAST);

	
	frame.setVisible(true);
}
	
	


	private JButton newButton(String pText, int pWidth, int pHeight) {
	     JButton button = new JButton(pText);
	     button.setPreferredSize(new Dimension(pWidth, pHeight));
	     button.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
	     return button;
	  }
}
