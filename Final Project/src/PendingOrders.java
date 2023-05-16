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

public class PendingOrders {
	public static void main(String[] args)
	{
		new PendingOrders().PendingOrders();
	}
	
	

	public void PendingOrders(){
	//Frame
	JFrame frame = new JFrame("Pending Order");
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
	
	
	Object[][] data = {
		    {"Phone", "899",
		     "1", new String("Pending"), new Boolean(false)},
		    {"Laptop", "1599",
		     "1", new String("Pending"), new Boolean(true)},
		    {"Calculator", "150",
		     "2", new String("Pending"), new Boolean(false)},
		    {"Watch", "199",
		     "3", new String("Pending"), new Boolean(true)},
		    {"Bag", "20",
		     "5", new String("Pending"), new Boolean(false)}
		};
	Object[] columnNames = {"Serial Number",
            "Item Name",
            "Quantity",
            "Confirmation",
            };
	
	JPanel orderGrid = new JPanel();
	
	JButton but1 = newButton("1", 40, 50);
	JButton but2 = newButton("2", 40, 50);
	JButton but3 = newButton("3", 40, 50);
	JButton but4 = newButton("4", 40, 50);
	JButton but5 = newButton("5", 40, 50);
	
	JTable orderS = new JTable(data, columnNames);
	
	orderS.setRowHeight(70);
	orderS.setAlignmentX(50);

	

	JScrollPane scrollpane = new JScrollPane(orderS);
	scrollpane.setPreferredSize(new Dimension(480, 300));
	scrollpane.setVisible(true);
	scrollpane.setViewportView(orderS);
	
	
	Font r = new Font("SansSerif", Font.PLAIN, 15);
	RoundedJTextField searchBar = new RoundedJTextField(7);
	searchBar.setBounds(50,45,200,50);
	searchBar.setBorder(new LineBorder(Color.BLACK));
	searchBar.setFont(r);
	
	
	JButton searchButton = new JButton("Search");
	searchButton.setBounds(50,175,200,50);
	searchButton.setFocusPainted(false);
	searchButton.setForeground(Color.BLACK);
	searchButton.setBackground(Color.BLUE);
	searchButton.setBorder(new LineBorder(Color.BLACK));
	
	JButton storePage = new JButton("Store Page");
	storePage.setBounds(50,350,200,50);
	storePage.setFocusPainted(false);
	storePage.setForeground(Color.BLACK);
	storePage.setBackground(Color.BLUE);
	storePage.setBorder(new LineBorder(Color.BLACK));
		
	JButton logout = new JButton("Logout");
	logout.setBounds(50,525,200,50);
	logout.setFocusPainted(false);
	logout.setForeground(Color.BLACK);
	logout.setBackground(Color.RED);
	logout.setBorder(new LineBorder(Color.BLACK));
	 
	Font f = new Font("serif", Font.BOLD, 25);
	
		ActionListener buttons = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == storePage) {
					ShoppingPage shopping = new ShoppingPage();	
					storePage.setVisible(true);
					
				}if(e.getSource() == logout) {
					System.exit(0);									
				}else if(e.getSource()==searchButton) {
					String userS = searchBar.getText();
						if(userS.length()==0) {
							ErrorFrame error = new ErrorFrame();
						}else {
							//searchmethod
						}
				}else if(e.getSource()==but1) {
					
				}
			}					
		};
		

		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		orderS.setDefaultRenderer(String.class, centerRenderer);
		
		
		
	orderGrid.add(scrollpane);
	orderGrid.add(but1);
	orderGrid.add(but2);
	orderGrid.add(but3);
	orderGrid.add(but4);
	orderGrid.add(but5);
	searchButton.addActionListener(buttons);
	logout.addActionListener(buttons);
	storePage.addActionListener(buttons);
	//sideButtons.add(searchButton);
	sideButtons.add(searchBar);
	sideButtons.add(logout);
	sideButtons.add(storePage);
	frame.add(orderGrid, BorderLayout.CENTER);
	frame.add(sideButtons, BorderLayout.WEST);
	frame.setVisible(true);
}
	
	private JButton newButton(String pText, int pWidth, int pHeight) {
	     JButton button = new JButton(pText);
	     button.setPreferredSize(new Dimension(pWidth, pHeight));
	     button.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
	     return button;
	  }
}
