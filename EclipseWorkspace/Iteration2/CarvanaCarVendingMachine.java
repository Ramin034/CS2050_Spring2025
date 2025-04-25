/** @author Ramin Akbari
 * @version 3/28/25
 */


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
* 
* the CarVendingMachine class is a car vending machine
* it uses a menu to allow a user to navigate through
* 
* features:
* load in a file of cars
* display cars
* retrieve car
* sort cars by price
* sort cars by year
* 
* default constructor for CarVendingMachine class
* initializes the vending machine system
*/


public class CarvanaCarVendingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}

abstract class Car{
	private String carName;
	private String make;
	private int year;
	private double price;
	
	public Car(String carName, String make, int year, double price) {
		this.carName =  carName;
		this.make = make;
		this.year = year;
		this.price = price;
	}
	
	public String getCarName() {
		return carName;
	}
	
	public String getMake() {
		return make;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}
	
	public abstract String getType();
	
	@Override
	public String toString() {
		return make + " "+ carName + " "+ year + " - $" + price;
	}
	
}

class BasicCar extends Car{
	public BasicCar(String carName, String make, int year, double price){
		super(carName, make, year, price);
	}
	
	@Override
	public String getType() {
		return "Basic";
	}
}

class PremiumCar extends Car{
	public PremiumCar(String carName, String make, int year, double price) {
		super(carName, make, year, price);
	}
	
	@Override
	public String getType() {
		return "Premium";
	}
}

class VendingMachine{
	private int floors;
	private int spaces;
	private Map<String, Car>carTower = new HashMap<>();
	private Queue<Car> carWashQueue = new LinkedList<>();
	
	public VendingMachine(int floors, int spaces) {
		this.floors = floors;
		this.spaces = spaces;
	}
	
	public void loadFromFile(String filename) {
		try {
			File inputFileName = new File(filename);
			Scanner inputFile = new Scanner(inputFileName);
			while(inputFile.hasNext())
			{
				String carType = inputFile.next();
				int floor = inputFile.nextInt();
				int space = inputFile.nextInt();
				int year = inputFile.nextInt();
				double price = inputFile.nextDouble();
				String make = inputFile.next();
				String carName = inputFile.next();	
				Car cars = null;
				if(carType.equals("B")) {
					cars = new BasicCar(carName, make, year, price);
				}
				else if(carType.equals("P")) {
					cars = new PremiumCar(carName, make, year, price);
				}
			}
			inputFile.close();
		} 
		catch(FileNotFoundException e) 
		{
			System.out.println("Error: File Not Found");
		}
		catch(IOException e)
		{
			System.out.println("Unexpected Error Occurred");
		}
	}
	
	public void addCar(int floor, int space, Car car) {
		if(floor < 1 || floor > floors || space < 1 || space > spaces) {
			System.out.println("Error: Invalid position at Floor " + floor +
			" Space " + space);
			System.out.println();
			System.out.println("Cannot place Car: " + car + " (Floor: " + floor + 
			", Space: " + space + ")");
		}
		else {
			String key = floor + "-" + space;
			if(carTower.containsKey(key)) {
				System.out.println("Error: Slot at Floor " + floor + " Space " +
				space + " is already occupied");
				System.out.println();
				System.out.println(car + " (Floor: " + floor + ", Space: " + space 
				+ ") cannot be placed.");
			}
			else {
				carTower.put(key, car);
			}
		}
	}
	
	
	
}