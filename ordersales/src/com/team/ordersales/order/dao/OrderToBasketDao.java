package com.team.ordersales.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.team.ordersales.order.dto.OrderToBasketDto;
import com.team.ordersales.utils.ConfigureImpl;

public class OrderToBasketDao {
	
	private static int currentSeq() {
		String COUNT_QUERY = "select max(seq)\r\n"
				+ "from orderinfo";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int currentseq = 0;
		
		Connection conn = ConfigureImpl.getConnObject();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(COUNT_QUERY);
			
			if(rs.next()) {
				currentseq = rs.getInt(1);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currentseq;
	}
	
	public static int insertOrderInfo(OrderToBasketDto orderToBasketDto, String id) {
		String sql = "INSERT INTO orderinfo(seq, goodscode, orderquantity, id) VALUES(?, ?, ?, ?)";
		
		int iRet = 0;
		
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			int currentSeq = currentSeq();
			System.out.println(currentSeq);
			
			pstmt.setInt(1, ++currentSeq);
			pstmt.setString(2, orderToBasketDto.getCode());
			pstmt.setInt(3, orderToBasketDto.getQuantity());
			pstmt.setString(4, id);
			
			iRet = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigureImpl.closeConn();
		
		return iRet;
	}
	
	public static int updateConfirmedBySeq(int seq, String confirmed) {
		String sql = "update orderinfo\r\n" + 
				"set orderconfirmed = ?\r\n" + 
				"where seq = ?";
		
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
			pstmt.setString(1, confirmed);
			pstmt.setInt(2, seq);
			
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
