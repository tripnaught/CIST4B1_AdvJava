import java.util.Arrays;
import java.util.Scanner;

public class Week1 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Class1 c1 = new Class1();
		Class2 c2 = new Class2();

		c1.print();
		c2.print();
		print();
		print("AAAAAAAAAAAAAAAA");

		// =====================================
		// =====================================

		
		int in = scan.nextInt();
		int[] array = new int[in];

		for (int i = 0; i < in; i++) {
			array[i] = i;
		}
		System.out.println(Arrays.toString(array));

	}

	public static void print() {
		System.out.println("This is a testing print.");
	}

	// this IS polymorphism. the functions have the same signature/scope,
	// and the parameters tell java which version of the function to use.
	public static void print(String a) {
		System.out.println(a);
	}
}

class Class1 {
	private int a;

	public Class1() {
		this.a = 10;
	};

	public void print() {
		System.out.println(a);
	}
}

class Class2 extends Class1 {
	public Class2() {
		super();
	} 

	@Override
	public void print() {
		System.out.print("a is: ");
		super.print();
	}
}