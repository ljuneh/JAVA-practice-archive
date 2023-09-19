package com.jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdergoodsAdminDAO {

	SqlMention sql = new SqlMention();
	
	public ArrayList<OrderGoodsET> getList_ViewInfo(MakeAdmin admin, int pickInSales) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = admin.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 
		ArrayList<OrderGoodsET> list = new ArrayList<>();

		try {

			//실행할 sql 문의 뼈대 미리 준비하기
			String QUERY = sql.getPiQUERY1();
			
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(QUERY);
			
			if(pickInSales == 1) {
				pstmt.setString(1, "N");
			} else {
				pstmt.setString(1, "Y");
			}

			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// cursor 가 위치한 곳의 칼럼 데이터를 빼오기
				OrderGoodsET ordergoodsET = new OrderGoodsET();
				ordergoodsET.setGOODSCODE(rs.getString(1));
				ordergoodsET.setGOODSNAME(rs.getString(2));
				ordergoodsET.setRAWMATERIALCODE(rs.getString(3));
				ordergoodsET.setRAWMATERIALQUANTITY(rs.getInt(4));
				ordergoodsET.setINSALES(rs.getString(5));
				list.add(ordergoodsET);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean check_TorF(MakeAdmin admin, int updateGoodscode) { // 이건 짜피 데이터 베이스에 있는지 없는지만 확인할건데 리턴타입을 bool로 해도 됌?

		Connection conn = admin.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean tOrF = false;
		
		try {

			String QUERY = sql.getPiQUERY3();

			pstmt = conn.prepareStatement(QUERY);
			pstmt.setInt(1, updateGoodscode);
			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 성공
	            String insale111 = rs.getString("INSALES");
	            // 현재 상태를 표시
	            System.out.printf("\t<< 현재 판매 여부: %s >>\n", insale111);
				
	            tOrF = true;
			} else {
				// 실패
				tOrF = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return tOrF;
	}

	public boolean update(MakeAdmin admin, int updateGoodscode, String request) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = admin.getConn();
		
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//실행할 sql 문의 뼈대 미리 준비하기
			String QUERY = sql.getPiQUERY2();
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(QUERY);
			
			//? 에 필요한값 바인딩하기 
			pstmt.setString(1, request);
			pstmt.setInt(2, updateGoodscode);
			//sql 문 실행하기 (INSERT, UPDATE, DELETE)
			flag = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		if (flag > 0) {
			//성공
			return true;
		} else {
			//실패
			return false;
		}
	}
}