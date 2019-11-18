package si.plapt.challenges.codesignals.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AIntroGates {

	public static void main(String[] args) {
		AIntroGates app = new AIntroGates();
		
		/*int n = 29;
		System.out.println(app.addTwoDigits(n));		
		*/
		
		/*int n = 2;
		System.out.println(app.largestNumber(n));*/
		
	/*	Pattern pattern = Pattern.compile("^\\w{3}-\\w{2}$ |^\\w{4}-\\w{1}$");
        Matcher matcher = pattern.matcher("2A23-3");
        if (matcher.find()){
            System.out.println("Found");
        } else {
        	 System.out.println("Not found");
        }*/
		
		/*System.out.println(app.romanToArabic("IV"));*/
		
		System.out.println(app.phoneCall(1, 2, 1, 6));
        
		
	}
	
	
	
			
	int addTwoDigits(int n) {
		return n%10 + n/10;		
	}
	
	int largestNumber(int n) {
		
		
		int val = 0;
		int mn = 1;
		for (int i=1; i< n; i++) {
			mn *=10;
			val += mn;
		}
			
		
		return 9*val +9;
	}
	
	enum RomanNumeral {
	    I(1), IV(4), V(5), IX(9), X(10), 
	    XL(40), L(50), XC(90), C(100), 
	    CD(400), D(500), CM(900), M(1000);
	 
	    private int value;
	 
	    RomanNumeral(int value) {
	        this.value = value;
	    }
	 
	    public int getValue() {
	        return value;
	    }
	     
	    public static List<RomanNumeral> getReverseSortedValues() {
	        return Arrays.stream(values())
	          .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
	          .collect(Collectors.toList());
	    }
	}
	
	
	public static int romanToArabic(String input) {
	    String romanNumeral = input.toUpperCase();
	    int result = 0;
	         
	    List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
	 
	    int i = 0;
	 
	    while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
	        RomanNumeral symbol = romanNumerals.get(i);
	        if (romanNumeral.startsWith(symbol.name())) {
	            result += symbol.getValue();
	            romanNumeral = romanNumeral.substring(symbol.name().length());
	        } else {
	            i++;
	        }
	    }
	 
	    if (romanNumeral.length() > 0) {
	        throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
	    }
	 
	    return result;
	}
	
	int phoneCall(int min1, int min2_10, int min11, int s) {
	    int i=0;
	    if (s< min1){
	          return 0;	          
	     }
	    do {
	        if (i==0){
	            s-= min1;
	            i++;
	        } else if (i<10){
	        	int min = s/min2_10;
	        	if (min >9) {
	        		min = 9;
	        	}
	            i+=min ;	           
	            s-= min*min2_10;
	            if (s< min2_10) {
	            	return i;
	            }
	        } else {
	            int min = s/min11;
	            i+= min;
	            s-=min*min11;
	            return i;
	        }
	       
	        
	    } while (s>0);
	    
	    return i;
	}

	
	
	
}


