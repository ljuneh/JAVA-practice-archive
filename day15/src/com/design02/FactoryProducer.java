package com.design02;

/**
 * 
 */
public class FactoryProducer {

    private boolean isRounded = false;
    
    public FactoryProducer() {
    }
    
    


    public boolean isRounded() {
		return isRounded;
	}




	public void setRounded(boolean isRounded) {
		this.isRounded = isRounded;
	}




	/**
     * @return
     */
    public AbstractFactory getFactory() {
    	AbstractFactory factory = null;
        if(isRounded) {
        	factory = new RoundedShapeFactory();
        } else {
        	factory = new ShapeFactory();
        }
        return factory;
    }

}