package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.util.SystemOutLogger;

public class StreamEx {

	public static void main(String[] args) {
		streamWithClassList();
	}

	static void streamfilterwithList() {

		List<String> names = new ArrayList<String>();
		names.add("Ajeet");
		names.add("Negan");
		names.add("Aditya");
		names.add("Steve");

		// Using Stream and Lambda expression
		long count = names.stream().filter(str -> str.length() < 6).count();
		System.out.println("There are " + count + " strings with length less than 6");

		Stream s = names.stream().filter(str -> str.startsWith("A"));
		// s.forEach(str -> System.out.println(str));
		// we can write above code as below as well
		s.forEach(System.out::println);
	}

	static void streamWithClassList() {
		List<Product> pro = new ArrayList<Product>();
		pro.add(new Product(1, "Computer", 40000f));

		pro.add(new Product(3, "TV", 45000f));

		pro.add(new Product(4, "Mobile", 20000f));

		pro.add(new Product(6, "DVD player", 4000f));
		pro.add(new Product(7, "CD player", 3000f));
		pro.add(new Product(8, "Projector", 43000f));

		List<Float> priceList = pro.stream().filter(p -> p.price >= 20000f).map(p -> p.price)
				.collect(Collectors.toList());
		System.out.println(priceList);

		double totalPrice = pro.stream().collect(Collectors.summingDouble(pr -> pr.price));
		System.out.println("All sum" + totalPrice);

		double totalPriceFor20k = pro.stream().filter(p -> p.price >= 20000f)
				.collect(Collectors.summingDouble(pr -> pr.price));
		System.out.println("sum for price above 20 k" + totalPriceFor20k);

		double average = pro.stream().collect(Collectors.averagingDouble(pr -> pr.price));
		System.out.println("Average " + average);
		Long count = pro.stream().filter(pr -> pr.price > 4000f).collect(Collectors.counting());
		Long count1 = pro.stream().filter(pr -> pr.price > 4000f).count();
		System.out.println("Count greter than 4000 " + count + " using count " + count1);

		List<Product> playerList = pro.stream().filter(p -> p.name.contains("player")).collect(Collectors.toList());

		System.out.println("List containing player");
		playerList.forEach(p -> System.out.println(p.id + " " + p.name + " " + p.price));

	

	}

}

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
