package com.jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsalesGoodsAdminDAO {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	SqlMention sql = new SqlMention();
	
	// 판매 가능 상품 추가
	public void insertInsalesGoods(MakeAdmin admin, int updateGoodscode) {
		Connection conn = admin.getConn();
		
		String QUERY = sql.getPiQUERY4();
		int flag = 0;
		
		try {
			pstmt = conn.prepareStatement(QUERY);
			pstmt.setInt(1, updateGoodscode);

	        flag = pstmt.executeUpdate();
	        
	        if (pstmt != null) {
	            pstmt.close();
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (flag > 0) return true;
//		else return false;
	}
	
	// 판매 불가 상품 삭제
	public void deleteInsalesGoods(MakeAdmin admin, int updateGoodscode) {
		
		Connection conn = admin.getConn();
		String QUERY = sql.getPiQUERY5();
		int flag = 0;
		
		try {
			pstmt = conn.prepareStatement(QUERY);
	        pstmt.setInt(1, updateGoodscode);

	        flag = pstmt.executeUpdate();
	        
	        if (pstmt != null) {
	            pstmt.close();
	        }	
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (flag > 0) return true;
//		else return false;
	}
}
