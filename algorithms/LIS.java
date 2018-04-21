
/*
Longest Common subsequence (LIS): 

	Dynamic programming. Using the optimal substructure. 
	The LIS of size n is equal to the optimal substructure of LIS of size n-1 
	
	E.g array of size 9 = 
			1 + LIS of size 8 if array[8] > array[7]
			otherwise: LIS of size 8
	
	We can use both top-down (memorization) and bottom-up (tabulation) approaches

	Input  : arr[] = {3, 10, 2, 1, 20}
	Output : Length of LIS = 3


	Input  : arr[] = {3, 2}
	Output : Length of LIS = 1
	

	Input : arr[] = {50, 3, 10, 7, 40, 80}
	Output : Length of LIS = 4

	Input: {10, 22, 9, 33, 21, 50, 41, 60, 80}
	Output : Length of LIS = 6

*/

public class LIS {


	public static void initialize_Array(int[] lookup, int value) {
		/////////////////////////////////////////////////////////////////
		/* 
			Using loop unrolling to initialize array. 
			reduce the run time by a factor of 4

		*/

		int i = 0;
		int size = lookup.length;
		int repeat = size/4;


		while (repeat > 0) {
			lookup[i] = value;
			if (i + 1 < size) {
				lookup[i + 1] = value;
			}
			if (i + 2 < size) {
				lookup[i + 2] = value;
			}
			if (i + 3 < size) {
				lookup[i + 3] = value;
			}
			i += 4;
			repeat--;
		}

		switch (size % 4) {
			case 3: lookup[i+2] = value;
			case 2: lookup[i+1] = value;
			case 1: lookup[i] = value;
		}
/////////////////////////////////////////////////////////////////
	}

	private static int L(int[] A, int i, int[] lookup) {

		if (lookup[i] == -1) {

			if (i == 0) {
				lookup[i] = 1;
				return lookup[i];
			}

			else {
				if (A[i] > A[i-1]) {
					lookup[i] = 1 + L(A, i-1, lookup);
				}
				else {
					lookup[i] = L(A, i-1, lookup);
				}
				return lookup[i];
			}
		}
		
		return lookup[i];
	}

	public static int LIS_Memorization(int[] A) {

		int size = A.length;
		int resMax = 0;
		int i;
		int[] lookup = new int[size];
		
		initialize_Array(lookup, -1);

		for (i = 0; i < size; i++) {
			resMax = Math.max(resMax, L(A, i, lookup));
		}
		return resMax;

	}



	public static int LIS_tabulation(int[] A) {

		int size = A.length;
		if (size == 0) return 0;

		int i, j, max = 0;
		int[] lis = new int[size];

		initialize_Array(lis, 1);

		for (i = 1; i < size; i++) {
			for (j = 0; j < i; j++) {

				if (A[i] > A[j]) {
					lis[i] = 1 + lis[j];
				}
				else {
					lis[i] = lis[j];
				}
			}

		}
		
		return lis[size-1];
	}



	public static void main(String[] args) {

		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		// int[] arr = {};
		System.out.println(LIS_Memorization(arr));

		System.out.println(LIS_tabulation(arr));

	}

}






