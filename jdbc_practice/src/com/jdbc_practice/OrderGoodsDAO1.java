package com.jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderGoodsDAO1 {
	
	private static String QUERY1 = "select rawmaterialquantity\r\n"
			+ "from ordergoods\r\n"
			+ "where goodscode = ?";
	
	private static String QUERY2 = "select rawmaterialcode\r\n"
			+ "from ordergoods\r\n"
			+ "where goodscode = ?";
	
	public OrderGoodsDAO1() {}
	
	public static int retRawQuantityInOrderGoods(String code) {
		int quantity = 0;
		
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(QUERY1);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				quantity = rs.getInt(1);
				
			} else {
				System.out.println("사용될 원재료 수량 가져오기 실패");
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return quantity;
		
	}
	
	public static String retRawCodeByCode(String code) {
		String rawCode = "";
		
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(QUERY2);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rawCode = rs.getString(1);
				
			} else {
				System.out.println("사용될 원재료 수량 가져오기 실패");
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rawCode;
	}

}
