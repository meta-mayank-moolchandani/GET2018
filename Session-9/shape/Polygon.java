package shape;

import java.util.Date;

import point.Point;

public class Polygon implements Shape {
	final private String name = "Polygon";

	private int side;
	private int numberOfSides;
	private Point startingPoint;

	private long timeStamp;



	public Polygon(Point startingPoint, int side, int numberOfSides) {
     	this.startingPoint =startingPoint;
		this.side = side;
		this.numberOfSides = numberOfSides;
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
	public boolean isPointEnclosed(Point pointToBeChecked) {
		Point originPolygon = getOrigin();
		int halfLengthOfSide = side / 2;
		int apothem = (int) (side/(2*Math.tan(180/numberOfSides)));
		int nextStepDistance = (apothem)*(apothem) - (halfLengthOfSide * halfLengthOfSide);
		if(nextStepDistance < 0)
		{
			nextStepDistance = - nextStepDistance;
		}
		int lengthOfMedian = (int) Math.sqrt(nextStepDistance); 
		System.out.println(lengthOfMedian);
		int originPoint = (int)this.getOrigin().getX_coordinate();
		int centerOfPolygonX = (int)this.getOrigin().getX_coordinate() + halfLengthOfSide;
		int centerOfPolygonY = (int)this.getOrigin().getY_coordinate() + lengthOfMedian;
		System.out.println("Center  "+centerOfPolygonX+" "+centerOfPolygonY);
		int AreaOfCircleEnclosingPolygon = (int)3.14 * lengthOfMedian *lengthOfMedian ;
		int distanceOfOriginAndPointEnclosed = (int) Math.sqrt((pointToBeChecked.getY_coordinate() - centerOfPolygonY) *(pointToBeChecked.getY_coordinate() - centerOfPolygonY) + (pointToBeChecked.getX_coordinate() - centerOfPolygonX) *(pointToBeChecked.getX_coordinate() - centerOfPolygonX) );
		int AreaOfCircleEnclosingPoint = (int)3.14 * (distanceOfOriginAndPointEnclosed) * (distanceOfOriginAndPointEnclosed);
		if(AreaOfCircleEnclosingPolygon > AreaOfCircleEnclosingPoint)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

}
