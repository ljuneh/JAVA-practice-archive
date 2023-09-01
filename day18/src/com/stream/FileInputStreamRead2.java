package com.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputStreamRead2 {
	private final static String FILED = "C:\\eclipse-java-2020-12-R-win32-x86_64\\eclipse\\eclipseWorkspace\\day18\\src\\com\\stream";
	public static void main(String[] args) {
		File objFile = new File(FILED+"\\testdata.txt");
		FileReader fir = null;
		FileWriter fiw = null;
		
		try {
			fir = new FileReader(objFile);
			fiw = new FileWriter(FILED+"\\testdataout.txt");
			int i = 0;
			while((i = fir.read()) != -1) {
				System.out.print((char) i);
				fiw.write(i);
			}
			fir.close();
			fiw.close();
		}
		 catch (IOException e) {
			 System.out.println("입출력 에러");
			 e.printStackTrace();
		}
	}
}
