package si.plapt.challenges.hackerrank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import junit.framework.TestCase;

public class HackBasicTest extends TestCase {
	
	@Test
	public void testUsername() {
		
		String userName = "Julia007";
		String regular = "^[a-zA-Z]{1}\\w{7,29}";
		if (userName.matches(regular)) {
	        System.out.println("Valid");
	    } else {
	        System.out.println("Invalid");
	    } 
	}
	
	@Test 
	public void testTagContent() {
		String cases[] = {
				"<h1>Nayeem loves counseling</h1>",
				"<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
				"<Amee>safat codes like a ninja</amee>",
				"<SA premium>Imtiaz has a secret crush</SA premium>"
		};
		
		for (int i = 0; i < cases.length; i++) {
			String line = cases[i];
			Pattern pattern = Pattern.compile("<(.+)>([^<>]+)</\\1>");
			
			Matcher match = pattern.matcher(line);
			boolean found = false;
			while (match.find()) {				
				System.out.println(match.group(2));
				found = true;
			}
			if (!found) {
				System.out.println("None");
			}
		}						
	}
	
	@Test
	public void testProbablyPrime() {
		String[] numbers = {
			"13",
			"5",
			"27"
		};
		
	
		
		for (String prime : numbers) {
			BigInteger bg = new BigInteger(prime);
			if (bg.isProbablePrime(100)) {
				System.out.println("prime");
			} else {
				System.out.println("not prime");
			}
		}
		
		Scanner scanner = new Scanner(System.in);
		
	}

	
	@Test 
	public void testBigNumber(){
		
	    String a = "1234";
	    String b = "20";
	    BigDecimal aN = new BigDecimal(a);
	    BigDecimal bN = new BigDecimal(b);
	    System.out.println(aN.add(bN));
	    System.out.println(aN.multiply(bN));
	}
	
	
	@Test
	public void testBigDecimalSort() {
		String[] numbers = {
				"-100",
				"50",
				"0",
				"56.6",
				"90",
				"0.12",
				".12",
				"02.34",
				"000.000"
		};
		
		Arrays.sort(numbers, 0, numbers.length, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				BigDecimal b1 = new BigDecimal(o1);
				BigDecimal b2 = new BigDecimal(o2);
				return b2.compareTo(b1);
			}
		});
		
		for (String num : numbers) {
			System.out.println(num);
		}
		
	}
	
	@Test
	public void testHashSet() {
		String[] pair_left = {
				"john", "john","john","mary", "mary"
		};
		String[] pair_right = {
				"tom", "mary","tom","anna", "anna"
		};
		
		Set<String> pairs = new HashSet<>();
		for (int i = 0; i < pair_left.length; i++) {
			pairs.add(pair_left[i]+"-"+pair_right[i]);
			System.out.println(pairs.size());
		}
		
	}
	
	@Test
	public void testHourGlass() {
		String[] lines = {
			"-1 -1 0 -9 -2 -2",
			"-2 -1 -6 -8 -2 -5",
			"-1 -1 -1 -2 -3 -4",
			"-1 -9 -2 -4 -4 -5",
			"-7 -3 -3 -2 -9 -9",
			"-1 -3 -1 -2 -4 -5"
		};
		
		int[][] arr = new int[6][6];
		for (int i = 0; i < 6; i++) {
            String[] arrRowItems = lines[i].split(" ");
            
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
		}
		
		int maxSum = Integer.MIN_VALUE;
		for (int i=0;i< arr.length-2; i++) {
			for (int j=0;j< arr[i].length-2; j++) {
				int sum = 0;
				for (int k=0; k<3;k++) {					
					sum += arr[i][j+k];
					sum += arr[i+2][j+k];					
				}	
				sum += arr[i+1][j+1];
				
				System.out.println(sum);
				if (sum > maxSum) {
					maxSum= sum;
				}
			}
		}
		
		System.out.println(maxSum);
	}
	
	
	@Test
	public void testNegativeSubArrays() {
		//Scanner scanner = new Scanner(System.in);
		//Integer n = scanner.nextInt();	
		//int[] arr = new int[n];
		//for (int i=0; i< n;i++) {
		//	arr[i] = scanner.nextInt();
		//}
		int n = 5;
		int[] arr = {1,-2,4,-5,1};
		int count =0;
		for (int k=1; k <= n; k++) {	
			//System.out.println("===== " + k +" =====");
			for (int i=0;i<n;i++) {
				int sum = 0;			
				if (i+ k - 1 < n) {
					for (int j=i; j< i + k; j++) {
						sum+=arr[j];
					}
					//System.out.println(sum);
					if (sum <0) {
						count++;
					}
				}
				
			}
		}
		
		System.out.println(count);
		
	}
	
}
