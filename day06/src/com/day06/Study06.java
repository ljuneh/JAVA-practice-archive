package com.day06;

import java.util.ArrayList;
import java.util.HashMap;

public class Study06 {
	public static void main(String[] args) {
		HashMap<String, ArrayList<Integer>> result = new HashMap<>();
		String[] keyArray = {"Lorem","ex","id"};
//		result.put("Lorem",null);
		for(int i=0; i<keyArray.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			result.put(keyArray[i], list);
		}
		System.out.println(result.get("Lorem"));
		result.get("Lorem").add(1);
		result.get("Lorem").add(11);
		result.get("ex").add(111);
		System.out.println(result.get("ex").get(0));
	}
}
