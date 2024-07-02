package hotel_style;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddRoom extends JPanel{
	private String[] attribut = {"NOMBRE", "TYPE", "ETAT", "NOMBRE DE LITS", "PRIX"};
	AddRoom(){
		FormModel addClient = new FormModel(attribut, "ADD ROOM");
		add(addClient.titleCont);
		add(addClient.inputPanel);
		add(addClient.errorCont);
		add(addClient.btnCont);
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(50, 50, 10, 50));
	}
}
