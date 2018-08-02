package point;

public class Point {
	private double x_coordinate;
	private double y_coordinate;

	public Point(double x_coordinate, double y_coordinate) {
		super();
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
	}

	/**
	 * @return the x_coordinate
	 */
	public double getX_coordinate() {
		return x_coordinate;
	}

	/**
	 * @return the y_coordinate
	 */
	public double getY_coordinate() {
		return y_coordinate;
	}
}
