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
		System.out.println("�������:" + properStock + "�������:" + currentStock);		
	}
	
	private static int userOrderProcess(int currentStock, Scanner sc) {
		System.out.print("�ֹ����� �Է��ϼ���:>>> ");
		int inputValue = sc.nextInt();
		currentStock -= inputValue;
		
		return currentStock;
	}
	
	public static int goodsStockProcess(int currentStock, int properStock, Scanner sc) {
		if(currentStock < properStock) {
			currentStock += (properStock-currentStock);
		}
		System.out.print("�ֹ��Ͻðڽ��ϱ�?>>>(1) ");
		int iInputValue = sc.nextInt();
		if(iInputValue == 1) {
			currentStock = userOrderProcess(currentStock, sc);
		}
		System.out.println("�������:" + properStock + "�������:" + currentStock);	
		
		return currentStock; 
	}
}
