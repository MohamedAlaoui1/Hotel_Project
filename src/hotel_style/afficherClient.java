package hotel_style;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hotel.beans.Client;

public class afficherClient extends JPanel {
	
	    
	    afficherClient(){
	    	Client client1 = new Client();
	    
		    List<Client> clients = client1.getAllClients(); 
		    
		    
		    DefaultTableModel model = new DefaultTableModel();
		    
		    model.addColumn("ID");
		    model.addColumn("Name");
		    model.addColumn("City");
		    model.addColumn("Country");
		  
	
		    for (Client client : clients) {
		        model.addRow(new Object[]{client.getId(), client.getName(), client.getCity(), client.getCountry()});
		    }
		    
		    
		    JTable table = new JTable(model);
		    JScrollPane scrollPane = new JScrollPane(table);
		    
		    
		    setLayout(new FlowLayout(FlowLayout.CENTER));
		    add(scrollPane);
	    
	}

}
