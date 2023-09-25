package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsalesGoodsUserDAO {
	private static String QUERY1 = "select seq, goodscode, goodsname, rawmaterialcode, rawmaterialquantity\r\n"
			+ "from insalesgoods";
	private static String QUERY2 = "select i.seq, i.goodscode, i.goodsname, r.rawmaterialname, i.rawmaterialquantity\r\n"
			+ "from insalesgoods i, rawmaterial r\r\n"
			+ "where i.rawmaterialcode = r.rawmaterialcode";
	private static String QUERY3 = "select *\r\n"
			+ "from insalesgoods\r\n"
			+ "where goodscode = ?";
	
	

	
	public InsalesGoodsUserDAO() {}
	
	
	
	public static ArrayList<InsalesGoodsEntity> retInsalesGoodsArr() {
		ArrayList<InsalesGoodsEntity> inSalesGoodsArr = new ArrayList<InsalesGoodsEntity>();
		
		Connection conn = ConfigureImpl.getConnObject();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY1);
			while(rs.next()) {
				InsalesGoodsEntity insalesGoods = new InsalesGoodsEntity();
				insalesGoods.setSeq(rs.getInt(1));
				insalesGoods.setGoodsCode(rs.getString(2));
				insalesGoods.setGoodsName(rs.getString(3));
				insalesGoods.setRawMaterialCode(rs.getString(4));
				insalesGoods.setRawMaterialQuantity(rs.getInt(5));
				
				inSalesGoodsArr.add(insalesGoods);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inSalesGoodsArr;
	}
	
	public static ArrayList<ShowInsalesEntity> retShowInsalesArr() {
		ArrayList<ShowInsalesEntity> showInsalesArr = new ArrayList<ShowInsalesEntity>();
		
		Connection conn = ConfigureImpl.getConnObject();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY2);
			
			while(rs.next()) {
				ShowInsalesEntity showInsales = new ShowInsalesEntity();
				showInsales.setSeq(rs.getInt(1));
				showInsales.setGoodsCode(rs.getString(2));
				showInsales.setGoodsName(rs.getString(3));
				showInsales.setRawMaterialName(rs.getString(4));
				showInsales.setRawMaterialQuantity(rs.getInt(5));
				
				showInsalesArr.add(showInsales);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return showInsalesArr;
	}
	
	public static boolean searchInsalesGoodsByCode(String code) {
		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isSearched = false;
		try {
			pstmt = conn.prepareStatement(QUERY3);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			isSearched = rs.next();
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSearched;
	}
	

}
