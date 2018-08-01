package shape;

import point.Point;

public interface Shape {
	enum Shapes {
		SQUARE("Square"), RECTANGLE("Rectangle"), CIRCLE("Circle"), TRIANGLE(
				"Triangle"), POLYGON("Polygon");

		private String type;

		Shapes(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
	public String getName();
	public double getArea();

	public double getPerimeter();

	public Point getOrigin();

	public boolean isPointEnclosed(Point point);
	
	
}
