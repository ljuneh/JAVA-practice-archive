package com.main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ShoppingBasket basket = new ShoppingBasket();
//
//
//        Goods goods = new Goods(0,"��ǰ�̸� 1", 1000, 100, 10);
//
//        StockInfo stockInfo = new StockInfo();
//        stockInfo.registerStockByKey(goods.getKey(), goods, 16);
//
//        Goods goods2 = new Goods(1,"��ǰ�̸� 2", 2000, 200, 20);
//        stockInfo.registerStockByKey(goods2.getKey(), goods2, 26);
//
//        Goods goods3 = new Goods(2,"��ǰ�̸� 3", 3000, 300, 30);
//        stockInfo.registerStockByKey(goods3.getKey(), goods3, 35);
//
//        System.out.println(stockInfo);
//
//        // ��ǰ �˻�
//        System.out.println("��ǰ �˻�");
//        Scanner sc = new Scanner(System.in);
//        SearchGoods searchGoods = new SearchGoods(sc);
//        searchGoods.searchInfoByName("��ǰ�̸� 1", stockInfo, basket);
//        searchGoods.searchInfoByName("��ǰ�̸� 2", stockInfo, basket);
//        searchGoods.searchInfoByName("��ǰ�̸� 3", stockInfo, basket);
//        sc.close();
//        
//        // ��ٱ��� ���
//        System.out.println("��ٱ��� ���");
//        UserInfo userInfo = new UserInfo("�ƹ���", 30, "male");
//        basket.setUserInfo(userInfo);
//        System.out.println(basket);
//        
//        // ��ٱ��� ��ǰ ����
//        System.out.println("��ٱ��� ��ǰ ����");
//        basket.removeStockByKey(2);
//        System.out.println(basket);
//        
//        
//        // ��ٱ��� ��ǰ ���� ����
//        System.out.println("��ٱ��� ��ǰ ���� ����");
//        basket.changeStockByKey(0, 100);
//        System.out.println(basket);
//
//        // �ֹ� ���� ����
//        System.out.println("�ֹ� ���� ����");
//        OrderInfo orderInfo = new OrderInfo(basket, 1); // �ֹ���ȣ 1��
//        // ��ǰ ��� ���� �������� ��ȯ
//        PaymentInfo paymentInfo = orderInfo.retPaymentInfo(stockInfo);
//        
//        // ���� ������ ���� ��ǰ ��� ��ȭ
//        System.out.println("���� ������ ���� ��ǰ ��� ��ȭ");
//        paymentInfo.purchaseAndUpdate(stockInfo);
//        
//        System.out.println(stockInfo);
        
    	Scanner sc = new Scanner(System.in);
		StockInfo stockInfo = new StockInfo(); // ���
		SearchGoods searchGoods = new SearchGoods(sc); // �˻�
		ShoppingBasket basket = new ShoppingBasket(); // ��ٱ���
		UserInfo userInfo = new UserInfo("�ƹ���", 30, "male"); // ����� ����
		basket.setUserInfo(userInfo);
		OrderInfo orderInfo; // �ֹ� ����
		PaymentInfo paymentInfo; // ���� ����

		Goods goods = new Goods(0, "��ǰ�̸�1", 1000, 100, 10);
		stockInfo.registerStockByKey(goods.getKey(), goods, 16);

		Goods goods2 = new Goods(1, "��ǰ�̸�2", 2000, 200, 20);
		stockInfo.registerStockByKey(goods2.getKey(), goods2, 26);

		Goods goods3 = new Goods(2, "��ǰ�̸�3", 3000, 300, 30);
		stockInfo.registerStockByKey(goods3.getKey(), goods3, 35);

		int count = 0;
		int inputNumber;
		while (true) {
			inputNumber = -1;
			displayMainMenu();
			try {
				inputNumber = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("��ȣ �ùٸ��� �Է��ϼ���");
				continue;
			}
			
			if (inputNumber == 0) {
				System.out.println(stockInfo);
				
			} else if (inputNumber == 1) {
				System.out.println("��ǰ �˻�\n ��ǰ �̸��� �Է��ϼ���");
				System.out.print("��ǰ�̸� : ");
				String inputName = sc.nextLine();
				searchGoods.searchInfoByName(inputName, stockInfo, basket);
				
			} else if (inputNumber == 2) {
				System.out.println("��ٱ��� ���");
				System.out.println(basket);
				
			} else if (inputNumber == 3) {
				System.out.println("��ٱ��� ��ǰ ����");
				System.out.println("������ ��ǰ�� Ű�� �Է��ϼ���");
				System.out.print("��ǰ Ű : ");
				int inputRemoveKey = Integer.parseInt(sc.nextLine());
				basket.removeStockByKey(inputRemoveKey);
				
			} else if (inputNumber == 4) {
				System.out.println("��ٱ��� ��ǰ ���� ����");
				System.out.println("������ ������ ��ǰ�� Ű�� �Է��ϼ���");
				System.out.print("��ǰ Ű : ");
				int inputChangeKey = Integer.parseInt(sc.nextLine());
				System.out.print("��ǰ ���� : ");
				int inputChangeNumber = Integer.parseInt(sc.nextLine());
				basket.changeStockByKey(inputChangeKey, inputChangeNumber);
				
			} else if (inputNumber == 5) {
				System.out.println("��� �ֹ�");
				count++;
				orderInfo = new OrderInfo(basket, count);
				paymentInfo = orderInfo.retPaymentInfo(stockInfo);
				System.out.println("�ֹ� Ȯ��\n������ ���� ��ǰ ��� ��ȭ");
				basket.clearListAndStock();
				paymentInfo.purchaseAndUpdate(stockInfo);

			} else if (inputNumber == 6) {
				System.out.println("�ý��� ����");
				break;
			} 
		}
		sc.close();

    }
    
    public static void displayMainMenu() {
		System.out.println("===========================================");
		System.out.println("(0) ��ü ��ǰ ����");
		System.out.println("(1) ��ǰ �˻�");
		System.out.println("(2) ��ٱ��� ����");
		System.out.println("(3) ��ٱ��Ͽ��� ��ǰ ���� ����");
		System.out.println("(4) ��ٱ��Ͽ��� ��ǰ ���� ����");
		System.out.println("(5) ��� �ֹ�");
		System.out.println("(6) ����");
		System.out.println("===========================================");
		System.out.print("��ȣ �Է� : ");
	}
}