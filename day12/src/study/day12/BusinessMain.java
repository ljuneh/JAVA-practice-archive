package study.day12;

import java.util.Scanner;

public class BusinessMain {

	public static void main(String[] args) {
		int iProperStock1 = 10; int iProperStock2 = 10;
		int iCurrentStock1 = 0; int iCurrentStock2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 2; ++i) {
			iCurrentStock1 = goodsStockProcess(iCurrentStock1, iProperStock1, sc);
			iCurrentStock2 = goodsStockProcess(iCurrentStock2, iProperStock2, sc);
		}

		BusinessMain bm = new BusinessMain();
		System.out.println("====================================");
		bm.printStock(iProperStock1, iCurrentStock1, iProperStock2, iCurrentStock2);
		
		sc.close();

	}


	
	public void printStock(int iProperStock1, int iCurrentStock1, 
			int iProperStock2, int iCurrentStock2) {
		System.out.println("�������:" + iProperStock1 + "�������:" + iCurrentStock1);
		System.out.println("�������:" + iProperStock2 + "�������:" + iCurrentStock2);		
	}

	public static int goodsStockProcess(int iCurrentStock, int iProperStock, Scanner sc) {
		if(iCurrentStock < iProperStock) {
			iCurrentStock += (iProperStock - iCurrentStock);
		}
		System.out.print("�ֹ��Ͻðڽ��ϱ�?>>>(1) ");
		int iInputValue = sc.nextInt();
		if(iInputValue == 1) {
			iCurrentStock = userOrderProcess(iCurrentStock, sc);
		}

		System.out.println("�������:" + iProperStock + "�������:" + iCurrentStock);	
		
		return iCurrentStock;
	}
	
	private static int userOrderProcess(int iCurrentStock, Scanner sc) {
		System.out.print("�ֹ����� �Է��ϼ���:>>> ");
		int iInputValue = sc.nextInt();
		iCurrentStock -= iInputValue;
		
		return iCurrentStock;
	}
	
}
