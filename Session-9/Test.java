import java.util.*;

import shape.*;
import shape.Shape.Shapes;
import point.*;

public class Test {

	public static void main(String[] args) {
		Point StartingPoint = new Point(10, 10);
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(3);

		Shape shape1 = ShapeFactory.createShape(Shapes.TRIANGLE, StartingPoint,
				list);
		System.out.println("t:" + shape1.getArea());

		Point StartingPoint2 = new Point(50, 50);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);

		Shape shape2 = ShapeFactory.createShape(Shapes.SQUARE, StartingPoint2,
				list1);
		System.out.println("sq:" + shape2.getArea());

		Point StartingPoint3 = new Point(25, 25);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(2);
		list3.add(3);

		Shape shape3 = ShapeFactory.createShape(Shapes.RECTANGLE,
				StartingPoint3, list3);
		System.out.println("re:" + shape3.getArea());

		Point StartingPoint4 = new Point(25, 25);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(5);

		Shape shape4 = ShapeFactory.createShape(Shapes.SQUARE, StartingPoint4,
				list4);
		System.out.println("re:" + shape4.getArea());

		Screen screen = new Screen(1000, 1000);
		System.out.println(screen.AddShape(shape1));
		System.out.println(screen.AddShape(shape2));
		System.out.println(screen.AddShape(shape3));
		System.out.println(screen.AddShape(shape4));
		System.out.println("\n\n\n");

		List<Shape> oldShape = screen.getListOfShapes();
		for (Shape shape : oldShape) {
			System.out.println(shape.getName() + ":" + shape.getArea());
		}
		System.out.println("\n");

		List<Shape> xyz = screen.sortByArea();
		for (Shape shape : xyz) {
			System.out.println(shape.getName() + ":" + shape.getArea());
		}

		System.out.println("\n\nparimeter\n\n");

		for (Shape shape : oldShape) {
			System.out.println(shape.getName() + ":" + shape.getPerimeter());
		}
		System.out.println("\n");

		xyz = screen.sortByPerimeter();
		for (Shape shape : xyz) {
			System.out.println(shape.getName() + ":" + shape.getPerimeter());
		}

		Date date = new Date();
		System.out.println(date.toString());
		long xyzz = date.getTime();
		System.out.println(xyzz);

		System.out.println();
		long xyzzz = date.getTime();
		System.out.println(xyzzz);

		Point point = new Point(1, 1);
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		Shape shape = ShapeFactory.createShape(Shapes.CIRCLE, point, l);
		System.out.println(shape.getOrigin().getX_coordinate());

		System.out.println(shape.isPointEnclosed(new Point(2, 2)));
		System.out.println(shape.isPointEnclosed(new Point(1.2, 0)));

	}
}
