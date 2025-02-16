import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.IOException;


public class AkbariGE01Polymorphism {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File myFile =  new File("Animals.txt");
		Scanner inputFile = new Scanner(myFile);
		int maxAnimals = inputFile.nextInt();
		inputFile.nextLine();
		Animal[] animals = new Animal[maxAnimals];
		String animalType;
		String name;
		String food;
		int weight;
		int sleep;
		String location;
		int index = 0;
		
		while(inputFile.hasNext()) {
			animalType = inputFile.next();
			name = inputFile.next();
			food = inputFile.next();
			weight = inputFile.nextInt();
			sleep = inputFile.nextInt();
			location= inputFile.nextLine();
			
			/*
			for(int i =0; i < animals.length; i++)
			{
				animals[i] = animalType;
			}
			*/
			
			if(animalType.equals("Bear")) {
				animals[index] = new Bear(name, food, weight, sleep, location);
			}
			else if(animalType.equals("Elephant")) {
				animals[index] = new Elephant(name, food, weight, sleep, location);
			}
			else if(animalType.equals("Monkey")) {
				animals[index] = new Monkey(name, food, weight, sleep, location);
			}
			else if(animalType.equals("Sloth")) {
				animals[index] = new Sloth(name, food, weight, sleep, location);
			}
			
			index++;
		}
		
		for(int i = 0; i < animals.length; i++)
		{
			if(animals[i] instanceof Bear)
			{
				System.out.println("Animal[" + i + "] is a  Bear");
				System.out.println(animals[i].toString());
				animals[i].eat();
				animals[i].sleep();
				animals[i].swim();
			}
			else if(animals[i] instanceof Elephant) {
				System.out.println("Animal[" + i + "] is a Elephant");
				System.out.println(animals[i].toString());
				animals[i].eat();
				animals[i].sleep();
				animals[i].swim();
			}
			else if(animals[i] instanceof Monkey) {
				System.out.println("Animal[" + i + "] is a Monkey");
				System.out.println(animals[i].toString());
				animals[i].eat();
				animals[i].sleep();
				animals[i].swim();
			}
			else if(animals[i] instanceof Sloth) {
				System.out.println("Animal[" + i + "] is a Sloth");
				System.out.println(animals[i].toString());
				animals[i].eat();
				animals[i].sleep();
				animals[i].swim();
			}
			
			
			
			
		}
		

	}

}

class Animal{
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;
	
	public Animal() {
		
	}
	
	
	public Animal(String name, String food, int weight, int sleep, String location) {
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFood() {
		return food;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getSleep() {
		return sleep;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void eat() {
		System.out.println("Animal is eating");
	}
	
	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}
	
	public void swim() {
		System.out.println("Animal is swimming");
	}
}

class Bear extends Animal{
	
	public Bear(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	
	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood()); // getter were used since food isn't in this field
	}
	
	@Override
	public void sleep() {
		System.out.println("Bear is sleeping " + getSleep() + " hours");
	}
	
	@Override
	public void swim() {
		System.out.println("Bear is swimming.");
	}
	
	@Override
	public String toString() {
		return "Bear: Name: " + getName() + " - Weighs: " + getWeight() + 
				" lbs - sleeps: " + getSleep() + " hours - location: " + getLocation();
	}
}

class Elephant extends Animal{
	
	public Elephant(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	
	@Override
	public void sleep() {
		System.out.println("Elephant is sleeping " + getSleep() + " hours");
	}
	
	@Override
	public String toString() {
		return "Elephant: Name: " + getName() + " - Weighs: " + getWeight() + 
				" lbs - sleeps: " + getSleep() + " hours - location: " + getLocation();
	}
	
}

class Monkey extends Animal{
	
	public Monkey(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	
	@Override
	public void eat() {
		System.out.println("Monkey is eating " + getFood());
	}
	
	@Override
	public void swim() {
		System.out.println("Monkey is swimming");
	}
	
	@Override
	public String toString() {
		return "Monkey: Name: " + getName() + " - Weighs: " + getWeight() + 
				" lbs - sleeps: " + getSleep() + " hours - location: " + getLocation();
	}
}

class Sloth extends Animal{
	
	public Sloth(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	
	@Override
	public String toString() {
		return "Sloth: Name: " + getName() + " - Weighs: " + getWeight() + 
				" lbs - sleeps: " + getSleep() + " hours - location: " + getLocation();
	}
	
}
