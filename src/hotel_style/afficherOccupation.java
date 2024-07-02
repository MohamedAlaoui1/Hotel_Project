package hotel_style;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hotel.beans.Reservation;

public class afficherOccupation extends JPanel{
	afficherOccupation(){
		Reservation reservation1 = new Reservation();
	    List<Reservation> reservations = reservation1.getAllOccupation(); 
	    
	    
	    DefaultTableModel model = new DefaultTableModel();
	    

	    model.addColumn("ID");
	    model.addColumn("Room Number");
	    model.addColumn("Date");
	    model.addColumn("Days");
	  

	    for (Reservation reservation : reservations) {
	        model.addRow(new Object[]{reservation.getClient(), reservation.getRoom(), reservation.getDate(), reservation.getDays()});
	    } 
	    
	    
	    JTable table = new JTable(model);
	    JScrollPane scrollPane = new JScrollPane(table);
	    
	    
	    setLayout(new FlowLayout(FlowLayout.CENTER));
	    add(scrollPane);
	    
	}
}
