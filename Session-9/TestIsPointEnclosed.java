import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import point.Point;
import shape.Shape;
import shape.ShapeFactory;
import shape.Shape.Shapes;


public class TestIsPointEnclosed {

	@Test
	public void testIsPointOnScreen() {
		Point StartingPoint = new Point(3, 3);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);

		/**
		 * shape is not added because starting point of the shape is not at the screen
		 */
		Shape shape1 = ShapeFactory.createShape(Shapes.CIRCLE, StartingPoint,
				list);
		
		Point point = new Point(3,3);
		boolean actualResult = shape1.isPointEnclosed(point);
		assertEquals(true, actualResult);
	}
	
	@Test
	public void test2IsPointOnScreen() {
		Point StartingPoint = new Point(3, 3);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);

		/**
		 * shape is not added because starting point of the shape is not at the screen
		 */
		Shape shape1 = ShapeFactory.createShape(Shapes.CIRCLE, StartingPoint,
				list);
		
		Point point = new Point(50,50);
		boolean actualResult = shape1.isPointEnclosed(point);
		assertEquals(false, actualResult);
	}
	


}
