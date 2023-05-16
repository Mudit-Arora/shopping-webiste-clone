import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AddNewItem {
	
	AddNewItem(){ 
	JFrame frame = new JFrame("Add A New Item");
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
	
	JButton editScreen = new JButton("Edit Items");
	editScreen.setBounds(50,175,200,50);
	editScreen.setFocusPainted(false);
	editScreen.setForeground(Color.BLACK);
	editScreen.setBackground(Color.BLUE);
	editScreen.setBorder(new LineBorder(Color.BLACK));
	
	JButton addItem = new JButton("Add Items");
	addItem.setBounds(50,350,200,50);
	addItem.setFocusPainted(false);
	addItem.setForeground(Color.BLACK);
	addItem.setBackground(Color.BLUE);
	addItem.setBorder(new LineBorder(Color.BLACK));
	
	
	JButton logout = new JButton("Logout");
	logout.setBounds(50,525,200,50);
	logout.setFocusPainted(false);
	logout.setForeground(Color.BLACK);
	logout.setBackground(Color.RED);
	logout.setBorder(new LineBorder(Color.BLACK));
	 
	Font f = new Font("serif", Font.BOLD, 25);
	Font u = new Font("serif", Font.BOLD, 22);
	
	JLabel sNum = new JLabel("Serial Number :");
	sNum.setFont(u);
	sNum.setBounds(50, 153, 150, 75);
	
	JLabel name = new JLabel("Name : ");
	name.setFont(f);
	name.setBounds(50, 250, 150, 75);
	
	
	JLabel uName = new JLabel("Price :");
	uName.setFont(f);
	uName.setBounds(50, 350, 150, 75);
	
	JLabel pWord = new JLabel("Quantity :");
	pWord.setFont(f);
	pWord.setBounds(50, 450, 150, 75);
	
	
	RoundedJTextField serialNum = new RoundedJTextField(5);
	serialNum.setBounds(50, 175, 200, 35);
	
	RoundedJTextField itemName = new RoundedJTextField(5);
	itemName.setBounds(50,275,200,35);
	
	RoundedJTextField itemPrice = new RoundedJTextField(5);
	itemPrice.setBounds(50,375,200,35);
	
	RoundedJTextField itemDescription = new RoundedJTextField(5);
	itemDescription.setBounds(50,475,200,35);
	
		ActionListener buttons = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == editScreen) {
					frame.setVisible(false);
					ShoppingPage shoppingpage = new ShoppingPage();
					//waiting for edit screen					
					
				}if(e.getSource() == logout) {
					System.exit(0);
					
				}if(e.getSource() == addItem) {
					String serial = serialNum.getText();
					String itemname = itemName.getText();
					String sPrice = itemPrice.getText();
					String description = itemDescription.getText();
													
				if((serial.length() == 0)||(itemname.length() == 0)||(sPrice.length() == 0)||(description.length()==0)) {
					ErrorFrame error = new ErrorFrame();
				}else {
					int ser = 0;
					int quan = 0;
					double itemprice = 0;
					try {
						ser = Integer.parseInt(serial);
						quan = Integer.parseInt(description);
						itemprice = Double.parseDouble(sPrice);
					
					 } catch (NumberFormatException b) {
						 ErrorFrame error = new ErrorFrame();
					 }
					
					Item.addNewItem(ser, itemname, itemprice, quan);
				}
			  }					
			}
		};
	logout.addActionListener(buttons);
	editScreen.addActionListener(buttons);
	addItem.addActionListener(buttons);
	fields.add(serialNum);
	fields.add(itemName);
	fields.add(itemPrice);
	fields.add(itemDescription);
	text.add(sNum);
	text.add(name);
	text.add(uName);
	text.add(pWord);
	labels.add(fields, BorderLayout.CENTER);
	labels.add(text, BorderLayout.WEST);
	sideButtons.add(addItem);
	sideButtons.add(logout);
	sideButtons.add(editScreen);
	frame.add(labels, BorderLayout.CENTER);
	frame.add(sideButtons, BorderLayout.WEST);
	frame.setVisible(true);
}
}
