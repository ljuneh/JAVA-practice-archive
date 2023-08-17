package com.inheritance;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class TV extends Media {
	private int size;

    /**
     * Default constructor
     */
    public TV() {
    	super();
    }
    
    public TV(boolean power, int volumn, int size) {
    	super(power, volumn);
    	this.size = size;
    }


     
    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void watch() {
        // TODO implement here
		String str = (this.isPower()) ? "hi have fun":"switch on";
    	System.out.println(str);
    }

}