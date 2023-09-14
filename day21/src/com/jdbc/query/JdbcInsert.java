package com.jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "project";
	private static String PASS = "ljuneh";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			
			String sqlInsert = "insert into stockinfo(rawmaterialcode, rawmaterialquantity)\r\n"
					+ "values('123457',50)";
			
			String sqlSelect = "select rawmaterialcode, rawmaterialquantity\r\n"
					+ "From stockinfo";
			int iRet = stmt.executeUpdate(sqlInsert);
			if(iRet>=1) {
				rs = stmt.executeQuery(sqlSelect);
				while(rs.next()) {
					System.out.println(rs.getString(1) + "");
					System.out.println(rs.getInt(2));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
