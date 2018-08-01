package shape;

import java.util.*;

import point.Point;

public class Circle implements Shape {
	final private String name = "Circle";
	final private double PI = 3.1415;
    
	private String timeStamp;
	private Point center;
	private int radius;

	public Circle(Point center, int radius) {
		this.radius = radius;
		this.center = center;
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

/**
 * for getting the area of circle	
 */
	@Override
	public double getArea() {
		return (PI * radius * radius);
	}

/**
 * for getting the perimeter of circle
 */
	@Override
	public double getPerimeter() {
		return (2 * PI * radius);
	}

	/**
	 * the origin will considered to be a point on the circle that lies on the
	 * line connecting the center of the circle to the origin of the screen.
	 * 
	 * returning the origin
	 */

	@Override
	public Point getOrigin() {
		double firstRoot = 0;
		double secondRoot = 0;

		double m = center.getY_coordinate() / center.getY_coordinate();  //slope of line
		double a = 1 + Math.pow(m, 2); //coordinate of x^2
		double b = 2 * center.getX_coordinate() + 2 * m //coordinate of x
				* center.getY_coordinate();
		double c = (Math.pow(center.getX_coordinate(), 2)  //coordinate of 1
				+ Math.pow(center.getY_coordinate(), 2) - Math.pow(radius, 2));
		double d = Math.sqrt((Math.pow(b, 2)) - (4 * a * c)); //Discriminate of quadratic equation 

		if (d >= 0) {
			firstRoot = (b + d) / (2 * a);
			secondRoot = (b - d) / (2 * a);
		}
		double minRoot = firstRoot <= secondRoot ? firstRoot : secondRoot; //need to return the lower point
		Point OriginPoint = new Point(minRoot, m * minRoot);  //second point will be mx
		return OriginPoint;
	}

/**
 * for getting the distance between two point	
 * @param point1
 * @param point2
 * @return
 */
	private double getDistance(Point point1, Point point2) {
		double x1 = point1.getX_coordinate();
		double y1 = point1.getY_coordinate();

		double x2 = point2.getX_coordinate();
		double y2 = point2.getY_coordinate();

		double distance = Math.sqrt((Math.pow((y2 - y1), 2))
				+ (Math.pow((x2 - x1), 2)));
		return distance;
	}

/**
 * checking whether the point is enclosed or not	
 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean flag = false;
		double dis = getDistance(point, center);
		if (dis <= radius) {
			flag = true;
		}
		return flag;
	}

}
