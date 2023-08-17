package study.day12;

import java.util.Scanner;

public class OrderGoods {
	private int properStock;
	private int currentStock;
	
	public OrderGoods() {}
	
	public OrderGoods(int properStock, int currentStock) {
		this.currentStock = currentStock;
		this.properStock = properStock;
	}
	
	public void printStock() {
		System.out.println("적정재고:" + properStock + "현재재고:" + currentStock);		
	}
	
	private static int userOrderProcess(int currentStock, Scanner sc) {
		System.out.print("주문량을 입력하세요:>>> ");
		int inputValue = sc.nextInt();
		currentStock -= inputValue;
		
		return currentStock;
	}
	
	public static int goodsStockProcess(int currentStock, int properStock, Scanner sc) {
		if(currentStock < properStock) {
			currentStock += (properStock-currentStock);
		}
		System.out.print("주문하시겠습니까?>>>(1) ");
		int iInputValue = sc.nextInt();
		if(iInputValue == 1) {
			currentStock = userOrderProcess(currentStock, sc);
		}
		System.out.println("적정재고:" + properStock + "현재재고:" + currentStock);	
		
		return currentStock; 
	}
}
