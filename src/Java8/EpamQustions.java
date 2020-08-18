package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EpamQustions {
	public static void main(String[] args) {

		// ref : https://www.baeldung.com/java-8-comparator-comparing
		// thirdHightstRent();

		// https://www.logicbig.com/how-to/java/lambda-list-contains-a-substring.html
		// stringContainsInList();

		// Predicates in java :
		// https://mkyong.com/java8/java-8-predicate-examples/#:~:text=In%20Java%208%2C%20Predicate%20is,for%20a%20collection%20of%20objects.

		predicateEx();
	}

	public static void stringContainsInList() {
		List<String> list = Arrays.asList("Apple", "Orange", "Banana");
		String string = "A box of Oranges";
		boolean match = list.stream().anyMatch(string::contains);
		System.out.println(match);
	}

	public static void predicateEx() {
		Predicate<Integer> ageGreterthan18 = x -> x > 18;
		//https://www.javatpoint.com/java-predicate-interface
		System.out.println("test age " + ageGreterthan18.test(20));
		List<Integer> ageList = Arrays.asList(12, 33, 32, 11, 64, 1, 8, 18, 22, 15);

		List<Integer> ageListWithAgeGreaterThan18 = ageList.stream().filter(ageGreterthan18)
				.collect(Collectors.toList());
		System.out.println(ageListWithAgeGreaterThan18);
	}

	public static void thirdHightstRent() {
		List<Apartment> apartmentlist = new ArrayList<Apartment>();
		// Adding Products
		apartmentlist.add(new Apartment(1, "Modern A", 480f));
		apartmentlist.add(new Apartment(23, "Hostel A", 400f));
		apartmentlist.add(new Apartment(15, "BergerStass A", 460f));
		apartmentlist.add(new Apartment(9, "HPH A", 30f));
		apartmentlist.add(new Apartment(29, "XPP A", 800f));
		apartmentlist.add(new Apartment(49, "LL Add", 700f));
		apartmentlist.add(new Apartment(19, "UUU A", 200f));
		System.out.println(" ##### Before sorting #####");
		for (Apartment apr : apartmentlist) {
			System.out.println(apr.toString());
		}
		System.out.println(" ##### After sorting #####");
		Comparator<Apartment> rentCom = Comparator.comparing(Apartment::getRent).reversed();
		Collections.sort(apartmentlist, rentCom);
		for (Apartment apr : apartmentlist) {
			System.out.println(apr.toString());
		}
		System.out.println(" ##### 3rd highst rent #####");
		System.out.println(apartmentlist.get(2).toString());
	}
}

class Apartment {
	int id;
	String name;
	float rent;

	public Apartment(int id, String name, float rent) {
		this.id = id;
		this.name = name;
		this.rent = rent;
	}

	public String toString() {

		return "id" + id + " name " + name + " rent " + rent;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getRent() {
		return rent;
	}
}