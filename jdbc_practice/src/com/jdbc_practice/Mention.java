package com.jdbc_practice;

public class Mention {
	
	private String middleLine1 = "\t│%18s %-31s│\n";
	private String middleLine2 = "\t│%17s %-32s│\n";
	private String topLine = 	"\t┌──────────────────────────────────────────────────┐\n";
	private String bottomLine = "\t└──────────────────────────────────────────────────┘\n";
	
	// Admin Menu
	private String adminMenu1 = "1. Product Info";
	private String adminMenu2 = "2. Show SalesInfo";
	private String adminMenu3 = "3. Manage Stock";
	
	// Login Admin
	private String loginAdmin = "Login Admin";
	
	// Product Goods
	private String pgMenu = "1. Show  2. Change";
	private String chooseInsales = "1. NonSales  2. Sales";
	
	private String selectStartDate = "Start Date(YYYY-MM-DD)";
	private String selectEndDate = "End Date(YYYY-MM-DD)";
	
	private String isLogout = "1. Home 2. Logout";
	
	private String Logout = "Logout Complete";
	
	public String getTopLine() {
		return topLine;
	}
	public String getMiddleLine1() {
		return middleLine1;
	}
	public String getMiddleLine2() {
		return middleLine2;
	}
	public String getBottomLine() {
		return bottomLine;
	}		
	
	public String getAdminMenu1() {
		return adminMenu1;
	}
	public String getAdminMenu2() {
		return adminMenu2;
	}
	public String getAdminMenu3() {
		return adminMenu3;
	}
	
	public String getLoginAdmin() {
		return loginAdmin;
	}
		
	public String getPgMenu() {
		return pgMenu;
	}

	public String getSelectStartDate() {
		return selectStartDate;
	}
	public String getSelectEndDate() {
		return selectEndDate;
	}	
	
	public String getIsLogout() {
		return isLogout;
	}
	
	public String getChooseInsales() {
		return chooseInsales;
	}
	
	public String getLogout() {
		return Logout;
	}
	
	public static void MakeBox1(Mention men, String ment) {
		System.out.printf(men.getTopLine());
		System.out.printf(men.getMiddleLine1(), "", ment);
		System.out.printf(men.getBottomLine());
	}
	
	public static void MakeBox2(Mention men, String ment) {
		System.out.printf(men.getTopLine());
		System.out.printf(men.getMiddleLine2(), "", ment);
		System.out.printf(men.getBottomLine());
	}
}
