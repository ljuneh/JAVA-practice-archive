package study.day12;

import java.util.Scanner;

public class BusinessMain02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		OrderGoods orderGoods = new OrderGoods(10, 0);
		
		int properStock1 = 10; int currentStock1 = 0;
		for(int i = 0; i < 2; ++i) {
			currentStock1 = OrderGoods.goodsStockProcess(currentStock1, properStock1, sc);
	
		}
		sc.close();
	}
}
