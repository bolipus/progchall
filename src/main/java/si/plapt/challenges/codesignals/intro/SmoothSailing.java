package si.plapt.challenges.codesignals.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SmoothSailing {
	public static void main(String[] args) {
		
		SmoothSailing app = new SmoothSailing();
		
		 String[] inputArray = { "aba", "aa", "ad", "vcd", "aba" };
		
		String[] longestStrings = app.allLongestStrings(inputArray);
		
		for (String string : longestStrings) { System.out.println(string); }

		/*
		 * String s1 = "abca"; String s2 = "xyzbac";
		 * 
		 * System.out.println(new IntroLevel2().commonCharacterCount(s1, s2));
		 */

		// System.out.println(new IntroLevel2().isLucky(1230));
		// System.out.println(new IntroLevel2().isLucky(239017));

		/*
		 * int[] inputArray = { -1, 150, 190, 170, -1, -1, 160, 180 };
		 * 
		 * for (int element : inputArray) { System.out.print(element +"\t"); }
		 * System.out.println();
		 * 
		 * int[] sortedArray = new IntroLevel2().sortByHeight(inputArray); for (int
		 * element : inputArray) { System.out.print(element +"\t"); }
		 * System.out.println();
		 */

		/*
		 * String s = "a(bc)de"; String s2 = "a(bcdefghijkl(mno)p)q"; String s3 =
		 * "The ((quick (brown) (fox) jumps over the lazy) dog)"; System.out.println(new
		 * IntroLevel2().reverseParentheses(s3));
		 */

	}
	
	
	String[] allLongestStrings(String[] inputArray) {

		Arrays.sort(inputArray, (a, b) -> b.length() - a.length());

		int maxLength = inputArray[0].length();
		int length = maxLength;

		List<String> longestStringsList = new ArrayList<>();

		for (int i = 0; i < inputArray.length; i++) {
			length = inputArray[i].length();
			if (length < maxLength) {
				break;
			}
			longestStringsList.add(inputArray[i]);
		}

		String[] longestStrings = {};
		return longestStringsList.toArray(longestStrings);
	}

	int commonCharacterCount(String s1, String s2) {

		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			int index = s2.lastIndexOf(s1.charAt(i));
			if (index != -1) {
				count++;
				String part1 = "";
				if (index > 0) {
					part1 = s2.substring(0, index);
				}
				String part2 = "";
				if (index < s2.length() - 1) {
					part2 = s2.substring(index + 1);
				}
				s2 = part1 + part2;
			}
		}
		return count;
	}

	boolean isLucky(int n) {
		String num = String.valueOf(n);
		int size = num.length();
		int halfSize = size / 2;
		int sum1 = 0;
		for (int i = 0; i < halfSize; i++) {
			sum1 += Integer.valueOf(num.charAt(i));
		}

		int sum2 = 0;
		for (int i = halfSize; i < size; i++) {
			sum2 += Integer.valueOf(num.charAt(i));
		}

		return sum1 == sum2;
	}

	int[] sortByHeight(int[] a) {
		int[] sorted = Arrays.copyOf(a, a.length);
		Arrays.sort(sorted);

		/*
		 * for (int element : sorted) { System.out.print(element + "\t"); }
		 * System.out.println();
		 */

		int index = 0;
		while (index < a.length && sorted[index] == -1) {
			index++;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] == -1)
				continue;
			a[i] = sorted[index++];
		}

		return a;

	}

	String reverseParentheses(String s) {
		Pattern pattern = Pattern.compile("\\([\\w\\s]+\\)");

		do {
			Matcher matcher = pattern.matcher(s);

			while (matcher.find()) {
				System.out.print("Start index: " + matcher.start());
				System.out.print(" End index: " + matcher.end() + " ");
				System.out.println(matcher.group());
				String replacement = new StringBuilder(matcher.group()).reverse().toString();
				replacement = replacement.substring(1, replacement.length() - 1);
				s = s.replace(matcher.group(), replacement);
			}

		} while (s.contains("("));

		return s;
	}
}
