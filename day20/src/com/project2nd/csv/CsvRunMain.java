package com.project2nd.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class CsvRunMain implements CsvFilePath {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(fOrderInfo)));
		String oneLine = null;
		
		String firstLine = null;
		firstLine = br.readLine();
		String[] firstArr = firstLine.split(",");
		System.out.println(Arrays.toString(firstArr));
		
		boolean[] isNumberArr = new boolean[firstArr.length];
		String[] numberColumn = {"rawmaterialquantity","orderquantity", "seq"};
		
		for(int i=0; i<firstArr.length;i++) {
//			isNumberArr[i] = Arrays.asList(numberColumn).contains(firstArr[i]);
			boolean isNumber = false;
			for(String s: numberColumn) {
				if(s.equals(firstArr[i])) {
					isNumber = true;
				}
			}
			
			isNumberArr[i] = isNumber;
		}
		
		//////////////////////////////
		
		System.out.println(Arrays.toString(isNumberArr));
		boolean test = Arrays.asList(numberColumn).contains("seq");
		System.out.println("seq"+" : "+test);
		
		test = Arrays.asList(numberColumn).contains(firstArr[0].toCharArray());
		System.out.println(firstArr[0]);
		System.out.println(firstArr[0]+" : "+test);
		
		////////////////////////////////////
		
//		isNumberArr[0] = true;
		
		
		File fw = new File(fInsertScript);
		FileWriter fwr = new FileWriter(fw);
		
		String sColumTitle = "INSERT INTO orderinfo(";
		while((oneLine = br.readLine()) != null) {
			String retLine = "";
			retLine += sColumTitle;
			String[] sArr = oneLine.split(",");
			for(int i=0; i<sArr.length; i++) {
				retLine += firstArr[i];
				retLine += ",";
			}
			retLine = retLine.substring(0, retLine.length()-1);
			retLine +=") VALUES(";
			for(int i=0; i<sArr.length; i++) {
				if(isNumberArr[i]) {
//					System.out.println("숫자");
					retLine += sArr[i];
					retLine += ",";
				} else {
//					System.out.println("문자열");
					retLine += "'";
					retLine += sArr[i];
					retLine += "',";
				}
				
			}
			retLine = retLine.substring(0, retLine.length()-1);
			retLine +=");";
			
			
			System.out.println(retLine);
			fwr.write(retLine);
			fwr.write("\n");
		}
		fwr.write("COMMIT;");
		
		br.close();
		fwr.close();
	}
}
