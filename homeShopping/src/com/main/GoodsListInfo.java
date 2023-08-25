package com.main;

import java.util.HashMap;

public class GoodsListInfo {
	private HashMap<String, Goods> goodsList;
	
	public GoodsListInfo() {
		this.goodsList = new HashMap<String, Goods>();
	}
	
	public void add(String key, Goods goods) {
		goodsList.put(key, goods);
	}
	
	public void remove(String key) {
		goodsList.remove(key);
	}
	
	public Goods getGoods(String key) {
		return goodsList.get(key);
	}
	
	@Override
	public String toString() {
		return goodsList.toString();
	}
	
}
