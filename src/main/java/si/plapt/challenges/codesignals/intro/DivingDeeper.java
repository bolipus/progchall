package si.plapt.challenges.codesignals.intro;


import java.util.HashMap;
import java.util.Map;

public class DivingDeeper {

	public static void main(String[] args) {
		DivingDeeper app = new DivingDeeper();
/*
		int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int[] inputArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int[] result = app.extractEachKth(inputArray, 3);
		
		for (int val : result) {
			System.out.print(val + "\t");
		}
		System.out.println();*/

		/*int n = 91;

		System.out.println(app.digitDegree(n));*/
		
		String bishop = "h1", pawn = "h3";
		
		System.out.println(app.bishopAndPawn(bishop, pawn));

	}
	
	int[] extractEachKth(int[] inputArray, int k) {
		int newSize = inputArray.length -inputArray.length / k ;
		
		if (newSize == 0) {
			return new int[0];
		}
		
		int[] result = new int[newSize];
		int m = 0;
		for (int i=0;i < inputArray.length; i++) {			
			if ((i+1) % k == 0 && i>0) {
				continue;
			}
			result[m++] = inputArray[i];
		}
		
		
		return result;
	}

	char firstDigit(String inputString) {
		for (int i=0; i< inputString.length(); i++){
			if (Character.isDigit(inputString.charAt(i))){
				 return inputString.charAt(i);
			}
		}
		return '\0';
	}
	
	int differentSymbolsNaive(String s) {
		Map<Character, Integer> charMap = new HashMap<>();
		for(int i=0;i< s.length(); i++){
			Character c = s.charAt(i);
			Integer counter = charMap.get(c);
			if (counter==null){
				counter = new Integer(0);
			}
			counter++;

			charMap.put(c, counter);
		}

		return charMap.size();

	}
	

	int arrayMaxConsecutiveSum(int[] inputArray, int k) {
		int maxSum = 0;
		int sum = 0;
		for (int i=0; i< inputArray.length - k  + 1; i++){
			if (i==0){
				for (int j=0;j<k; j++){
					sum+= inputArray[j];
				}
			} else {

				if (i-1 >= 0){
					sum -= inputArray[i-1];
				} 
				sum += inputArray[i+k-1];				
			}
			if (sum > maxSum){
				maxSum = sum;
			}
		}

		return maxSum;
	}
	

	int digitDegree(int n) {
		int degree = 0;
		while (n / 10 > 0){
			int sum = 0;
			int num = n;
			while (num >= 10){
				sum += num % 10;
				num = num / 10;
				if (num < 10){
					sum += num;
				}
			}			
			n = sum;
			degree++;
		}

		return degree;
	}
	
	
	boolean bishopAndPawn(String bishop, String pawn) {

		bishop = bishop.toUpperCase();
		pawn = pawn.toUpperCase();

		int x1 = (int)bishop.charAt(0) - 64;
		int y1 = (int)bishop.charAt(1) - 48;
		
		int x2 = (int)pawn.charAt(0) - 64;
		int y2 = (int)pawn.charAt(1) - 48;
						
		int sx = x1;
		int sy = y1;
		
		while (sx > 0 && sy>0) {
			sx--;
			sy--;
			if (sx == x2 && sy==y2) {
				return true;
			}
		}
		
		sx = x1;
		sy = y1;
		
		while (sx < 8 && sy<8) {
			sx++;
			sy++;
			if (sx == x2 && sy==y2) {
				return true;
			}
		}
		
		sx = x1;
		sy = y1;
		
		while (sx < 8 && sy >0) {
			sx++;
			sy--;
			if (sx == x2 && sy==y2) {
				return true;
			}
		}
		
		sx = x1;
		sy = y1;
		
		while (sx > 0 && sy < 8) {
			sx--;
			sy++;
			if (sx == x2 && sy==y2) {
				return true;
			}
		}
		
		return false;
	}


}
