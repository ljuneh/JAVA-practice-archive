package com.jdbc_practice;

public class SqlMention {


   // SalesInfo SQL QUERY
   private static String siQUERY1 = "select o.goodsname,s.orderquantity,s.salesdate\r\n"
			+ "from ordergoods o,salesinfo s\r\n"
			+ "where s.goodscode = o.goodscode and s.salesdate between ? and ? "
			+ " order by s.salesdate,o.goodsname ASC";
   
   // ProductInfo SQL QUERY
   private static String piQUERY1 = "SELECT GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQUANTITY, INSALES\r\n"
			+ "from ORDERGOODS\r\n"
			+ "where INSALES = ?";
   
   private static String piQUERY2 = "update ORDERGOODS\r\n"
			+ "set INSALES = ?\r\n"
			+ "where GOODSCODE = ?";

   private static String piQUERY3 = "SELECT INSALES FROM ORDERGOODS WHERE GOODSCODE = ?";
	
   private static String piQUERY4 = "INSERT INTO INSALESGOODS i (SEQ, GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQUANTITY)\n"
		   + "SELECT (SELECT MAX(SEQ) + 1 FROM INSALESGOODS),GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQUANTITY\n"
		   + "FROM ORDERGOODS o \n"
		   + "WHERE GOODSCODE = ?";
	
   private static String piQUERY5 = "DELETE FROM INSALESGOODS WHERE GOODSCODE = ?";   

   public String getsiQUERY1() {
      return siQUERY1;
   }

   
   // ProductInfo SQL QUERY
   public String getPiQUERY1() {
	   return piQUERY1;
   }
	
   public String getPiQUERY2() {
	   return piQUERY2;
   }
	
   public String getPiQUERY3() {
	   return piQUERY3;
   }
	
   public String getPiQUERY4() {
	   return piQUERY4;
   }
	
   public String getPiQUERY5() {
	   return piQUERY5;
   }


   
   
}