package study.day14;

public class Square implements Shape {

	private double weight;
	private double height;
    /**
     * Default constructor
     */
    public Square() {
    }
    
    public Square(double weight, double height) {
    	this.weight= weight;
    	this.height = height;
    }



	/**
     * @return
     */
    public void draw() {
//        String str = String.format("weight : %f, height : %f, area = %f", weight, height, weight*height);
    	String str = "draw square";
        System.out.println(str);
    }

}