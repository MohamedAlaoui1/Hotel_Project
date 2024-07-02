package hotel.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
	private int id;
	private int numRoom;
	private java.sql.Date date;
	private int days;

	private static int ci = 1;

	public Reservation() {
		
	}

	public static int getCi() {
		return ci;
	}

	public static void setCi(int ci) {
		Reservation.ci = ci;
	}

	public Reservation(int num, int id, int numRoom, java.sql.Date date2, int days) {
		this();
		this.id = id;
		this.numRoom = numRoom;
		this.date = date2;
		this.days = days;
	}
	
//	public Reservation(int num, int id, int numChamb, Date date2, int days) {
//		
//	}

	public int getClient() {
		return id;
	}

	public void setClient(int id) {
		this.id = id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getRoom() {
		return numRoom;
	}

	public void setRoom(int numRoom) {
		this.numRoom = numRoom;
	}

//	public int getNumber() {
//		number = ci;
//		return number;
//	}
//
//	public void setNumber(int number) {
//		this.number = number;
//	}

	public String toString() {
		return "Reservation [client=" + id + ", room=" + numRoom + ", date=" + date + ", days="
				+ days + "]";
	}
	
	public void ajouterResrvation(int num, int id, int numRoom, java.sql.Date date , int days) {
        Connection con = null;
        try {
        	ci++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotel";
            con = DriverManager.getConnection(url, "root", "root");

            
            String query = "INSERT INTO reservation (number , idClient, numberRoom, date, days) VALUES (?, ?, ?, ?, ?);";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, num);
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(3, numRoom);
            preparedStatement.setDate(4, date);
            preparedStatement.setInt(5, days);

            
            preparedStatement.executeUpdate();
           
            System.out.println("Client ajouté avec succès !");
        } catch (Exception ex) {
            System.out.println("Erreur lors de l'ajout du client : " + ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                    System.out.println("Connexion fermée !!");
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e);
            }
        }
    }
	
	public List<Reservation> getAllReservations() {
	    List<Reservation> reservations = new ArrayList<>();
	    
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
	        String query = "SELECT * FROM reservation"; 
	        PreparedStatement statement = conn.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            
	            int num = resultSet.getInt("number");
	            int id = resultSet.getInt("idClient");
	            int numRoom = resultSet.getInt("numberRoom");
	            java.sql.Date date = resultSet.getDate("date");
	            int days = resultSet.getInt("days");
	            
	          
	            Reservation reservation = new Reservation(num, id, numRoom, date, days);
	            reservations.add(reservation);
	        }
	        
	        conn.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return reservations;
	}
	
	public List<Reservation> getAllOccupation() {
	    List<Reservation> reservations = new ArrayList<>();
	    
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
	        String query = "select reservation.* from reservation join room on reservation.numberRoom=room.number where room.state=\"OCCUPEE\";"; 
	        PreparedStatement statement = conn.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            
	            int num = resultSet.getInt("number");
	            int id = resultSet.getInt("idClient");
	            int numRoom = resultSet.getInt("numberRoom");
	            java.sql.Date date = resultSet.getDate("date");
	            int days = resultSet.getInt("days");
	            
	          
	            Reservation reservation = new Reservation(num, id, numRoom, date, days);
	            reservations.add(reservation);
	        }
	        
	        conn.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return reservations;
	}
	
	

}
