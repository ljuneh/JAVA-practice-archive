package com.team.ordersales.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.team.ordersales.login.entity.LoginUserEntity;
import com.team.ordersales.utils.ConfigureImpl;

public class RetrieveMemberDao {
	public static List<LoginUserEntity> getMemberList(String id) {
		String sqlRole = "select role from loginuser where id = ?";
		String sqlUserRole = "select role from loginuser where id = ?";
		String sqlAdminRole = "select role from loginuser where id = ?";
		
		
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
			pstmt = conn.prepareStatement(sqlRole);
			
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConfigureImpl.closeConn();
		
		return null;
	}

}
