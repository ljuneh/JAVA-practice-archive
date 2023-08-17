package com.inheritance;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Media {
	
	private boolean power;

    private int volumn;
	

    /**
     * Default constructor
     */
    public Media() {}
    
    public Media(boolean power, int volumn) {
    	this.power = power;
    	this.volumn = volumn;
    }

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
    
    

}