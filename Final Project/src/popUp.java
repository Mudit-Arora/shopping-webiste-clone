import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class popUp {
		
	
	popUp()
	{
Font f = new Font("serif", Font.BOLD, 21);
		
		JFrame popUp = new JFrame("Purchase Complete");
		popUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popUp.setVisible(true);
		popUp.setSize(600,250);
		popUp.setLayout(null);
		popUp.setResizable(false);
		
		JButton close = new JButton("Close");
		close.setBounds(260,100,80,30);
		close.setFocusPainted(false);
		close.setForeground(Color.BLACK);
		close.setBackground(Color.GRAY);
		close.setBorder(new LineBorder(Color.BLACK));
		
		String message = "Your order has been placed. Total:  $3296";
		
		JLabel errorMessage = new JLabel();
		errorMessage.setText(message);
		errorMessage.setFont(f);
		errorMessage.setForeground(Color.BLUE);
		errorMessage.setBounds(90, 10, 400, 50);
		
		ActionListener button = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popUp.setVisible(false);
			}
		
		};
		close.addActionListener(button);
		popUp.add(errorMessage);
		popUp.add(close);
	}
}


