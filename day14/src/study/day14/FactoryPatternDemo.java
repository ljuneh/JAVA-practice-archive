package study.day14;



/**
 * 
 */
public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape = shapeFactory.getShape("Rectangle");
		shape.draw();
	}

}
