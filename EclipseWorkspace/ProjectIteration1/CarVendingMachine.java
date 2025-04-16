/**
 * 
 * @author Ramin Akbari
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
public class CarVendingMachine {
	//no initialization need for this class
	
	/**
	 * The code give the user options that read from a file, display, retrieve,
	 * and sort them.
	 * 
	 * @param args Command-line arguments (not used in this program).
	 * @throws IOException input output operations fails
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int floors = 0;
		int spaces = 0;
		int choice;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of floors for the car vending machine: ");
		floors = scanner.nextInt();
		System.out.println("Enter the Number of spaces for the car vending machine: ");
		spaces = scanner.nextInt();
		VendingMachine tower = new VendingMachine(floors, spaces);
		
		do {
			System.out.println("=== Car Vending Machine Menu ===");
			System.out.println("1. Load Car Data");
			System.out.println("2. Display Vending Machine");
			System.out.println("3. Retrieve a Car");
			System.out.println("4. Print Sorted Inventory (Price)");
			System.out.println("5. Print Sorted Inventory (Year)");
			System.out.println("6. Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice){
				case 1:
					String Filename;
					System.out.println("Enter the file name");
					Filename = scanner.next();
					try {
						File inputFileName = new File(Filename);
						Scanner inputFile = new Scanner(inputFileName);
						while(inputFile.hasNext())
						{
							int floor = inputFile.nextInt();
							int space = inputFile.nextInt();
							int year = inputFile.nextInt();
							double price = inputFile.nextDouble();
							String make = inputFile.next();
							String carName = inputFile.next();
							Car cars = new Car(carName, make, year, price);
							tower.addCar(floor, space, cars);
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
					break;
				case 2:
					tower.displayVM();
					break;
				case 3:
					int floor = 0;
					int space = 0;
					System.out.println("Enter floor to retrieve car: ");
					floor = scanner.nextInt();
					System.out.println("Enter Location to retrieve car: ");
					space = scanner.nextInt();
					tower.retrieveCar(floor, space);
					break;
				case 4:
					tower.sortByPrice();
					break;
				case 5:
					tower.sortByYear();
					break;
				case 6:
					System.out.println("Exiting program. Goodbye!");
					break;
					
					
			}
		} while(choice != 6);
			
        	 
     }

	}


/**
 * A car with a name, car make, year, and a price
 */

class Car{
	private String carName;
	private String make;
	private int year;
	private double price;
	
	
	/**
	 * contrsucts a car with the following parameter
	 * @param carName the name of the car
	 * @param make the cars make
	 * @param year the year of the car
	 * @param price the price of the car
	 */
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
	
	@Override
	public String toString() {
		return make + " "+ carName + " "+ year + " - $" + price;
	}
}


class VendingMachine {
	private Car tower[][];
	
	/**
	 * constructs a vending machine with the following parameters
	 * @param floor the number of floors
	 * @param space the number of spaces in each floor
	 */
	public VendingMachine(int floor, int space) {
		tower = new Car[floor][space];
	}
	
	// adds cars to the 2d array
	/**
	 * adds cars to the 2d array
	 * @param floor which floor the car will be placed
	 * @param space which space the car will be placed
	 * @param cars the car object that is added
	 */
	public void addCar(int floor, int space, Car cars) {
		if(floor < tower.length && space < tower[0].length && tower[floor][space]== null) {
			tower[floor][space] = cars;
		}
		else 
		{
			System.out.println("Error: Slot at Floor " + floor + " Space " +
			space + " is already occupied");
		}
	}
	
	
	//displays all the cars and their locations
	public void displayVM() {
		for(int row=0; row<tower.length; row++) {
			System.out.println("Floor " + (row + 1) + ": ");
			System.out.println();
			for(int col=0; col < tower[0].length; col++) {
				if(tower[row][col] == null) {
					System.out.println("Space " + (col + 1)+" Empty");
				}
				else {
					Car cars = tower[row][col];
					System.out.println("Space " + (col + 1) + ": " + cars.getMake() + 
							" " + cars.getCarName() + " " + cars.getYear() + " - $" + cars.getPrice());
				}
			}
		}
	}
	
	
	//retrieves a car from a specific location and fills the spot with null
	public void retrieveCar(int floor, int space) {
		if(floor < tower.length && space < tower[0].length && 
				tower[floor][space] != null) {
			System.out.println("Car retrieved from " + floor + " Location " +
				space + ": " + tower[floor][space]);
			tower[floor][space]= null;
		}
		else
		{
			System.out.println("No car located at Floor " + floor + 
					" Location " + space);
		}
	}
	
	
	//sorts the price of the cars from lowest to highest
	public void sortByPrice() {
		int maxCars = 0;
		int index = 0;
		for(int row = 0; row < tower.length; row++) {
			for(int col = 0; col < tower[0].length; col++) {
				if(tower[row][col] != null) {
					maxCars++;
				}
			}
		}
		//puts cars from 2d array into a 1d
		Car[] arrayOfCars = new Car[maxCars];
		for(int row = 0; row < tower.length; row++) {
			for(int col = 0; col < tower[0].length; col++) {
				if(tower[row][col] != null) {
					arrayOfCars[index]=tower[row][col];
					index++;
				}
			}
		}
		
		//insertion sort
		for(int i = 1; i < arrayOfCars.length; i++) {
			Car key = arrayOfCars[i];
			int position = i;
			
			while(position > 0 && arrayOfCars[position - 1].getPrice() > key.getPrice()) {
				arrayOfCars[position] = arrayOfCars[position - 1];
				position = position - 1;
			}
			arrayOfCars[position] = key;
		}
		
		//this part is to repopulate the 2d array
		int index2 = 0;
		for(int row = 0; row < tower.length; row++) {
			for(int col = 0; col< tower[0].length; col++) {
				if(index2< arrayOfCars.length) {
					tower[row][col] = arrayOfCars[index2];
					index2++;
				}
				else {
					tower[row][col]=null;
				}
			}
		}
		System.out.println("Sorted inventory by price: ");
		for(int i=0; i<arrayOfCars.length; i++) {
			System.out.println(arrayOfCars[i]);
		}
	}
	
	//sorts the cars by year from oldest to newest
	public void sortByYear() {
		int maxCars = 0;
		int index = 0;
		for(int row = 0; row < tower.length; row++) {
			for(int col = 0; col < tower[0].length; col++) {
				if(tower[row][col] != null) {
					maxCars++;
				}
			}
		}
		//puts cars from 2d array into a 1d
		Car[] arrayOfCars = new Car[maxCars];
		for(int row = 0; row < tower.length; row++) {
			for(int col = 0; col < tower[0].length; col++) {
				if(tower[row][col] != null) {
					arrayOfCars[index]=tower[row][col];
					index++;
				}
			}
		}
		
		//insertion sort
		for(int i = 1; i < arrayOfCars.length; i++) {
			Car year = arrayOfCars[i];
			int position = i;
			
			while(position > 0 && arrayOfCars[position - 1].getYear() > year.getYear()) {
				arrayOfCars[position] = arrayOfCars[position - 1];
				position = position - 1;
			}
			arrayOfCars[position] = year;
		}
		
		//this part is to repopulate the 2d array
		int index2 = 0;
		for(int row = 0; row < tower.length; row++) {
			for(int col = 0; col< tower[0].length; col++) {
				if(index2< arrayOfCars.length) {
					tower[row][col] = arrayOfCars[index2];
					index2++;
				}
				else {
					tower[row][col]=null;
				}
			}
		}
		System.out.println("Sorted inventory by year: ");
		for(int i=0; i<arrayOfCars.length; i++) {
			System.out.println(arrayOfCars[i]);
		}
	}
	
}
