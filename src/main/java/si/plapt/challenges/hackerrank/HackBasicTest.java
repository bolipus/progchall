package si.plapt.challenges.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import junit.framework.TestCase;

public class HackBasicTest extends TestCase {
	

	@Test
	public void testUsername() {
		
		String userName = "Julia007";
		String regular = "^[a-zA-Z]{1}\\w{7,29}";
		if (userName.matches(regular)) {
	        System.out.println("Valid");
	    } else {
	        System.out.println("Invalid");
	    } 
	}
	
	@Test 
	public void testTagContent() {
		String cases[] = {
				"<h1>Nayeem loves counseling</h1>",
				"<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
				"<Amee>safat codes like a ninja</amee>",
				"<SA premium>Imtiaz has a secret crush</SA premium>"
		};
		
		for (int i = 0; i < cases.length; i++) {
			String line = cases[i];
			Pattern pattern = Pattern.compile("<(.+)>([^<>]+)</\\1>");
			
			Matcher match = pattern.matcher(line);
			boolean found = false;
			while (match.find()) {				
				System.out.println(match.group(2));
				found = true;
			}
			if (!found) {
				System.out.println("None");
			}
		}						
	}
	
	@Test
	public void testProbablyPrime() {
		String[] numbers = {
			"13",
			"5",
			"27"
		};
		
	
		
		for (String prime : numbers) {
			BigInteger bg = new BigInteger(prime);
			if (bg.isProbablePrime(100)) {
				System.out.println("prime");
			} else {
				System.out.println("not prime");
			}
		}
		
		Scanner scanner = new Scanner(System.in);
		
	}

	
	@Test 
	public void testBigNumber(){
		
	    String a = "1234";
	    String b = "20";
	    BigDecimal aN = new BigDecimal(a);
	    BigDecimal bN = new BigDecimal(b);
	    System.out.println(aN.add(bN));
	    System.out.println(aN.multiply(bN));
	}
	
	
	@Test
	public void testBigDecimalSort() {
		String[] numbers = {
				"-100",
				"50",
				"0",
				"56.6",
				"90",
				"0.12",
				".12",
				"02.34",
				"000.000"
		};
		
		Arrays.sort(numbers, 0, numbers.length, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				BigDecimal b1 = new BigDecimal(o1);
				BigDecimal b2 = new BigDecimal(o2);
				return b2.compareTo(b1);
			}
		});
		
		for (String num : numbers) {
			System.out.println(num);
		}
		
	}
	
	@Test
	public void testHashSet() {
		String[] pair_left = {
				"john", "john","john","mary", "mary"
		};
		String[] pair_right = {
				"tom", "mary","tom","anna", "anna"
		};
		
		Set<String> pairs = new HashSet<>();
		for (int i = 0; i < pair_left.length; i++) {
			pairs.add(pair_left[i]+"-"+pair_right[i]);
			System.out.println(pairs.size());
		}
		
	}
	
	@Test
	public void testHourGlass() {
		String[] lines = {
			"-1 -1 0 -9 -2 -2",
			"-2 -1 -6 -8 -2 -5",
			"-1 -1 -1 -2 -3 -4",
			"-1 -9 -2 -4 -4 -5",
			"-7 -3 -3 -2 -9 -9",
			"-1 -3 -1 -2 -4 -5"
		};
		
		int[][] arr = new int[6][6];
		for (int i = 0; i < 6; i++) {
            String[] arrRowItems = lines[i].split(" ");
            
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
		}
		
		int maxSum = Integer.MIN_VALUE;
		for (int i=0;i< arr.length-2; i++) {
			for (int j=0;j< arr[i].length-2; j++) {
				int sum = 0;
				for (int k=0; k<3;k++) {					
					sum += arr[i][j+k];
					sum += arr[i+2][j+k];					
				}	
				sum += arr[i+1][j+1];
				
				System.out.println(sum);
				if (sum > maxSum) {
					maxSum= sum;
				}
			}
		}
		
		System.out.println(maxSum);
	}
	
	
	@Test
	public void testNegativeSubArrays() {
		//Scanner scanner = new Scanner(System.in);
		//Integer n = scanner.nextInt();	
		//int[] arr = new int[n];
		//for (int i=0; i< n;i++) {
		//	arr[i] = scanner.nextInt();
		//}
		int n = 5;
		int[] arr = {1,-2,4,-5,1};
		int count =0;
		for (int k=1; k <= n; k++) {	
			//System.out.println("===== " + k +" =====");
			for (int i=0;i<n;i++) {
				int sum = 0;			
				if (i+ k - 1 < n) {
					for (int j=i; j< i + k; j++) {
						sum+=arr[j];
					}
					//System.out.println(sum);
					if (sum <0) {
						count++;
					}
				}
				
			}
		}
		
		System.out.println(count);
		
	}
	
	@Test
	public void testListInsertDelete() {
		/*Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		int q = scanner.nextInt();
		for (int i = 0; i < q; i++) {
			String op = scanner.next();
			if (op.equalsIgnoreCase("Insert")) {
				int index = scanner.nextInt();
				int value = scanner.nextInt();
				list.add(index, value);
			} else if (op.equalsIgnoreCase("Delete")) {
				int index = scanner.nextInt();
				list.remove(index);
			}
		
		}
		
		for (int i=0;i<list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		
	}
	
	@Test
	public void testBitSet() {
		String input = "5 4\n" + 
				"AND 1 2\n" + 
				"SET 1 4\n" + 
				"FLIP 2 2\n" + 
				"OR 2 1";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		
		Scanner scanner = new Scanner(is);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		BitSet b1 = new BitSet(n);
		BitSet b2 = new BitSet(n);
		for (int i = 0;i<m; i++) {
			String op = scanner.next();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			if (op.equals("AND")) {
				if (a==1) {
					b1.and(b2);
				} else {
					b2.and(b1);
				}								
				
			}
			if (op.equals("OR")) {
				if (a==1) {
					b1.or(b2);
				} else {
					b2.or(b1);
				}
			}
			
			if (op.equals("XOR")) {
				if (a==1) {
					b1.xor(b2);
				} else {
					b2.xor(b1);
				}
			}
			
			if (op.equals("SET")) {
				if (a==1) {
					b1.set(b, true);
				} else {
					b2.set(b, true);
				}	
			}
			
			if (op.equals("FLIP")) {
				if (a==1) {
					b1.flip(b);
				} else {
					b2.flip(b);
				}	
			}
			
			
			System.out.println(b1.cardinality()+" "+b2.cardinality());
		}
		
	}
	
	
	@Test
	public void test1DArray() {
		String input = "4\n" + 
				"5 3\n" + 
				"0 0 0 0 0\n" + 
				"6 5\n" + 
				"0 0 0 1 1 1\n" + 
				"6 3\n" + 
				"0 0 1 1 1 0\n" + 
				"3 1\n" + 
				"0 1 0";
		
		InputStream is = new ByteArrayInputStream(input.getBytes());
		
		Scanner scanner = new Scanner(is);
		
		int q = scanner.nextInt();
		
		for (int i=0; i<q; i++) {
			int n = scanner.nextInt();
			int leap = scanner.nextInt();
			int[] game = new int[n];
			for (int j=0;j< n; j++) {
				game[j] = scanner.nextInt();				
			}
			int index = 0;
			
			while(index < n) {
				game[index] = 1;
				if (index == n-1 || index+leap >= n) {
					System.out.println("YES");
					break;
				} else if (game[index+leap] ==  0) {
					index+=leap;					
				} else if (game[index+1] == 0 ) {
					index++;
				} else if (index >0 && game[index - 1] == 0 ) {
					index--;
				} else {
					System.out.println("NO");
					break;
				}
				
				
			}
			
		}
		
	}
	
	@Test
	public void testStackBalanced() {
		String input = "({}[])\n" + 
				"(({()})))\n" + 
				"({(){}()})()({(){}()})(){()}\n" + 
				"{}()))(()()({}}{}\n" + 
				"}}}}\n" + 
				"))))\n" +
				"{{{\n" + 
				"(((\n" + 
				"[]{}(){()}((())){{{}}}{()()}{{}{}}\n" + 
				"[[]][][]\n" + 
				"}{";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		
		Scanner scanner = new Scanner(is);
		while (scanner.hasNext()) {
			String line = scanner.next();
			//System.out.println("<"+line+">");
			Stack<Character> stack = new Stack<>();
			boolean isFalsed = false;
			for (int i=0;i< line.length(); i++) {
				Character ch = line.charAt(i);
				if (ch == '{' || ch == '(' || ch=='[') {
					stack.push(ch);
					continue;
				} 
				
				if (stack.isEmpty()) {
					isFalsed = true;
					break;
				}
				Character sch = stack.pop();
				if ( ch == '}' && sch != '{'){
					isFalsed = true;
					break;
				}
				if ( ch == ')' && sch != '('){
					isFalsed = true;
					break;
				}
				if ( ch == ']' && sch != '['){
					isFalsed = true;
					break;
				}								
			}
			if (stack.isEmpty() && !isFalsed) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}
		
		
	}
	
	@Test
	public void testDequeMaxUnique	() {
		String input = "3 3\n" + 
				"1 2 3";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		Deque<Integer> deque = new ArrayDeque<>();
		Set<Integer> set = new HashSet<>();
		
		Scanner in = new Scanner(is);
		int n = in.nextInt();
        int m = in.nextInt();

        int max =0;
        
        int i=0;
        while (i<m) {
        	int num = in.nextInt();
        	deque.add(num);
        	set.add(num);
        	i++;
        }
        
        max = set.size();
        
        while(i<n) {
        	if (set.size() > max) {
        		max = set.size();
        	}
        	
        	int num = in.nextInt();
        	
        	Integer first = deque.pop();
        	deque.add(num);
        	set.add(num);
        	
        	if (!deque.contains(first)){
        		set.remove(first);
        	}
        	i++;
        }
              
        System.out.println(max);
	}
	
	class Student {
		  private Integer id;
		  private String name;
		  private Double cgpa;
		  public Student(int id, String name, double cgpa){
		    this.id = id;
		    this.name = name;
		    this.cgpa = cgpa;
		  }

		  public Integer getId(){
		    return id;
		  }

		  public String getName(){
		    return name;
		  }

		  public Double getCgpa(){
		    return cgpa;
		  }

		}

		class Priorities {
		  
		  public List<Student> getStudents(List<String> events){
		    
			
		  
			PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
		    	@Override
		    	public int compare(Student s1, Student s2) {
		    		int cgpaCom = s2.getCgpa().compareTo(s1.getCgpa());
		    		if (cgpaCom != 0) {
		    			return cgpaCom;
		    		} else {
		    			int nameComp = s1.getName().compareTo(s2.getName());
		    			if (nameComp!=0) {
		    				return nameComp;
		    			} else {
		    				return s1.getId().compareTo(s2.getId());		    				
		    			}
		    		}
		    		
		    	}
		    	
			});
		    for (String event : events) {
				String[] tokens = event.split(" ");
				if (tokens[0].equals("ENTER")) {
					int id = Integer.parseInt(tokens[3]);
					String name = tokens[1];
					double cgpa = Double.parseDouble(tokens[2]);
					
					queue.offer(new Student(id,name, cgpa));					
					
				} if (tokens[0].equals("SERVED")) {
					queue.poll();					
				}
			}
		    
		    List<Student> students = new ArrayList<>();
		    while (!queue.isEmpty()) {
		    	students.add(queue.poll());
		    }
		    
		    return students;
		  }
		  
		

		}

		
		
		public void testPriorityQueue() {
			String input = "12\n" + 
					"ENTER John 3.75 50\n" + 
					"ENTER Mark 3.8 24\n" + 
					"ENTER Shafaet 3.7 35\n" + 
					"SERVED\n" + 
					"SERVED\n" + 
					"ENTER Samiha 3.85 36\n" + 
					"SERVED\n" + 
					"ENTER Ashley 3.9 42\n" + 
					"ENTER Maria 3.6 46\n" + 
					"ENTER Anik 3.95 49\n" + 
					"ENTER Dan 3.95 50\n" + 
					"SERVED";
			InputStream is = new ByteArrayInputStream(input.getBytes());
			
			Scanner scan = new Scanner(is);
			
			int totalEvents = Integer.parseInt(scan.nextLine());    
	        List<String> events = new ArrayList<>();
	        
	        while (totalEvents-- != 0) {
	            String event = scan.nextLine();
	            events.add(event);
	        }
	        
	        Priorities priorities = new Priorities();
	        
	        List<Student> students = priorities.getStudents(events);
	        
	        if (students.isEmpty()) {
	            System.out.println("EMPTY");
	        } else {
	            for (Student st: students) {
	                System.out.println(st.getName());
	            }
	        }
		}
	
}
