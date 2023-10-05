package com.team.ordersales.display.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team.ordersales.display.entity.InsalesGoodsEntity;
import com.team.ordersales.utils.ConfigureImpl;

public class DisplayGoodsDao {
	
	public static ArrayList<InsalesGoodsEntity> retInsalesGoodsEntity() {
		String sql_insalesgoods = "select seq, goodscode, goodsname, rawmaterialcode, rawmaterialquantity, price\r\n" + 
				"from insalesgoods";
		
		ArrayList<InsalesGoodsEntity> insalesGoodsEntityArr = new ArrayList<InsalesGoodsEntity>();
		
		
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
			pstmt = conn.prepareStatement(sql_insalesgoods);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				insalesGoodsEntityArr.add
				(new InsalesGoodsEntity
						(rs.getInt("seq"), rs.getString("goodscode"), 
						rs.getString("goodsname"), rs.getString("rawmaterialcode"),
						rs.getInt("rawmaterialquantity"), rs.getInt("price")));
				
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return insalesGoodsEntityArr;
	}
	
	public static int retCurrentRawQuantity(String code) {
		String sql = "select s.rawmaterialquantity\r\n" + 
				"from stockinfo s, insalesgoods i\r\n" + 
				"where s.rawmaterialcode = i.rawmaterialcode\r\n" + 
				"and i.goodscode = ?";
		
		int quantity = 0;
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
				quantity = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return quantity;
	}

}
