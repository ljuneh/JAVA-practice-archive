package com.day06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Study01 {
	public static void main(String[] args) throws IOException {
		BufferedReader keywordInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("검색어를 입력하세요");
		String keywords = keywordInput.readLine();
		keywordInput.close();
		String[] keywordArray = keywords.split(" ");
		for (String key:keywordArray) {
			System.out.println(key);
		}
	
		
		File file = new File("C:\\Users\\hbi2\\Documents\\example.txt");
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String s;
		int nextLine = 0;
		HashMap<String, List<List<Integer>>> result = new HashMap<>();
		for(int i=0; i<keywordArray.length; i++) {
			List<List<Integer>> doubleList = new ArrayList<>();
			result.put(keywordArray[i], doubleList);
		}
		
		
		while((s = bf.readLine()) != null) {
			nextLine ++;
//			System.out.println(s);
//			String[] textArray = s.split(" ");
//			for(int i=0; i<textArray.length; i++) {
////				int keyIndex = Arrays.binarySearch(null, 0)
//			}
			for(int i=0;i<keywordArray.length;i++) {
				String keyword = keywordArray[i];
//				int point = s.indexOf(keyword);
				List<Integer> point = findIndexes(keyword, s);
//				System.out.println(keyword+" 포함된 위치는 " + nextLine+"줄 " + (point+1)+"번째");
				
				result.get(keyword).add( point);
			}
				
		}
		
		for(int i=0;i<keywordArray.length;i++) {
			System.out.println(keywordArray[i]);
			for(int j=0;j<result.get(keywordArray[i]).size(); j++) {
//				System.out.print(result.get(keywordArray[i]).get(j) + " ");
			}
			System.out.println(result.get(keywordArray[i]));
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static List<Integer> findIndexes(String word, String document) {
		List<Integer> indexList = new ArrayList<Integer> ();
		int index = document.indexOf(word);
		
		while(index != -1) {
			indexList.add(index+1);
			index = document.indexOf(word, index+1+word.length());
		}
		
		return indexList;
	}
}
