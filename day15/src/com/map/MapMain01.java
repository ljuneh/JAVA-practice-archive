package com.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain01 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		System.out.println(map.get("a"));
		
		for(String s : map.keySet()) {
			System.out.println(s);
			System.out.println(map.get(s));
		}
		
		map.remove("c");
		System.out.println(map.toString());
		
		map.clear();
		System.out.println(map.toString());
	}
}
