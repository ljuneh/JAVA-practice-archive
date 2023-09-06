package com.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class FileReadLikeDataBase {
	public static void main(String[] args) throws IOException {
		String currentPath = Paths.get("").toAbsolutePath().toString();
		System.out.println(currentPath);
		
		File objFile =  new File(currentPath+"\\src\\com\\database\\tablelikedata.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(objFile));
		
		String oneLine = null;
		System.out.println("studentid name departmentid");
		int iLineType = 0;  // 0: 타이틀 1: 데이터
		while((oneLine = br.readLine()) != null) {
			if(oneLine.startsWith("Title")) {
				iLineType = 0;
			} else if(oneLine.startsWith("Data")) {
				iLineType = 1;
			}
			
			if(iLineType == 1) {
				String[] sSplitVal = oneLine.split("#");
				System.out.print(sSplitVal[1] + " ");
				System.out.print(sSplitVal[2] + " ");
				System.out.print(sSplitVal[3] + " ");
				System.out.println();
			}
		}
		
		
		br.close();
		
		
	}
}
