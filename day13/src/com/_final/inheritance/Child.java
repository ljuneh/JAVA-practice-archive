package com._final.inheritance;

public class Child extends Parent{
	private int child01;
	
	public Child() {}
	public Child(int child01) {
		this.child01 = child01;
	}
	public Child(int parent01, int parent02, int child01) {
		super(parent01, parent02);
		this.child01 = child01;
	}
	public int getChild01() {
		return child01;
	}
	public void setChild01(int child01) {
		this.child01 = child01;
	}
}
