package si.plapt.challenges.codesignals.intro;

import java.util.Arrays;

public class IslandKnowledge {

	public static void main(String[] args) {
		/*
		 * String inputString ="172.16.254.1";
		 * System.out.println(level2.isIPv4Address(inputString));
		 */

		/*
		 * int[] inputArray = {5, 3, 6, 7, 9};
		 * System.out.println(level2.avoidObstacles(inputArray));
		 */

		/*
		 * int[][] image = {{1, 1, 1}, {1, 7, 1}, {1, 1, 1}}; int[][] image2 = {{7, 4,
		 * 0, 1}, {5, 6, 2, 2}, {6, 10, 7, 8}, {1, 4, 2, 0}};
		 * 
		 * int[][] result = level2.boxBlur(image2); for (int i=0;i<result.length; i++) {
		 * for (int j=0;j<result[0].length; j++) { System.out.print(result[i][j]+" "); }
		 * System.out.println(); }
		 */

		/*boolean[][] matrix = { { true, false, false }, { false, true, false }, { false, false, false } };

		int[][] result = level2.minesweeper(matrix);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}*/

	}
	
	
	boolean isIPv4Address(String inputString) {
		String[] ipVal = inputString.split("\\.");

		if (ipVal.length != 4) {
			return false;
		}

		for (String val : ipVal) {
			if (val.isEmpty()) {
				return false;

			}
			try {
				if (Integer.valueOf(val) > 255) {
					return false;
				}
			} catch (NumberFormatException ex) {
				return false;
			}

		}

		return true;
	}

	int avoidObstacles(int[] inputArray) {
		Arrays.sort(inputArray);

		int jump = 2;
		for (int i = 0; i < inputArray.length;) {
			if (inputArray[i] % jump == 0) {
				jump++;
				i = 0;
			} else {
				i++;
			}
		}

		return jump;
	}

	int[][] boxBlur(int[][] image) {
		int[][] result = new int[image.length - 2][image[0].length - 2];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				double sum = 0;
				for (int a = -1; a < 2; a++) {
					for (int b = -1; b < 2; b++) {
						sum += image[i + a + 1][j + b + 1];
					}
				}
				sum /= 9.0;
				result[i][j] = (int) Math.floor(sum);
			}
		}

		return result;
	}

	int[][] minesweeper(boolean[][] matrix) {
		int[][] result = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int sum = 0;
				for (int a = -1; a < 2; a++) {
					int x = i + a;
					if (x < 0 || x >= matrix.length)
						continue;

					for (int b = -1; b < 2; b++) {
						int y = j + b;
						if (y < 0 || y >= matrix[0].length)
							continue;

						if (a == 0 && b == 0){
							continue;
						}
						
						if (matrix[x][y]) {
							sum++;
						}

					}
				}
				result[i][j] = sum;
			}
		}
		return result;
	}
}
