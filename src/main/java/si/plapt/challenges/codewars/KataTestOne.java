package si.plapt.challenges.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class KataTestOne {

	
	@Test
	 public void testFormatDuration() {
       int duration = 3662;
       int minutes = duration % 60;
       int hours = duration % 3600;
       int days  = duration % (3600*365);
       
       System.out.println(days);
       System.out.println(hours);
       System.out.println(minutes);
    }
	
	@Test
	public void testCreateSpiral() {
		int N = 5;
        int[][] spiral = new int[N][N];
        
        int count = 1;
        int i=0;
        int j=0;
        int dx = 1;
        int dy = 0;
        int minX = 0;
        int minY = 0;
        int maxX = N;
        int maxY = N;
        while (count <= N*N){
          spiral[j][i] = count;
          i += dx;
          j += dy;
          printSpiral(spiral, N);
          
          if (i == maxX && j == minY) {
        	  dx = 0;
        	  dy = 1;  
        	  i = maxX - 1;
        	  minY++;  
        	  j = minY;
          }
          
          if (i == maxX-1 && j == maxY) {
        	  dx = -1;
        	  dy = 0;
        	  maxX--; 
        	  i = maxX -1;
        	  j = maxY- 1;
          }
          
          if (i < minX && j == maxY - 1) {
        	  dx = 0;
        	  dy = -1;
        	  i = minX;
        	  maxY--;
        	  j=maxY-1;
          }
          
          
          if (i == minX && j < minY) {
        	  dx = 1;
        	  dy = 0;
        	  minX++;
        	  i=minX;
        	  j=minY;
          }
          
          count++;
        }
        
        printSpiral(spiral, N);
       
    }
	
	public void printSpiral(int[][] spiral, int N) {
		 for(int j=0;j< N; j++) {
	        	for(int i=0;i< N; i++) {
	            	System.out.print(spiral[j][i] +" ");
	            }
	        	System.out.println();
	        }
		 System.out.println();
	}
	
	public String lcs(String x, String y) {
		System.out.println("x:" + x);
		System.out.println("y:" + y);
		
		if (x.length() < y.length()) {
			String tmp = x;
			x=y;
			y = tmp;
		}

		
		int i=0;
		int j = 0;		
		int pos = -1;
		String longest = "";
		while (i < x.length() && pos < x.length()-1 && j < y.length()) {
															
			if (x.charAt(i) == y.charAt(j)) {
				pos = i;
				longest += x.charAt(i);
				j++;
			}			
			i++;
			
			if (i==x.length() && pos < x.length()) {			
				i = pos+1;
				j++;
			}
			
		
		}
		

		System.out.println("longest:" + longest);
		return longest;
	}
	
	@Test
	public void testLcs() {
		//lcs("abcdef", "acf");
		lcs("a", "a");
		//lcs("anothertest", "notatest");
	
	}
	
	public int convertBinaryArrayToInt(List<Integer> binary) {
       int prod = 1;
       int sum = 0;
       for (int i= binary.size()-1; i>= 0; i--) {
    	   sum += binary.get(i)*prod;    	   
    	   prod *=2;
       }
       return sum;
    }
	
	@Test
	public void testConvertBinary() {
		List<Integer> binary = Arrays.asList(1,1,1,1);
		int num = convertBinaryArrayToInt(binary);
		System.out.println(num);
		assertEquals(15,  num);
	}
        
	
	class Node  {
		private Node next;	
		
		int index;
		
		public Node(int index) {
			this.index = index;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "Node: " + index; 
		}
	}
	
	public Node createNodeLoop() {
		
		Node node = new Node(0);
		Node startNode = node;
		
		Node loopNode = null;
		
		for (int i=1;i<6; i++) {
			Node next = new Node(i);
			
			if (i==3) {
				loopNode = next;
			}
			
			node.setNext(next);
			node = next;			
		}
		
		node.setNext(loopNode);
		
		return startNode;
	}
	
	public int loopSize(Node node) {
	    java.util.List<Node> nodeList = new java.util.ArrayList<>();
	    nodeList.add(node);
	   // System.out.println(node +":" +node.hashCode());
	    boolean isLoop = false;
	    int count = 0;
	    while (node!=null && !isLoop){	     
	      node = node.getNext();
	      //System.out.println(node +":" +node.hashCode());
	      count = 0;
	      for (int i=nodeList.size()-1; i>=0; i--){
	        if (nodeList.get(i).hashCode() != node.hashCode()){
	          count++;
	        }  
	        
	          if (nodeList.get(i).hashCode() == node.hashCode()){
	            isLoop = true;
	            break;
	          }
	        
	      }
	      nodeList.add(node);
	    }
	    return isLoop? count+1:0;
	    
	  }
	
	@Test
	public void testLoop() {
		Node node = createNodeLoop();
		System.out.println(loopSize(node));
	}

	public  String whoIsNext(String[] names, int n)
    {
      
     
		while ( n > names.length){
		      n = (n - (names.length - 1)) / 2;
		}
		return names[n-1];
     
      
      //System.out.println(names[pos]);
      
     
      //return "";
      //return names[pos];
	   
    }
	
	@Test
	public void testWhoIsNext() {
		 String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		 int n = 52;
		 System.out.println(whoIsNext(names, n));
	}
	
	
}
