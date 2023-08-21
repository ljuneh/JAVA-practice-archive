package study.day14;

public class Circle implements Shape {
	
	private double r;
	
    /**
     * Default constructor
     */
    public Circle() {
    }
    
    public Circle(double r) {
    	this.r = r;
    }
    

	/**
     * @return
     */
    public void draw() {
//    	String str = String.format("radius : %f, circumference : %f, area = %f", r, Math.PI*2*r, Math.PI*r*r);
    	String str = "draw circle";
        System.out.println(str);
    }

}
