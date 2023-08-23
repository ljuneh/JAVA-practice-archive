package com.design02;

/**
 * 
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
		FactoryProducer factoryProducer = new FactoryProducer();
		factoryProducer.setRounded(true);
		AbstractFactory factory =  factoryProducer.getFactory();
		
		
		
		String key = "RoundedSquare";
		Shape shape = factory.getShape(key);
		shape.draw();
		
	}

}