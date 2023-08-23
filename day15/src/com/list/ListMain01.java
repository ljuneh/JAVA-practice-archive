package com.list;

import java.util.ArrayList;
import java.util.List;

public class ListMain01 {
	public static void main(String[] args) {
		List<String> sName = new ArrayList<>();
		sName.add(0,"aa");
		sName.add("bb");
		sName.add("cc");
		
		System.out.println(sName.get(0));
		
		for(String s : sName) {
			System.out.println(s);
		}
		
		sName.remove(2);
		System.out.println(sName.toString());
		
	}
}
