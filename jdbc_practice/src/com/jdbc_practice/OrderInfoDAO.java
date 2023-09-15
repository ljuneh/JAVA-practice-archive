package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderInfoDAO {
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "project";
	private static String PASS = "ljuneh";
	private static String QUERY1 = "select seq, goodsCode, orderQuantity, orderConfirmed, TO_CHAR(orderDate, 'YY/MM/DD'), userid\r\n"
			+ "from orderinfo\r\n"
			+ "where goodscode = ?\r\n"
			+ "and userid = ?\r\n"
			+ "order by seq asc";
	private static String QUERY2 = "update orderinfo "
			+ "set orderconfirmed = ?, orderdate = sysdate "
			+ "where goodscode = ?\r\n"
			+ "and userid = ?";
	private static String QUERY3 = "select goodsCode, orderQuantity, orderConfirmed, TO_CHAR(orderDate, 'YY/MM/DD')\r\n"
			+ "from orderinfo";
	private static String COUNT_QUERY = "select max(seq)\r\n"
			+ "from orderinfo";
	private static String QUERY4 = "INSERT INTO orderinfo(seq, goodscode, orderquantity, userid) VALUES(?, ?, ?, ?)";

	
	public OrderInfoDAO() {}
	
	public static int currentSeq() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int currentseq = 0;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(COUNT_QUERY);
			
			if(rs.next()) {
				currentseq = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentseq;
	}
	
	public static void insertOrderInfo(String goodscode, int orderquantity, String userid) {
		int currentSeq = currentSeq();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateOrderConfirmedByCode(String code, String confirmed, String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int searchOrderInfoByCode(String code, String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isSearched = false;
		int iRet = 0;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt = conn.prepareStatement(QUERY1);
			pstmt.setString(1, code);
			pstmt.setString(2, userId);
			
//			rs = pstmt.executeQuery();
//			
//			isSearched = rs.next();
			
			iRet = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return isSearched;
		return iRet;
	}
	
	public static ArrayList<OrderInfo> retOrderInfoArr() {
		ArrayList<OrderInfo> orderInfoArr = new ArrayList<OrderInfo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY3);
			
			while(rs.next()) {
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setGoodsCode(rs.getString(1));
				orderInfo.setOrderQuantity(rs.getInt(2));
				orderInfo.setOrderConfirmed(rs.getString(3));
				orderInfo.setOrderDate(rs.getString(4));
				
				orderInfoArr.add(orderInfo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderInfoArr;
	}

}
