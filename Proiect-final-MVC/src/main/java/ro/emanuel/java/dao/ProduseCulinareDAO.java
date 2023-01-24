package ro.emanuel.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.pojo.ProdusCulinar;

public class ProduseCulinareDAO {
	
	public static ArrayList<ProdusCulinar> getALL() throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		ArrayList<ProdusCulinar> result = new ArrayList<ProdusCulinar>();

		String query = "select * from produse_culinare";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			ProdusCulinar p = new ProdusCulinar();
			p.setId(rs.getInt("id"));
			p.setNumeProdusCulinar(rs.getString("nume"));
			p.setPret(rs.getString("pret"));
			p.setDescriereProdus(rs.getString("descriere_produs"));
			
			result.add(p); 
		}
		return result;
	}

	
	public static ProdusCulinar getById(int id) throws SQLException {
		
		ProdusCulinar p = null;
		
		Connection conn = DBHelper.getConnection();
		
		String query = "select * from produse_culinare where id=" + id;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		if(rs.next()) {
			p = new ProdusCulinar();
			p.setId(rs.getInt("id"));
			p.setNumeProdusCulinar(rs.getString("nume"));
			p.setPret(rs.getString("pret"));
			p.setDescriereProdus(rs.getString("descriere_produs"));
		}
		
		return p;
	}
	
	
	public static void insert(ProdusCulinar p) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		
		String sql = "insert into produse_culinare(nume, pret, descriere_produs)" +
		"value ('" + p.getNumeProdusCulinar() + "','" + p.getPret() + "','" + p.getDescriereProdus() + "')";

		
		Statement stmt = conn.createStatement();
		int rowsInserted = stmt.executeUpdate(sql);

		if (rowsInserted > 0) {
			System.out.println("Un nou produs a fost adaugat cu succes!");
		}
	}
	
	
	public static void update(ProdusCulinar p) throws SQLException {
			
		Connection conn = DBHelper.getConnection();
		
		String query = "UPDATE produse_culinare "
				+ "SET nume = '" + p.getNumeProdusCulinar() + "', "
				+ "pret = '"+ p.getPret() + "', "
				+ "descriere_produs = '"+ p.getDescriereProdus() + "' "
				+ "WHERE id = "+ p.getId() + " ;";			
			
		Statement stmt = conn.createStatement();
		int rowsUpdated = stmt.executeUpdate(query);

		if (rowsUpdated > 0) {
			System.out.println("Un nou produs a fost modificat cu succes!");
		}
		else
			System.out.println("Produsul nu a fost modificat!");
	
	}
	
	
	public static void updatePrepared(ProdusCulinar p) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		String query = "UPDATE produse_culinare SET nume=?, pret=?, descriere_produs=? " +
				"WHERE id=?";

		PreparedStatement updateStmt = conn.prepareStatement(query);
		
		updateStmt.setString(1, p.getNumeProdusCulinar());
		updateStmt.setString(2, p.getPret());
		updateStmt.setString(3, p.getDescriereProdus());
		updateStmt.setInt(4, p.getId());
		
		if(updateStmt.executeUpdate() > 0) {
		System.out.println("Un produs a fost modificat cu succes!");
		}
		else
		System.out.println("Produsul nu a fost modificat!");
	}
	
	
	public static void delete(int id) throws SQLException {
		
		String sql = "DELETE FROM produse_culinare WHERE id=" + id;
		
		Connection conn = DBHelper.getConnection();

		Statement stmt = conn.createStatement();

		int rowsDeleted = stmt.executeUpdate(sql);
		if (rowsDeleted > 0) {
			System.out.println("Un produs a fost sters cu succes!");
		}
	}
	
}
