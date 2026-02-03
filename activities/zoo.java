public class zoo {
	public static void main(String[] args) {
		Cow bessie = new Cow("moo", "Bessie", 13, 34);
		Dog fido = new Dog("woof", "Fido", "Poodle", "Jane");
		Dog rover = new Dog("arf", "Rover", "Great Dane", "Charlie");
		Animal[] zoo = {bessie, fido, rover};

		// for (Animal animal : zoo) {
		// 	animal.speak();
		// 	System.out.println();
		// }

		// here's an example of casting
		for (Animal animal : zoo) {
			if (animal instanceof Cow) {
				Cow c = (Cow) animal;
				System.out.println("\"whoa check out this cow\"");
				c.speak();
				System.out.printf("This cow has %d spots!\n", c.spotCount);
			} 
			else if (animal instanceof Dog) {
				Dog d = (Dog) animal;
				System.out.println("\"whoa check out this dog\"");
				d.speak();
				System.out.printf("This dog is a %s!\n", d.breed);
			}
			System.out.println();
		}
	}
}

class Animal {
	private String noise;
	private String name;

	public Animal(String noise, String name) {
		this.noise = noise;
		this.name = name;
	}

	public void speak() {
		System.out.printf("%s says %s!\n", name, noise);
	}
}

class Cow extends Animal {
	int age;
	int spotCount;

	public Cow(String noise, String name, int age, int spotCount) {
		super(noise, name);
		this.age = age;
		this.spotCount = spotCount;
	}

	@Override
	public void speak() {
		super.speak();
		System.out.println("What a nice cow!");
	}
}

class Dog extends Animal {
	String breed;
	String owner;

	public Dog(String noise, String name, String breed, String owner) {
		super(noise, name);
		this.breed = breed;
		this.owner = owner;
	}

	@Override
	public void speak() {
		super.speak();
		System.out.println("What a good dog!");
	}
}