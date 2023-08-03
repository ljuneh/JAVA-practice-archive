package com.arcon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Study02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int randNum01 = (int)(Math.random()*99 + 1);
		int randNum02 = (int)(Math.random()*99 + 1);
		
		System.out.println(randNum01 + " : " + randNum02);
		int absDiff = Math.abs(randNum02-randNum01);
		System.out.println(absDiff);
		
		int[] randArray = new int[100];
		for(int i = 0; i<randArray.length; i++) {
			insertNumber(randArray, i);
		}
		for(int i = 0; i<randArray.length; i++) {
			System.out.println((i+1)+"번째 : "+randArray[i]);
		}
			
	}
	
	public static void insertNumber(int[] array, int index) {
		int randNum = (int)(Math.random()*999 + 1);
		if(!IntStream.of(array).anyMatch(x -> x == randNum)) {
			array[index] = randNum;
		} else {
//			array[index] = 100000;
			insertNumber(array, index);
		}
	}
}
