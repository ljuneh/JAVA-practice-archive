package com._abstract;

public class Circle extends Shape {
	private double r;
	public Circle() {}
	public Circle(double r, String name) {
		super(name);
		this.r = r;
	}
	@Override
	public double area() {
		double dArea = Math.PI*r*r;
		return dArea;
	}

	@Override
	public double perimeter() {
		double dPerimeter = Math.PI*r*2;
		return dPerimeter;
	}

}
