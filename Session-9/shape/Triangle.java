package shape;

import java.util.Date;

import point.Point;

public class Triangle implements Shape {

	final private String name = "Triangle";
	private int side1;
	private int side2;
	private int side3;
	private Point startingPoint;
	
	private long timeStamp;

	public Triangle(Point startingPoint, int side1, int side2, int side3) {
		this.startingPoint = startingPoint;

		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
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
	public boolean isPointEnclosed(Point pointToBeChecked) {
		double area = getArea();
		//Point originTriangle = getOrigin();
		int height = (int) (area*2/this.side1);
		int vertex2Y = (int)height + (int)(this.getOrigin().getY_coordinate());
		int vertex2X = (int) (Math.sqrt((this.side2*this.side2) - (height-(int)(this.getOrigin().getY_coordinate()))*(height-(int)(this.getOrigin().getY_coordinate())))) + (int)(this.getOrigin().getX_coordinate()) ;
		int vertex3Y = (int)(this.getOrigin().getY_coordinate()) ;
		int vertex3X = (int)(this.getOrigin().getY_coordinate())+side1;
		Point vertex2 =new Point(vertex2X,vertex2Y);
		Point vertex3 =new Point(vertex3X,vertex3Y);
		
		if(vertex3.getX_coordinate()>vertex2.getX_coordinate()){
			return true;
		}else{
			return false;
		}
		
	}

}
