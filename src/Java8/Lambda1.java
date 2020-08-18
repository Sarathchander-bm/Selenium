package Java8;

import java.util.ArrayList;
import java.util.List;

//https://beginnersbook.com/2017/10/java-lambda-expressions-tutorial-with-examples/
@FunctionalInterface
interface MyFunctionalInterface {

	// A method with no parameter
	public String sayHello();
}

@FunctionalInterface
interface MyFunctionalInterfaceSinglePar {

	// A method with one parameter
	public int incrementBy5(int a);
}

@FunctionalInterface
interface MyFunctionalInterfaceTwoPar {

	public String stringcon(String a, String b);
}

public class Lambda1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFunctionalInterface myinterface = () -> {
			return "hellow";
		};
		System.out.println(myinterface.sayHello());

		MyFunctionalInterfaceSinglePar singlePar = (n) -> {
			return n + 5;
		};
		System.out.println(singlePar.incrementBy5(10));

		MyFunctionalInterfaceTwoPar twoPar = (s1, s2) -> {
			return s1 + s2;
		};
		System.out.println(twoPar.stringcon("Abhishek", " Priyanka"));
		System.out.println("For Each");
		// for each for list
		List<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Shlok");
		names.add("Priyanka");
		names.add("Anuska");
		names.forEach(n -> System.out.println(n));
		
		System.out.println("Method reference");
		names.forEach(System.out::println);
	}

}
