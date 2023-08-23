package com.design02;

/**
 * 
 */
public class RoundedShapeFactory extends AbstractFactory {

    /**
     * Default constructor
     */
    public RoundedShapeFactory() {
    }



    /**
     * @return
     */
    @Override
    public Shape getShape(String key) {
        Shape shape = null;
        if (key == "RoundedRectangle") {
        	shape = new RoundedRectangle();
        } else if (key == "RoundedSquare") {
        	shape = new RoundedSquare();
        }
        return shape;
    }

}