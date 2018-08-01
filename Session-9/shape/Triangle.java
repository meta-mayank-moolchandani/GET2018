package shape;

import java.util.Date;

import point.Point;

public class Triangle implements Shape {

	final private String name = "Triangle";
	private int side1;
	private int side2;
	private int side3;
	private Point startingPoint;
	private String timeStamp;

	public Triangle(Point startingPoint, int side1, int side2, int side3) {
		this.startingPoint = startingPoint;

		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
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
		double s = getPerimeter() / 2;
		double area = Math.sqrt((s * (s - side1)) + (s * (s - side2))
				+ (s * (s - side3)));
		return area;
	}

	@Override
	public double getPerimeter() {
		return (side1 + side2 + side3);
	}

	@Override
	public Point getOrigin() {
		return startingPoint;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		return true;
	}

}
