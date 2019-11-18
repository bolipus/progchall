package si.plapt.challenges.codesignals.core;

public class LoopTunnel {

	public static void main(String[] args) {
		LoopTunnel app = new LoopTunnel();

		/* System.out.println(app.countSumOfTwoRepresentations2(93, 24, 58)); */

		/* System.out.println(app.lineUp("AALAAALARAR")); */

		/* System.out.println(app.additionWithoutCarrying(456, 1734)); */
		// System.out.println(app.appleBoxes(5));
		/*
		 * System.out.println(app.increaseNumberRoundness(902200100));
		 * 
		 * System.out.println(app.increaseNumberRoundness(11000));
		 * System.out.println(app.increaseNumberRoundness(106611));
		 */

		/*System.out.println(app.rounders(1234));*/
		
		System.out.println(app.candles(39, 8));
		
		
		/*System.out.println(app.countBlackCells(3, 4));*/

	}

	int countSumOfTwoRepresentations2(int n, int l, int r) {

		int count = 0;
		int q = n - l;
		for (int i = l; i <= r && i <= q; i++) {
			q = n - i;
			if (q <= r) {
				count++;
			}
		}

		if (n % 2 == 0)
			return count;
		else
			return count - 1;

	}

	int lineUp(String commands) {
		int count = 0;
		String command = "";
		boolean inLine = true;
		for (int i = 0; i < commands.length(); i++) {
			command += commands.charAt(i);
			if (command.equals("A") && inLine) {
				command = "";
				count++;
				inLine = true;
			} else if (command.equals("LL")) {
				command = "";
				count++;
				inLine = true;
			} else if (command.equals("RR")) {
				command = "";
				count++;
				inLine = true;
			} else if (command.equals("LR")) {
				command = "";
				count++;
				inLine = true;
			} else if (command.equals("RL")) {
				command = "";
				count++;
				inLine = true;
			} else if (command.equals("L") && !inLine) {
				command = "";
				count++;
				inLine = true;
			} else if (command.equals("R") && !inLine) {
				command = "";
				count++;
				inLine = true;
			} else {
				command = "";
				inLine = false;
			}
			;
		}

		return count;
	}

	int additionWithoutCarrying(int param1, int param2) {
		int sum = 0;
		int k = 1;
		while (param1 > 0 || param2 > 0) {

			int a = param1 % 10;
			int b = param2 % 10;
			param1 /= 10;
			param2 /= 10;
			int val = (a + b) % 10;
			sum += val * k;
			k *= 10;
		}

		return sum;
	}

	int appleBoxes(int k) {
		int sumY = 0;
		int sumR = 0;
		for (int i = 1; i <= k; i++) {
			if (i % 2 == 1) {
				sumY += i * i;
			} else {
				sumR += i * i;
			}
		}
		return sumR - sumY;
	}

	boolean increaseNumberRoundness(int n) {
		while (n % 10 == 0) {
			n = n / 10;
		}

		while (n % 10 != 0) {
			n = n / 10;
		}

		if (n != 0) {
			return true;
		} else {
			return false;
		}

	}

	int rounders(int n) {
		int val = 1;
		int k =1;
		int b = 0;
		
		if (n <=10) {
			return 10;
		}
		
		while (n > 10) {
			int a = n % 10 + b;
			if (a < 5) {
				b = 0;
			} else {
				b = 1;
			}
			k *= 10;				
			n = n / 10;
		}
		val = k*(n % 10 + b);
		
		return val;
	}

	
	int candles(int candlesNumber, int makeNew) {
		int numBurned = 0;
		int numOfLeft = 0;
		do  {
			numBurned += candlesNumber;
			numOfLeft += candlesNumber;
			
			candlesNumber = numOfLeft / makeNew;
			numOfLeft = numOfLeft % makeNew;			
		} while(numOfLeft + candlesNumber >= makeNew);
		
		
		
		return numBurned + candlesNumber;
	}
	
	
	int countBlackCells(int n, int m) {
		int a = n;
		int b = m;
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;			
		}
		
		return m+n+ a -2; 

	}


}
