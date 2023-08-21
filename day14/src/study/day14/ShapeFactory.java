package study.day14;

public class ShapeFactory {

    /**
     * Default constructor
     */
    public ShapeFactory() {
    }

    public Shape getShape(String key) {
    	Shape shape = null;
        if(key=="Circle") {
        	shape = new Circle();
        } else if (key == "Square"){
        	shape = new Square();
        } else if (key == "Rectangle") {
        	shape = new Rectangle();
        }
        
        return shape;
    }

}
