package com.main;


public class Main {
	public static void main(String[] args) {
		Goods goods = new Goods("임의의 상품 이름1", 1000, 10, 1);
//		System.out.println(goods);
		
		
		GoodsListInfo goodsListInfo = new GoodsListInfo();
//		goodsListInfo.add(goods.getName(), goods);
//		System.out.println(goodsListInfo);
		
		StockInfo stockInfo = new StockInfo();
//		stockInfo.register(goods.getName(), 1);
//		System.out.println(stockInfo);
		
		StockAdder.addNewGoods(goods, 5, goodsListInfo, stockInfo);
		System.out.println(goodsListInfo);
		System.out.println(stockInfo);
		Goods goods2 = new Goods("임의의 상품 이름2", 2000, 20, 2);
		StockAdder.addNewGoods(goods2, 25, goodsListInfo, stockInfo);
		System.out.println(goodsListInfo);
		System.out.println(stockInfo);
	}
}
