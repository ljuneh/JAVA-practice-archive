package com.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputBufferedReaderRead03 {
	private final static String FILEDIRBASE = "C:\\eclipse-java-2020-12-R-win32-x86_64\\eclipse\\eclipseWorkspace\\day18\\src\\com\\stream";
	private final static String sInFileName = FILEDIRBASE + "\\testdata.txt";	
	
	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(sInFileName);
			br = new BufferedReader(fr);
			String oneLine = "";
			oneLine = br.readLine();
			while(oneLine != null) {
				System.out.println(oneLine);
				oneLine = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("입출력 에러");
			e.printStackTrace();
		} 
	}
}
