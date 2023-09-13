package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunMain {
	
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "project";
	private static String PASS = "ljuneh";
	private static String QUERY1 = "SELECT seq, goodscode, goodsname FROM ordergoods";
	private static String QUERY2
//	= "SELECT goodscode, orderdate "
//			+ "FROM orderinfo";
	= "SELECT goodscode, TO_CHAR(orderdate, 'YY/MM/DD') "
			+ "FROM orderinfo";
	
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
//			rs = stmt.executeQuery(QUERY1);
//			
//			while(rs.next()) {
//				System.out.print("순번: " + rs.getInt("seq"));
//				System.out.print(" 상품코드: " + rs.getString("goodscode"));
//				System.out.println(" 상품명: " + rs.getString("goodsname"));
//			}
			
//			rs.close();
			
			queryOrdergoods(stmt, rs);
			queryOrderinfo(stmt, rs);
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
			System.out.print("순번: " + rs.getInt(1));
			System.out.print(" 상품코드: " + rs.getString("goodscode"));
			System.out.println(" 상품명: " + rs.getString(3));
		}
		
		rs.close();
	}
	
	public static void queryOrderinfo(
			Statement stmt, ResultSet rs) throws SQLException {
		// 질의 수행
		rs = stmt.executeQuery(QUERY2);
		while(rs.next()) {
			System.out.print("상품코드: " + rs.getString("goodscode"));
//			System.out.println("주문일자: " + rs.getDate(2));
			System.out.println(" 주문일자: " + rs.getString(2));			
		}
	}
	
	
}
