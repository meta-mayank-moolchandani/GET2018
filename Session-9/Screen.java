import shape.*;
import point.*;
import java.util.*;

public class Screen {

	private int maximumXcoordinate;
	private int maximumYcoordinate;
	private List<Shape> listOfShapes;

	/**
	 * @return the listOfShapes
	 */
	public List<Shape> getListOfShapes() {
		List<Shape> newList = new ArrayList<Shape>();
		for (Shape shape : listOfShapes) {
			newList.add(shape);
		}
		return newList;
	}

	/**
	 * constructor for initialising the values
	 * 
	 * @param maximumXcoordinate
	 * @param maximumYcoordinate
	 */
	public Screen(int maximumXcoordinate, int maximumYcoordinate) {
		this.maximumXcoordinate = maximumXcoordinate;
		this.maximumYcoordinate = maximumYcoordinate;
		listOfShapes = new ArrayList<Shape>();
	}

	/**
	 * checking the point exists or not on the screen
	 * 
	 * @param point
	 * @return
	 */
	public boolean isPointOnScreen(Point point) {
		boolean flag = true;
		if (point.getX_coordinate() > maximumXcoordinate
				|| point.getY_coordinate() > maximumYcoordinate) {
			flag = false;
		}
		return flag;
	}

	/**
	 * adding shape on screen
	 * 
	 * @param shape
	 * @return
	 */
	public boolean AddShape(Shape shape) {
		boolean flag = false;

		if (isPointOnScreen(shape.getOrigin())) {
			
			flag = listOfShapes.add(shape);
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * removing shape from the screen
	 * 
	 * @param shape
	 * @return
	 */
	public boolean RemoveShape(Shape shape) {
		boolean flag = false;
		if (isPointOnScreen(shape.getOrigin())) {
			flag = listOfShapes.remove(shape);
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * removing alll shapes from screen
	 * 
	 * @param shape
	 * @return
	 */
	public boolean RemoveAllShape() {
		listOfShapes.clear();
		return (listOfShapes.size() == 0) ? true : false;
	}

	/**
	 * sorting by the area
	 * 
	 * @return
	 */
	public List<Shape> sortByArea() {
		List<Shape> shapeList = getListOfShapes();
		List<Shape> sortedShapeList = new ArrayList<Shape>();

		while (shapeList.size() != 0) {
			int minIndex = findMinimumAreaIndex(shapeList);
			sortedShapeList.add(shapeList.get(minIndex));
			shapeList.remove(minIndex);
		}
		return sortedShapeList;
	}

	/**
	 * finding the maximum index from the list which has maximum area
	 * 
	 * @param list
	 * @return
	 */
	private int findMinimumAreaIndex(List<Shape> list) {
		double min = list.get(0).getArea();
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (min >= list.get(i).getArea()) {
				min = list.get(i).getArea();
				index = i;
			}
		}
		return index;
	}

	/**
	 * sorting list by parimeter
	 * 
	 * @return
	 */
	public List<Shape> sortByPerimeter() {
		List<Shape> shapeList = getListOfShapes();
		List<Shape> sortedShapeList = new ArrayList<Shape>();

		while (shapeList.size() != 0) {
			int minIndex = findMinimumPerimeterIndex(shapeList);
			sortedShapeList.add(shapeList.get(minIndex));
			shapeList.remove(minIndex);
		}
		return sortedShapeList;
	}

	/**
	 * finding the maximum index from the list which has mimimum perimeter
	 * 
	 * @param list
	 * @return
	 */
	private int findMinimumPerimeterIndex(List<Shape> list) {
		double min = list.get(0).getPerimeter();
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (min >= list.get(i).getPerimeter()) {
				min = list.get(i).getPerimeter();
				index = i;
			}
		}
		return index;
	}

	/**
	 * sorting list by parimeter
	 * 
	 * @return
	 */
	public List<Shape> sortByTimeStamp() {
		List<Shape> shapeList = getListOfShapes();
		List<Shape> sortedShapeList = new ArrayList<Shape>();

		while (shapeList.size() != 0) {
			int minIndex = findMinimumTimeStampIndex(shapeList);
			sortedShapeList.add(shapeList.get(minIndex));
			shapeList.remove(minIndex);
		}
		return sortedShapeList;
	}

	/**
	 * finding the maximum index from the list which has mimimum perimeter
	 * 
	 * @param list
	 * @return
	 */
	private int findMinimumTimeStampIndex(List<Shape> list) {
		double min = list.get(0).getPerimeter();
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (min >= list.get(i).getPerimeter()) {
				min = list.get(i).getPerimeter();
				index = i;
			}
		}
		return index;
	}

	
}
