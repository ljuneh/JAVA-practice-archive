package com.main;
import java.util.HashMap;

public class StockInfo {
    private HashMap<Integer, Goods> goodsList;
    private HashMap<Integer, Integer> goodsStock;

    public StockInfo() {
        goodsList = new HashMap<>();
        goodsStock = new HashMap<>();
    }

    public HashMap<Integer, Goods> getGoodsList() {
        return goodsList;
    }

    public HashMap<Integer, Integer> getGoodsStock() {
        return goodsStock;
    }

    public void registerStockByKey(int key, Goods goods, int number) {
        goodsList.put(key, goods);
        goodsStock.put(key, number);

    }

    public void changeStockByKey(int key, int number) {
        if(goodsList.containsKey(key)) {
            goodsStock.put(key,number);
        }
    }

    public int getStockByKey(int key) {
        return goodsStock.get(key);
    }

    public Goods getGoodsByKey(int key) {
        return goodsList.get(key);
    }

    public void removeStockByKey(int key) {
        goodsList.remove(key);
        goodsStock.remove(key);
    }
    
    public void clearListAndStock() {
    	goodsList.clear();
    	goodsStock.clear();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        goodsList.forEach((key, goods)->{
            String s =  String.format("//상품 키: %d, 상품 이름: %s, 상품 갯수: %d, 상품 가격: %d// \n", key, goods.getName(), goodsStock.get(key), goods.getPrice());
            str.append(s);
        });

        return str.toString();
    }
}
