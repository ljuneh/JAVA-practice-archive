package com.driver;

import java.util.ArrayList;

public interface FileDriver {
	ArrayList<String> fileOpen(String path);
	String searchContents(ArrayList<String> sArrayList, String searchword);
	
}
