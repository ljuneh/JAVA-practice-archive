package com.main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ShoppingBasket basket = new ShoppingBasket();
//
//
//        Goods goods = new Goods(0,"상품이름 1", 1000, 100, 10);
//
//        StockInfo stockInfo = new StockInfo();
//        stockInfo.registerStockByKey(goods.getKey(), goods, 16);
//
//        Goods goods2 = new Goods(1,"상품이름 2", 2000, 200, 20);
//        stockInfo.registerStockByKey(goods2.getKey(), goods2, 26);
//
//        Goods goods3 = new Goods(2,"상품이름 3", 3000, 300, 30);
//        stockInfo.registerStockByKey(goods3.getKey(), goods3, 35);
//
//        System.out.println(stockInfo);
//
//        // 상품 검색
//        System.out.println("상품 검색");
//        Scanner sc = new Scanner(System.in);
//        SearchGoods searchGoods = new SearchGoods(sc);
//        searchGoods.searchInfoByName("상품이름 1", stockInfo, basket);
//        searchGoods.searchInfoByName("상품이름 2", stockInfo, basket);
//        searchGoods.searchInfoByName("상품이름 3", stockInfo, basket);
//        sc.close();
//        
//        // 장바구니 출력
//        System.out.println("장바구니 출력");
//        UserInfo userInfo = new UserInfo("아무개", 30, "male");
//        basket.setUserInfo(userInfo);
//        System.out.println(basket);
//        
//        // 장바구니 상품 삭제
//        System.out.println("장바구니 상품 삭제");
//        basket.removeStockByKey(2);
//        System.out.println(basket);
//        
//        
//        // 장바구니 상품 수량 변경
//        System.out.println("장바구니 상품 수량 변경");
//        basket.changeStockByKey(0, 100);
//        System.out.println(basket);
//
//        // 주문 정보 생성
//        System.out.println("주문 정보 생성");
//        OrderInfo orderInfo = new OrderInfo(basket, 1); // 주문번호 1번
//        // 상품 재고에 따른 결제정보 반환
//        PaymentInfo paymentInfo = orderInfo.retPaymentInfo(stockInfo);
//        
//        // 결제 결정에 따른 상품 재고 변화
//        System.out.println("결제 결정에 따른 상품 재고 변화");
//        paymentInfo.purchaseAndUpdate(stockInfo);
//        
//        System.out.println(stockInfo);
        
    	Scanner sc = new Scanner(System.in);
		StockInfo stockInfo = new StockInfo(); // 재고
		SearchGoods searchGoods = new SearchGoods(sc); // 검색
		ShoppingBasket basket = new ShoppingBasket(); // 장바구니
		UserInfo userInfo = new UserInfo("아무개", 30, "male"); // 사용자 정보
		basket.setUserInfo(userInfo);
		OrderInfo orderInfo; // 주문 정보
		PaymentInfo paymentInfo; // 결제 정보

		Goods goods = new Goods(0, "상품이름1", 1000, 100, 10);
		stockInfo.registerStockByKey(goods.getKey(), goods, 16);

		Goods goods2 = new Goods(1, "상품이름2", 2000, 200, 20);
		stockInfo.registerStockByKey(goods2.getKey(), goods2, 26);

		Goods goods3 = new Goods(2, "상품이름3", 3000, 300, 30);
		stockInfo.registerStockByKey(goods3.getKey(), goods3, 35);

		int count = 0;
		int inputNumber;
		while (true) {
			inputNumber = -1;
			displayMainMenu();
			try {
				inputNumber = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("번호 올바르게 입력하세요");
				continue;
			}
			
			if (inputNumber == 0) {
				System.out.println(stockInfo);
				
			} else if (inputNumber == 1) {
				System.out.println("상품 검색\n 상품 이름을 입력하세요");
				System.out.print("상품이름 : ");
				String inputName = sc.nextLine();
				searchGoods.searchInfoByName(inputName, stockInfo, basket);
				
			} else if (inputNumber == 2) {
				System.out.println("장바구니 출력");
				System.out.println(basket);
				
			} else if (inputNumber == 3) {
				System.out.println("장바구니 상품 삭제");
				System.out.println("삭제할 상품의 키를 입력하세요");
				System.out.print("상품 키 : ");
				int inputRemoveKey = Integer.parseInt(sc.nextLine());
				basket.removeStockByKey(inputRemoveKey);
				
			} else if (inputNumber == 4) {
				System.out.println("장바구니 상품 수량 변경");
				System.out.println("수량을 변경할 상품의 키를 입력하세요");
				System.out.print("상품 키 : ");
				int inputChangeKey = Integer.parseInt(sc.nextLine());
				System.out.print("상품 수량 : ");
				int inputChangeNumber = Integer.parseInt(sc.nextLine());
				basket.changeStockByKey(inputChangeKey, inputChangeNumber);
				
			} else if (inputNumber == 5) {
				System.out.println("재고 주문");
				count++;
				orderInfo = new OrderInfo(basket, count);
				paymentInfo = orderInfo.retPaymentInfo(stockInfo);
				System.out.println("주문 확인\n결제에 따른 상품 재고 변화");
				basket.clearListAndStock();
				paymentInfo.purchaseAndUpdate(stockInfo);

			} else if (inputNumber == 6) {
				System.out.println("시스템 종료");
				break;
			} 
		}
		sc.close();

    }
    
    public static void displayMainMenu() {
		System.out.println("===========================================");
		System.out.println("(0) 전체 상품 보기");
		System.out.println("(1) 상품 검색");
		System.out.println("(2) 장바구니 보기");
		System.out.println("(3) 장바구니에서 상품 수량 삭제");
		System.out.println("(4) 장바구니에서 상품 수량 변경");
		System.out.println("(5) 재고 주문");
		System.out.println("(6) 종료");
		System.out.println("===========================================");
		System.out.print("번호 입력 : ");
	}
}