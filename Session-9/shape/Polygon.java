package shape;

import java.util.Date;

import point.Point;

public class Polygon implements Shape {
	final private String name = "Polygon";

	private int side;
	private int numberOfSides;
	private Point startingPoint;
	private String timeStamp;



	public Polygon(Point startingPoint, int side, int numberOfSides) {
     	this.startingPoint =startingPoint;
		this.side = side;
		this.numberOfSides = numberOfSides;
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
		return (numberOfSides * (side * side))
				/ (4 * (Math.tan((Math.PI) / numberOfSides)));
	}

	@Override
	public double getPerimeter() {
		return  (side * numberOfSides);
	}

	@Override
	public Point getOrigin() {
		return this.startingPoint;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		// TODO Auto-generated method stub
		return false;
	}

}
