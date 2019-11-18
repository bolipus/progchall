package si.plapt.challenges.codesignals.intro;

import java.util.ArrayList;
import java.util.List;


public class RainbowClarity {

	public static void main(String[] args) {
		RainbowClarity app = new RainbowClarity();

		/*String inputString = "aabbbc";
		System.out.println(app.lineEncoding(inputString));*/
		
		/*String cell = "a1";
		
		System.out.println(app.chessKnight(cell));*/
		
		int n  = 152;
		int n1  = 1001;
		int n2  = 10;
		int n3 = 222219;
		//System.out.println(app.deleteDigit(n));
	//	System.out.println(app.deleteDigit(n1));
	//	System.out.println(app.deleteDigit(n2));
		System.out.println(app.deleteDigit(n3));
	}
	
	String lineEncoding(String s) {
		
		System.out.println("Input:" +s);
		
		StringBuilder part = new StringBuilder();
		part.append(s.charAt(0));
		List<String> parts = new ArrayList<>();
		
		for (int i=1; i < s.length(); i++) {
			if (s.charAt(i) == part.charAt(0)) {
				part.append(s.charAt(i));
			} else {
				parts.add(part.toString());
				part = new StringBuilder();
				part.append(s.charAt(i));
			}
		}
		
		if (part.length() != 0) {
			parts.add(part.toString());
		}
		
		StringBuilder result = new StringBuilder();
		for (String p : parts) {
			if (p.length() > 1) {
				result.append(p.length());
			}
			result.append(p.charAt(0));			
		}

		
		return result.toString();
	}

	
	int chessKnight(String cell) {
		
		cell = cell.toUpperCase();
		
		int x = (int)cell.charAt(0) - 64;
		int y = (int)cell.charAt(1) - 48;
		
		int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
		
		int moves = 0;
		for (int i=0;i< 8 ;i++) {
			int px = x+dx[i];
			int py = y+dy[i];
			if (px >= 1 && px<=8 && py >= 1 && py<=8) {
				moves++;
			}
		}
		
		return moves;

	}
	
	int deleteDigit(int n) {
		String val = String.valueOf(n);
		int max = 0;
		String prefix = "";
		for (int i=0;i< val.length(); i++) {
			String postfix = val.substring(i+1);
			int num = Integer.valueOf(prefix + postfix);
			if (num > max) {
				max = num;
			}
			prefix += val.charAt(i);
		}
		
		return max;
	}



}
