package com.jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductInfo {
	Mention men = new Mention();
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Boolean logout = false;
	
	SqlMention sql = new SqlMention();
	InsalesGoodsAdminDAO iDAO = new InsalesGoodsAdminDAO();
	OrdergoodsAdminDAO oDAO = new OrdergoodsAdminDAO();
	
	ArrayList<OrderGoodsEntity> oET = new ArrayList<>();
	
	public ProductInfo() {}
	
	public ProductInfo(MakeAdmin admin) {
		ProductInfo_check(admin);
	}
		
	public Boolean ProductInfo_check(MakeAdmin admin) {
		Scanner sc = admin.getSc();
		
		try {
			
			System.out.printf(men.getMiddleLine2(), "", men.getPgMenu());
//			System.out.println("1. 보기  ||||  2. 변경");
			sc.nextLine();
			int pick = sc.nextInt();
			
			if(pick == 1) {
				ViewProductInfo(admin, pstmt, rs);
			}
			else {
				ChangeViewPruductInfo(admin, pstmt, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Mention.MakeBox2(men, men.getIsLogout());
	      
		int comeBack = sc.nextInt();
	    if(comeBack == 2) logout = true;
	      
	    return logout;
	}
	
	public void ViewProductInfo(MakeAdmin admin, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		
		Scanner sc = admin.getSc();
		
		System.out.printf(men.getMiddleLine2(),"",men.getChooseInsales());
		
		int pickInSales = sc.nextInt();
		
		oET = oDAO.getList_ViewInfo(admin, pickInSales);
		
		if(oET.size() == 0) {
			System.out.println("조회 내역이 없습니다.");
		}else {
			printList(oET);
		}
	}
	
	public void ChangeViewPruductInfo(MakeAdmin admin, PreparedStatement pstmt, ResultSet rs) {
	    boolean wantToCancel = false;
	    
	    Scanner sc = admin.getSc();

	    while (!wantToCancel) {
	        // 상품 코드를 입력받아 insales를 검색해 y 또는 n인지 확인
			System.out.println("\t<< 변경할 상품의 상품 코드를 입력하세요.. >>");
			int updateGoodscode = sc.nextInt();
			
			boolean isExsist = oDAO.check_TorF(admin, updateGoodscode);

			// 데이터가 있는지 확인
			if (isExsist) {

			    // 사용자 입력을 요청
			    System.out.println("\t<< 변경할 상품의 판매 여부를 입력하세요 (Y/N) ((취소 : c)): >> ");
			    String request = sc.next().toLowerCase();

			    if (request.equals("y") || request.equals("n")) {
			    	
			    	oDAO.update(admin, updateGoodscode, request);
			        
			        InsalesGoodsAdminDAO iDAO = new InsalesGoodsAdminDAO(); 
			        // ordergoods에서 변경된 내용을 insalesgoods 로 변경 삭제.
			        if(request.equals("y")) {iDAO.insertInsalesGoods(admin, updateGoodscode);}
			        if(request.equals("n")) {iDAO.deleteInsalesGoods(admin, updateGoodscode);}
			        
			        System.out.print("\t<< 변경 완료되었습니다. (계속변경하기 : 1 / 취소하기 : 2) >>");
			        int conti = sc.nextInt();
			        
			        if(conti == 1) {
			        	continue;
			        }
			        else if(conti == 2) {
			        	wantToCancel = true;
			        } else {
			        	System.out.println("\t<< 올바른 입력이 아닙니다. (1(계속 변경하기)또는 2(취소하기)로 입력하세요.) >>");
			        }
			        
			    } else if (request.equals("c")) {
			        wantToCancel = true;
			    } else {
			        System.out.println("\t<< 올바른 입력이 아닙니다. (Y/N 또는 C로 입력하세요) >>");
			    }
			} else {
			    System.out.println("\t<< 해당 상품 코드가 존재하지 않습니다. >>");
			}
	    }
	}
	
	private void printList(ArrayList<OrderGoodsEntity> oET) {
		System.out.println("\t======================상품 조회======================");
	       
	       for(OrderGoodsEntity dto:oET) {
	    	   System.out.println(dto.toString());
	       }
	   }   
}
