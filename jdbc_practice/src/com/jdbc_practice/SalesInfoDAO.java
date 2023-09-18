package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesInfoDAO {
	private static String QUERY1 = "truncate table salesinfo";
	private static String QUERY2 = "INSERT INTO salesinfo(goodscode, orderquantity) VALUES(?, ?)";
	private static String QUERY3 = "select goodscode, orderquantity, salesdate\r\n"
			+ "from salesinfo\r\n"
			+ "where goodscode = ?";
	private static String QUERY4 = "update salesinfo\r\n"
			+ "set orderquantity = ?\r\n"
			+ "where goodscode = ?";
	
	
	public SalesInfoDAO() {}
	
	public static void initSalesInfo() {
		Connection conn = ConfigureImpl.getConnObject();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			int intInit = stmt.executeUpdate(QUERY1);
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SalesInfoEntity retSearchedSalesInfoByCode(String code) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		SalesInfoEntity salesInfo = new SalesInfoEntity();
		
		
		boolean isSearched = false;
		try {
			pstmt = conn.prepareStatement(QUERY3);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			isSearched = rs.next();
			if(isSearched) {
				System.out.println("salesinfo searched");
				salesInfo.setGoodsCode(rs.getString(1));
				salesInfo.setOrderQuantity(rs.getInt(2));
				salesInfo.setSalesDate(rs.getDate(3));
			} else {
				System.out.println("salesinfo not searched");
				return null;
			}
				
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salesInfo;
	}
	
	public static void insertSalesInfo(OrderInfoEntity orderInfo) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(QUERY2);
			pstmt.setString(1, orderInfo.getGoodsCode());
			pstmt.setInt(2, orderInfo.getOrderQuantity());
			
			int iRet = pstmt.executeUpdate();
			
			if(iRet>=1) {
				System.out.println("상품코드가 "+orderInfo.getGoodsCode()+" 인 상품을 "+orderInfo.getOrderQuantity()+"수량만큼 insert");
			} else {
				System.out.println("insert 실패");
			}
			
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateSalesInfoByCode(String code, int quantity) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(QUERY4);
			pstmt.setInt(1, quantity);
			pstmt.setString(2, code);
			
			int iRet = pstmt.executeUpdate();
			
			if(iRet>=1) {
				System.out.println("상품코드가 "+code+" 인 상품의 수량을 "+quantity+"로 업데이트");
			} else {
				System.out.println("상품 추가 실패");
			}
			
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
