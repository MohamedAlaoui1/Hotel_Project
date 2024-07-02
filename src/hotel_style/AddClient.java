package hotel_style;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddClient extends JPanel{
	
	private String[] attribut = {"NOM  ", "VILLE ", "PAYS "};
	//FormModel addClient = new FormModel(attribut, "ADD Client");
	
	
	AddClient(){
		
		FormModel addClient = new FormModel(attribut, "ADD Client");
		add(addClient.titleCont);
		add(addClient.inputPanel);
		add(addClient.errorCont);
		add(addClient.btnCont);
		
		
		
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(50, 50, 10, 50));

	}
	
	

}
