package si.plapt.challenges.codesignals.core;

public class Corner {

	public static void main(String[] args) {
		Corner app = new Corner();
		
		/*System.out.println(app.killKthBit(37, 3));*/
		
		int a[] = {24, 85, 0};
		
		/*System.out.println(app.arrayPacking(a));*/
		
		/*System.out.println(app.rangeBitCount(2, 7));*/
		
		
		
		/*System.out.println(app.mirrorBits2(97));*/
		
	/*	System.out.println(app.secondRightmostZeroBit(37));*/
		
	/*	System.out.println(app.swapAdjacentBits(13));*/
		
		/*System.out.println(app.differentRightmostBit(7,23));*/
		
		System.out.println(app.equalPairOfBits(1073741824,1006895103));


	}
	
	int killKthBit(int n, int k) {
		 return ( (n & (1 << (k -1))) == n)? n : n & ~(1 << (k -1));
	}

	
	int arrayPacking(int[] a) {
		int M = a[a.length-1];
		for (int i= a.length-2; i>=0; i--) {
			M = (M << 8) | a[i];
		}
		
		return M;
	}
	
	int rangeBitCount(int a, int b) {
		int count =0;
		for(int i=a; i <=b; i++) {
			String s = Integer.toBinaryString(i);
			count += s.replaceAll("0", "").length();
		}
		
		return count;
	}

	int mirrorBits(int a) {
		String s = Integer.toBinaryString(a);
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		return Integer.valueOf(s, 2);
	}
	
	int mirrorBits2(int a) {
		int b = 0;
		while (a!=0) {
			b <<= 1;
			b |= (a & 1);
			a >>= 1;
		}
		return b;
	}

	int secondRightmostZeroBit(int n) {
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n+1));
		System.out.println(Integer.toBinaryString((n | n+1)));
		
		System.out.println(Integer.toBinaryString(~(n | n+1)));
		
		System.out.println(Integer.toBinaryString(-~(n | n+1)));
		
		System.out.println(Integer.toBinaryString(~(n | n+1) & -~(n | n+1)));
		
		
		return 0;
	}
	
	int swapAdjacentBits(int n) {
		System.out.println(Integer.toBinaryString(n));
		
		System.out.println(Integer.toBinaryString((n << 1) & 0xAAAAAAAA));
		System.out.println(Integer.toBinaryString((n >> 1) & 0x55555555));
		
		
		
		return ((n << 1) & 0xAAAAAAAA) | ((n >> 1) & 0x55555555);
	}
	
	
	int differentRightmostBit(int n, int m) {
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(n ^ m));
		System.out.println(Integer.toBinaryString(~(n ^ m)+1));
		System.out.println(Integer.toBinaryString((n ^ m) & ~(n ^ m)+1));
		
		return (n ^ m) & ~(n ^ m)+1;
	}

	int equalPairOfBits(int n, int m) {
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(~(n ^ m)));
		System.out.println(Integer.toBinaryString(~(n ^ m) & (n ^ m)+1));
		
		return ~(n ^ m) & (n ^ m)+1;
	}

}
