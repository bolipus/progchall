package si.plapt.challenges.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackBasicJava {

	public static void main(String[] args) {
//		String s = "welcometojava";
//		Integer k = 3;
//		System.out.println(HackBasicjava.getSmallestAndLargest(s, k));;
//		
//		String R = new StringBuilder(s).reverse().toString();

		// System.out.println(HackBasicjava.isAnagram("anagramm","marganaa"));
		
		/*String ips[] = {
				"12.12.12.12",
				"13.13.13.112",
				"VUUT.12.12",
				"111.111.11.111",
				"1.1.1.1.1.1.1",
				".....",
				"1...1..1..1",
				"0.0.0.0",
				"255.0.255.0",
				"266.266.266.266",
				"00000.000000.0000000.00001",
				"0023.0012.0012.0034"
		};*/
		
		/*String ips[] = {
				"259.259.259.259",
				"266.266.266.266",
				"255.255.255.255",
				"555.555.555.555",
				"666.666.666.666",
				"249.249.249.249",
				"249.249.249.256"
		};*/
		
		/*String ips[] = {
				"000.12.12.034",
				"121.234.12.12",
				"23.45.12.56",
				"00.12.123.123123.123",
				"122.23",
				"Hello.IP"
		};*/
		
		//HackBasicjava.IPVerify(ips);
		//HackBasicjava.testRepeated();
		
		//HackBasicjava.repeatedWord("tap taptap For fOr for forfor");
		
		HackBasicJava.roundRobin();

	}
	
	public static void testRepeated() {
		String input = "test test";
		String regex = "((\\b\\w+\\b)\\s)+";	
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
       
        Matcher m = p.matcher(input);
        while (m.find()) {
        	System.out.println(m.group());
        }
	}
	
	public static void repeatedWord(String sentence) {
		String regex = "\\b(\\w+)(\\s+\\1\\b)+";
		// String regex = "(\\b\\w+\\b)(\\s+\\1)+";
	        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	        String input = sentence;
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
            	//System.out.println(m.group());
            	//System.out.println(m.group(2));
                input = input.replaceAll(m.group(), m.group(1));
            }
            
            // Prints the modified sentence.
            System.out.println(input);
	}
	
	public static void IPVerify(String[] ips) {
		//String ip = "259.";
		//System.out.println(ip.matches("([0-2]{1}[0-4]{1}[0-9]{1}.|[0-2]{1}[5]{1}[0-5]{1}.|[0-9]{1,2}.){3}([0-2]{1}[0-4]{1}[0-9]{1}|[0-2]{1}[5]{1}[0-5]{1}|[0-9]{1,2})"));
		//System.out.println(ip.matches("([0-2]{1}[0-5]{2}.|[0-9]{1,2}.){3}([0-2]{1}[0-5]{2}|[0-9]{1,2}){1}"));
		//System.out.println(ip.matches("([0-5]{1,2}.)"));
		//System.out.println(ip.matches("([0-2]{1}[0-5]{2}.|[0-5]{1,2}.){3}([0-2]{1}[0-5]{2}.|[0-5]{1,2}.){1}"));
		for (String ip : ips) {
			System.out.println(ip.matches("([0-2]{1}[0-4]{1}[0-9]{1}.|[0-2]{1}[5]{1}[0-5]{1}.|[0-9]{1,2}.){3}"
					+ "([0-2]{1}[0-4]{1}[0-9]{1}|[0-2]{1}[5]{1}[0-5]{1}|[0-9]{1,2})"));
		}
		
		
		
		
	}

	public static void roundRobin() {
		Integer[] teams = { 1, 2, 3, 4, 5, 6 };
		
		int size = teams.length;
		int rounds = size - 1;
		int half = size / 2;
		
		for (int i = 0; i < rounds; i++) {
			int m = 0;
			int n = size - 1;
		
			for (int j = 0; j < half; j++) {
				int first = teams[m++];
				int second = teams[n--];
				System.out.println(first + ":" + second);
			}
			
			int tmp = teams[size -1];
			for (int j=size-1; j > 0; j--) {
				teams[j] = teams[j-1];
			}
			teams[1] = tmp;

		}

	}

	public static void tokens() {
		String s = "   ";
		s = s.trim();
		String[] tokens = s.split("[ \t!,?._\'@]+");
		if (s.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(tokens.length);
			for (String tok : tokens) {
				System.out.println(tok);
			}
		}
	}

	public static boolean isAnagram(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		int[] freq = new int[26];
		for (int i = 0; i < a.length(); i++) {
			freq[a.charAt(i) - 'a']++;
		}

		for (int i = 0; i < b.length(); i++) {
			freq[b.charAt(i) - 'a']--;
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void testString() {
		String A = "hello";
		String B = "java";

		System.out.println(A.length() + B.length());
		System.out.println(A.compareTo(B) <= 0 ? "No" : "Yes");
		System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase()
				+ B.substring(1));

	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		smallest = s.substring(0, k);
		largest = smallest;
		for (int i = 1; i < s.length() - k + 1; i++) {
			String sub = s.substring(i, i + k);
			if (sub.compareTo(smallest) < 0) {
				smallest = sub;
			}
			if (sub.compareTo(largest) > 0) {
				largest = sub;
			}

		}

		return smallest + "\n" + largest;
	}

}
