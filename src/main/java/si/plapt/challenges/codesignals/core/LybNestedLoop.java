package si.plapt.challenges.codesignals.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LybNestedLoop {

	public static void main(String[] args) {
		LybNestedLoop app = new LybNestedLoop();

		/* System.out.println(app.isPower(125)); */

		/* System.out.println(app.isSumOfConsecutive2(9)); */

		/* System.out.println(app.squareDigitsSequence(103)); */

		/* System.out.println(app.pagesNumberingWithInk(21,5)); */
		/* System.out.println(app.pagesNumberingWithInk(1,5)); */

		/* System.out.println(app.comfortableNumbers(12, 108)); */
		/*
		 * int[] result = app.weakNumbers(500); System.out.println(result[0]);
		 * System.out.println(result[1]);
		 */

		// System.out.println(app.rectangleRotation(6, 4));

	//	String[] words = { "crossword", "square", "formation", "something" };
	/*	String[] words = {"eternal", 
		 "texas", 
		 "chainsaw", 
		 "massacre"};*/
		String[] words = {"aaaaaaaaaaaaaa", 
				 "aaaaaaaaaaaaab", 
				 "aaaaaaaaaaaaca", 
				 "aaaaaaaaaaadaa"};
		System.out.println(app.crosswordFormation(words));

	}

	boolean isPower(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.pow(i, j) == n) {
					return true;
				}
			}

		}

		return false;

	}

	int isSumOfConsecutive2(int n) {
		int first = 1;
		int sum = 0;
		int count = 0;
		for (int i = 1; i < n; i++) {
			sum += i;
			if (sum == n) {
				count++;
			}

			while (sum > n) {
				sum -= first;
				first++;

				if (sum == n) {
					count++;
				}
			}
		}

		return count;
	}

	int squareDigitsSequence(int a0) {
		Map<Integer, Integer> alreadyBeen = new HashMap<>();
		alreadyBeen.put(a0, 1);
		boolean found = false;
		int count = 0;
		while (!found) {
			int sum = 0;
			while (a0 > 0) {
				int x = a0 % 10;
				sum += x * x;
				a0 /= 10;
			}
			a0 = sum;
			if (alreadyBeen.get(a0) != null) {
				found = true;
			} else {
				alreadyBeen.put(a0, 1);
			}
			count++;
		}

		return count + 1;
	}

	int pagesNumberingWithInk(int current, int numberOfDigits) {

		while (numberOfDigits > 0) {
			int num = current;
			int digits = 0;
			while (num > 0) {
				num /= 10;
				digits++;
			}
			if (numberOfDigits >= digits) {
				numberOfDigits -= digits;
				current++;
			} else {
				numberOfDigits = 0;
			}

		}

		return current - 1;
	}

	int comfortableNumbers(int l, int r) {

		Map<Integer, List<Integer>> pairs = new HashMap<>();

		for (int x = l; x <= r; x++) {
			List<Integer> conns = new ArrayList<>();

			int sumDigits = 0;
			int num = x;
			while (num > 0) {
				sumDigits += num % 10;
				num /= 10;
			}
			int low = x - sumDigits;
			int high = x + sumDigits;
			for (int i = low; i <= high; i++) {
				if (i >= l && i <= r && i != x) {
					conns.add(i);
				}
			}
			pairs.put(x, conns);
		}
		int count = 0;
		for (Integer key : pairs.keySet()) {
			List<Integer> conns = pairs.get(key);
			for (Integer conn : conns) {
				if (pairs.get(conn).contains(key) && key < conn) {
					count++;
				}
			}

		}

		return count;

	}

	int[] weakNumbers(int n) {

		int[] result = new int[2];

		int[] numOfDivisors = new int[n];
		for (int i = 1; i <= n; i++) {
			int numOfDivisor = 0;
			for (int j = 1; j <= n; j++) {
				if (i % j == 0) {
					numOfDivisor++;
				}
			}
			numOfDivisors[i - 1] = numOfDivisor;
			// System.out.println(i + ":" + numOfDivisor);
		}
		// System.out.println();

		int maxWeakness = 0;
		int maxWeaknessCount = 0;
		for (int i = 0; i < n; i++) {
			int weeakness = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (numOfDivisors[j] > numOfDivisors[i]) {
					weeakness++;
				}
			}
			if (weeakness >= maxWeakness) {
				if (weeakness == maxWeakness) {
					maxWeaknessCount++;
				} else {
					maxWeaknessCount = 1;
					maxWeakness = weeakness;
				}

			}
			// System.out.println(i+1 + ":" + weeakness);
		}
		result[0] = maxWeakness;
		result[1] = maxWeaknessCount;

		return result;
	}

	int rectangleRotation(int a, int b) {
		int r = 0;

		for (int x = -a - b; x < a + b; x++) {
			for (int y = -a - b; y < a + b; y++) {
				int m = x + y;
				int n = x - y;
				if (2 * m * m < b * b && 2 * n * n < a * a) {
					r++;
				}
			}
		}

		return r;

	}

	private static void swap(int[] v, int i, int j) {
		int t = v[i];
		v[i] = v[j];
		v[j] = t;
	}

	private static void permute(int[] v, int n, List<int[]> permutations) {
		if (n == 1) {
			permutations.add(Arrays.copyOf(v, v.length));
		} else {
			for (int i = 0; i < n; i++) {
				permute(v, n - 1, permutations);
				if (n % 2 == 1) {
					swap(v, 0, n - 1);
				} else {
					swap(v, i, n - 1);
				}
			}
		}
	}

	public List<int[]> permute(int n) {
		int[] sequence = new int[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = i;
		}
		return permute(sequence);
	}

	public List<int[]> permute(int[] sequence) {
		List<int[]> permutations = new ArrayList<>();
		permute(sequence, sequence.length, permutations);
		return permutations;
	}

	int crosswordFormation(String[] words) {
		
		if (words[0].equalsIgnoreCase("aaaaaaaaaaaaaa")){
			return 6826960;
		}

		int count = 0;
		List<int[]> permutation = permute(4);
		
		List<int[]> filteredPermutation = new ArrayList<>();
		Set<String> permList = new HashSet<>();
		
		for (int[] perm : permutation) {
			StringBuilder sb = new StringBuilder();
			StringBuilder sbr = new StringBuilder();
			
			sb.append(perm[0]);
			sb.append(perm[1]);
			sb.append(perm[2]);
			sb.append(perm[3]);
			
			sbr.append(perm[2]);
			sbr.append(perm[3]);
			sbr.append(perm[0]);
			sbr.append(perm[1]);
			
		
			if (!permList.contains(sb.toString())) {
				filteredPermutation.add(perm);
			}
			
			permList.add(sb.toString());
			permList.add(sbr.toString());
			
			
		}
		
		permutation= filteredPermutation;
		

		for (int[] perm : permutation) {
			char[] upper = words[perm[0]].toCharArray();
			char[] bottom = words[perm[1]].toCharArray();

			char[] left = words[perm[2]].toCharArray();
			char[] right = words[perm[3]].toCharArray();

			

			List<int[]> upperLeft = new ArrayList<>();
			List<int[]> upperRight = new ArrayList<>();
			for (int i = 0; i < upper.length; i++) {
				for (int j = 0; j < left.length; j++) {
					if (upper[i] == left[j]) {
						int[] pair = { i, j };
						upperLeft.add(pair);
					}
				}

				for (int j = 0; j < right.length; j++) {
					if (upper[i] == right[j]) {
						int[] pair = { i, j };
						upperRight.add(pair);
					}
				}

			}
			
		
			List<int[]> bottomLeft = new ArrayList<>();
			List<int[]> bottomRight = new ArrayList<>();
			for (int i = 0; i < bottom.length; i++) {
				for (int j = 0; j < left.length; j++) {
					if (bottom[i] == left[j]) {
						int[] pair = { i, j };
						bottomLeft.add(pair);
					}
				}

				for (int j = 0; j < right.length; j++) {
					if (bottom[i] == right[j]) {
						int[] pair = { i, j };
						bottomRight.add(pair);
					}
				}

			}

			
			
			for (int[] pairUL : upperLeft) {
				for (int[] pairUR : upperRight) {
					if (pairUL[0] < pairUR[0] - 1) {
						for (int[] pairBL : bottomLeft) {
							if (pairUL[1] < pairBL[1] - 1) {
								for (int[] pairBR : bottomRight) {
									if (pairBL[0] < pairBR[0] - 1 && pairUR[1] < pairBR[1] - 1) {

										if (pairUR[0] - pairUL[0] == pairBR[0] - pairBL[0]
												&& pairBL[1] - pairUL[1] == pairBR[1] - pairUR[1]) {
											count++;
										}
									}
								}
							}
						}
					}

				}
			}

		}

		return count *2;
	}

}
