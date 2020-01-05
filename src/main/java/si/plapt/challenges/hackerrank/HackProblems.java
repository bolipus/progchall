package si.plapt.challenges.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class HackProblems {

	@Test
	public void testBreakRecord() {
		String input = "9\n" + "10 5 20 20 4 5 2 25 1";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		int highest = scanner.nextInt();
		int lowest = highest;
		int lowBreak = 0;
		int highBreak = 0;
		for (int i = 0; i < n - 1; i++) {
			int x = scanner.nextInt();
			if (x > highest) {
				highest = x;
				highBreak++;
			}
			if (x < lowest) {
				lowest = x;
				lowBreak++;
			}
		}
		System.out.println(highBreak + " " + lowBreak);

		scanner.close();
	}

	@Test
	public void testBirthChokolade() {
		String input = "1\n" + "4\n" + "4 1";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		int[] chocko = new int[n];
		for (int i = 0; i < n; i++) {
			chocko[i] = scanner.nextInt();
		}
		int day = scanner.nextInt();
		int month = scanner.nextInt();

		int ways = 0;
		for (int i = 0; i < n - month + 1; i++) {
			int sum = 0;
			for (int j = 0; j < month; j++) {
				sum += chocko[i + j];
			}
			if (sum == day) {
				ways++;
			}
		}

		System.out.println(ways);

		scanner.close();

	}

	@Test
	public void testDivisiblePairs() {
		String input = "6 3\n" + "1 3 2 6 1 2";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((arr[i] + arr[j]) % k == 0) {
					count++;
				}
			}
		}
		System.out.println(count);

		scanner.close();
	}

	@Test
	public void testMigratoryBird() {
		String input = "6\n" + "		1 4 4 4 5 3";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();

		Map<Integer, Integer> sightings = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int bird = scanner.nextInt();
			if (!sightings.containsKey(bird)) {
				sightings.put(bird, 1);
			} else {
				sightings.put(bird, sightings.get(bird) + 1);
			}
		}

		List<Entry<Integer, Integer>> sorted = sightings.entrySet().stream().sorted((e1, e2) -> {
			if (e1.getValue() == e2.getValue()) {
				return e1.getKey().compareTo(e2.getKey());
			} else {
				return e2.getValue().compareTo(e1.getValue());
			}
		}).collect(Collectors.toList());

		System.out.println(sorted.get(0).getKey());

		scanner.close();
	}

	void bonAppetit(List<Integer> bill, int k, int b) {
		int sum = 0;
		for (int i = 0; i < bill.size(); i++) {
			if (i != k) {
				sum += bill.get(i);
			}
		}
		sum = sum / 2;
		if (sum == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - sum);
		}

	}

	@Test
	public void testBonAppetit() {
		String input = "4 1\n" + "3 10 2 9\n" + "7";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		List<Integer> bill = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			bill.add(scanner.nextInt());
		}

		int b = scanner.nextInt();
		bonAppetit(bill, k, b);

		scanner.close();
	}

	int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> sockMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (!sockMap.containsKey(ar[i])) {
				sockMap.put(ar[i], 1);
			} else {
				sockMap.put(ar[i], sockMap.get(ar[i]) + 1);
			}
		}
		Optional<Integer> count = sockMap.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getValue() / 2)
				.reduce((a, b) -> a + b);

		return count.orElse(0);

	}

	@Test
	public void testSockMarchant() {
		String input = "1\n" + "100";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();

		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = scanner.nextInt();
		}

		System.out.println(sockMerchant(n, ar));

		scanner.close();
	}

	int pageCount(int n, int p) {
		int pageFront = 1;
		int frontFlip = 0;
		while (pageFront < p) {
			pageFront += 2;
			frontFlip++;
		}
		// System.out.println(frontFlip);

		int pageBack = n;
		int backFlip = 0;
		while (pageBack - 1 > p || pageBack > p && n % 2 == 0) {
			pageBack -= 2;
			backFlip++;
		}

		// System.out.println(backFlip);

		return backFlip < frontFlip ? backFlip : frontFlip;
	}

	@Test
	public void testFlip() {
		String input = "6\n" + "5";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		int p = scanner.nextInt();

		System.out.println(pageCount(n, p));

		scanner.close();
	}

	int countingValleys(int n, String s) {
		int numValey = 0;
		boolean isValey = false;
		int level = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U') {
				level++;
				if (level == 0 && isValey) {
					numValey++;
					isValey = false;
				}
			}

			if (s.charAt(i) == 'D') {
				level--;
				if (level == -1) {
					isValey = true;
				}
			}
		}

		return numValey;

	}

	@Test
	public void testCountValey() {
		String input = "8\n" + "UDDDUDUU";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		String s = scanner.next();

		System.out.println(countingValleys(n, s));

		scanner.close();

	}

	int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int moneySpent = -1;
		for (int i=0; i<keyboards.length; i++){
			for (int j=0; j<drives.length; j++){
				int sumSpent = keyboards[i] + drives[j];
				if (sumSpent <= b && sumSpent > moneySpent){
					moneySpent = sumSpent;
				}
			}
		}
		return moneySpent;
	}

	@Test
	public void testMoneySpent() {

		String input = "10 2 3\n" + "3 1\n" + "5 2 8";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int b = scanner.nextInt();
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] keyboards = new int[n];
		for (int i = 0; i < n; i++) {
			keyboards[i] = scanner.nextInt();
		}

		int[] drives = new int[m];
		for (int i = 0; i < m; i++) {
			drives[i] = scanner.nextInt();
		}

		System.out.println(getMoneySpent(keyboards, drives, b));

		scanner.close();

	}

	String catAndMouse(int x, int y, int z) {
		int dx = (int)Math.abs(x-z);
		int dy = (int)Math.abs(y-z);
		if (dx==dy){
			return "Mouse C";
		} else if (dx<dy){
			return "Cat A";
		} else {
			return "Cat B";
		}
		

	}


	@Test
	public void testCatAndMouse() {

		String input = "2\n" +
		"1 2 3\n" +
		"1 3 2";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int q = scanner.nextInt();
		for (int i=0; i < q; i++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int z = scanner.nextInt();
			System.out.println(catAndMouse(x, y, z));
		}

		

		scanner.close();

	}

	int pickingNumbers(List<Integer> a) {
		
		int maxLength = 0;
		for (int i = 0; i < a.size() - 1; i++) {
			//4 6 5 3 3 1
			List<Integer> maxList = new ArrayList<>();
			maxList.add(a.get(i));
			int diff = 0;
			for (int j = i + 1; j < a.size(); j++){
				int dx = a.get(j) - a.get(i);
				if (Math.abs(dx) > 1){
					continue;
				}
				if (diff == 0){
					maxList.add(a.get(j));
					diff = dx;
				} else if (diff > 0){
					if (dx<0){
						maxList.remove(maxList.size()-1);					
						diff = dx;
					} 
					maxList.add(a.get(j));					
				} else if (diff < 0){
					if (dx>0){
						maxList.remove(maxList.size()-1);					
						diff = dx;
					} 
					maxList.add(a.get(j));				
				}

			}
			if (maxList.size() > maxLength){
				maxLength = maxList.size();
			}
			
		}

		return maxLength;

  }


	@Test
	public void testPickingNumbers() {

		String input = "6\n"+
		"1 2 2 3 1 2";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		List<Integer> a = new ArrayList<>();
		for (int i=0; i < n; i++){
			a.add(scanner.nextInt());
		}

		System.out.println(pickingNumbers(a));

		scanner.close();

	}

	int hurdleRace(int k, int[] height) {
		int maxHeight = 0;
		for (int i=0; i< height.length; i++){
			if (height[i] > maxHeight){
				maxHeight = height[i];
			}
		}
		int dx = maxHeight-k;
		return dx < 0 ? 0 : dx;
	}


	@Test
	public void testHurdleRace() {

		String input = "5 4\n"+
		"1 6 3 5 2";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] height = new int[n];
		for (int i=0;i<n;i++){
			height[i] = scanner.nextInt();
		}

		System.out.println(hurdleRace(k, height));

		scanner.close();

	}

	int designerPdfViewer(int[] h, String word) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Map<Character,Integer> map = new HashMap<>();
		for (int i=0; i< alphabet.length(); i++){
			map.put(alphabet.charAt(i), h[i]);
		}

		int tallest = 0;
		for(int i=0;i<word.length(); i++){
			int height = map.get(word.charAt(i));
			if ( height > tallest){
				tallest = height;
			}
		}

		return tallest*word.length();

	}

	@Test
	public void testDesignerPdfViewe() {

		String input = "1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5\n"+
		"abc";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);
		int[] h = new int[26];
		for (int i=0; i < 26; i++){
			h[i] = scanner.nextInt();
		}

		String word = scanner.next();

		System.out.println(designerPdfViewer(h, word));

		scanner.close();

	}


	int utopianTree(int n) {
		int h =1;
		for (int i=1; i<= n; i++){
			if (i % 2 == 0){
				h+=1;
			} else {
				h *= 2;
			}
		}
		return h;
	}

	@Test
	public void testUtopianTree() {

		String input = "3\n"+
		"0\n"+
		"1\n"+
		"4";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);
	
		int n = scanner.nextInt();
		for (int i=0;i<n; i++){
			int nc = scanner.nextInt();
			System.out.println(utopianTree(nc));
		}

		scanner.close();

	}


	String angryProfessor(int k, int[] a) {
		int count = 0;
		for (int i=0;i< a.length; i++){
			if (a[i] <=0){
				count++;
				if (count == k){
					return "NO";
				}
			}
		}
		return "YES";

	}

	@Test
	public void testAngryProfessor() {

		String input = "2\n"+
		"4 3\n"+
		"-1 -3 4 2\n"+
		"4 2\n"+
		"0 -1 2 1";

		InputStream is = new ByteArrayInputStream(input.getBytes());

		Scanner scanner = new Scanner(is);
	
		int ntc = scanner.nextInt();
		for (int i=0; i< ntc; i++){

			int n = scanner.nextInt();

			int k = scanner.nextInt();

			int[] a = new int[n];

			for (int j = 0; j < n; j++) {
					a[j] = scanner.nextInt();
			}

				System.out.println(angryProfessor(k, a));		
		}

		
		scanner.close();

	}



}
