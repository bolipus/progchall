package si.plapt.challenges.codesignals.intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RainReasons {
	public static void main(String[] args) {
		/*int n = 248622;
		System.out.println(level2.evenDigitsOnly(n));*/
		
		/*String name = "var_1__Int";
		String name2 = "qq-q";
		String name3 = "2w2";
		String name4 =" variable";
		
		System.out.println(level2.correctVariableName(name));
		System.out.println(level2.correctVariableName(name2));
		System.out.println(level2.correctVariableName(name3));
		System.out.println(level2.correctVariableName(name4));*/
		
		/*String inputString = "crazy";
		System.out.println(level2.alphabeticShift(inputString));*/
		
		/*String cell1 = "A1"; 
		String cell2 = "B2";
		System.out.println(level2.chessBoardCellColor(cell1, cell2));*/

	}
	
	

	
	boolean evenDigitsOnly(int n) {
		while (n > 0) {
			int digit = n % 10;
			if (digit %2 != 0) {
				return false;
			}
			n = n /10;
		}
		return true;
	}

	boolean correctVariableName(String name) {
		System.out.println(name);
		Pattern pattern = Pattern.compile("^[a-zA-Z_][\\w]*");
		Matcher matcher = pattern.matcher(name);
		
		return matcher.matches();
	}
	

	String alphabeticShift(String inputString) {
		StringBuilder sb = new StringBuilder() ; 
		for (int i=0;i< inputString.length(); i++) {
			if (inputString.charAt(i) == 'z') {
				sb.append('a');
			} else {
				char c = inputString.charAt(i);
				c++;
				sb.append(c);
			}
		}
		return sb.toString();
	}

	boolean chessBoardCellColor(String cell1, String cell2) {
		
		System.out.println((int)"A".charAt(0));
		
		
		int x1 = (int)cell1.charAt(0) - 64;
		int y1 = (int)cell1.charAt(1) - 48;
		
		int x2 = (int)cell2.charAt(0) - 64;
		int y2 = (int)cell2.charAt(1) - 48;
		
		int sumX = x1 + x2;
		int sumY = y1 + y2;
		
		if (sumX % 2 == 0 && sumY %2 == 0 || sumX % 2 == 1 && sumY % 2 == 1) {
			return true;
		} 
		
		return false;	
	}
}
