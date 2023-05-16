import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ChooseCreateAccount {
	ChooseCreateAccount(){
		Font f = new Font("serif", Font.BOLD, 25);
		
		JFrame popUp = new JFrame("Choose From the Options Below");
		popUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popUp.setVisible(true);
		popUp.setSize(600,250);
		popUp.setLayout(null);
		popUp.setResizable(false);
		
		JButton employee = new JButton("Employee");
		employee.setBounds(130,100,80,30);
		employee.setFocusPainted(false);
		employee.setForeground(Color.BLACK);
		employee.setBackground(Color.GRAY);
		employee.setBorder(new LineBorder(Color.BLACK));
		
		JButton customer = new JButton("Customer");
		customer.setBounds(430,100,80,30);
		customer.setFocusPainted(false);
		customer.setForeground(Color.BLACK);
		customer.setBackground(Color.GRAY);
		customer.setBorder(new LineBorder(Color.BLACK));
		
		JLabel errorMessage = new JLabel();
		errorMessage.setText("Which type of account would you like to make?");
		errorMessage.setFont(f);
		errorMessage.setForeground(Color.blue);
		errorMessage.setBounds(20, 10, 500, 50);
		
		ActionListener button = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==customer) {
					CreateCustomerAccount customer = new CreateCustomerAccount();
				}else if (e.getSource()==employee) {
					CreateEmployeeAccount employee = new CreateEmployeeAccount();
				}
				popUp.setVisible(false); 
			} 
			
		};
		customer.addActionListener(button);
		employee.addActionListener(button);
		popUp.add(errorMessage);
		popUp.add(employee);
		popUp.add(customer);
		
	}
	
}
