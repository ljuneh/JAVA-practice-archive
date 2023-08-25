package com.main;

public class Goods {
	private String name;
	private int price;
	private double size;
	private double weight;
//	private String key;
	
	public Goods() {}
	public Goods(String name, int price, double size, double weight) {
		this.name = name;
		this.price = price;
		this.size = size;
		this.weight = weight;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("제품 이름: %s, 가격: %d원, 크기: %f, 무게: %f", name, price, size, weight);
	}
}
