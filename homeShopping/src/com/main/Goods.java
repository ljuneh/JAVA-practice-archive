package com.main;
public class Goods {
    private String name;
    private int price;
    private double size;
    private double weight;
	private int key;

    public Goods() {}
    public Goods(int key, String name, int price, double size, double weight) {
        this.key = key;
        this.name = name;
        this.price = price;
        this.size = size;
        this.weight = weight;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
        return String.format("제품 키: %d 이름: %s, 가격: %d원, 크기: %f, 무게: %f", key, name, price, size, weight);
    }
}
