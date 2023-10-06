package com.team.ordersales.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.ordersales.order.entity.OrderInfoEntity;
import com.team.ordersales.sales.entity.SalesInfoEntity;
import com.team.ordersales.utils.ConfigureImpl;

public class SalesInfoDao {
	
	public static SalesInfoEntity retSearchedSalesInfoByCode(String code) {
		String sql = "select goodscode, orderquantity, salesdate\r\n"
				+ "from salesinfo\r\n"
				+ "where goodscode = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		SalesInfoEntity salesInfoEntity = new SalesInfoEntity();
		
		
		boolean isSearched = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			isSearched = rs.next();
			if(isSearched) {
				salesInfoEntity.setGoodsCode(rs.getString(1));
				salesInfoEntity.setOrderQuantity(rs.getInt(2));
				salesInfoEntity.setSalesDate(rs.getDate(3));
			} else {
				return null;
			}
				
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigureImpl.closeConn();
		
		return salesInfoEntity;
	}
	
	public static int insertSalesInfo(OrderInfoEntity orderInfo) {
		String sql = "INSERT INTO salesinfo(goodscode, orderquantity) VALUES(?, ?)";
		int iRet = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderInfo.getGoodsCode());
			pstmt.setInt(2, orderInfo.getOrderQuantity());
			
			iRet = pstmt.executeUpdate();
			
			
			
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigureImpl.closeConn();
		
		return iRet;
	}
	
	public static int updateSalesInfoByCode(String code, int quantity) {
		String sql = "update salesinfo\r\n"
				+ "set orderquantity = ?\r\n"
				+ "where goodscode = ?";
		int iRet = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quantity);
			pstmt.setString(2, code);
			
			iRet = pstmt.executeUpdate();
			
			
			
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigureImpl.closeConn();
		
		
		return iRet;
	}

}
