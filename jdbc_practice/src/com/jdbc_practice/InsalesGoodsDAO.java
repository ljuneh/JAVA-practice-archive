package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsalesGoodsDAO {
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "project";
	private static String PASS = "ljuneh";
	private static String QUERY1 = "select seq, goodscode, goodsname, rawmaterialcode, rawmaterialquantity\r\n"
			+ "from insalesgoods";
	private static String QUERY2 = "select i.seq, i.goodscode, i.goodsname, r.rawmaterialname, i.rawmaterialquantity\r\n"
			+ "from insalesgoods i, rawmaterial r\r\n"
			+ "where i.rawmaterialcode = r.rawmaterialcode";
	private static String QUERY3 = "select *\r\n"
			+ "from insalesgoods\r\n"
			+ "where goodscode = ?";
	
	

	
	public InsalesGoodsDAO() {}
	
	
	
	public static ArrayList<InsalesGoods> retInsalesGoodsArr() {
		ArrayList<InsalesGoods> inSalesGoodsArr = new ArrayList<InsalesGoods>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY1);
			
			while(rs.next()) {
				InsalesGoods insalesGoods = new InsalesGoods();
				insalesGoods.setSeq(rs.getInt(1));
				insalesGoods.setGoodsCode(rs.getString(2));
				insalesGoods.setGoodsName(rs.getString(3));
				insalesGoods.setRawMaterialCode(rs.getString(4));
				insalesGoods.setRawMaterialQuantity(rs.getInt(5));
				
				inSalesGoodsArr.add(insalesGoods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inSalesGoodsArr;
	}
	
	public static ArrayList<ShowInsales> retShowInsalesArr() {
		ArrayList<ShowInsales> showInsalesArr = new ArrayList<ShowInsales>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY2);
			
			while(rs.next()) {
				ShowInsales showInsales = new ShowInsales();
				showInsales.setSeq(rs.getInt(1));
				showInsales.setGoodsCode(rs.getString(2));
				showInsales.setGoodsName(rs.getString(3));
				showInsales.setRawMaterialName(rs.getString(4));
				showInsales.setRawMaterialQuantity(rs.getInt(5));
				
				showInsalesArr.add(showInsales);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return showInsalesArr;
	}
	
	public static boolean searchInsalesGoodsByCode(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isSearched = false;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(QUERY3);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			isSearched = rs.next();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSearched;
	}
	

}
