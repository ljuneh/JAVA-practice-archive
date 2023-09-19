package com.jdbc_practice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesInfo {
	
	ArrayList<SalesInfoEntity> sET = new ArrayList<>();

	private static boolean logout = false;
	Mention men = new Mention();
	
	public SalesInfo(){}
	
	public SalesInfo(MakeAdmin admin) {
		querySalesInfo(admin);
	}
   
   public Boolean querySalesInfo(MakeAdmin admin) {
	   Scanner sc = admin.getSc();

	   System.out.printf(men.getMiddleLine2(), "",men.getSelectStartDate());
	   Date sDate = Date.valueOf(sc.next());
	   
	   System.err.printf(men.getMiddleLine2(), "", men.getSelectEndDate());
	   Date eDate = Date.valueOf(sc.next());
	       
	   SalesInfoAdminDAO sDAO = new SalesInfoAdminDAO();
	   
	   sET = sDAO.getList(admin, sDate, eDate);
	   
	   if(sET.size() == 0) {
		   System.out.println("조회 내역이 없습니다.");
	   } else {
		   printList(sET);
	   }
	   
	   Mention.MakeBox2(men, men.getIsLogout());
	  
	   int comeBack = sc.nextInt();
	  
	   if(comeBack == 2) logout = true;
	  
	   return logout;
   }
   
   private void printList(ArrayList<SalesInfoEntity> sET) {
	   System.out.println();
	   System.out.println("\t======================상품 조회======================");
       Date pfd = null;
       
       for(SalesInfoEntity dto:sET) {
    	   Date fd = dto.getSalesDate();
    	   
    	   if(pfd != null && pfd.compareTo(fd) !=0)
    	   {System.out.println("\t───────────────────────────────────────────────────");}
    	   System.out.println(dto.toString());
    	   
    	   pfd = fd;
       }
   }   
}
