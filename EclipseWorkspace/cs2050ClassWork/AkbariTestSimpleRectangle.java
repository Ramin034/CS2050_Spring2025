
public class AkbariTestSimpleRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleRectangle rectangle1 = new SimpleRectangle();
		SimpleRectangle rectangle2 = new SimpleRectangle(3,1);
		SimpleRectangle rectangle3 = new SimpleRectangle(-4,2);
		
		System.out.println("The area of rectangle 1 is: " + rectangle1.getArea() +
				" and the perimeter of rectangle 1 is: " + rectangle1.getPerimeter());
		
		System.out.println("The area of rectangle 2 is: " + rectangle2.getArea() +
				" and the perimeter of rectangle 2 is: " + rectangle2.getPerimeter());
		
		System.out.println("The area of rectangle 3 is: " + rectangle3.getArea() +
				" and the perimeter of rectangle 3 is: " + rectangle3.getPerimeter());
		

	}
	

}

class SimpleRectangle{
	private double length = 0;
	private double width = 0;
	
	
	public SimpleRectangle() {
		length = 0;
		width = 0;
		
	}
	
	public SimpleRectangle(double newLength, double newWidth) {
		length = newLength;
		width = newWidth;
		
		if(newLength < 0) {
			length = 1;
		}
		else if(newWidth < 0) {
			width = 1;
		}
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getPerimeter() {
		return 2 * length + 2 * width;
	}
	
	public void setLength(double newLength) {
		length = newLength;
	}
	
	public void setWidth(double newWidth) {
		width = newWidth;
	}
	
}
