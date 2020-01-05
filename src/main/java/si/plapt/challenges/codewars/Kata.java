package si.plapt.challenges.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Kata {

	

	public static double findUniq(double arr[]) {

		Map<Double, Integer> myMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			double el = arr[i];
			myMap.computeIfAbsent(el, k -> 0);
			myMap.put(el, myMap.get(el) + 1);

		}

		LinkedHashMap<Double, Integer> sortedMap = new LinkedHashMap<>();

		myMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		return (double) sortedMap.keySet().toArray()[0];

	}

	public static boolean isValid(String braces) {
		Deque<Character> stack = new LinkedList<>();
		Map<Character, Character> brMap = new HashMap<>();
		brMap.put(')', '(');
		brMap.put('}', '{');
		brMap.put(']', '[');

		for (int i = 0; i < braces.length(); i++) {

			char c = braces.charAt(i);

			switch (c) {
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;
			case ')':
			case '}':
			case ']':
				if (stack.isEmpty()) {
					return false;
				}

				if (brMap.get(c) != stack.pop()) {
					return false;
				}
				break;
			default:
				return false;
			}

		}

		return stack.isEmpty();
	}

	public static int[] deleteNth(int[] elements, int maxOccurrences) {

		Map<Integer, Integer> myMap = new HashMap<>();

		List<Integer> result = new ArrayList<>();
		for (int el : elements) {
			myMap.computeIfAbsent(el, k -> 0);

			int count = myMap.get(el);
			count++;
			if (count <= maxOccurrences) {
				result.add(el);
			}

			myMap.put(el, count);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public static int findIt(int[] a) {
		Map<Integer, Integer> occurrences = Arrays.stream(a).boxed()
				.collect(Collectors.groupingBy(s -> new Integer(s), Collectors.reducing(0, e -> 1, Integer::sum)));

		Optional<Integer> key = occurrences.entrySet().stream().filter(x -> x.getValue() % 2 != 0)
				.map(map -> map.getKey()).findFirst();

		return key.get();

	}

	public static boolean validate(String n) {

		List<Integer> numbers = n.chars().mapToObj(x -> Character.getNumericValue(x)).collect(Collectors.toList());

		int sum = 0;

		for (int i = 0; i < n.length(); i++) {
			if (n.length() % 2 != 0) {
				if (i % 2 == 0) {
					sum += numbers.get(i);
				} else {
					int val = numbers.get(i) * 2;
					if (val > 9) {
						val -= val;
					}
					sum += val;
				}
			} else {
				if (i % 2 != 0) {
					sum += numbers.get(i);
				} else {
					int val = numbers.get(i) * 2;
					if (val > 9) {
						val -= 9;
					}
					sum += val;
				}
			}

		}

		return sum % 10 == 0;
	}

	public static String WhoIsNext(String[] names, long n) {
//		if (n < 4 ) {
//			return names[n];
//		}
//		int i = 1;
//		n -= 4;
//		
//        do {
//        	n = n + 1;
//        	n 
//        } while (n > 0);

		return "";
	}

	public static String camelCase(String str) {
		str = str.trim();
		if (str.isEmpty()) {
			return str;
		}
		return Arrays.asList(str.split("\\s+")).stream()
				.map(x -> x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase()).collect(Collectors.joining());
	}

	public static int[] isPerfectPower(int n) {
		int max = (int) Math.floor(Math.sqrt(n));
		for (int i = max; i > 1; i--) {
			long sum = 1;
			int mult = 1;
			while (sum < n) {
				sum *= i;
				mult++;
			}
			if (sum == n) {
				return new int[] { i, mult - 1 };
			}
		}
		return null;
	}

	public static int sequence(int[] arr) {
		int maxSum = 0;
		int maxSumTotal = 0;
		for (int a : arr) {
			maxSum += a;
			if (maxSum < 0) {
				maxSum = 0;
			}

			if (maxSum > maxSumTotal) {
				maxSumTotal = maxSum;
			}
		}

		return maxSumTotal;
	}

	private static int getLengthOfMissingArray(Object[][] objects) {
		if (objects.length == 0) {
			return 0;
		}
		List<Integer> lengths = Arrays.stream(objects).map(o -> o.length).collect(Collectors.toList());
		Collections.sort(lengths, (x, y) -> x - y);
		for (int i = 0; i < lengths.size() - 1; i++) {
			if (lengths.get(i + 1) - lengths.get(i) > 1) {
				return lengths.get(i) + 1;
			}
		}
		return 0;
	}

	public static String lcs(String x, String y) {

		return "";
	}

	public static String sumOfDivided(int[] l) {

		Integer max = Arrays.stream(l).map(x -> Math.abs(x)).max().getAsInt();

		boolean[] isPrimeArray = new boolean[max+1];
		Arrays.fill(isPrimeArray, true);
		for (int i = 2; i * i <= max; i++) {			
			for (int j = i * i; j <= max; j+=i) {
				isPrimeArray[j] = false;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < max+1; i++) {
			if (isPrimeArray[i]) {
				String s = "(";			
				s += i + " ";				
				int sum = 0;
				int numPrime = 0;
				for (int j = 0; j < l.length; j++) {
					if (l[j] % i == 0) {
						sum += l[j];
						numPrime++;
					}
				}
				if (numPrime > 0) {
					sb.append(s+sum+")");					
				}
				
			}
		}

		return sb.toString();
	}
	
	public static Map<String,List<Integer>> getPeaks(int[] arr) {
		Map<String,List<Integer>> peaksMap = new HashMap<>();
		List<Integer> pos = new ArrayList<>();
		List<Integer> peaks = new ArrayList<>();
		
		if (arr.length < 1) {
			peaksMap.put("pos", pos);
			peaksMap.put("peaks", peaks);
			return peaksMap;
		}
		
		
		for (int i=1; i< arr.length-1; i++) {
			
			if (arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
				pos.add(i);
				peaks.add(arr[i]);				
			}
			
			if (arr[i-1] < arr[i] && arr[i] == arr[i+1]) {
				
				int start = i;
				while (i < arr.length-1 && arr[i] == arr[i+1]) {
					i++;
				}
				
				if (i < arr.length-1 && arr[i] > arr[i+1]) {
					pos.add(start);
					peaks.add(arr[start]);		
				}
			}
		}
		
		peaksMap.put("pos", pos);
		peaksMap.put("peaks", peaks);
		
		return peaksMap;
		
		
		
    }
	
	
	public static String longToIP(long ip) {
	    // Java doesn't have uint32, so here we use long to represent int32
		
		String res = "";
		for (int i=0;i<4; i++) {
			int x = (int) (255 & ip);
			System.out.println(x);
			ip = ip >> 8;
			res = x + "." + res;
		}
		
		return res.substring(0, res.length()-1); // do it!
	}
	
	public static String makeReadable(int seconds) {
		
		int hours = seconds / 3600;
		seconds -= hours * 3600;	
		int minutes = seconds / 60;
		seconds = seconds - minutes*60;
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	  }
	
	public static int josephusSurvivor(final int n, final int k) {
		return 0;
	  } 
	
	
	public static void main(String[] args) {
		System.out.println(Kata.josephusSurvivor(7,3));
	}

	public static void printArray(int[] array) {
		for (int el : array) {
			System.out.print(el + " ");
		}
		
		

		System.out.println();

	}

}
