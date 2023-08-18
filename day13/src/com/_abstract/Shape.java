package com._abstract;

public abstract class Shape {
	private String name;
	
	public Shape() {}
	public Shape(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract double area();
	
	public abstract double perimeter();
	
	public void draw() {
		String info = String.format("%s (≥–¿Ã=%f, µ—∑π=%f)", name, area(), perimeter());
		System.out.println(info);
	}
}
