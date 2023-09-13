package com.sales;

import java.util.ArrayList;

public class StockInit {
	
	public StockInit() {}
	
	public static ArrayList<Stock> getInitStockList(
			ArrayList<ArrayList<Material>> objMaterialInfo) {
		
		ArrayList<Stock> stockInitList = 
				new ArrayList<>();
		
		for(int i = 0; i < objMaterialInfo.size(); i++) {
			for(int j = 0; j < objMaterialInfo.get(i).size(); j++) {
				stockInitList.add(
				new Stock(
						objMaterialInfo.get(i).get(j).getsMaterialCode(), 
						(int)(Math.random() * 100 + 1)));
			}
		}
		
		return stockInitList;
		
	}
}
