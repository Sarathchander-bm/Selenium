package basicJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest {
//65 90 A-Z 97-122 a-z  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 

		String a = "ABHISHEK";
		StringBuilder sb = new StringBuilder();
		char[] carr = a.toCharArray();
		for (char c : carr) {
			if (!Character.isLowerCase(c)) {
				c = (char) (c + 32);
			}
			sb.append(c);
		}
		System.out.println(sb.toString());
		// getHigest();
		sortMapWithValueJava8();
	}

	static void getHigest() {
		String checkStr = "Red kayak is owned by Anna and her dad";
		List<String> list = new ArrayList<String>();
		String[] word = checkStr.toLowerCase().split(" ");
		for (String wr : word) {
			if (isPalindromStr(wr)) {
				list.add(wr);
			}
		}
		System.out.println(list);
		String[] wordPal = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			wordPal[i] = list.get(i);
		}

		System.out.println("Smallest " + getSmallest(wordPal));
		System.out.println("Biggest " + getBiggest(wordPal));
	}

	static String getSmallest(String[] arr) {
		String smallests = "";
		int lenght = arr[0].length();
		smallests = arr[0];
		for (String s : arr) {
			if (s.length() < lenght)
				smallests = s;
		}
		return smallests;
	}

	static String getBiggest(String[] arr) {
		String biggest = "";
		int lenght = arr[0].length();
		biggest = arr[0];
		for (String s : arr) {
			if (s.length() > lenght)
				biggest = s;
		}
		return biggest;
	}

	static Boolean isPalindromStr(String str) {
		Boolean isPalindrom = true;

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				isPalindrom = false;
				break;
			}
		}

		return isPalindrom;
	}

	public static void sortMapWithValueJava8() {

		// https://dzone.com/articles/how-to-sort-a-map-by-value-in-java-8
		final Map<String, Integer> wordCounts = new HashMap<>();
		wordCounts.put("USA", 100);
		wordCounts.put("jobs", 200);
		wordCounts.put("software", 50);
		wordCounts.put("technology", 70);
		wordCounts.put("opportunity", 205);
		Map<String, Integer> sorted = wordCounts.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e2, LinkedHashMap::new));
		System.out.println(sorted);
	}
}
