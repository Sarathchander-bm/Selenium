package Java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
//
public class MapFilter {
	public static void main(String[] args) {
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(5, "Shlok");
		hmap.put(9, "Anushka");
		hmap.put(10, "Devansh");
		hmap.put(30, "Piyu");
		hmap.put(34, "Abhishek");

		//by key
		Map<Integer, String> result = hmap.entrySet().stream().filter(map -> map.getKey() < 18)
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		System.out.println(result);
		result.forEach((key, value) -> System.out.println(key + " - " + value));

		// by value
		Map<Integer, String> result1 = hmap.entrySet().stream().filter(map -> map.getValue().startsWith("A"))
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		System.out.println(result1);
		result1.forEach((key, value) -> System.out.println(key + " - " + value));
	}

}
