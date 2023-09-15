package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesInfoDAO {
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "project";
	private static String PASS = "ljuneh";
	private static String QUERY1 = "truncate table salesinfo";
	private static String QUERY2 = "INSERT INTO salesinfo(goodscode, orderquantity) VALUES(?, ?)";
	
	public SalesInfoDAO() {}
	
	public static void initSalesInfo() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			int intInit = stmt.executeUpdate(QUERY1);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertSalesInfo(OrderInfo orderInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(QUERY2);
			pstmt.setString(1, orderInfo.getGoodsCode());
			pstmt.setInt(2, orderInfo.getOrderQuantity());
			
			int iRet = pstmt.executeUpdate();
			
			if(iRet>=1) {
				System.out.println("상품코드가 "+orderInfo.getGoodsCode()+" 인 상품을 "+orderInfo.getOrderQuantity()+"수량만큼 insert");
			} else {
				System.out.println("insert 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
