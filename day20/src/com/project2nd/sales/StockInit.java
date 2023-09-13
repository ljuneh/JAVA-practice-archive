package com.project2nd.sales;

import java.util.ArrayList;

public class StockInit {
	
	public StockInit() {}
	
	public static ArrayList<Stock> getInitStockList(
			ArrayList<Material> objMaterialInfo) {
		
		ArrayList<Stock> stockInitList = 
				new ArrayList<>();
		
		for(int i = 0; i < objMaterialInfo.size(); i++) {
			
			stockInitList.add(
			new Stock(objMaterialInfo.get(i).getsMaterialCode(), 30));
			
		}
		
		return stockInitList;
		
	}
}
