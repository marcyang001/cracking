
public class Pointer_Problems {


	public static void main(String[] args) {

		//printTriangle(3);

		int[] arr = {1,0,1,0,0,1};
		sortBinaryArray(arr);

		for (int i : arr) {
			System.out.println(i);
		}

	}

	/*
	 n = 3
	    #
	   ##
      ###

	*/

	public static void printTriangle(int n) {

		for (int i = 0; i < n; i++) {
			String line = "";
			// add correct spaces at each line
			for (int j = i; j < n-1; j++) {
				line += " ";
			}

			for(int k = 0; k <=i; k++) {
				line += "#";
			}

			System.out.println(line);
		}
	}

	/*
	  
	  input: {1,0,1,0,0,1}
	  output: {0,0,0,1,1,1 } ==> sorted array
	  	  
	*/

	public static void sortBinaryArray(int[] arr) {

		int n = arr.length;

		int ptr0 = 0;
		int ptr1 = n-1;

		while (ptr0 < ptr1) {

			// if 1 is before 0, swap the elements 
			// trim it 
			if (arr[ptr0] == 1 && arr[ptr1] == 0) {
				int temp = arr[ptr0];
				arr[ptr0] = arr[ptr1];
				arr[ptr1] = temp;
				ptr0++;
				ptr1--;
			}
			// if there is 1 in the front, decrement ptr1 and look for possible swap
			else if (arr[ptr0] == 1 && arr[ptr1] == 1) {
				ptr1--;
			}
			// if there is 0 in the back, increment ptr0 and look for possible swap
			else if (arr[ptr0] == 0 && arr[ptr1] == 0) {
				ptr0++;
			}
			else {
				// if 0 is in front and 1 is the back, then trim it, nothing to swap
				ptr1--;
				ptr0++;
			}
		}
	}




}