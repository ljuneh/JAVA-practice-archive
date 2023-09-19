package com.jdbc_practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SalesInfoAdminDAO {
	
	public ArrayList<SalesInfoEntity> getList(MakeAdmin admin, Date sDate, Date eDate) {
		
		ArrayList<SalesInfoEntity> sList = new ArrayList<>();
		SqlMention sql = new SqlMention();
		
		String QUERY = sql.getsiQUERY1();
		Connection conn = admin.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(QUERY);
 
			pstmt.setDate(1, sDate);
			pstmt.setDate(2, eDate);
			 
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SalesInfoEntity sET = new SalesInfoEntity();
				sET.setGoodsCode(rs.getString(1));
				sET.setOrderQuantity(rs.getInt(2));
				sET.setSalesDate(rs.getDate(3));
			
				sList.add(sET);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return sList;
	}
}
