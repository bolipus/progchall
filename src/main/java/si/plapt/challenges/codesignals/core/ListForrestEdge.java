package si.plapt.challenges.codesignals.core;

import java.util.Arrays;

public class ListForrestEdge {

	public static void main(String[] args) {
		ListForrestEdge app = new ListForrestEdge();

	/*	int[] inputArray = {2, 3, 2, 3, 4, 5};
		int[] outputArray = app.removeArrayPart(inputArray, 2, 4);
		
		for (int el : outputArray) {
			System.out.print(el+ "\t");
		}
		System.out.println();*/
		
		/*int[] inputArray = {7, 2, 2, 5, 10, 7};
		System.out.println(app.isSmooth(inputArray));*/
		
		int[] inputArray = {7, 2, 2, 5, 10, 7};
		int[] outputArray = app.replaceMiddle(inputArray);
			
		for (int el : outputArray) {
			System.out.print(el+ "\t");
		}
	}
	
	int[] removeArrayPart(int[] inputArray, int l, int r) {
	    int size = l + inputArray.length - r- 1 ;
	    int[] result = new int[size];
	    int k=0;
	    for(int i=0;i<inputArray.length; i++) {
	    	if (i < l || i > r) {
	    		result[k++] = inputArray[i];
	    	}
	    }
	    return result;
	}
	
	boolean isSmooth(int[] arr) {
		int size = arr.length;
		if (size % 2 == 1) {
			int middle = arr[size /2];		
			return (arr[0] == middle) && (middle == arr[size-1]);
		} else {
			int middle = arr[size/2 -1] + arr[size /2];		
			return (arr[0] == middle) && (middle == arr[size-1]);
		}
		
	}

	int[] replaceMiddle(int[] arr) {
		int size = arr.length;
		if (size % 2 == 1) {
			return arr;
		} else {	
			int middle = arr[size/2 -1] + arr[size /2];		
			arr[size/2 -1] = middle;
			for (int i=size /2; i < size-1; i++) {
				arr[i] = arr[i+1];
			}
			return Arrays.copyOf(arr, size-1);
		}
	}



}
