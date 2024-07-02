package hotel_style;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import hotel.beans.Client;


public class StandardView {
	
		JFrame frame = new JFrame();
		JPanel panelCont = new JPanel();
		AddClient ajoutC = new AddClient();
		AddRoom ajoutR = new AddRoom();
		AddReservation ajoutReser = new AddReservation();
		afficherClient affC = new afficherClient();
		afficherRoom affR = new afficherRoom();
		afficherReservation affReser = new afficherReservation();
		afficherOccupation affOccup = new afficherOccupation();
		//Client client = new Client();
		CardLayout c1 = new CardLayout();
		

		HtlBtn button1 = new HtlBtn("Ajouter Client");
		HtlBtn button2 = new HtlBtn("Ajouter Chambre");
		HtlBtn button3 = new HtlBtn("Ajouter Reservation");
		HtlBtn button4 = new HtlBtn("Afficher Clients");
		HtlBtn button5 = new HtlBtn("Afficher Chambres");
		HtlBtn button6 = new HtlBtn("Afficher Reservations");
		HtlBtn button7 = new HtlBtn("Afficher Occupations");
		HtlBtn exit = new HtlBtn("Exit");
		JPanel buttonCont = new JPanel();
		
		public StandardView() {
			
			panelCont.setLayout(c1);
			buttonCont.setLayout(new BoxLayout(buttonCont,BoxLayout.Y_AXIS));
			buttonCont.add(button1);
			buttonCont.add(Box.createVerticalGlue());
			buttonCont.add(button2);
			buttonCont.add(Box.createVerticalGlue());
			buttonCont.add(button3);
			buttonCont.add(Box.createVerticalGlue());
			buttonCont.add(button4);
			buttonCont.add(Box.createVerticalGlue());
			buttonCont.add(button5);
			buttonCont.add(Box.createVerticalGlue());
			buttonCont.add(button6);
			buttonCont.add(Box.createVerticalGlue());
			buttonCont.add(button7);
			buttonCont.add(Box.createVerticalGlue());
			buttonCont.add(exit);
			buttonCont.add(Box.createVerticalGlue());
			
			panelCont.add(ajoutC, "red");
			panelCont.add(ajoutR, "blue");
			panelCont.add(ajoutReser, "green");
			panelCont.add(affC, "purple");
			panelCont.add(affR, "yellow");
			panelCont.add(affReser, "pink");
			panelCont.add(affOccup, "orange");
			
			
			button1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                c1.show(panelCont, "red");
	            }
	        });

	        button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                c1.show(panelCont, "blue");
	            }
	        });

	        button3.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                c1.show(panelCont, "green");
	            }
	        });
	        
	        button4.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	        
	                c1.show(panelCont, "purple");
	                
	                
	            }
	        });
	        
	        button5.addActionListener(new ActionListener() {
	            
	            public void actionPerformed(ActionEvent e) {
	            	
	                c1.show(panelCont, "yellow");
	                
	                
	            }
	        });
	        
	        button6.addActionListener(new ActionListener() {
	            
	            public void actionPerformed(ActionEvent e) {
	            	
	                c1.show(panelCont, "pink");
	                
	                
	            }
	        });
	        
	        button7.addActionListener(new ActionListener() {
	            
	            public void actionPerformed(ActionEvent e) {
	            	
	                c1.show(panelCont, "orange");
	             
	            }
	        });
	        
	        
	        exit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	frame.dispose();
	            }
	        });
			
			
	        
	        
	        
	        buttonCont.setBackground(Color.DARK_GRAY);
	        buttonCont.setBorder(new EmptyBorder(50, 50, 10, 50));
	        frame.setLayout(new BorderLayout());
	        frame.add(BorderLayout.WEST, buttonCont);
	        frame.add(BorderLayout.CENTER, panelCont);
			frame.setSize(1000,600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			frame.setVisible(true);
		}

		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable(){
	            public void run() {
	            	new StandardView();
	            }
	        });

		}

	}

