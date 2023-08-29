package com.main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingBasket basket = new ShoppingBasket();


        Goods goods = new Goods(0,"��ǰ�̸� 1", 1000, 100, 10);

        StockInfo stockInfo = new StockInfo();
        stockInfo.registerStockByKey(goods.getKey(), goods, 16);

        Goods goods2 = new Goods(1,"��ǰ�̸� 2", 2000, 200, 20);
        stockInfo.registerStockByKey(goods2.getKey(), goods2, 26);

        Goods goods3 = new Goods(2,"��ǰ�̸� 3", 3000, 300, 30);
        stockInfo.registerStockByKey(goods3.getKey(), goods3, 35);

        System.out.println(stockInfo);

        // ��ǰ �˻�
        System.out.println("��ǰ �˻�");
        Scanner sc = new Scanner(System.in);
        SearchGoods searchGoods = new SearchGoods(sc);
        searchGoods.searchInfoByName("��ǰ�̸� 1", stockInfo, basket);
        searchGoods.searchInfoByName("��ǰ�̸� 2", stockInfo, basket);
        searchGoods.searchInfoByName("��ǰ�̸� 3", stockInfo, basket);
        
        // ��ٱ��� ���
        System.out.println("��ٱ��� ���");
        UserInfo userInfo = new UserInfo("�ƹ���", 30, "male");
        basket.setUserInfo(userInfo);
        System.out.println(basket);
        
        // ��ٱ��� ��ǰ ����
        System.out.println("��ٱ��� ��ǰ ����");
        basket.removeStockByKey(2);
        System.out.println(basket);
        
        
        // ��ٱ��� ��ǰ ���� ����
        System.out.println("��ٱ��� ��ǰ ���� ����");
        basket.changeStockByKey(0, 100);
        System.out.println(basket);

        // �ֹ� ���� ����
        System.out.println("�ֹ� ���� ����");
        OrderInfo orderInfo = new OrderInfo(basket, 1); // �ֹ���ȣ 1��
        // ��ǰ ��� ���� �������� ��ȯ
        PaymentInfo paymentInfo = orderInfo.retPaymentInfo(stockInfo);
        
        // ���� ������ ���� ��ǰ ��� ��ȭ
        System.out.println("���� ������ ���� ��ǰ ��� ��ȭ");
        paymentInfo.purchaseAndUpdate(stockInfo);
        
        System.out.println(stockInfo);

    }
}