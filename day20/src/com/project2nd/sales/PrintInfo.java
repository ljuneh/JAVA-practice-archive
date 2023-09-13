package com.project2nd.sales;

import java.util.ArrayList;

public class PrintInfo {
	public static void printOrderInfoList(
			ArrayList<OrderInfo> orderInfoList) {
		String sInfo = "";
		for(OrderInfo orderInfo : orderInfoList) {
			sInfo += orderInfo.getsGoodsCode() + ", ";
			sInfo += orderInfo.getiOrderQty() + ", ";
			sInfo += orderInfo.isbOrderConfirmed();
			System.out.println(sInfo);
			sInfo = "";
		}
		
	}

}
