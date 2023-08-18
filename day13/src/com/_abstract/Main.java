package com._abstract;

public class Main {
	public static void main(String[] args) {
		Shape shape01 = new Circle(10, "circle");
		shape01.draw();
		
		Shape shape02 = new Rectange(10, 10, "rectange");
		shape02.draw();
		
		
	}
}
