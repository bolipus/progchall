package si.plapt.challenges.codesignals.intro;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErruptionLight {

	public static void main(String[] args) {
		ErruptionLight app = new ErruptionLight();
		
	/*	String inputString = "bbbaacdafe";
		String inputString2 = "aabbb";
		String inputString3 = "bbc";
		String inputString4 = "abcdefghijklmnopqrstuvwxyzz";
				
		System.out.println(app.isBeautifulString(inputString));
		System.out.println(app.isBeautifulString(inputString2));
		System.out.println(app.isBeautifulString(inputString3));
		System.out.println(app.isBeautifulString(inputString4));*/
		
		/*String address = "prettyandsimple@example.com";
		String address2 = "<>[]:,;@\"!#$%&*+-/=?^_{}| ~.a\"@example.org"; 
		System.out.println(app.findEmailDomain(address2));*/
		
		/*String st = "abcdc";
		
		System.out.println(app.buildPalindrome(st));*/
		
		/*int votes[] = {2, 3, 5, 2};
		int k = 3;
		
		System.out.println(app.electionsWinners(votes, k));*/
		
		
		String inputString = "00-1B-63-84-45-E6";
		String inputString2 = "Z1-1B-63-84-45-E6";
		String inputString3 = "not a MAC-48 address";
		String inputString4 = "02-03-04-05-06-07-";
		
		System.out.println(app.isMAC48Address(inputString));
		System.out.println(app.isMAC48Address(inputString2));
		System.out.println(app.isMAC48Address(inputString3));
		System.out.println(app.isMAC48Address(inputString4));
		
		

	}

	
	boolean isBeautifulString(String inputString) {
		Map<Character, Integer> charMap = new HashMap<>();
		
		int codeA = (int)('a');
		int codeZ = (int)('z');
		
		Integer zero = new Integer(0);
		int c = codeA;
		do {
			charMap.put((char) c, zero);
			c++;
		} while (c <= codeZ);
	
		
		for (int i=0; i < inputString.length(); i++) {
			Character ch = inputString.charAt(i);
			Integer counter = charMap.get(ch);
			counter++;
			charMap.put(ch, counter);
		}
		
		c = codeA;
		do {
			Integer counter1 = charMap.get((char)c);
			Integer counter2 = charMap.get((char)(c+1));
			//System.out.print((char)c +":" +counter1);
			//System.out.print("\t");
			//System.out.println((char)(c+1) +":" +counter2);
			
			if ( counter1 <  counter2) {
				return false;
			}
			c++;
		} while (c < codeZ );
		
		
		return true;
		
	}
	
	String findEmailDomain(String address) {
		Pattern pattern = Pattern.compile(".+@([a-zA-Z_0-9.]+)");
		Matcher matcher = pattern.matcher(address);
		
		String domain = "";
		
		if (matcher.find()) {
			domain = matcher.group(1);	
			int index = domain.lastIndexOf('@');
			if (index != -1) {
				domain = domain.substring(index+1);
			}
		}
		
		return domain;
	}


	
	String buildPalindrome(String st) {
		StringBuilder sb = new StringBuilder(st);
		String reverse = sb.reverse().toString();
		
		String s = st;
	
		int index = 0;
		while (!reverse.contains(s)) {
			s = s.substring(1);
			index++;
		}
		
		return  st.substring(0, index) + reverse;
					
		
	}
	
	int electionsWinners(int[] votes, int k) {
		int num = 0;
		for (int i=0;i< votes.length; i++) {
			int maxVotes = votes[i] + k;
			boolean canWin = true;
			for (int j=0;j<votes.length; j++) {
				if (i==j) {
					continue;
				}
				if (maxVotes <= votes[j]) {
					canWin = false;
					break;
				}
			}
			if (canWin) {
				num++;
			}
		}
		
		return num;
	}
	
	boolean isMAC48Address(String inputString) {
		if (inputString.length() > 17) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("([a-fA-F_0-9]{2}-){5}[a-fA-F_0-9]{2}");
		Matcher matcher = pattern.matcher(inputString);
		
		
		if (matcher.find()) {
			return true;
		} 
		
		return false;
		
	}

	


}
