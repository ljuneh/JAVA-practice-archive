package com.main;

import java.util.HashMap;

public class StockInfo {
	private HashMap<String, Integer> stockMap;
	
	public StockInfo() {
		this.stockMap = new HashMap<String, Integer>();
	}
	
	public void register(String key, int number) {
		stockMap.put(key, number);
	}
	
	@Override
	public String toString() {
		return stockMap.toString();
	}
	
	
}
