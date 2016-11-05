package pl.com.bottega.carcraft.application;

import pl.com.bottega.carcraft.model.Car;

/**
 * Created by kprzygudzki on 05.11.
 */
public class Start {

	public static void main(String[] args){
		Car fastCar = new Car("Fast", 70, 15);
		Car slowCar = new Car("Slow", 50, 10, 100, 100);

		//fastCar.left();
		//fastCar.left();
		//fastCar.left(40);

		//System.out.println(fastCar.getX());

		slowCar.moveTo(20, 20);
		System.out.println(slowCar.getX() + " " + slowCar.getY() + " " + slowCar.getFuelLevel());
	}
}
