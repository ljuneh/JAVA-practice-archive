package com.team.ordersales.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.ordersales.login.dto.RegisterMemberDto;
import com.team.ordersales.utils.ConfigureImpl;

public class RegisterMemberDao {
	public static boolean regiMember(RegisterMemberDto registerMemberDto) {
		int count = 0;
		String sql = "insert into loginuser(id, password, role, addr) values(?,?,?,?)";
		
		String sql_select = "select id from loginuser where id = ?";
		
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
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setString(1, registerMemberDto.getId());
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				return false;
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, registerMemberDto.getId());
			pstmt.setString(2, registerMemberDto.getPassword());
			pstmt.setString(3, registerMemberDto.getRole());
			pstmt.setString(4, registerMemberDto.getAddr());
			count = pstmt.executeUpdate();
			
			
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

}
