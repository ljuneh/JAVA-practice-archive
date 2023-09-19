package com.jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderInfoUserDAO {
	private static String QUERY1 = "select seq, goodsCode, orderQuantity, orderConfirmed, orderDate, userid\r\n"
			+ "from orderinfo\r\n"
			+ "where goodscode = ?\r\n"
			+ "and userid = ?\r\n"
			+ "order by seq asc";
	private static String QUERY2 = "update orderinfo "
			+ "set orderconfirmed = ?, orderdate = sysdate "
			+ "where goodscode = ?\r\n"
			+ "and userid = ?";
	private static String QUERY3 = "select goodsCode, orderQuantity, orderConfirmed, orderDate\r\n"
			+ "from orderinfo";
	private static String COUNT_QUERY = "select max(seq)\r\n"
			+ "from orderinfo";
	private static String QUERY4 = "INSERT INTO orderinfo(seq, goodscode, orderquantity, userid) VALUES(?, ?, ?, ?)";

	
	public OrderInfoUserDAO() {}
	
	public static int currentSeq() {
		Connection conn = ConfigureImpl.getConnObject();
		Statement stmt = null;
		ResultSet rs = null;
		
		int currentseq = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(COUNT_QUERY);
			
			if(rs.next()) {
				currentseq = rs.getInt(1);
			}
			
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentseq;
	}
	
	public static void insertOrderInfo(String goodscode, int orderquantity, String userid) {
		int currentSeq = currentSeq();
		
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(QUERY4);
			pstmt.setInt(1, ++currentSeq);
			pstmt.setString(2, goodscode);
			pstmt.setInt(3, orderquantity);
			pstmt.setString(4, userid);
			
			int iRet = pstmt.executeUpdate();
			if(iRet>=1) {
				System.out.println("주문 선택 성공");
			} else {
				System.out.println("주문 선택 실패");
			}
			
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateOrderConfirmedByCode(String code, String confirmed, String userid) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY2);
			pstmt.setString(1, confirmed);
			pstmt.setString(2, code);
			pstmt.setString(3, userid);
			int iRet = 0;
			
			if(searchOrderInfoByCode(code, userid)>=1) {
				System.out.println("코드 "+code+" 찾음.");
				iRet = pstmt.executeUpdate();
				conn.commit();
			} else {
				System.out.println("코드 없음. 올바른 코드를 입력하세요");
			}
			if(iRet>=1) {
				System.out.println("업데이트 완료");
				System.out.println("업데이트 개수: "+iRet);
				searchOrderInfoByCode(code, userid);
			} else {
				
			}
			
			
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int searchOrderInfoByCode(String code, String userId) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		boolean isSearched = false;
		int iRet = 0;
		try {
			pstmt = conn.prepareStatement(QUERY1);
			pstmt.setString(1, code);
			pstmt.setString(2, userId);
			
//			rs = pstmt.executeQuery();
//			
//			isSearched = rs.next();
			
			iRet = pstmt.executeUpdate();
			
			
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return isSearched;
		return iRet;
	}
	
	public static ArrayList<OrderInfoEntity> retOrderInfoArr() {
		ArrayList<OrderInfoEntity> orderInfoArr = new ArrayList<OrderInfoEntity>();
		
		Connection conn = ConfigureImpl.getConnObject();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY3);
			
			while(rs.next()) {
				OrderInfoEntity orderInfo = new OrderInfoEntity();
				orderInfo.setGoodsCode(rs.getString(1));
				orderInfo.setOrderQuantity(rs.getInt(2));
				orderInfo.setOrderConfirmed(rs.getString(3));
				orderInfo.setOrderDate(rs.getDate(4));
				
				orderInfoArr.add(orderInfo);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderInfoArr;
	}

}
