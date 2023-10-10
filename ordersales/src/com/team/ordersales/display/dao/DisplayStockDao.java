package com.team.ordersales.display.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team.ordersales.display.dto.StockInfoDto;
import com.team.ordersales.utils.ConfigureImpl;

public class DisplayStockDao {
	
	public static ArrayList<StockInfoDto> retStockInfoDto() {
		
		String sql = "select r.rawmaterialname, s.rawmaterialquantity\r\n" + 
				"from rawmaterial r, stockinfo s\r\n" + 
				"where r.rawmaterialcode = s.rawmaterialcode";
		
		ArrayList<StockInfoDto> stockInfoDtoArr = new ArrayList<StockInfoDto>();
		
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
				stockInfoDtoArr.add(new StockInfoDto(rs.getString(1), rs.getInt(2)));
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigureImpl.closeConn();
		
		return stockInfoDtoArr;
	}

}
