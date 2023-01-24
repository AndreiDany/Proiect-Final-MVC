package ro.emanuel.java.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.pojo.Client;

public class ClientiDAO {
	
	public static ArrayList<Client> getALL() throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		ArrayList<Client> result = new ArrayList<Client>();

		String query = "select * from clienti";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			Client c = new Client();
			c.setId(rs.getInt("id"));
			c.setNume(rs.getString("nume"));
			c.setPrenume(rs.getString("prenume"));
			c.setNumarDeTelefon(rs.getString("numar_de_telefon"));
			c.setEmail(rs.getString("email"));
			
			result.add(c);
		}
		return result;
	}
	
	
	public static Client getById(int id) throws SQLException {
		
		Connection conn = DBHelper.getConnection();

		String query = "select * from clienti where id=" + id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		Client c = null;
		
		if (rs.next()) {
			c = new Client();
			c.setId(rs.getInt("id"));
			c.setNume(rs.getString("nume"));
			c.setPrenume(rs.getString("prenume"));
			c.setNumarDeTelefon(rs.getString("numar_de_telefon"));
			c.setEmail(rs.getString("email"));

		}
		return c;
	}
	
	
	public static int insert(Client c) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		
		ArrayList<Client> clienti = getALL();
		int idClient=0;
		
		Iterator<Client> it = clienti.iterator();
		boolean clientExistent = false;
		
		while (it.hasNext()) {
			
			Client client =  it.next();
			
			if(c.getEmail().equals( client.getEmail() )) {
				clientExistent = true; 
				idClient=client.getId();
			}
		}
		
		if(clientExistent == false) {
			String sql = "insert into clienti(nume, prenume, numar_de_telefon, email)" +
			"value ('" + c.getNume() + "','" + c.getPrenume() + "','" + c.getNumarDeTelefon() + "','" + c.getEmail() + "')";
	
			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int rowsInserted = stmt.executeUpdate();
	
			if (rowsInserted > 0) {
				System.out.println("Un nou cient a fost adaugat cu succes!");
			}
			
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                c.setId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
			return c.getId();
		}
		else
		{
			System.out.println("Client existent!");
			return idClient;
		}
	}
	
	
	public static void updatePrepared(Client c) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		String query = "UPDATE clienti SET nume=?, prenume=?, numar_de_telefon=?, email=? " +
				"WHERE id=" + c.getId();

		PreparedStatement updateStmt = conn.prepareStatement(query);
		
		updateStmt.setString(1, c.getNume());
		updateStmt.setString(2, c.getPrenume());
		updateStmt.setString(3, c.getNumarDeTelefon());
		updateStmt.setString(4, c.getEmail());
		
		if(updateStmt.executeUpdate() > 0) {
		System.out.println("Un client a fost modificat cu succes!");
		}
		else
		System.out.println("Clientul nu a fost modificat!");
	}
	
	
	public static void delete(int id) throws SQLException {
		
		String sql = "DELETE FROM clienti WHERE id=" + id;
		
		Connection conn = DBHelper.getConnection();

		Statement stmt = conn.createStatement();

		int rowsDeleted = stmt.executeUpdate(sql);
		if (rowsDeleted > 0) {
			System.out.println("Un client a fost sters cu succes!");
		}
	}

}
