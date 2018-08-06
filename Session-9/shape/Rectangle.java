package shape;

import java.util.Date;

import point.Point;

public class Rectangle implements Shape {
	final private String name = "Rectangle";
	private Point startingPoint;
	private int height;
	private int width;
	private long timeStamp;

	public Rectangle(Point startingPoint, int height, int width) {
		this.startingPoint = startingPoint;
		this.height = height;
		this.width = width;
		this.timeStamp = (new Date()).getTime();
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
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
		return (height * width);
	}

	@Override
	public double getPerimeter() {
		return (2 * (height + width));
	}

	@Override
	public Point getOrigin() {
		return this.startingPoint;
	}
/**
 * checking if point is in the rectangle or not
 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean flag = false;
		double xmax = startingPoint.getX_coordinate() + width;
		double ymax = startingPoint.getY_coordinate() + height;

		if (point.getX_coordinate() < xmax && point.getY_coordinate() < ymax) {
			flag = true;
		}
		return flag;
	}

}
