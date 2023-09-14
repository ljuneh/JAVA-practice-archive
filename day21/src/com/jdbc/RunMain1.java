package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunMain1 {
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "project";
	private static String PASS = "ljuneh";
	private static String QUERY1 = "select s.goodscode, i.goodsname, s.orderquantity, r.rawmaterialname, r.rawmaterialtype\r\n"
			+ "from salesinfo s, insalesgoods i, rawmaterial r\r\n"
			+ "where s.goodscode = i.goodscode\r\n"
			+ "and i.rawmaterialcode = r.rawmaterialcode";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 연결 설정
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// 구문객체 생성
			stmt = conn.createStatement();
			// 질의 수행
			
			queryOrdergoods(stmt, rs);
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end try/catch	
	} // end main
	
	public static void queryOrdergoods(
			Statement stmt, ResultSet rs) throws SQLException {
		// 질의 수행
		rs = stmt.executeQuery(QUERY1);
		while(rs.next()) {
			System.out.print("상품명: " + rs.getString("goodsname"));
			System.out.print(" 상품수량: " + rs.getInt("orderquantity"));
			System.out.print(" 원재료명: " + rs.getString("rawmaterialname"));
			System.out.println(" 원재료 타입: " + rs.getString("rawmaterialtype"));
		}
		
		rs.close();
	}
	
}
