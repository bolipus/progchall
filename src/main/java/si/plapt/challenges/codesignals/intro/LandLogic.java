package si.plapt.challenges.codesignals.intro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LandLogic {

	public static void main(String[] args) {
		LandLogic app = new LandLogic();
		/*
		 * String text = "Ready, steady, go!";
		 * System.out.println(app.longestWord(text));
		 */

		/*
		 * String time1 = "13:58"; String time2 = "25:51";
		 * System.out.println(app.validTime(time1));
		 * System.out.println(app.validTime(time2));
		 */

		/*
		 * String inputString =
		 * "there are some (12) digits 5566 in this 770 string 239";
		 * System.out.println(app.sumUpNumbers(inputString));
		 */

		/*
		 * int[][] matrix = {{1, 2, 1}, {2, 2, 2}, {2, 2, 2}, {1, 2, 3}, {2, 2, 1}};
		 * 
		 * System.out.println(app.differentSquares(matrix));
		 */

		/*
		 * int product = 0; System.out.println(app.digitsProduct(product));
		 */

		/*
		 * String[] names2 = {"doc", "doc", "image", "doc(1)", "doc"};
		 * 
		 * String[] names ={"a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a",
		 * "a"};
		 * 
		 * String[] result = app.fileNaming(names); for (String s: result) {
		 * System.out.print(s + " "); }
		 */
		/*
		 * String code = "010010000110010101101100011011000110111100100001";
		 * System.out.println(app.messageFromBinaryCode(code));
		 */

	/*	int n = 3;
		int[][] result = app.spiralNumbers(n);
		for (int j=0; j< result[0].length; j++) {
			for (int i=0;i< result.length; i++) {			
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();			
		}*/
		
		
		int[][] grid = {{1,3,2,5,4,6,9,8,7}, 
		       {4,6,5,8,7,9,3,2,1}, 
		       {7,9,8,2,1,3,6,5,4}, 
		       {9,2,1,4,3,5,8,7,6}, 
		       {3,5,4,7,6,8,2,1,9}, 
		       {6,8,7,1,9,2,5,4,3}, 
		       {5,7,6,9,8,1,4,3,2}, 
		       {2,4,3,6,5,7,1,9,8}, 
		       {8,1,9,3,2,4,7,6,5}};
		
		int[][] grid2 = 
			  {{1,3,2,5,4,6,9,2,7}, 
		       {4,6,5,8,7,9,3,8,1}, 
		       {7,9,8,2,1,3,6,5,4}, 
		       {9,2,1,4,3,5,8,7,6}, 
		       {3,5,4,7,6,8,2,1,9}, 
		       {6,8,7,1,9,2,5,4,3}, 
		       {5,7,6,9,8,1,4,3,2}, 
		       {2,4,3,6,5,7,1,9,8}, 
		       {8,1,9,3,2,4,7,6,5}};
		
		System.out.println(app.sudoku(grid2));
		
	}

	String longestWord(String text) {
		Pattern pattern = Pattern.compile("([a-zA-Z]*)");

		Matcher matcher = pattern.matcher(text);

		String longest = "";
		while (matcher.find()) {
			String word = matcher.group();
			if (word.length() > longest.length()) {
				longest = word;
			}
		}

		return longest;
	}

	boolean validTime(String time) {
		String[] values = time.split(":");

		short hour = Short.parseShort(values[0]);
		short minute = Short.parseShort(values[1]);

		return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
	}

	int sumUpNumbers(String inputString) {
		Pattern pattern = Pattern.compile("([0-9]*)");

		Matcher matcher = pattern.matcher(inputString);

		int sum = 0;
		while (matcher.find()) {
			String number = matcher.group();
			if (number.length() > 0) {
				System.out.println(number);
				sum += Integer.parseInt(number);
			}
		}

		return sum;
	}

	int differentSquares(int[][] matrix) {
		int width = matrix.length;
		int height = matrix[0].length;

		Set<String> setSquares = new TreeSet<>();
		for (int i = 0; i < width - 1; i++) {
			for (int j = 0; j < height - 1; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(matrix[i][j]);
				sb.append(matrix[i + 1][j]);
				sb.append(matrix[i][j + 1]);
				sb.append(matrix[i + 1][j + 1]);
				setSquares.add(sb.toString());
			}
		}

		return setSquares.size();

	}

	int digitsProduct(int product) {

		Stack<Integer> products = new Stack<>();
		products.push(product);

		Stack<Integer> results = new Stack<>();

		int minNum = Integer.MAX_VALUE;
		int num = 0;

		if (product == 0) {
			return 10;
		}

		if (product < 10) {
			return product;
		}

		do {
			int val = products.pop();
			if (!results.isEmpty()) {
				num = results.pop();
				num *= 10;
			}

			for (int i = 2; i < 10; i++) {
				int currNum = num;
				if (val % i == 0) {
					int newVal = val / i;

					if (newVal < 10) {
						currNum += i;
						currNum *= 10;
						currNum += newVal;
						if (currNum < minNum) {
							minNum = currNum;
						}

					} else {
						products.push(newVal);
						currNum += i;
						results.push(currNum);
					}
				}
			}

		} while (!products.isEmpty());

		if (minNum == Integer.MAX_VALUE) {
			return -1;
		} else {
			return minNum;
		}

	}

	String[] fileNaming(String[] names) {
		Map<String, Integer> nameMap = new HashMap<>();
		String[] result = new String[names.length];

		for (int i = 0; i < names.length; i++) {
			Integer counter = nameMap.get(names[i]);

			if (counter == null) {
				result[i] = names[i];
				counter = new Integer(1);
			} else {
				StringBuilder sb = null;

				do {
					sb = new StringBuilder();
					sb.append(names[i]);
					sb.append("(");
					sb.append(counter++);
					sb.append(")");
				} while (nameMap.get(sb.toString()) != null);

				nameMap.put(sb.toString(), new Integer(1));
				result[i] = sb.toString();
			}
			nameMap.put(names[i], counter);
		}

		return result;
	}

	String messageFromBinaryCode(String code) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < code.length(); i += 8) {
			String s = code.substring(i, i + 8);
			byte val = Byte.parseByte(s, 2);
			sb.append((char) val);
		}
		return sb.toString();
	}

	int[][] spiralNumbers(int n) {
		int[][] result = new int[n][n];
		int right =  n;
		int bottom = n;
		int left = 0;
		int top = 0;
		int x = 0;
		int y = 0;
		int count = 1;
		
		do {
			while (x < right) {
				result[y][x++] = count++;
			}
			
			top++;			
			x--;
			y = top;
			
			while (y < bottom) {
				result[y++][x] = count++;
			}
			
			right--;			
			y--;
			x = right - 1 ;
			
			while (x >= left) {
				result[y][x--] = count++;
			}
			
			bottom--;			
			x++;
			y = bottom - 1;
					
			while (y >= top) {
				result[y--][x] = count++;
			}
			left++;
			y++;
			x = left;
			
		} while (count <= n*n);

		return result;
	}
	
	boolean sudoku(int[][] grid) {
		
		
		for (int i=0; i < grid.length; i+=3) {
		
			for (int j=0; j< grid[0].length; j+=3) {
				
				boolean[] flagsSquare = new boolean[9];
				Arrays.fill(flagsSquare, 0, 9, false);				
				for (int m=0;m < 3; m++) {					
					for (int n=0;n < 3; n++) {
						int num = grid[i+m][j+n];
						if (flagsSquare[num -1]) {
							return false;
						} else {
							flagsSquare[num-1] = true;
						}	
					}
				}
			}
		}
		
		for (int i=0; i < grid.length; i++) {
			boolean[] flagsRow = new boolean[9];
			Arrays.fill(flagsRow, 0, 9, false);			
			for (int j=0; j< grid[0].length; j++) {
					
				int num = grid[i][j];
				if (flagsRow[num -1]) {
					return false;
				} else {
					flagsRow[num-1] = true;
				}	
			}
		}
		
		for (int j=0; j < grid.length; j++) {
			boolean[] flagsColumn = new boolean[9];
			Arrays.fill(flagsColumn, 0, 9, false);	
			
			for (int i=0; i< grid[0].length; i++) {
							
				int num = grid[i][j];
				if (flagsColumn[num -1]) {
					return false;
				} else {
					flagsColumn[num-1] = true;
				}	
			}
		}
		
		return true;
	}


}
