package com.project2nd.sales;
import java.util.ArrayList;

public class MaterialInit {

	public MaterialInit() {}
	
	public static ArrayList<Material> getInitMaterialList() {
		
		ArrayList<Material> rawMatList = new ArrayList<>();
		
		Material mat1 = new Material(1, "11111", "원재료1", "1");
		rawMatList.add(mat1);
		Material mat2 = new Material(2, "22222", "원재료2", "1");
		rawMatList.add(mat2);
		
		Material mat26 = new Material(26, "288886", "원재료26", "2");
		rawMatList.add(mat26);
		Material mat27 = new Material(27, "299997", "원재료27", "2");
		rawMatList.add(mat27);
		
		Material mat51 = new Material(51, "566661", "원재료51", "3");
		rawMatList.add(mat51);
		Material mat52 = new Material(52, "577772", "원재료52", "3");
		rawMatList.add(mat52);
		
		Material mat76 = new Material(76, "844436", "원재료76", "4");
		rawMatList.add(mat76);
		Material mat77 = new Material(77, "855547", "원재료77", "4");
		rawMatList.add(mat77);
		
		
		
		return rawMatList;
	}
}

