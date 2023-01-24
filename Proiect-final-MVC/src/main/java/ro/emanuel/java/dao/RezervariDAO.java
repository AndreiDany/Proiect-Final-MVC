package ro.emanuel.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.pojo.Client;
import ro.emanuel.java.pojo.Rezervare;

public class RezervariDAO {
	
	public static void insert(Rezervare rezervare, int idMasa) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		
		Client client = rezervare.getClient();
		int idClient = client.getId();		

		String sql = "insert into rezervari(id_client, data_si_ora, id_masa)" +
		"value ('" + idClient + "','" + rezervare.getDataSiOra() + "', " + idMasa + " )";
	
		
		Statement stmt = conn.createStatement();
		int rowsInserted = stmt.executeUpdate(sql);
	
		if (rowsInserted > 0) {
			System.out.println("O noua rezervare a fost adaugata cu succes!");
		}
	}
	
	public static ArrayList<Rezervare> getALL() throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		ArrayList<Rezervare> result = new ArrayList<Rezervare>();

		String query = "select * from rezervari";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			Rezervare r = new Rezervare();
			
			r.setId(rs.getInt("id"));
			r.setClient(ClientiDAO.getById(rs.getInt("id_client")));
			r.setDataSiOra(rs.getString("data_si_ora"));

			
			result.add(r);
		}
		return result;
	}
	
	public static Rezervare getById(int id) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		Rezervare r = new Rezervare();

		String query = "select * from rezervari where id=" + id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		if(rs.next()) {
			
			r.setId(rs.getInt("id"));
			r.setClient(ClientiDAO.getById(rs.getInt("id_client")));
			r.setDataSiOra(rs.getString("data_si_ora"));

		}
		return r;
	}
	
	public static void updatePrepared(Rezervare r) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		String query = "UPDATE rezervari SET id_client=?, data_si_ora=? " +
				"WHERE id=" + r.getId();

		PreparedStatement updateStmt = conn.prepareStatement(query);
		
		updateStmt.setInt(1, r.getClient().getId());
		updateStmt.setString(2, r.getDataSiOra());
		
		if(updateStmt.executeUpdate() > 0) {
		System.out.println("O rezervare a fost modificata cu succes!");
		}
		else
		System.out.println("O rezervare nu a fost modificata!");
	}
	
	public static void delete(int id) throws SQLException {
		
		String sql = "DELETE FROM rezervari WHERE id=" + id;
		
		Connection conn = DBHelper.getConnection();

		Statement stmt = conn.createStatement();

		int rowsDeleted = stmt.executeUpdate(sql);
		if (rowsDeleted > 0) {
			System.out.println("O rezervare a fost stearsa cu succes!");
		}
	}

}
