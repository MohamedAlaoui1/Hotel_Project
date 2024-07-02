package hotel_style;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddReservation extends JPanel{
	private String[] attribut = {"ID de Client        ", "Numero de Chambre","Annee d'arrive","Mois d'arrive","Jour d'arrive", "Nombre de Jour"};
	AddReservation(){
		FormModel addClient = new FormModel(attribut, "ADD RESERVATION");
		add(addClient.titleCont);
		add(addClient.inputPanel);
		add(addClient.errorCont);
		add(addClient.btnCont);
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(50, 50, 10, 50));
	}
}
