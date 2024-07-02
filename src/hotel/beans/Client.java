package hotel.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Client {
	private String id;
	private String name;
	private String city;
	private String country;

	private static int ci = 1;
	
	public Client() {
		
	}

	public Client(String id, String name, String city, String country) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
		
	}

	public static int getCi() {
		return ci;
	}

	public static void setCi(int ci) {
		Client.ci = ci;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", city=" + city + ", country=" + country + "]";
	}
	
	public void ajouterClient(int id, String name, String city , String country) {
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/hotel";
	            con = DriverManager.getConnection(url, "root", "root");

	            
	            String query = "INSERT INTO client (id, name, city, country) VALUES (?, ?, ?, ?)";
	            
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setInt(1, id);
	            preparedStatement.setString(2, name);
	            preparedStatement.setString(3, city);
	            preparedStatement.setString(4, country);

	            
	            preparedStatement.executeUpdate();

	            System.out.println("Client ajouté avec succès !");
	            ci++;
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
	
	public List<Client> getAllClients() {
	    List<Client> clients = new ArrayList<>();
	    
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
	        String query = "SELECT * FROM client"; 
	        PreparedStatement statement = conn.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            
	            String id = resultSet.getString("id");
	            String nom = resultSet.getString("name");
	            String city = resultSet.getString("city");
	            String country = resultSet.getString("country");
	            
	            Client client = new Client(id, nom, city, country);
	            clients.add(client);
	        }
	        
	        conn.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return clients;
	}
	
	}


