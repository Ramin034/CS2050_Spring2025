/** @author Ramin Akbari
 * @version 4/28/25
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
* searches for car
* queues for a car wash
* sells cars
* 
* default constructor for CarvanaCarVendingMachine class
* initializes the vending machine system
*/


public class CarvanaCarVendingMachine {
	
	/**
	 * launches main menu to interact and select options for the vending machine
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of floors for the car vending machine: ");
        int floors = scanner.nextInt();
        System.out.print("Enter the number of spaces for the car vending machine: ");
        int spaces = scanner.nextInt();
        scanner.nextLine();
        VendingMachine tower = new VendingMachine(floors, spaces);
        int choice;
        
        do {
        	System.out.println("=== Car Vending Machine Menu ===");
            System.out.println("1. Load Car Data from File");
            System.out.println("2. Display Vending Machine");
            System.out.println("3. Retrieve a Car by Location (Floor & Space)");
            System.out.println("4. Print Sorted Inventory (Price)");
            System.out.println("5. Print Sorted Inventory (Year)");
            System.out.println("6. Search for Cars (Manufacturer & Type)");
            System.out.println("7. Add Car to Wash Queue");
            System.out.println("8. Process Car Wash Queue");
            System.out.println("9. Sell a Car");
            System.out.println("10. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
            	case 1:
            		System.out.println("Enter the file name");
            		tower.loadFromFile(scanner.nextLine());
            		break;
            	case 2:
            		tower.DisplayVendingMachine();
            		break;
            	case 3:
            		System.out.print("Enter floor: ");
                    int inputFloor = scanner.nextInt();
                    System.out.print("Enter space: ");
                    int inputSpace = scanner.nextInt();
                    tower.RetrieveCar(inputFloor, inputSpace);
                    break;
            	case 4:
            		tower.SortByPrice();
            		break;
            	case 5:
            		tower.SortByYear();
            		break;
            	case 6:
            		System.out.println("Enter manufacturer: ");
            		String manufact = scanner.nextLine();
            		System.out.println("Enter car type (Basic/Premium): ");
            		String type = scanner.nextLine();
            		tower.SearchForCar(manufact, type);
            		break;
            	case 7:
            		System.out.println("Enter floor: ");
            		int washFloor = scanner.nextInt();
            		System.out.println("Enter space: ");
            		int washSpace = scanner.nextInt();
            		tower.addWashQueue(washFloor, washSpace);
            		break;
            	case 8:
            		tower.ProcessWashQueue();
            		break;
            	case 9:
            		System.out.println("Enter floor of the car to sell: ");
            		int sFloor = scanner.nextInt();
            		System.out.println("Enter space of the car to sell: ");
            		int sSpace = scanner.nextInt();
            		tower.SellingCar(sFloor, sSpace);
            		break;
            	case 10:
            		System.out.println("Exiting program. Goodbye!");
            		break;
            	default:
            		System.out.println("Invalid choice. Please try again.");
            }
            
            
        }while(choice != 10);

	}

}

/**
 * Abstract base class for car.
 * Subclasses must specify car type (Basic, Premium).
 */
abstract class Car{
	private String carName;
	private String make;
	private int year;
	private double price;
	
	/**
	 * constructs a car with the following parameters
	 * @param carName the model name of the car
	 * @param make the manufacturer of the car
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
	
	/**
	 * Defines the type of car Basic or Premium
	 * @return a string indicating if it is Basic or Premium
	 */
	public abstract String getType();
	
	@Override
	public String toString() {
		return getType() + " Car: " + make + " "+ carName + " "+ year + " - $" + price;
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
	
	/**
	 * The loadFromFile method takes in a filename and saves the data from the file
	 * @param filename
	 */
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
				if(cars != null) {
					addCar(floor, space, cars);
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
	
	/**
	 * adds car into the hashmap by checking if the location to store the car is 
	 * out of bounds or if the spot is already occupied
	 * @param floor
	 * @param space
	 * @param car
	 */
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
	
	
	/**
	 * The DisplayVendingMachine method displays all cars currently 
	 * stored in the vending machine.
     * Only occupied slots are shown.
	 */
	public void DisplayVendingMachine() {
		if(carTower.isEmpty()) {
			System.out.println("Vending machine is empty.");
		}
		else {
			for(Map.Entry<String, Car> entry : carTower.entrySet()) {
				String key = entry.getKey();
				String[] keyArray = key.split("-");
				int floor = Integer.parseInt(keyArray[0]);
				int space = Integer.parseInt(keyArray[1]);
				Car car = entry.getValue();
				System.out.println(car.getType() + " Car: "
			              + car.getMake() + " " + car.getCarName()
			              + " " + car.getYear() + " - $" + car.getPrice()
			              + " (Floor: " + floor + ", Space: " + space + ")");
			}
		}
		
	}
	
	/**
     * Removes and reports the car at a chosen location.
     * 
     * @param floor this is the floor number of the location
     * @param space this is the space number of the location
     */
	public void RetrieveCar(int floor, int space) {
		String key = floor + "-" + space;
        if (!carTower.containsKey(key)) {
            System.out.println("Car not found at this location.");
        } else {
            Car car = carTower.remove(key);
            System.out.println("Car retrieved: " + car + " (Floor: " + floor + ", Space: " + space + ")");
        }
	}
	
	/**
     * purpose is to help with sorting helper (unused option string parameter).
     *
     * @param comparing comparator for sorting
     * @param option descriptive header
     */
	public void Sorting(Comparator <Car> comparing, String option) {
		List<Car> cars = new ArrayList<>(carTower.values());
		cars.sort(comparing);
		for (Car sortedCar : cars) {
            System.out.println(sortedCar);
        }
        System.out.println();
		
	}
	
	/** Sorts and prints inventory by price (low to high). */
	public void SortByPrice() {
		Sorting(Comparator.comparing(Car :: getPrice), "Sorted Inventory By Price");
	}
	
	 /** Sorts and prints inventory by year (oldest to newest). */
	public void SortByYear() {
		Sorting(Comparator.comparing(Car :: getYear), "Sorted Inventory By Year");
	}
	
	/**
     * Does a search by manufacturer and type.
     *
     * @param manufacturer the make to match
     * @param type         "Basic" or "Premium"
     */
	public void SearchForCar(String manufacturer, String type) {
		List<Car> foundCars = findCars(new ArrayList<>(carTower.values()), manufacturer, type);
        printCars(foundCars, manufacturer, type);
		
	}
	
	/**
     * Filters a list of cars by make and type.
     *
     * @param inventory    list of cars to search
     * @param manufacturer case-insensitive make to match
     * @param type         case-insensitive type to match
     * @return list of matching cars
     */
	public static List<Car> findCars(List<Car> inventory, String manufacturer, String type){
		List<Car> results = new ArrayList<>();
		
		for(Car cars : inventory) {
			if(cars.getMake().equalsIgnoreCase(manufacturer) && cars.getType().equalsIgnoreCase(type)) {
				results.add(cars);
			}
		}
		return results;
	}
	
	/**
     * Prints the results of a search, or a no cars available message.
     *
     * @param cars         list of cars to print
     * @param manufacturer the make used in search
     * @param type         the type used in search
     */
	public static void printCars(List<Car> cars, String manufacturer, String type) {
	    if (cars.isEmpty()) {
	    	System.out.println("No cars available.");
	    	} else {
	            for (Car currentCar : cars) {
	                System.out.println(currentCar);
	            }
	        }
	    System.out.println();
	 }
	
	/**
     * Enqueues a car for washing and reports the action.
     *
     * @param floor which floor the car is located
     * @param space which space the car is located
     */
	public void addWashQueue(int floor, int space) {
		String key = floor + "-" + space;
		if(!carTower.containsKey(key)) {
			System.out.println("Car not found at this location.");
		}
		Car cars = carTower.remove(key);
		
		System.out.println();
		System.out.println("Car retrieved: " + cars + " (Floor: " + floor + ", Space: " + space + ")");
		carWashQueue.add(cars);
		System.out.println("Car added to wash queue");
		System.out.println();
	}
	
	/** 
     * Processes the wash queue, washing each car in FIFO order.
     * If the queue is empty, prints a prompt instead.
     */
	public void ProcessWashQueue() {
		if (carWashQueue.isEmpty()) {
	        System.out.println("No cars in the wash queue.");
	    } else {
	        System.out.println("Processing washes:");
	        while (!carWashQueue.isEmpty()) {
	            System.out.println("Washing: " + carWashQueue.remove());
	        }
	    }
	    System.out.println();
	}
	
	/**
     * Removes and reports a car sale at the specified position.
     *
     * @param floor where the floor is located
     * @param space where the space is located
     */
	public void SellingCar(int floor, int space) {
		String key = floor + "-" + space;
        if (!carTower.containsKey(key)) {
            System.out.println("No car found at Floor " + floor + " Space " + space + ".");
        } else {
            Car car = carTower.remove(key);
            System.out.println("Car Sold: " + car + " (Floor: " + floor + ", Space: " + space + ")");
        }
	}
	
	
}