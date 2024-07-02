package hotel_style;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hotel.beans.Client;
import hotel.beans.Room;

public class afficherRoom extends JPanel{
	afficherRoom(){
		Room room1 = new Room();
	    List<Room> rooms = room1.getAllRooms(); 
	    
	    
	    DefaultTableModel model = new DefaultTableModel();
	    
	    model.addColumn("Number");
	    model.addColumn("Type");
	    model.addColumn("State");
	    model.addColumn("BedCount");
	    model.addColumn("Price");
	  

	    for (Room room : rooms) {
	        model.addRow(new Object[]{room.getNumber(), room.getTypeS(), room.getStateS(), room.getBedCount(), room.getPrice()});
	    }
	    
	    
	    JTable table = new JTable(model);
	    JScrollPane scrollPane = new JScrollPane(table);
	    
	    
	    setLayout(new FlowLayout(FlowLayout.CENTER));
	    add(scrollPane);
	    
	}
}
