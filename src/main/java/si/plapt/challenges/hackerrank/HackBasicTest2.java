package si.plapt.challenges.hackerrank;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;



public class HackBasicTest2 {
	
	@Test
	public void testMD5() throws NoSuchAlgorithmException {
		String input = "HelloWorld";
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(input.getBytes());
		
		System.out.println(DatatypeConverter.printHexBinary(digest).toLowerCase());
		
	}
	
	class Prime {
		public void checkPrime(int... a) {
			for (int x : a) {
				if (BigInteger.valueOf(x).isProbablePrime(1)) {
					System.out.print(x + " ");
				}				
			}
			System.out.println();
			
		}
	}
	
	
	@Test
	public void testPrimeNumber() {
		try{
			String input = "2\n" + 
					"1\n" + 
					"3\n" + 
					"4\n" + 
					"5";
			InputStream is = new ByteArrayInputStream(input.getBytes());
			
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			Prime ob=new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1,n2);
			ob.checkPrime(n1,n2,n3);
			ob.checkPrime(n1,n2,n3,n4,n5);	
			Method[] methods=Prime.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			for(int i=0;i<methods.length;i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload=true;
					break;
				}
				set.add(methods[i].getName());
				
			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	
		int gcd(int a, int b) {
			if (a == 0) {
				return b;
			} else {
				return gcd(b % a, a);
			}
		}
		
		int lcm(int a, int b) {
			if (a == 0 || b==0) {
				return 0;
			} 
			return a*b/gcd(a,b);
		}
		
		int gcdAll(int[] x) {
			int result = x[0];
			for (int i=1; i<x.length; i++) {
				result = gcd(result, x[i]);
				
				if (result == 1) {
					return 1;
				}
			}
			return result;
		}
		
		int lcmAll(int[] x) {
			int result = x[0];
			for (int i=1; i<x.length; i++) {
				result = lcm(result, x[i]);			
			}
			
			return result;
			
		}
		
		@Test
		public void testBetweenTwoSets() {
			int[] a = {2, 4};
			int[] b = {16,32,96};
			int x = lcmAll(a);
			int y = gcdAll(b);
			System.out.println(x);
			System.out.println(y);
			
			int i = x;
			int j = 2;
			int count =0;
			while (i<=y) {
				if (y % i ==0) {
					count++;
				}				
				i=j*x;
				j++;
			}
			
			System.out.println(count);
			
		}

}
