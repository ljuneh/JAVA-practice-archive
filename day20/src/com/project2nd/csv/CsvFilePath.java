package com.project2nd.csv;

import java.nio.file.Paths;

public interface CsvFilePath {
	public final static String currentPath = Paths.get("").toAbsolutePath().toString();
	public final static String fInsalesGoods = currentPath + "\\src\\com\\project2nd\\csv\\insalesgoods.csv";
	public final static String fOrderGoods = currentPath + "\\src\\com\\project2nd\\csv\\ordergoods.csv";
	public final static String fOrderInfo = currentPath + "\\src\\com\\project2nd\\csv\\orderinfo.csv";
	public final static String fRawMat = currentPath + "\\src\\com\\project2nd\\csv\\rawmaterial.csv";
	public final static String fSalesInfo = currentPath + "\\src\\com\\project2nd\\csv\\salesinfo.csv";
	public final static String fStockInfo = currentPath + "\\src\\com\\project2nd\\csv\\stockinfo.csv";
	public final static String fInsertScript = currentPath + "\\src\\com\\project2nd\\csv\\insertscript.txt";
}
