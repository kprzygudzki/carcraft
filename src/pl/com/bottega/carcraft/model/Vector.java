package pl.com.bottega.carcraft.model;

/**
 * Created by kprzygudzki on 06.11.
 */
public class Vector {
	private int x;
	private int y;
	private double length;

	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
		length = Math.sqrt(x * x + y * y);
	}

	Vector(Point start, Point end){
		x = end.getX() - start.getX();
		y = end.getY() - start.getY();
		length = Math.sqrt(x * x + y * y);
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	double getLength() {
		return length;
	}
}
