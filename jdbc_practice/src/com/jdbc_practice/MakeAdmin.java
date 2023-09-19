package com.jdbc_practice;
import java.util.Scanner;
import java.sql.Connection;

public class MakeAdmin {
	
	// Admin 필드
	private Connection conn;
	private Scanner sc;
	
	// 
	public MakeAdmin(Connection conn, Scanner sc) {
		this.conn = conn;
		this.sc = sc;
		
		new MakeAdmin(this);
	}
	
	// Admin Menu
	public MakeAdmin(MakeAdmin admin) {
		this.conn = admin.getConn();
		this.sc = admin.getSc();
		
		new AdminActivity(admin);
	}

	// Connection 
	public Connection getConn() {
		return conn;
	}	
	// Scanner
	public Scanner getSc() {
		return sc;
	}
}
