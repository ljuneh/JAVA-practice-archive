package study.day14;

public class Rectangle implements Shape {
	
	private double weight;
	private double height;
    /**
     * Default constructor
     */
    public Rectangle() {
    }
    
    public Rectangle(double weight, double height) {
    	this.weight= weight;
    	this.height = height;
    }
    
    

	/**
     * @return
     */
    public void draw() {
//        String str = String.format("weight : %f, height : %f, area = %f", weight, height, weight*height);
        String str = "draw rectangle";
        System.out.println(str);
    }



}
