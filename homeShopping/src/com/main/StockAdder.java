package com.main;

public class StockAdder {
	
	public static void addNewGoods(Goods goods, int number, GoodsListInfo goodsListInfo, StockInfo stockInfo) {
		goodsListInfo.add(goods.getName(), goods);
		stockInfo.register(goods.getName(), number);
	}
}
