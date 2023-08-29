package com.main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingBasket basket = new ShoppingBasket();


        Goods goods = new Goods(0,"상품이름 1", 1000, 100, 10);

        StockInfo stockInfo = new StockInfo();
        stockInfo.registerStockByKey(goods.getKey(), goods, 16);

        Goods goods2 = new Goods(1,"상품이름 2", 2000, 200, 20);
        stockInfo.registerStockByKey(goods2.getKey(), goods2, 26);

        Goods goods3 = new Goods(2,"상품이름 3", 3000, 300, 30);
        stockInfo.registerStockByKey(goods3.getKey(), goods3, 35);

        System.out.println(stockInfo);

        // 상품 검색
        System.out.println("상품 검색");
        Scanner sc = new Scanner(System.in);
        SearchGoods searchGoods = new SearchGoods(sc);
        searchGoods.searchInfoByName("상품이름 1", stockInfo, basket);
        searchGoods.searchInfoByName("상품이름 2", stockInfo, basket);
        searchGoods.searchInfoByName("상품이름 3", stockInfo, basket);
        
        // 장바구니 출력
        System.out.println("장바구니 출력");
        UserInfo userInfo = new UserInfo("아무개", 30, "male");
        basket.setUserInfo(userInfo);
        System.out.println(basket);
        
        // 장바구니 상품 삭제
        System.out.println("장바구니 상품 삭제");
        basket.removeStockByKey(2);
        System.out.println(basket);
        
        
        // 장바구니 상품 수량 변경
        System.out.println("장바구니 상품 수량 변경");
        basket.changeStockByKey(0, 100);
        System.out.println(basket);

        // 주문 정보 생성
        System.out.println("주문 정보 생성");
        OrderInfo orderInfo = new OrderInfo(basket, 1); // 주문번호 1번
        // 상품 재고에 따른 결제정보 반환
        PaymentInfo paymentInfo = orderInfo.retPaymentInfo(stockInfo);
        
        // 결제 결정에 따른 상품 재고 변화
        System.out.println("결제 결정에 따른 상품 재고 변화");
        paymentInfo.purchaseAndUpdate(stockInfo);
        
        System.out.println(stockInfo);

    }
}