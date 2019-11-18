package si.plapt.challenges.codesignals.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExploringWaters {
	
	public static void main(String[] args) {
		/*
		 * int[] a = {50, 60, 60, 45, 70}; int[] b = new
		 * IntroLevel2().alternatingSums(a); System.out.println("[" + b[0] +", " +b[1] +
		 * "]");
		 */

		/*
		 * String[] picture = {"abc", "ded"};
		 * 
		 * String[] picBorder= new IntroLevel2().addBorder(picture); for (String s :
		 * picBorder) { System.out.println(s); }
		 */

		/*
		 * int[] a= {1, 2, 3}; int[] b = {2, 1, 3}; System.out.println(new
		 * IntroLevel2().areSimilar(a, b));
		 */

		/*
		 * int[] a= {1, 1, 1}; System.out.println(new IntroLevel2().arrayChange(a));
		 */

		/*
		 * String inputString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"; String inputString2
		 * = "aabb"; String inputString3 = "abbcabb";
		 * System.out.println(level2.palindromeRearranging(inputString3));
		 */

	}
	
	
	int[] alternatingSums(int[] a) {
		int[] b = { 0, 0 };
		for (int i = 0; i < a.length; i++) {
			b[i % 2] += a[i];
		}
		return b;
	}

	String[] addBorder(String[] picture) {
		int height = picture.length + 2;
		int width = picture[0].length() + 2;
		String[] picBorder = new String[height];

		char[] charArray = new char[width];
		Arrays.fill(charArray, '*');

		String upDown = String.valueOf(charArray);
		for (int i = 0; i < height; i++) {
			if (i == 0 || i == height - 1) {
				picBorder[i] = upDown;
			} else {
				picBorder[i] = "*" + picture[i - 1] + "*";
			}
		}
		return picBorder;
	}

	boolean areSimilar(int[] a, int[] b) {

		if (a.length != b.length) {
			return false;
		}
		List<Integer> diffIndices = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				diffIndices.add(i);
			}
		}

		System.out.println("Size:" + diffIndices.size());

		if (diffIndices.isEmpty()) {
			return true;
		}

		if (diffIndices.size() != 2) {
			return false;
		}

		if (a[diffIndices.get(0)] == b[diffIndices.get(1)] && a[diffIndices.get(1)] == b[diffIndices.get(0)]) {
			return true;
		}
		return false;
	}

	int arrayChange(int[] inputArray) {
		int moves = 0;
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] <= inputArray[i - 1]) {
				moves += inputArray[i - 1] + 1 - inputArray[i];
				inputArray[i] = inputArray[i - 1] + 1;
			}
		}

		return moves;

	}

	boolean palindromeRearranging(String inputString) {
		boolean canBe = false;
		Map<Integer, Integer> counterMap = new HashMap<>();
		for (int i = 0; i < inputString.length(); i++) {
			Integer key = inputString.codePointAt(i);
			Integer count = counterMap.get(key);
			if (count == null) {
				count = Integer.valueOf(0);
			}
			count++;
			counterMap.put(key, count);
		}
		short oddOnes = 0;
		for (Integer count : counterMap.values()) {
			if (count % 2 != 0) {
				oddOnes++;
				if (oddOnes > 1) {
					return false;
				}
			}
		}

		return true;

	}
}
