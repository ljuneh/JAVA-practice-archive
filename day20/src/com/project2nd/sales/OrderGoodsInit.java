package com.project2nd.sales;

import java.util.ArrayList;

public class OrderGoodsInit {
	public OrderGoodsInit() {}
	
	public static ArrayList<OrderGoods> getInitOrderGoodsList(
			ArrayList<ArrayList<Material>> objMaterialInfo) {
		ArrayList<OrderGoods>  orderGoodsList = new ArrayList<>();
		// 주문상품: 커피1+얼음1+001 -> 11001
		// 커피/얼음 // 0~3: 커피, 4~7: 얼음
		for(ArrayList<Material> materialList : objMaterialInfo) {
			for(int i = 0, j= 4; i < 4; i++, j++) {
				OrderGoods orderGoods = new OrderGoods();
				orderGoods.setsGoodsCode(
						materialList.get(i).getiMaterialType() +
						materialList.get(j).getiMaterialType() +
						"00" + i);
				orderGoods.setsGoodsName(
						materialList.get(i).getsMaterialName());
				orderGoods.setsMaterialCode1(
						materialList.get(i).getsMaterialCode());
				orderGoods.setsMaterialCode2(
						materialList.get(j).getsMaterialCode());
				orderGoods.setiMaterialQty1(1);
				orderGoods.setiMaterialQty2(1);		
				orderGoodsList.add(orderGoods);
			}
		}
			
		return orderGoodsList;
		
	}
}
