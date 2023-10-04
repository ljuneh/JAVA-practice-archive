package com.team.ordersales.display.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team.ordersales.display.dto.InsalesGoodsDto;
import com.team.ordersales.utils.ConfigureImpl;

public class DisplayGoodsDao {
	
	public static ArrayList<InsalesGoodsDto> retInsalesGoodsDto() {
		String sql = "select seq, goodscode, goodsname, rawmaterialcode, rawmaterialquantity, price\r\n" + 
				"from insalesgoods";
		
		ArrayList<InsalesGoodsDto> insalesGoodsDtoArr = new ArrayList<InsalesGoodsDto>();
		
		
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

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				insalesGoodsDtoArr.add(new InsalesGoodsDto(rs.getString("goodscode"), rs.getString("goodsname"), rs.getInt("price")));
				
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return insalesGoodsDtoArr;
	}

}
