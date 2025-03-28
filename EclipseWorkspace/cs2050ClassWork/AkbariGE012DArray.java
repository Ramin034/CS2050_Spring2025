
public class AkbariGE012DArray {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		Car[][] cars = new Car[3][4];
		
		for(int row = 0; row < cars.length; row++) {
			for(int col = 0; col < cars[0].length; col++) {
				cars[row][col]= new Car("Mitsubishi");
			}
		}
		
		for(int row = 0; row < cars.length; row++) {
			for(int col = 0; col < cars[0].length; col++) {
				cars[row][col].printMake();
			}
		} **/
		
		Car[][] cars1 = new Car[2][3];
		String[][] carBrand = {{"Ford", "Dodge", "Toyota"},
								{"Hyundai", "Chevrolet", "Subaru"}};

		for(int row = 0; row < cars1.length; row++) {
			for(int col = 0; col < cars1[0].length; col++) {
				cars1[row][col]= new Car(carBrand[row][col]);
			}
		}
		
		for(int row = 0; row < cars1.length; row++) {
			for(int col = 0; col < cars1[0].length; col++) {
				cars1[row][col].printMake();
			}
			System.out.println();
		}
	}
}

class Car{
	private String make;
	
	public Car() { 
	   this.make = "Unknown"; 
	}
		
	public Car(String make) {
	 	   this.make = make;
	}
	
	public void printMake() {
	   System.out.print(this.make + " ");
	}
} 
// Car
