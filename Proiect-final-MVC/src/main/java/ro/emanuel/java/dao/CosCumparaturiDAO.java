package ro.emanuel.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.pojo.ProdusCulinar;

public class CosCumparaturiDAO {
	
	public static ArrayList<Integer> getAll() throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		String query = "select * from cos_cumparaturi";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			int idProdus = rs.getInt("id_produs");
			
			result.add(idProdus);
		}
		
		return result;
	}

	public static void insert(ProdusCulinar p) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		
		String sql = "insert into cos_cumparaturi(id_produs)" +
		"value (" + p.getId() + ")";

		
		Statement stmt = conn.createStatement();
		int rowsInserted = stmt.executeUpdate(sql);

		if (rowsInserted > 0) {
			System.out.println("Un nou produs a fost adaugat in cos!");
		}
	}
	
	
	public static void delete(int id) throws SQLException {
		
		String sql = "DELETE FROM cos_cumparaturi WHERE id_produs=" + id;
		
		Connection conn = DBHelper.getConnection();

		Statement stmt = conn.createStatement();

		int rowsDeleted = stmt.executeUpdate(sql);
		if (rowsDeleted > 0) {
			System.out.println("Un produs a fost sters din cos!");
		}
	}
}
