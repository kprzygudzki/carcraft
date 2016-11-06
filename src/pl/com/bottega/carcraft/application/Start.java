package pl.com.bottega.carcraft.application;


import pl.com.bottega.carcraft.model.Car;
import pl.com.bottega.carcraft.model.Point;
import pl.com.bottega.carcraft.model.Vector;

/**
 * Created by kprzygudzki on 05.11.
 */
public class Start {

	public static void main(String[] args){
		Car fastCar = new Car("Fast", 70, 3);
		Car slowCar = new Car("Slow", 100, 2, new Point(10, 10));

		//fastCar.left();
		//fastCar.left();
		//fastCar.left(40);

		System.out.println(fastCar.getCurrentPosition());

		slowCar.moveTo(new Point(20, 20));
		System.out.println(slowCar.getX() + " " + slowCar.getY() + " " + slowCar.getFuelLevel());
		slowCar.moveBy(new Vector(5, 5));
		System.out.println(slowCar.getX() + " " + slowCar.getY() + " " + slowCar.getFuelLevel());
	}
}
