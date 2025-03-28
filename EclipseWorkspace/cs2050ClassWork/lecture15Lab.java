
public class lecture15Lab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


abstract class bird{
	private String name;
	
	
	public abstract void BirdFacts();
	
	public String getName() {
		return name;
	}
	
	
}

interface swim {
	public abstract int Swimmer();
}

class Penguin extends bird implements swim {
	private int swimSpeed;
	
	@Override
	public void BirdFacts() {
		System.out.println("I cant fly but I'm the fastest swimmer and deepest diver");
	}
	
	@Override
	public int Swimmer() {
		return swimSpeed;
		
	}
}

class Duck extends bird implements swim {
	
	@Override
	public void BirdFacts() {
		System.out.println("My highest documented flight was at 21,000 feet!");
	}
	
	@Override
	public void Swimmer() {
		
	}
}

class Ostrich extends bird {
	
	@Override
	public void BirdFacts() {
		System.out.println("Who needs flying when you're the biggest bird on Earth!");
	}
}

class sootyTern extends bird {
	
	@Override
	public void BirdFacts() {
		System.out.println("I spend most of my life at sea but can't swim!");
	}
}