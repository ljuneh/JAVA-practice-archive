package com.inheritance;

public class Main {
	public static void main(String[] args) {
		Audio objAudio = new Audio(true, 13);
		TV objTV = new TV(false, 50, 100);
		
		objTV.setPower(true);
		objTV.watch();
		
		objAudio.setVolumn(10);
		objAudio.tune();
	}
}
