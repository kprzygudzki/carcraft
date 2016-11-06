package pl.com.bottega.carcraft.model;

/**
 * Created by kprzygudzki on 05.11.
 */
public class Point {
	private int x;
	private int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	Point(Point start, Vector displacement){
		x = start.x + displacement.getX();
		y = start.y + displacement.getY();
	}

	int getX(){
		return x;
	}

	int getY(){
		return y;
	}

	void setPoint(Point point){
		x = point.getX();
		y = point.getY();
	}
}
