package com.sales;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 원재료 초기화(원재료 생성)
		ArrayList<ArrayList<Material>> 
		mateArrayList = 
				MaterialInit.
				getInitMaterialList();
		
		// 원재료 재고 초기화
		// (생성된 원재로 재고수량 등록)
		ArrayList<Stock> 
		stockList = 
				StockInit.
				getInitStockList(mateArrayList);
		
		for(Stock stock : stockList) {
			System.out.println(stock.getsMaterialCode() + ":" 
					+ stock.getiMaterialQty());
		}
		
		// 고객에게 보여줄 주문 상품 리스트 -  메뉴
		ArrayList<OrderGoods> 
		orderGoodsList = 
				OrderGoodsInit.
				getInitOrderGoodsList(mateArrayList);
		Menu.showMenu(sc, stockList, orderGoodsList);

		sc.close();
	}

}
