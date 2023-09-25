package jdbc;

import java.util.ArrayList;

public class Testcode {
	
	public static void main(String[] args) {
		ArrayList<ShowInsalesEntity> showInsalesArr = InsalesGoodsUserDAO.retShowInsalesArr();
		for(ShowInsalesEntity showInsales: showInsalesArr) {
			System.out.println(showInsales);
		}
	}

}
