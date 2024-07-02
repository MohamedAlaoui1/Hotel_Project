package hotel.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Room {
	public static final int SINGLE = 0;
	public static final int DOUBLE = 1;
	
	public static final int FREE = 0;
	public static final int NOT_FREE = 1;
	
	public static String types[] = {"SIMPLE","DOUBLE"};
	public static String states[] = {"LIBRE","OCCUPEE"};
	
	private int number;
	private int type;
	private int state;
	private int bedCount;
	private double price;
	private String typeS;
	private String stateS;
	
	public Room() {
	}

	public Room(int number, int type, int state, int bedCount, double price) {
		this.number = number;
		this.type = type;
		this.state = state;
		this.bedCount = bedCount;
		this.price = price;
	}
	public Room(int number, String typeS, String stateS, int bedCount, double price) {
		this.number = number;
		this.typeS = typeS;
		this.stateS = stateS;
		this.bedCount = bedCount;
		this.price = price;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String toString() {
		String s = "Chambre N " + number
			+ ", " + types[type] + ", " + states[state]
			+ ", Nombre de lits : " + bedCount + ", Prix : " + price + " DH";
		
		return s;
	}
	
	public void ajouterRoom(int num, String type, String state , int bedcount, int price) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotel";
            con = DriverManager.getConnection(url, "root", "root");

            
            String query = "INSERT INTO room (number, type, state, bedCount, price) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, state);
            preparedStatement.setInt(4, bedcount);
            preparedStatement.setInt(5, price);

            
            preparedStatement.executeUpdate();

            System.out.println("Chambre ajouté avec succès !");
        } catch (Exception ex) {
            System.out.println("Erreur lors de l'ajout de la Chambre : " + ex);
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
	
	

public List<Room> getAllRooms() {
    List<Room> rooms = new ArrayList<>();
    
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
        String query = "SELECT * FROM room"; // Assurez-vous que la table s'appelle 'clients' ou remplacez par le nom correct
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            // Récupération des données du client depuis la base de données
            int num = resultSet.getInt("number");
            String type = resultSet.getString("type");
            String state = resultSet.getString("state");
            int bedcount = resultSet.getInt("bedcount");
            double price = resultSet.getInt("price");

            int a;
            int b;
            a = (type == "SIMPLE")? 0 : 1;
            b = (state == "LIBRE")? 0 : 1;
            Room room = new Room(num, type, state, bedcount,price);
            rooms.add(room);
        }
        
        conn.close(); // Fermeture de la connexion à la base de données
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return rooms;
}

public String getTypeS() {
	return typeS;
}

public void setTypeS(String typeS) {
	this.typeS = typeS;
}

public String getStateS() {
	return stateS;
}

public void setStateS(String stateS) {
	this.stateS = stateS;
}
	
	
}
