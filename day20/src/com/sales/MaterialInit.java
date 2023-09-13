package com.sales;

import java.util.ArrayList;

public class MaterialInit {

	public MaterialInit() {}
	
	public static ArrayList<ArrayList<Material>> getInitMaterialList() {
		ArrayList<ArrayList<Material>> objMaterialList = 
				new ArrayList<ArrayList<Material>>();	
		// 1. 커피(1)/아이스(2) 종류 원재료 초기화
		ArrayList<Material> objCoffeeMaterialList = 
				new ArrayList<Material>();
		objCoffeeMaterialList.add(new Material("123_1", "원두1", 1));
		objCoffeeMaterialList.add(new Material("234_1", "원두2", 1));
		objCoffeeMaterialList.add(new Material("345_1", "원두3", 1));
		objCoffeeMaterialList.add(new Material("456_1", "원두4", 1));
		objCoffeeMaterialList.add(new Material("567_1", "얼음1", 2));
		objCoffeeMaterialList.add(new Material("678_1", "얼음2", 2));
		objCoffeeMaterialList.add(new Material("789_1", "얼음3", 2));
		objCoffeeMaterialList.add(new Material("891_1", "얼음4", 2));
		objMaterialList.add(objCoffeeMaterialList);
		
		// 2. 쥬스(3)/크림(4) 종류 원재료 초기화
		ArrayList<Material> objJuiceMaterialList = 
				new ArrayList<Material>();		
		objJuiceMaterialList.add(new Material("123_2", "쥬스1", 3));
		objJuiceMaterialList.add(new Material("234_2", "쥬스2", 3));
		objJuiceMaterialList.add(new Material("345_2", "쥬스3", 3));
		objJuiceMaterialList.add(new Material("456_2", "쥬스4", 3));
		objJuiceMaterialList.add(new Material("567_2", "크림1", 4));
		objJuiceMaterialList.add(new Material("678_2", "크림2", 4));
		objJuiceMaterialList.add(new Material("789_2", "크림3", 4));
		objJuiceMaterialList.add(new Material("891_2", "크림4", 4));
		objMaterialList.add(objJuiceMaterialList);
		
		return objMaterialList;
	}
}

