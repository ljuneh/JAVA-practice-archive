package com.jdbc_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class UserActivity {
	
	private String userId;
	
	private Scanner sc;
	
	
	public UserActivity(Scanner sc, String userId) {
		this.sc = sc;
		this.userId = userId;
		runMenu();
	}
	
	public void showInsalesGoods() {
		
		ArrayList<ShowInsales> showInsalesArr = InsalesGoodsDAO.retShowInsalesArr();
		
		for(ShowInsales showInsales: showInsalesArr) {
			System.out.println(showInsales);
		}
		
	}
	
	public void chooseInsalesGoods() {
		
		System.out.print("상품을 주문하시겠습니까? : (y/n) >>> ");
		String isOrder = sc.nextLine();
		
		if(decideToProceed(isOrder)) {
			System.out.print("주문할 상품의 코드를 입력하세요 >>> ");
			String code = sc.nextLine();
			System.out.print("주문할 상품량을 입력하세요");
			int quantity = 0;
			try {
				quantity = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("번호 올바르게 입력하세요. 메뉴로 돌아값니다");
			}
			
//			OrderInfoDAO.updateOrderConfirmedByCode(code, quantity, "Y");
			
			////새로 작성한 코드
			OrderInfoDAO.insertOrderInfo(code, quantity, userId);
			
		}
	}
	
	public void cancelInsalesGoods() {
		
		System.out.print("상품 주문을 취소하시겠습니까? : (y/n) >>> ");
		String isCancel = sc.nextLine();
		
		if(decideToProceed(isCancel)) {
			System.out.print("취소할 상품의 코드를 입력하세요 >>> ");
			String code = sc.nextLine();
			
			OrderInfoDAO.updateOrderConfirmedByCode(code, "C", userId);
			
		}
	}
	
	private boolean decideToProceed(String isOrder) {
		if(isOrder.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void showConfirmedGoods() {
		ArrayList<OrderInfo> orderInfoArr = OrderInfoDAO.retOrderInfoArr();
		
		for (OrderInfo orderInfo: orderInfoArr) {
			if(orderInfo.getOrderConfirmed().equals("N")) {
				System.out.println(orderInfo);
			}
		}
	}
	
	public void setSalesInfoWithConfirmedGoods() {
//		SalesInfoDAO.initSalesInfo();
		
		ArrayList<OrderInfo> orderInfoArr = OrderInfoDAO.retOrderInfoArr();
		
		for (OrderInfo orderInfo: orderInfoArr) {
			if(orderInfo.getOrderConfirmed().equals("")) {
				SalesInfoDAO.insertSalesInfo(orderInfo);
			}
		}
	}
	
	private static void displayMainMenu() {
		System.out.println("===========================================");
		System.out.println("(1) 주문 상품 보기");
		System.out.println("(2) 주문 선택");
		System.out.println("(3) 주문 취소");
		System.out.println("(4) 선택한 상품 출력");
		System.out.println("(5) 주문 확정");
		System.out.println("(6) 종료");
		System.out.println("===========================================");
		System.out.print("번호 입력 : ");
	}
	
	private void runMenu() {
		int inputNumber;
		while(true) {
			inputNumber = -1;
			displayMainMenu();
			try {
				inputNumber = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("번호 올바르게 입력하세요");
				continue;
			}
			
			if (inputNumber == 1) {
				System.out.println("주문 상품 출력");
				showInsalesGoods();
			} else if(inputNumber == 2) {
				System.out.println("주문 선택");
				chooseInsalesGoods();
			} else if(inputNumber == 3) {
				System.out.println("주문 취소");
				cancelInsalesGoods();
			} else if(inputNumber == 4) {
				System.out.println("선택한 상품 출력");
				showConfirmedGoods();
			} else if(inputNumber == 5) {
				System.out.println("주문 확정");
				setSalesInfoWithConfirmedGoods();
			}
			else if(inputNumber == 6) {
				System.out.println("시스템 종료");
				break;
			}
			
			else if(inputNumber == 0) {
				System.out.println(OrderInfoDAO.currentSeq());
			}
			
			
			
		}
	}
	
}