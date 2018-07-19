package area;

public abstract class Area {
	private static final double HALF = 0.5;
	private static final double PI = 3.1415;

/**
 * calculates the area of triangle	
 * @param width
 * @param height
 * @return
 */
	public static double areaOfTraiangle(int width, int height){
		double area= HALF * width * height;
		return area;
	}

/**
 * calculates the area of rectangle	
 * @param width
 * @param height
 * @return
 */
	public static double areaOfRectangle(int width, int height){
		double area = width * height;
		return area;
	}

/**
 * calculates the area of square	
 * @param side
 * @return
 */
	public static double areaOfSquare(int side){
		double area= side * side;
		return area;
	}

/**
 * calculates the area of circle	
 * @param radius
 * @return
 */
	public static double areaOfCircle(int radius){
		double area= PI*radius*radius;
		return area;
	}

}
