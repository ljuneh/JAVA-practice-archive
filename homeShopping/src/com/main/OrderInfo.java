package com.main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderInfo {
    private ShoppingBasket basket;
    private int orderNumber;

    public OrderInfo() {}
    public OrderInfo(ShoppingBasket basket, int orderNumber) {
        this.basket = basket;
        this.orderNumber = orderNumber;
    }

    public ShoppingBasket getBasket() {
        return basket;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setBasket(ShoppingBasket basket) {
        this.basket = basket;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public PaymentInfo retPaymentInfo(StockInfo mainBasket) {
        
        HashMap<Integer, Goods> goodsList = basket.getGoodsList();
        HashMap<Integer, Integer> goodsStock = basket.getGoodsStock();
        
        HashMap<Integer, Goods> mainList = mainBasket.getGoodsList();
        HashMap<Integer, Integer> mainStock = mainBasket.getGoodsStock();
        
        int totalPrice = 0;
        List<Integer> removeds = new ArrayList<>();
        for(int key : goodsList.keySet()) {
        	if(!mainList.containsKey(key) || !mainStock.containsKey(key)) {
        		System.out.println("재고 목록에 구매하고자 하는 상품 "+goodsList.get(key).getName()+"가 존재하지 않습니다");
        	} else if(mainStock.get(key) < goodsStock.get(key)) {
        		System.out.println("구매하고자 하는 상품 " + goodsList.get(key).getName() +"의 수량이 재고의 수량보다 적어서 구매목록에서 제외합니다");
//        		basket.removeStockByKey(key);;
        		removeds.add(key);
        		
        	} else {
        		System.out.println("상품 " + goodsList.get(key).getName() +" 을 수량 "+goodsStock.get(key)+"만큼 구매합니다." );
        		
        		totalPrice += goodsList.get(key).getPrice()*goodsStock.get(key);
        		
        	}
        }
        
        for(int removed : removeds) {
        	basket.removeStockByKey(removed);
        }
        System.out.println("총 가격 : "+totalPrice);
        PaymentInfo paymentInfo = new PaymentInfo(basket, orderNumber);
        return paymentInfo;
    }

}
