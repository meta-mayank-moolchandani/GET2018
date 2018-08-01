package shape;

import java.util.*;

import point.Point;
import shape.Shape.Shapes;

public class ShapeFactory {
	public static Shape createShape(Shapes shapeType, Point point, // Shapes is
																	// enum
			List<Integer> parameterList) {
		switch (shapeType) {
		case CIRCLE:
			return (new Circle(point, parameterList.get(0)));

		case POLYGON:
			return (new Polygon(point, parameterList.get(0),
					parameterList.get(1))); // side,number of side
		case RECTANGLE:
			return (new Rectangle(point, parameterList.get(0),
					parameterList.get(1))); // height and width
		case SQUARE:
			return (new Square(point, parameterList.get(0)));
		case TRIANGLE:
			return (new Triangle(point, parameterList.get(0),
					parameterList.get(1), parameterList.get(2)));
		default:
			return null;

		}

	}

}
