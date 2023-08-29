package com.main;
import java.util.HashMap;
import java.util.Scanner;

public class SearchGoods {
    Scanner sc;

    public SearchGoods() {}
    public SearchGoods(Scanner sc) {
        this.sc = sc;
    }


    private void addGoodsToBasket(int key, int number, int maxNumber, Goods goods, ShoppingBasket basket) {
        if(number <= 0) {
            System.out.println("������ 1�� �̻���� �Է� �����մϴ�. ��ٱ��� �Է��� ��ҵ˴ϴ�.");
        } else if(number > maxNumber) {
            System.out.println("�Է��Ͻ� ������ ����� �ִ�������� ���� �ִ������ ��ٱ��Ͽ� ��ڽ��ϴ�.");
            basket.registerStockByKey(key, goods, maxNumber);
        } else {
            System.out.println("�Է��Ͻ� ������ ��ٱ��Ͽ� ��ڽ��ϴ�.");
            basket.registerStockByKey(key, goods, number);
        }
    }

    public void searchInfoByName(String name, StockInfo stockInfo, ShoppingBasket basket) {
        System.out.println("��ǰ���� "+name+"�� ��ǰ�� �˻��� ���");

        HashMap<Integer, Goods> goodsList = stockInfo.getGoodsList();
        HashMap<Integer, Integer> goodsStock = stockInfo.getGoodsStock();
        if(goodsList.isEmpty()) {
            System.out.println("�˻���� ����");
        }
        goodsList.forEach((key, goods)->{
            if(goods.getName() == name) {
                System.out.println(String.format("//��ǰ Ű: %d, ��ǰ �̸�: %s, ��ǰ ����: %d, ��ǰ ����: %d// \n", key, goods.getName(), goodsStock.get(key), goods.getPrice()));
                System.out.print("�ش� ��ǰ�� �����ϰڽ��ϱ�? (y/n) : ");
                String input = sc.nextLine();
                char inputChar = input.charAt(0);
                if(inputChar == 'y') {
                    System.out.print("�����ϰ��� �ϴ� ��ǰ�� ������ �Է��ϼ���. ���� : ");
                    int number = Integer.parseInt(sc.nextLine());
                    int maxNumber = goodsStock.get(key);

                    addGoodsToBasket(key, number, maxNumber, goods, basket);
                    System.out.println();
                }
            }
        });


    }


}
