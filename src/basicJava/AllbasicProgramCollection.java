package basicJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AllbasicProgramCollection {

	public static void main(String[] args) {
		// RemoveDuplicateFromList();
		// sortList();
		// sortMapByKey();
		 sortMapWithValueJava8();
		// sortMapWithValues();
		// countCharOccurnceInString();
		// removeDuplicateCharFromString();
		getHighestAndLowestPalindrom();
	}

	public static void removeDuplicateCharFromString() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] cArr = str.toCharArray();

		Set<Character> sSet = new LinkedHashSet<Character>();
		for (char c : cArr) {
			if (sSet.contains(Character.toLowerCase(c)) || sSet.contains(Character.toUpperCase(c))) {
			} else {
				sSet.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();

		sSet.forEach(c -> sb.append(c));

		System.out.println(sb.toString());
		// Input
		// Testing is the best
		// output
		// Tesing hb
	}

	public static void countCharOccurnceInString() {
		String str = "hellow world";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] cArray = str.toCharArray();
		for (char c : cArray) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);

			} else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
	}

	public static void sortMapWithValues() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Siya", 10);
		map.put("Shlok", 5);
		map.put("Abhishek", 34);
		map.put("Devansh", 12);
		System.out.println("Unsorted map " + map);
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> me : list) {
			sortedMap.put(me.getKey(), me.getValue());
		}
		System.out.println("Soretd Map " + sortedMap);

	}

	public static void sortMapByKey() {
		Map<String, String> unsortMap = new HashMap<String, String>();
		unsortMap.put("Z", "z");
		unsortMap.put("B", "b");
		unsortMap.put("A", "a");
		unsortMap.put("C", "c");
		unsortMap.put("D", "d");
		unsortMap.put("E", "e");
		unsortMap.put("Y", "y");
		unsortMap.put("N", "n");
		unsortMap.put("J", "j");
		unsortMap.put("M", "m");
		unsortMap.put("F", "f");

		System.out.println("Unsort Map......");
		printMap(unsortMap);

		System.out.println("\nSorted Map......By Key");
		Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
		printMap(treeMap);

	}

	public static void sortList() {
		final List<String> ls = new ArrayList<String>();
		ls.add("Priyaka");
		ls.add("Abhishek");
		ls.add("Shlok");
		ls.add("Devansh");

		System.out.println("Without sort" + ls);

		Collections.sort(ls);
		System.out.println("Acending" + ls);
		Collections.sort(ls, Collections.reverseOrder());
		System.out.println("Decending" + ls);

	}

	public static void RemoveDuplicateFromList() {
		List<String> ls = new ArrayList<String>();
		ls.add("Priyaka");
		ls.add("Abhishek");
		ls.add("Shlok");
		ls.add("Devansh");
		ls.add("Abhishek");
		ls.add("Shlok");

		System.out.println("With duplicate" + ls);
		Set<String> set = new LinkedHashSet<String>(ls);
		System.out.println("Without duplicate" + set);
		ls.clear();
		ls = new ArrayList<String>(set);
		System.out.println("Without duplicate" + ls);
	}

	// pretty print a map
	public static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}

	public static void getHighestAndLowestPalindrom() {
		String str = "Red kayak is owned by Anna and her dad";
		String[] strArr = str.toLowerCase().split(" ");
		List<String> list = new ArrayList<String>();
		for (String s : strArr) {
			if (isStringPalindrom(s)) {
				list.add(s);
			}
		}
		System.out.println(list);
		System.out.println("Highest " + getHigheststr(list));
		System.out.println("Lowest " + getLoweststr(list));
	}

	public static Boolean isStringPalindrom(String s) {
		Boolean isPalindrom = true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				isPalindrom = false;
			}
		}
		return isPalindrom;
	}

	public static String getHigheststr(List<String> str) {
		String highest = str.get(0);

		for (String s : str) {
			if (s.length() > highest.length()) {
				highest = s;
			}
		}
		return highest;
	}

	public static String getLoweststr(List<String> str) {
		String lowest = str.get(0);

		for (String s : str) {
			if (s.length() < lowest.length()) {
				lowest = s;
			}
		}
		return lowest;
	}

	public static void sortMapWithValueJava8() {

		// https://dzone.com/articles/how-to-sort-a-map-by-value-in-java-8
		final Map<String, Integer> wordCounts = new HashMap<>();
		wordCounts.put("USA", 100);
		wordCounts.put("jobs", 200);
		wordCounts.put("software", 50);
		wordCounts.put("technology", 70);
		wordCounts.put("opportunity", 205);

		System.out.println(wordCounts);
		final Map<String, Integer> sortedByCount = wordCounts.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e2, LinkedHashMap::new));
		System.out.println("Sort by value");
		System.out.println(sortedByCount);

		final Map<String, Integer> sortedByCountReverse = wordCounts.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e2, LinkedHashMap::new));
		System.out.println("Sort by value reverse order");
		System.out.println(sortedByCountReverse);

		Map<String, Integer> sortedBykey = wordCounts.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e2, LinkedHashMap::new));

		System.out.println("Sort by Key");
		System.out.println(sortedBykey);

		Map<String, Integer> sortedBykeyrev = wordCounts.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e2, LinkedHashMap::new));

		System.out.println("Sort by Key reverse order");
		System.out.println(sortedBykeyrev);
	}

}
