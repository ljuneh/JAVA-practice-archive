package com.design02;

/**
 * 
 */
public abstract class AbstractFactory {

    /**
     * Default constructor
     */
    public AbstractFactory() {
    }

    /**
     * @return
     */
    public abstract Shape getShape(String key);

}