package com.driver;

import java.nio.file.Paths;
import java.util.ArrayList;

public class FileClient {
	public static void main(String[] args) {
		String currentPath = Paths.get("").toAbsolutePath().toString();
		String fName = currentPath+"\\src\\com\\driver\\데이터정보저장.txt";
		
		String searchWord = "경기";
		
		FileDriver fdr = new FileDriverImpl();
		ArrayList<String> aStrList = fdr.fileOpen(fName);
		String sRet = fdr.searchContents(aStrList, searchWord);
		System.out.println(sRet);
	}
}
