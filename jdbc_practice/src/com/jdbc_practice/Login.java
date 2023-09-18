package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	private static String QUERY1 = "select userid, userpassword, role\r\n"
			+ "from userinfo\r\n"
			+ "where userid = ?";
	
	private static int loginCount = 3;
	
	public Login() {}
	
	public static void enter(Scanner sc) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginEntity loginEntity = null;
		
		boolean isIdPassed = false;
		boolean isPasswordPassed = false;
		char role = 0;
		
		System.out.print("아이디 입력 >>> ");
		String enteredId = sc.nextLine();
		
		System.out.print("비밀번호 입력 >>> ");
		String enteredPassword = sc.nextLine();
		
		
		try {
			pstmt = conn.prepareStatement(QUERY1);
			pstmt.setString(1, enteredId);
			loginEntity = searchId(conn, pstmt, rs, enteredId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		if((loginEntity==null) && (--loginCount>0)) {
			System.out.println("처음 로그인으로 돌아옵니다. 로그인 카운트가 "+loginCount+"만큼 남았습니다");
			enter(sc);
			return;
		} else if((loginEntity!=null) && (loginCount>0)) {
			isIdPassed = true;
			
		} else if(loginCount == 0) {
			System.out.println("로그인 카운트 제한 횟수 초과");
			return;
		}
		
		try {
			if(enteredPassword.equals(loginEntity.getUserPassword())) {
				isPasswordPassed = true;
				role = loginEntity.getRole().charAt(0);
			} else if((--loginCount>0)) {
				System.out.println("잘못된 비밀번호를 입력했습니다. " + "로그인 카운트가 "+loginCount+"만큼 남았습니다");
				enter(sc);
				return;
			} else if(loginCount == 0) {
				System.out.println("로그인 카운트 제한 횟수 초과");
				return;
			}
			
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end id and password check
		
	
		
		
		if(isIdPassed&&isPasswordPassed&&(role=='a')) {
			System.out.println("로그인 성공");
			System.out.println("관리자 권한으로 로그인합니다");
		} else if(isIdPassed&&isPasswordPassed&&(role=='u')) {
			System.out.println("로그인 성공");
			System.out.println("사용자 권한으로 로그인합니다");
			
			UserActivity userActivity = new UserActivity(sc,enteredId);
			
			
		}
		
	}
	
	private static LoginEntity searchId(Connection conn, PreparedStatement pstmt, ResultSet rs, String enteredId) {
		LoginEntity loginEntity = new LoginEntity();
		try {
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				loginEntity.setUserId(rs.getString(1));
				loginEntity.setUserPassword(rs.getString(2));
				loginEntity.setRole(rs.getString(3));
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
			} else {
				System.out.println("아이디가 존재하지 않습니다");
				return null;
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return loginEntity;
	}
	
	
}
