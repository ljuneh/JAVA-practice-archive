package com.team.ordersales.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.ordersales.utils.ConfigureImpl;

public class StockInfoDao {
	
	private static String retRawCodeByCode(String code) {
		String sql = "select rawmaterialcode\r\n"
				+ "from ordergoods\r\n"
				+ "where goodscode = ?";
		String rawCode = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rawCode = rs.getString(1);
				
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rawCode;
	}
	
	
	public static int updateStockInfoByGoodsCode(String code, int quantity) {
		String sql = "update stockinfo set rawmaterialquantity = ?\r\n"
				+ "where rawmaterialcode = ?";
		int iRet = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rawCode = retRawCodeByCode(code);
		
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quantity);
			pstmt.setString(2, rawCode);
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
