package com.sales;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	
	public static void showMenu(
			Scanner sc, 
			ArrayList<Stock> stockListList,
			ArrayList<OrderGoods> orderGoodsList) {
		ArrayList<SalesInfo> salesInfoList = 
				new ArrayList<>();
		ArrayList<OrderInfo> orderInfoList = new ArrayList<>();

		int i  = 0;
		for(i = 0;  i < orderGoodsList.size(); i++) {
			System.out.println("=======================");
			System.out.println("주문상품코드: " 
							+ orderGoodsList.get(i).getsGoodsCode());
			System.out.println("주문상품명칭: " 
							+ orderGoodsList.get(i).getsGoodsName());
			System.out.println("원재료1: " 
							+ orderGoodsList.get(i).getsMaterialCode1());
			System.out.println("원재료1 수량: " 
							+ orderGoodsList.get(i).getiMaterialQty1());
			System.out.println("원재료2: " 
							+ orderGoodsList.get(i).getsMaterialCode2());
			System.out.println("원재료2 수량: " 
							+ orderGoodsList.get(i).getiMaterialQty2());
			System.out.print("주문 하시겠습니까?(y/n)>>>: ");
			if(sc.nextLine().equalsIgnoreCase("y")) {
				// 주문정보 생성
				ArrayList<OrderInfo> orderInfosList = 
						makeOrderInfo(orderGoodsList.get(i), orderInfoList);
				// 주문이 확정되면 
				System.out.println("주문을 확정하시겠습니까?(y/n)");
				if(sc.nextLine().equalsIgnoreCase("y")) {
					// 주문상품 판매수량과
					// 원재료 재고정보 변경 반영
					OrderConfirmed(
							orderGoodsList,
							orderInfosList,
							stockListList,
							salesInfoList);
				}
			}

			System.out.println("주문내역 리스트");
			PrintInfo.printOrderInfoList(orderInfoList);
			if(i == orderGoodsList.size()-1) {
					System.out.println("맨 마지막 주문 상품에 도달했습니다.");
					i = -1;
			}
			
			System.out.print("제고를 확인하시겠습니까?>>> ");
			if(sc.nextLine().equalsIgnoreCase("y")){
				for(Stock stock : stockListList) {
					System.out.println("코드: " + stock.getsMaterialCode()
					+ "\t" + "재고량: " + stock.getiMaterialQty());
				}							
			}
			
			System.out.print(
					"계속 보시겠습니까?(y/n)>>>: ");
			if(sc.nextLine().equalsIgnoreCase("y")) { 
				continue;
			} else { break; }			
		}
		System.out.println("감사합니다. 안녕히 가십시오.");				
	}
	
	public static ArrayList<OrderInfo> makeOrderInfo(
			OrderGoods orderGoods, ArrayList<OrderInfo> orderInfoList) {
		boolean bFoundFlag = false;
		if(orderInfoList.size() == 0) {
			orderInfoList.add(
					new OrderInfo(orderGoods.getsGoodsCode(),
							1, false));
		} else {
			for(int i = 0; i < orderInfoList.size();i++) {
				if(!orderInfoList.get(i).isbOrderConfirmed()) {
					if(orderGoods.getsGoodsCode().
							equalsIgnoreCase(orderInfoList.get(i).getsGoodsCode())){
						orderInfoList.get(i).setiOrderQty(
								orderInfoList.get(i).getiOrderQty() + 1);
						System.out.println("이미 주문 상품이 존재합니다.");
						bFoundFlag = true;
						break;
					}				
				} 
			}
			
			if(!bFoundFlag) {
				System.out.println("이전에 주문 상품한 상품이 존재하지 않습니다.");
				orderInfoList.add(
						new OrderInfo(orderGoods.getsGoodsCode(),
								1, false));
				bFoundFlag = false;
			}
		}
		return orderInfoList;
	}
	public static void OrderConfirmed(
			ArrayList<OrderGoods> orderGoodsList,
			ArrayList<OrderInfo> orderInfosList,
			ArrayList<Stock> stockListList,
			ArrayList<SalesInfo> salesInfoList) {
		boolean bFoundFlag = false;
		
		for(OrderInfo orderInfo : orderInfosList) {
			SalesInfo salesInfo = new SalesInfo();
			// 주문 상품 확정 플래그 등록
			if(!orderInfo.isbOrderConfirmed()) {
				orderInfo.setbOrderConfirmed(true);
				// 판매상품 정보 추가
				for(SalesInfo salesInfo1 : salesInfoList) {
					if(orderInfo.getsGoodsCode().
							equalsIgnoreCase(salesInfo1.getsGoodsCode())) {
						salesInfo1.setiSalesQty(
								salesInfo1.getiSalesQty() + 1);
						bFoundFlag = true;
						break;
					}
				}
				
				if(bFoundFlag) bFoundFlag = false;
				else {
					salesInfo.setsGoodsCode(orderInfo.getsGoodsCode());
					salesInfo.setiSalesQty(orderInfo.getiOrderQty());				
				}

				salesInfoList.add(salesInfo);	
				
				for(OrderGoods orderGoods : orderGoodsList) {
					if(orderInfo.getsGoodsCode().equalsIgnoreCase(
							orderGoods.getsGoodsCode())) {	
						for(Stock stock : stockListList) {
							if(orderGoods.getsMaterialCode1().equalsIgnoreCase(
											stock.getsMaterialCode())) {
								stock.setiMaterialQty(stock.getiMaterialQty() - 
										orderInfo.getiOrderQty());
							}
							if(orderGoods.getsMaterialCode2().equalsIgnoreCase(
									stock.getsMaterialCode())) {
								stock.setiMaterialQty(stock.getiMaterialQty() - 
										orderInfo.getiOrderQty());
							}
						}
						break;
					}
				}					
			}
			
		}
	}
}
