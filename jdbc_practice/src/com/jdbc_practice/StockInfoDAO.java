package com.jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StockInfoDAO {
	private static String QUERY1 = "update stockinfo set rawmaterialquantity = 50";
	private static String QUERY2 = "update stockinfo set rawmaterialquantity = ?\r\n"
			+ "where rawmaterialcode = ?";
	private static String QUERY3 = "select rawmaterialquantity\r\n"
			+ "from stockinfo\r\n"
			+ "where rawmaterialcode = ?";
	
	public StockInfoDAO() {};
	
	public static void initStockInfo() {
		Connection conn = ConfigureImpl.getConnObject();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int iRet = stmt.executeUpdate(QUERY1);
			if(iRet>=1) {
				System.out.printf("\t│%18s"+"초기화 성공","");
				System.out.println();
			} else {
				System.out.printf("\t│%18s"+"초기화 실패","");
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void updateStockInfo(String code, int quantity) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(QUERY2);
			pstmt.setInt(1, quantity);
			pstmt.setString(2, code);
			int iRet = pstmt.executeUpdate();
			
			if(iRet>=1) {
				System.out.println("update 성공");
			} else {
				System.out.println("update 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getStockInfoQuantity(String code) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int quantity = 0;
		
		try {
			pstmt = conn.prepareStatement(QUERY3);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				quantity = rs.getInt(1);
			} else {
				System.out.println("get 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return quantity;
		
	}

}
