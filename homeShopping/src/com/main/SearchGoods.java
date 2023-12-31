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
            System.out.println("수량은 1개 이상부터 입력 가능합니다. 장바구니 입력이 취소됩니다.");
        } else if(number > maxNumber) {
            System.out.println("입력하신 수량이 재고의 최대수량보다 많아 최대수량을 장바구니에 담겠습니다.");
            basket.registerStockByKey(key, goods, maxNumber);
        } else {
            System.out.println("입력하신 수량을 장바구니에 담겠습니다.");
            basket.registerStockByKey(key, goods, number);
        }
    }
    
    private void insertDecision(char inputChar, int key, Goods goods, ShoppingBasket basket, HashMap<Integer, Integer> goodsStock) {
    	if(inputChar == 'y') {
            System.out.print("구입하고자 하는 상품의 수량을 입력하세요. 수량 : ");
            int number = Integer.parseInt(sc.nextLine());
            int maxNumber = goodsStock.get(key);

            addGoodsToBasket(key, number, maxNumber, goods, basket);
            System.out.println();
        }
    }

    public void searchInfoByName(String name, StockInfo stockInfo, ShoppingBasket basket) {
    	
        System.out.println("상품명이 "+name+"인 상품을 검색한 결과");

        HashMap<Integer, Goods> goodsList = stockInfo.getGoodsList();
        HashMap<Integer, Integer> goodsStock = stockInfo.getGoodsStock();
        if(goodsList.isEmpty()) {
            System.out.println("검색결과 없음");
        }
        boolean searched = false;
        
        for(int key: goodsList.keySet()) {
        	Goods goods = goodsList.get(key);
        	if(name.equals(goods.getName())) {
            	searched = true;
                System.out.println(String.format("//상품 키: %d, 상품 이름: %s, 상품 갯수: %d, 상품 가격: %d// \n", key, goods.getName(), goodsStock.get(key), goods.getPrice()));
                System.out.print("해당 상품을 구입하겠습니까? (y/n) : ");
                String input = sc.nextLine();
                char inputChar = input.charAt(0);
                insertDecision(inputChar, key, goods, basket, goodsStock);
            }
        }
        if(!searched) {
        	System.out.println("검색결과 없음");
        }
       
    }


}
