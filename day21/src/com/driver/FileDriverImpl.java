package com.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileDriverImpl implements FileDriver{

	@Override
	public ArrayList<String> fileOpen(String path) {
		// TODO Auto-generated method stub
		
		File file = new File(path);
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> sArrList = new ArrayList<String>();
		
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String oneLine = null;
			while((oneLine = br.readLine()) != null) {
				sArrList.add(oneLine);
			}
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sArrList;
		
	}

	@Override
	public String searchContents(ArrayList<String> sArrayList, String searchword) {
		// TODO Auto-generated method stub
		
		String sRet = null;
		for(String str : sArrayList) {
			if(str.contains(searchword)) {
				sRet = str;
				break;
			}
		}
		return sRet;
	}

}
