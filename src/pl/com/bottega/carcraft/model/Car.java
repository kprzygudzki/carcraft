package pl.com.bottega.carcraft.model;

/**
 * Created by kprzygudzki on 05.11.
 */

public class Car {
	private static final double FUEL_CAPACITY = 60.0;
	private static final int DEFAULT_DISTANCE = 1;
	private static final Point DEFAULT_LOCATION = new Point(0,0);

	private String name;
	private Point currentPosition;
	private double fuelLevel;
	private double fuelConsumption;

	public Car(String name, double fuelLevel, double fuelConsumption, Point location){
		this.name = name;
		this.fuelLevel = Math.min(fuelLevel, FUEL_CAPACITY);
		this.fuelConsumption = fuelConsumption;
		this.currentPosition = location;
	}

	public Car(String name, double fuelLevel, double fuelConsumption){
		this(name, fuelLevel, fuelConsumption, DEFAULT_LOCATION);
	}

	private boolean targetIsOutOfBound(Point location){
		return location.getX() < 0 && location.getY() < 0;
	}

	private double requiredFuel(double distance){
		return distance * fuelConsumption;
	}

	private boolean notEnoughFuel(double requiredFuel){
		return requiredFuel > fuelLevel;
	}

	public void moveTo(Point destination){
		Vector displacement = new Vector(currentPosition, destination);
		double totalDistance = displacement.getX() + displacement.getY();

		// int distanceX = Math.abs(destination.x - currentPosition.x);
		// int distanceY = Math.abs(destination.y - currentPosition.y);
		// double totalDistance = distanceX + distanceY;

		if (notEnoughFuel(requiredFuel(totalDistance)) || targetIsOutOfBound(destination))
			return;

		currentPosition.setPoint(destination);
		fuelLevel -= totalDistance * fuelConsumption;
	}

	public void moveShort(Point destination){
		Vector displacement = new Vector(currentPosition, destination);
		double totalDistance = displacement.getLength();

		// int distanceX = destination.x - currentPosition.x;
		// int distanceY = destination.y - currentPosition.y;
		// double totalDistance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

		if (notEnoughFuel(requiredFuel(totalDistance)) || targetIsOutOfBound(destination))
			return;

		currentPosition.setPoint(destination);
		fuelLevel -= totalDistance * fuelConsumption;
	}

	public void moveBy(Vector displacement){
		moveTo(new Point(currentPosition, displacement));
	}

	/*
	public void moveBy(int distanceX, int distanceY){
		moveTo(new Point(currentPosition.x + distanceX, currentPosition.y + distanceY));
	}
	*/

	public void left(int distance){

		Vector displacement = new Vector(-distance, 0);
		moveBy(displacement);
	}

	public void left(){
		left(DEFAULT_DISTANCE);
	}

	public void right(int distance){
		Vector displacement = new Vector(distance, 0);
		moveBy(displacement);
	}

	public void right(){
		right(DEFAULT_DISTANCE);
	}

	public void up(int distance){
		Vector displacement = new Vector(0, distance);
		moveBy(displacement);
	}

	public void up(){
		up(DEFAULT_DISTANCE);
	}

	public void down(int distance){
		Vector displacement = new Vector(0, -distance);
		moveBy(displacement);
	}

	public void down(){
		down(DEFAULT_DISTANCE);
	}

	public Point getCurrentPosition() {
		return currentPosition;
	}

	public int getX(){
		return currentPosition.getX();
	}

	public int getY(){
		return currentPosition.getY();
	}

	public String getName(){
		return name;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}
}
