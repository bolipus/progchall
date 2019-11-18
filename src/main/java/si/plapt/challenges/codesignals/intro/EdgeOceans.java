package si.plapt.challenges.codesignals.intro;

public class EdgeOceans {

	public static void main(String[] args) {
		
		  int[] sequence = { 10, 1, 2, 3, 4, 5 };
		  
		  EdgeOceans app = new EdgeOceans();
		 
		  System.out.println((app.almostIncreasingSequence(sequence)));
		  
		  int[][] matrix = { { 0, 1, 1, 2 }, { 0, 5, 0, 0 }, { 2, 0, 3, 3 } };

		  System.out.println(app.matrixElementsSum(matrix));
		  	
	}
	
	boolean almostIncreasingSequence(int[] sequence) {

		int size = sequence.length;

		int numOfDesc = 0;
		for (int i = 0, j = 1; i < size - 1;) {

			if (sequence[i] >= sequence[j]) {
				numOfDesc++;

				if (i > 0 && sequence[i - 1] >= sequence[j]) {
					numOfDesc++;

					if (j < size - 1 && sequence[i] >= sequence[j + 1]) {
						numOfDesc++;
					} else {
						numOfDesc--;
					}
				}

				if (numOfDesc > 1) {
					return false;
				}

			}
			i++;
			j++;

		}

		return true;
	}

	int matrixElementsSum(int[][] matrix) {
		int sum = 0;

		int rows = matrix.length;
		int columns = matrix[0].length;

		System.out.println(rows);
		System.out.println(columns);

		for (int j = 0; j < columns; j++) {
			boolean isFreeAbove = false;

			for (int i = 0; i < rows; i++) {
				if (matrix[i][j] == 0) {
					isFreeAbove = true;
				} else if (matrix[i][j] > 0 && !isFreeAbove) {
					isFreeAbove = false;
					sum += matrix[i][j];
				}

			}
		}

		return sum;

	}

}
