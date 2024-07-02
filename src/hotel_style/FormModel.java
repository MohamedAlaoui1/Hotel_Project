package hotel_style;
import java.sql.Date;  

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hotel.beans.Client;
//import hotel.beans.Date;
//import hotel.beans.Hotel;
import hotel.beans.Reservation;
import hotel.beans.Room;

public class FormModel{
	
	JPanel titleCont = new JPanel();
	JPanel btnCont = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel errorCont = new JPanel();
	
	HtlBtn saveBtn = new HtlBtn("Sauvegarder");
	HtlBtn initBtn = new HtlBtn("Reinitialiser");
	
	//Hotel hotel = new Hotel();
	JLabel errorMes = new JLabel();
	Boolean checkInputs = true;
	
	
	
	FormModel(String arr[], String title){
		
		JLabel titleOfForm = new JLabel(title);
		
		titleCont.add(titleOfForm);
		
		for(int i =0; i<arr.length; i++) {
			inputPanel.add(new labledTextField(arr[i], 20));
			
		}
		
		
		
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		
		
		titleOfForm.setFont(new Font("sans-Serif", Font.PLAIN, 20));
		
		
		
		btnCont.add(saveBtn);
		btnCont.add(initBtn);
		
		errorCont.add(errorMes);
		
		initBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e)
			   {				    
				   initialiser();
			   }
			});
		
		
		
		
		
		
		saveBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e)
			   {
				   for (Component component : inputPanel.getComponents()) {
			           if(((labledTextField) component).getText().equals("")) {
			        	   checkInputs = false;
			        	   break;
			           }else {
			        	   checkInputs = true;
			           }
			        }
				   
				   
				  if(checkInputs) { 
					  
					  errorMes.setText("");
					  
					  
					  if(title == "ADD Client") {
						  JOptionPane.showMessageDialog(null, "Le client a ete ajoute avec succee !", "Client added", 
								  JOptionPane.PLAIN_MESSAGE);
						  
						  Client client = new Client();
						  
						  String name = ((labledTextField) inputPanel.getComponent(0)).getText();
						  String city = ((labledTextField) inputPanel.getComponent(1)).getText();
						  String country = ((labledTextField) inputPanel.getComponent(2)).getText();
						  
						  
						  client.ajouterClient(client.getCi(),name,city,country);
						  
					  }
					  
					  if(title == "ADD ROOM") {
						  JOptionPane.showMessageDialog(null, "La chambre a ete ajoute avec succee !", "Room added", 
								  JOptionPane.PLAIN_MESSAGE);
						  
						  int value1 = Integer.parseInt(((labledTextField) inputPanel.getComponent(0)).getText());
						  int value2 = Integer.parseInt(((labledTextField) inputPanel.getComponent(1)).getText());
						  int value3 = Integer.parseInt(((labledTextField) inputPanel.getComponent(2)).getText());
						  int value4 = Integer.parseInt(((labledTextField) inputPanel.getComponent(3)).getText());
						  int value5 = Integer.parseInt(((labledTextField) inputPanel.getComponent(4)).getText());
						  
						  Room newRoom = new Room();
						  
						  newRoom.ajouterRoom(value1, newRoom.types[value2], newRoom.states[value3], value4, value5);
						  
						  //hotel.addRoom(newRoom);
						  
					  }
					  
					  if(title == "ADD RESERVATION") {
						  JOptionPane.showMessageDialog(null, "La reservation a ete ajoute avec succee !", "Reservation added", 
								  JOptionPane.PLAIN_MESSAGE);
						  
//						  Date date = new Date(Integer.parseInt(((labledTextField) inputPanel.getComponent(2)).getText()),
//								  			Integer.parseInt(((labledTextField) inputPanel.getComponent(3)).getText()),
//								  			Integer.parseInt(((labledTextField) inputPanel.getComponent(4)).getText())
//								  );
						  StringBuffer sb = new StringBuffer();
					        sb.append(((labledTextField) inputPanel.getComponent(2)).getText());
					        sb.append("-");
					        sb.append(((labledTextField) inputPanel.getComponent(3)).getText());
					        sb.append("-");
					        sb.append(((labledTextField) inputPanel.getComponent(4)).getText());
					        
					        Date date=Date.valueOf(sb.toString());
						  
//						  hotel.addReservation(new Reservation(
//								  hotel.getClient(((labledTextField) inputPanel.getComponent(0)).getText()), 
//								  hotel.getRoom(Integer.parseInt(((labledTextField) inputPanel.getComponent(1)).getText())),
//						          date,
//						          Integer.parseInt(((labledTextField) inputPanel.getComponent(3)).getText())
//			                      
//								  ));
						  
						  int idClient = Integer.parseInt(((labledTextField) inputPanel.getComponent(0)).getText());
						  int numRoom = Integer.parseInt(((labledTextField) inputPanel.getComponent(1)).getText());
						  int days = Integer.parseInt(((labledTextField) inputPanel.getComponent(5)).getText());
						  
						  Reservation reservation = new Reservation();
						
						  reservation.ajouterResrvation(Reservation.getCi(), idClient, numRoom, date, days);
	  
					  }
					  initialiser();
				  
				  }else {
					  errorMes.setText("PLEASE FILL IN ALL THE TEXT FIELDS");
					  errorMes.setForeground(Color.red);
				  }
			   
			   
			   
			   
			   
			   
			   }
			});
		
		

	}

	public void initialiser() {
		for (Component component : inputPanel.getComponents()) {
            ((labledTextField) component).setText("");
          
        }
		errorMes.setText("");
		checkInputs = true;
		
	}
	
}


