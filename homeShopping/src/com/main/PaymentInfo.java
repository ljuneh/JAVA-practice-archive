package com.main;
import java.util.HashMap;

public class PaymentInfo {
    private ShoppingBasket basket;
    private int orderNumber;

    public PaymentInfo() {}
    public PaymentInfo(ShoppingBasket basket, int orderNumber) {
        this.basket = basket;
        this.orderNumber = orderNumber;
    }
    
    public ShoppingBasket getBasket() {
		return basket;
	}
	public void setBasket(ShoppingBasket basket) {
		this.basket = basket;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void purchaseAndUpdate(StockInfo mainBasket) {
    	HashMap<Integer, Goods> goodsList = basket.getGoodsList();
        HashMap<Integer, Integer> goodsStock = basket.getGoodsStock();
        HashMap<Integer, Integer> mainStock = mainBasket.getGoodsStock();
        int totalPrice = 0;
        for(int key : goodsList.keySet()) {
        	int updateStock = mainStock.get(key) - goodsStock.get(key);
        	mainBasket.changeStockByKey(key, updateStock);
        	totalPrice += goodsList.get(key).getPrice()*goodsStock.get(key);
        }
        System.out.println("총 가격 : "+totalPrice);
        System.out.println("최종 결제가 완료되었습니다.");
    }
}
