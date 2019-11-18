package si.plapt.challenges.codesignals.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crossroads {

	public static void main(String[] args) {
		Crossroads app = new Crossroads();
		
		System.out.println(app.metroCard(30));;
	}
	
	int[] metroCard(int lastNumberOfDays) {
	    List<Integer> days = new ArrayList<>();
	    if (lastNumberOfDays == 30){
	        days.add(31);
	    }
	    
	    if (lastNumberOfDays == 31){
	        days.add(28);
	        days.add(30);
	    }
	    
	    if (lastNumberOfDays == 28){
	         days.add(31);
	    }
	    
	   Collections.sort(days);
	   
	   int[] d = new int[days.size()];
	   for (int i=0;i<days.size(); i++) {
		   d[i] = days.get(i);
	   }
	    
	   return d;
	    
	}

	
}
