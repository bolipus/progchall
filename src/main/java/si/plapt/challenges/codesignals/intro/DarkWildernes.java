package si.plapt.challenges.codesignals.intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DarkWildernes {

	public static void main(String[] args) {
		
		DarkWildernes app = new DarkWildernes();

		/*int upSpeed = 100, downSpeed = 10, desiredHeight = 910;

		System.out.println(app.growingPlant(upSpeed, downSpeed, desiredHeight));*/


	/*	int value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, maxW = 8;

		System.out.println(app.knapsackLight(value1, weight1, value2, weight2, maxW));*/
	

		/*String inputString="123aa1";
		String inputString2 = "  3) always check for whitespaces";
		System.out.println(app.longestDigitsPrefix(inputString2));*/
		
		System.out.println(String.format("%02d:%02d", 5, 2));
		System.out.println(String.format("%02d:%02d", 14, 15));

	}

	int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
		int height = 0;
		int days = 0;


	 while (true) {
			height += upSpeed;			
			days++;
			if (height >= desiredHeight) {
				return days;
			}
			height -= downSpeed;
			
		} 
	}


	int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
		if (weight1 > maxW && weight2 > maxW){
			return 0;
		}

		if (weight1 + weight2 <= maxW){
			return value1 + value2;
		}  else if (weight1 <= maxW && weight2 < maxW) {
			return value1> value2? value1:value2;
		} else if (weight1 <= maxW){
			 return value1;
		} else {
			return value2;
		}
	}
	
	String longestDigitsPrefix(String inputString) {
		Pattern pattern = Pattern.compile("([a-zA-Z_]*)(\\s*\\d+)([a-zA-Z_\\s]*)");
		Matcher matcher = pattern.matcher(inputString);
		
		String maxDigits = "";
		while (matcher.find()) {
			String digits = matcher.group(2);			
			if (digits.length() > maxDigits.length() && !digits.startsWith(" ")) {
				maxDigits = digits;
				System.out.println("maxDigits:" + maxDigits);		
			}
				
	    }

	 	return maxDigits;
	}
	
	
	
	

}
