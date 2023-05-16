import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class guiEmployee {
	
	
	
	public guiEmployee(){
		
	
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
	if(Item.getLength()==15) {
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
	}
		
			   else if(Item.getLength()==17) {
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
				
				 {Item.getSerialNumberAt(15), Item.getNameAt(15),
						Item.getQuantityAt(15), Item.getPriceAt(15), new Boolean(true)},
				 {Item.getSerialNumberAt(16), Item.getNameAt(16),
							Item.getQuantityAt(16), Item.getPriceAt(16), new Boolean(true)}
			};
	}else {
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
				
				 {Item.getSerialNumberAt(15), Item.getNameAt(15),
						Item.getQuantityAt(15), Item.getPriceAt(15), new Boolean(true)},
			};
			

		Object[] columnNames = {"Serial Number",
	            "Item Name",
	            "Quantity",
	            "Price ($)",
	            };
		
		
		
	JTable orderS = new JTable(data, columnNames);
		
	JPanel orderGrid = new JPanel();
	
	
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
	
	JButton addItem = new JButton("Add new Item +");
	addItem.setBounds(50,175,200,50);
	addItem.setFocusPainted(false);
	addItem.setForeground(Color.BLACK);
	addItem.setBackground(Color.BLUE);
	addItem.setBorder(new LineBorder(Color.BLACK));

	JButton pendingOrders = new JButton("Pending Orders");
	pendingOrders.setBounds(50,350,200,50);
	pendingOrders.setFocusPainted(false);
	pendingOrders.setForeground(Color.BLACK);
	pendingOrders.setBackground(Color.BLUE);
	pendingOrders.setBorder(new LineBorder(Color.BLACK));
	
	JButton deleteItem = new JButton("Delete Item (-)");
	deleteItem.setBounds(50,525,200,50);
	deleteItem.setFocusPainted(false);
	deleteItem.setForeground(Color.BLACK);
	deleteItem.setBackground(Color.BLUE);
	deleteItem.setBorder(new LineBorder(Color.BLACK));
		
	JButton logout = new JButton("Logout");
	logout.setBounds(50,700,200,50);
	logout.setFocusPainted(false);
	logout.setForeground(Color.BLACK);
	logout.setBackground(Color.RED);
	logout.setBorder(new LineBorder(Color.BLACK));
	 
	Font f = new Font("serif", Font.BOLD, 25);
	
		ActionListener buttons = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == logout) {
					System.exit(0);									
				}else if(e.getSource()==addItem) {
					frame.setVisible(false);
					AddNewItem adding = new AddNewItem();
						}else if(e.getSource()== pendingOrders){
						PendingOrders pendingorders = new PendingOrders();
						frame.setVisible(false);
					}else if(e.getSource()==deleteItem) {
						int x =0;
						x = orderS.getSelectedRow();
						Item.removeAt(x);
					}
				
			}					
		};
		
		JPanel rightButtons = new JPanel();
		rightButtons.setLayout(null);
		rightButtons.setBackground(Color.GRAY);
		rightButtons.setPreferredSize(new Dimension(300,300));
		rightButtons.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
		
		JButton confirmCharges = new JButton("Confirm Charges -->");
		confirmCharges.setBounds(50,275,200,50);
		confirmCharges.setFocusPainted(false);
		confirmCharges.setForeground(Color.BLACK);
		confirmCharges.setBackground(Color.BLUE);
		confirmCharges.setBorder(new LineBorder(Color.BLACK));
		

		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		orderS.setDefaultRenderer(String.class, centerRenderer);
		
		
	
	orderGrid.add(scrollpane);
	addItem.addActionListener(buttons);
	logout.addActionListener(buttons);
	pendingOrders.addActionListener(buttons);
	sideButtons.add(addItem);
	sideButtons.add(searchBar);
	sideButtons.add(logout);
	sideButtons.add(pendingOrders);
	sideButtons.add(deleteItem);
	rightButtons.add(confirmCharges);
	frame.add(orderGrid, BorderLayout.CENTER);
	frame.add(sideButtons, BorderLayout.WEST);
	frame.add(rightButtons, BorderLayout.EAST);
	frame.setVisible(true);
}
	}
}
