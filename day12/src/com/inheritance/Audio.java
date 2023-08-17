package com.inheritance;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Audio extends Media {

    /**
     * Default constructor
     */
    public Audio() {
    	super();
    }
    
    public Audio(boolean power, int volumn) {
    	super(power, volumn);
    }

    public void tune() {
        // TODO implement here
    	String str = (this.isPower()) ? "hi":"turn it on";
    	System.out.println(str);
    }

}