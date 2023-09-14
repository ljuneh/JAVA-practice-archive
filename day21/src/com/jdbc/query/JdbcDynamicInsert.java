package com.jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDynamicInsert {
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "project";
	private static String PASS = "ljuneh";
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String rawmatcode = "342346";
			String sqlInsert = "insert into stockinfo(rawmaterialcode, rawmaterialquantity)\r\n"
					+ "values(?,?)";
			
			String sqlSelect = "select rawmaterialcode, rawmaterialquantity\r\n"
					+ "From stockinfo WHERE rawmaterialcode = ?";
			
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, rawmatcode);
			pstmt.setInt(2, 100);
			
			int iRet = pstmt.executeUpdate();
			if(iRet>=1) {
				pstmt = conn.prepareStatement(sqlSelect);
				pstmt.setString(1, rawmatcode);
				rs = pstmt.executeQuery();
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
