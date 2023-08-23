package com.design02;

/**
 * 
 */
public class ShapeFactory extends AbstractFactory {

    /**
     * Default constructor
     */
    public ShapeFactory() {
    }





    /**
     * @return
     */
    @Override
    public Shape getShape(String key) {
    	Shape shape = null;
    	if(key == "Rectangle") {
    		shape = new Rectangle();
    	} else if (key == "Square") {
    		shape = new Square();
    	}
        return shape;
    }

}