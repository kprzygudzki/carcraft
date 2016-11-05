package pl.com.bottega.carcraft.model;

/**
 * Created by kprzygudzki on 05.11.
 */

public class Car {
	private static final double FUEL_CAPACITY = 60.0;
	private static final int DEFAULT_DISTANCE = 1;
	private static final int DEFAULT_X = 0;
	private static final int DEFAULT_Y = 0;

	private String name;
	private int x;
	private int y;
	private double fuelLevel;
	private double fuelConsumption;

	public Car(String name, double fuelLevel, double fuelConsumption, int x, int y){
		this.name = name;
		this.fuelLevel = Math.min(fuelLevel, FUEL_CAPACITY);
		this.fuelConsumption = fuelConsumption;
		this.x = x;
		this.y = y;
	}

	public Car(String name, double fuelLevel, double fuelConsumption){
		this(name, fuelLevel, fuelConsumption, DEFAULT_X, DEFAULT_Y);
	}

	private boolean targetIsOutOfBound(int targetX, int targetY){
		return targetX < 0 && targetY < 0;
	}

	private double requiredFuel(double distance){
		return distance * fuelConsumption;
	}

	private boolean notEnoughFuel(double requiredFuel){
		return requiredFuel > fuelLevel;
	}

	public void moveTo(int targetX, int targetY){
		int distanceX = Math.abs(targetX - x);
		int distanceY = Math.abs(targetY - y);
		double totalDistance = distanceX + distanceY;

		if (notEnoughFuel(requiredFuel(totalDistance)) || targetIsOutOfBound(targetX, targetY))
			return;

		x = targetX;
		y = targetY;

		fuelLevel -= totalDistance * fuelConsumption;
	}

	public void moveShort(int targetX, int targetY){
		int distanceX = targetX - x;
		int distanceY = targetY - y;
		double totalDistance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

		if (notEnoughFuel(requiredFuel(totalDistance)) || targetIsOutOfBound(targetX, targetY))
			return;

		x = targetX;
		y = targetY;
		fuelLevel -= totalDistance * fuelConsumption;
	}

	public void moveBy(int distanceX, int distanceY){
		int targetX = x + distanceX;
		int targetY = y + distanceY;

		moveTo(targetX, targetY);
	}

	public void left(int distance){
		int targetX = x + distance;
		int targetY = y;

		moveTo(targetX, targetY);
	}

	public void left(){
		left(DEFAULT_DISTANCE);
	}

	public void right(int distance){
		int targetX = x + distance;
		int targetY = y;

		moveTo(targetX, targetY);
	}

	public void right(){
		right(DEFAULT_DISTANCE);
	}

	public void up(int distance){
		int targetX = x + distance;
		int targetY = y;

		moveTo(targetX, targetY);
	}

	public void up(){
		up(DEFAULT_DISTANCE);
	}

	public void down(int distance){
		int targetX = x + distance;
		int targetY = y;

		moveTo(targetX, targetY);
	}

	public void down(){
		down(DEFAULT_DISTANCE);
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public String getName(){
		return name;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}
}
