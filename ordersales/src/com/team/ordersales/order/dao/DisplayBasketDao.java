package com.team.ordersales.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team.ordersales.order.entity.OrderInfoEntity;
import com.team.ordersales.utils.ConfigureImpl;

public class DisplayBasketDao {
	
	public static ArrayList<OrderInfoEntity> retOrderInfoEntity(String id, String confirmed) {
		String sql = "select seq, goodscode, orderquantity, orderconfirmed, orderdate, id\r\n" + 
				"from orderinfo\r\n" + 
				"where id = ?\r\n" + 
				"and orderconfirmed = ?\r\n" + 
				"ORDER BY seq asc";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<OrderInfoEntity> orderInfoEntityArr = new ArrayList<OrderInfoEntity>();
		
		
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, confirmed);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
				orderInfoEntity.setSeq(rs.getInt(1));
				orderInfoEntity.setGoodsCode(rs.getString(2));
				orderInfoEntity.setOrderQuantity(rs.getInt(3));
				orderInfoEntity.setOrderConfirmed(rs.getString(4));
				orderInfoEntity.setOrderDate(rs.getDate(5));
				orderInfoEntity.setId(rs.getString(6));
				
				orderInfoEntityArr.add(orderInfoEntity);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConfigureImpl.closeConn();
		
		
		return orderInfoEntityArr;
	}
	
	public static String retGoodsNameByCode(String code) {
		String name = "";
		String sql = "select goodsname\r\n" + 
				"from ordergoods\r\n" + 
				"where goodscode = ?";
		
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
				name = rs.getString(1);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigureImpl.closeConn();
		
		return name;
	}
	
	public static int retPriceByCode(String code) {
		int price = 0;
		
		String sql = "select price\r\n" + 
				"from ordergoods\r\n" + 
				"where goodscode = ?";
		
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
				price = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigureImpl.closeConn();
		
		return price;
	}

}
