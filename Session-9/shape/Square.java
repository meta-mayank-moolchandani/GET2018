package shape;

import java.util.Date;

import point.Point;

public class Square implements Shape {

	final private String name = "Square";
	private Point startingPoint;
	private int side;
	private String timeStamp;

	public Square(Point strtingPoint, int side) {
		this.startingPoint = strtingPoint;
		this.side = side;
		this.timeStamp = (new Date()).toString();
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	@Override
	public Point getOrigin() {
		return startingPoint;

	}

/**
 * checking if point is in the square or not	
 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean flag = false;
		double xmax = startingPoint.getX_coordinate() + side;
		double ymax = startingPoint.getY_coordinate() + side;

		if (point.getX_coordinate() < xmax && point.getY_coordinate() < ymax) {
			flag = true;
		}
		return flag;

	}

}
