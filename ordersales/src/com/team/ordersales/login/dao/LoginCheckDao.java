package com.team.ordersales.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.ordersales.utils.ConfigureImpl;

public class LoginCheckDao {
	
	public static boolean loginCheck(String sParaId, String sParaPassword) {
		int count = 0;
		String sql = "select id from loginuser where id = ? and password = ?";
		
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
			pstmt.setString(1, sParaId);
			pstmt.setString(2, sParaPassword);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				++count;
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConfigureImpl.closeConn();
		
		
		if(count>0) {
			return true;
		}
		
		return false;
	}
	
	public static String retRole(String id) {
		String role = null;
		String sql = "select role\r\n" + 
				"from loginuser\r\n" + 
				"where id = ?";
		
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
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				role = rs.getString(1);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConfigureImpl.closeConn();
		
		return role;
	}

}
