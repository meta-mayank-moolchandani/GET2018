import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import point.Point;
import shape.Shape;
import shape.ShapeFactory;
import shape.Shape.Shapes;


public class TestRemoveAll {

	@Test
	public void testRemoveAllShape() {
		Screen screen = new Screen(100, 100);

		Point StartingPoint = new Point(10, 10);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(3);

		Shape shape1 = ShapeFactory.createShape(Shapes.TRIANGLE, StartingPoint,
				list);

		Point StartingPoint2 = new Point(50, 50);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);

		Shape shape2 = ShapeFactory.createShape(Shapes.SQUARE, StartingPoint2,
				list1);

		Point StartingPoint3 = new Point(25, 25);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(2);
		list3.add(3);

		Shape shape3 = ShapeFactory.createShape(Shapes.RECTANGLE,
				StartingPoint3, list3);

		screen.AddShape(shape1);
		screen.AddShape(shape2);
		screen.AddShape(shape3);

		List<Shape> shapeList = screen.getListOfShapes();
		for (Shape shape : shapeList) {
			System.out.println(shape.getName());
		}

		boolean actualResult = screen.RemoveAllShape();


		System.out.println("new list after deletion");
		List<Shape> shapeListUpdated = screen.getListOfShapes();
		for (Shape shape : shapeListUpdated) {
			System.out.println(shape.getName());
			
			assertEquals("true if successfully removed",true, actualResult);
		}
	}

}
