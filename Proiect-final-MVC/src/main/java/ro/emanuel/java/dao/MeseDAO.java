package ro.emanuel.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.pojo.Masa;

public class MeseDAO {

	public static ArrayList<Masa> getAll() throws SQLException {
		
		Masa m = null;
		
		Connection conn = DBHelper.getConnection();
		
		ArrayList<Masa> mese = new ArrayList<Masa>();
		
		String query = "select * from mese";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while(rs.next()) {
			m = new Masa();
			m.setId(rs.getInt("id"));
			m.setNumarLocuri(rs.getInt("numar_locuri"));
			
			mese.add(m);
		}
		
		return mese;
	}
	
	public static void insert(Masa m) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		
		String sql = "insert into mese(numar_locuri)" +
		"value (" + m.getNumarLocuri() + ")";

		
		Statement stmt = conn.createStatement();
		int rowsInserted = stmt.executeUpdate(sql);

		if (rowsInserted > 0) {
			System.out.println("O noua masa a fost introdusa cu succes!");
		}

	}
}
