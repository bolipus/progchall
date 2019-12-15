package si.plapt.challenges.hackerrank;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.TestCase;

public class HackProblems extends TestCase {
	
	@Test
	public void testBreakRecord() {
		String input = "9\n" + 
				"10 5 20 20 4 5 2 25 1";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		
		Scanner scanner = new Scanner(is);
		
		int n = scanner.nextInt();
		int highest = scanner.nextInt();
		int lowest = highest;
		int lowBreak = 0;
		int highBreak =0;
		for (int i=0;i<n-1;i++) {
			int x = scanner.nextInt();
			if (x> highest) {
				highest = x;
				highBreak++;
			}
			if (x< lowest) {
				lowest = x;
				lowBreak++;
			}			
		}
		System.out.println(highBreak + " " + lowBreak);
	}

	@Test
	public void testBirthChokolade() {
		String input = "1\n" + 
				"4\n" + 
				"4 1";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		
		Scanner scanner = new Scanner(is);
		
		int n = scanner.nextInt();
		int[] chocko = new int[n];
		for (int i=0;i<n; i++) {
			chocko[i] = scanner.nextInt();
		}
		int day = scanner.nextInt();
		int month = scanner.nextInt();
		
		int ways = 0;
		for (int i=0; i<n-month+1; i++) {
			int sum = 0;
			for (int j = 0; j<month; j++) {
				sum += chocko[i+j];
			}
			if (sum == day) {
				ways++;
			}
		}
		
		System.out.println(ways);
		
	}

	
	
}
