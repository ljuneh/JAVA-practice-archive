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
        		System.out.println("��� ��Ͽ� �����ϰ��� �ϴ� ��ǰ "+goodsList.get(key).getName()+"�� �������� �ʽ��ϴ�");
        	} else if(mainStock.get(key) < goodsStock.get(key)) {
        		System.out.println("�����ϰ��� �ϴ� ��ǰ " + goodsList.get(key).getName() +"�� ������ ����� �������� ��� ���Ÿ�Ͽ��� �����մϴ�");
//        		basket.removeStockByKey(key);;
        		removeds.add(key);
        		
        	} else {
        		System.out.println("��ǰ " + goodsList.get(key).getName() +" �� ���� "+goodsStock.get(key)+"��ŭ �����մϴ�." );
        		
        		totalPrice += goodsList.get(key).getPrice()*goodsStock.get(key);
        		
        	}
        }
        
        for(int removed : removeds) {
        	basket.removeStockByKey(removed);
        }
        System.out.println("�� ���� : "+totalPrice);
        PaymentInfo paymentInfo = new PaymentInfo(basket, orderNumber);
        return paymentInfo;
    }

}
