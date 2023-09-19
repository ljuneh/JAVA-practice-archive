package com.jdbc_practice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminActivity {
	
	Scanner sc;
	boolean logout = false;
	int choicemenu = -1;
	Mention men = new Mention();
	
	public AdminActivity() {}
	
	public AdminActivity(MakeAdmin admin) {
		adminMenu(admin);
	}
	
	private void adminMenu(MakeAdmin admin) {
		
		while(!logout) {
			choicemenu = chooseMenu(admin);
			
			System.out.printf(men.getTopLine());
			if(0<choicemenu && choicemenu < 3+1) {
				if(choicemenu == 1) {
					System.out.printf(men.getMiddleLine2(), "",men.getAdminMenu1(),"");
					System.out.println(men.getBottomLine());
					
					ProductInfo pi = new ProductInfo();
					logout = pi.ProductInfo_check(admin);
				} 
				else if(choicemenu == 2) {
					System.out.printf(men.getMiddleLine2(), "",men.getAdminMenu2(),"");
					System.out.println(men.getBottomLine());
				
					SalesInfo si = new SalesInfo();
					logout = si.querySalesInfo(admin);
				}
				else if(choicemenu == 3) {
					System.out.printf(men.getMiddleLine2(), "",men.getAdminMenu3(),"");
					System.out.println(men.getBottomLine());
				}
				
			}
			else {
				System.out.println("번호를 다시 입력하세요(1~3)");
			}
		}
		Mention men = new Mention();
		
		Mention.MakeBox1(men, men.getLogout());
		Connection conn = admin.getConn();
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
private int chooseMenu(MakeAdmin admin) {
		
		Scanner sc = admin.getSc();
		
		System.out.println();
		System.out.printf(men.getMiddleLine2(), "",men.getAdminMenu1(),"");
		System.out.printf(men.getMiddleLine2(), "",men.getAdminMenu2(),"");
		System.out.printf(men.getMiddleLine2(), "",men.getAdminMenu3(),"");
		
		int choosemenu = sc.nextInt();
		
		return choosemenu;
	}
}
