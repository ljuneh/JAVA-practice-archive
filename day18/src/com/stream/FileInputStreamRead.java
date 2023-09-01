package com.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamRead {
	private final static String FILED = "C:\\eclipse-java-2020-12-R-win32-x86_64\\eclipse\\eclipseWorkspace\\day18\\src\\com\\stream";
	public static void main(String[] args) {
		File objFile = new File(FILED+"\\testdata.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(objFile);
			fos = new FileOutputStream(FILED+"\\testdataout.txt");
			while(fis.available()>0) {
				int read = fis.read();
				System.out.print((char)read);
				fos.write(read);
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not exists");
			e.printStackTrace();
		}
		 catch (IOException e) {
			 System.out.println("입출력 에러");
			 e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
