import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import point.Point;
import shape.Shape;
import shape.ShapeFactory;
import shape.Shape.Shapes;


public class TestAddShape {

	@Test
	public void test1AddShape() {
		Screen screen  =  new Screen(100, 100);
		
		Point StartingPoint = new Point(101, 101);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(3);

		/**
		 * shape is not added because starting point of the shape is not at the screen
		 */
		Shape shape1 = ShapeFactory.createShape(Shapes.TRIANGLE, StartingPoint,
				list);
		boolean actualResult = screen.AddShape(shape1);
		
		assertEquals(false, actualResult);
		List<Shape> shapeList = screen.getListOfShapes();
		for(Shape shape:shapeList){
			System.out.println(shape.getName());
		}
	}
	
	@Test
	public void test2AddShape() {
		Screen screen  =  new Screen(100, 100);
		
		Point StartingPoint = new Point(10, 10);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(3);

		Shape shape1 = ShapeFactory.createShape(Shapes.TRIANGLE, StartingPoint,
				list);
		boolean actualResult = screen.AddShape(shape1);
		List<Shape> shapeList = screen.getListOfShapes();
		for(Shape shape:shapeList){
			System.out.println("test2 shape added:"+shape.getName());
		}
		
		assertEquals(true, actualResult);
	}


}
