
import java.util.*;

/*

Longest Common Subsequence 

Input: AEDFHR 
	   ABCDGH 

Output: ADH ==> 3

Input: AGGTAB
	   GXTXAYB

Output: GTAB ==> 4 



*/

public class LCS {

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

	public static int LCS_memorization(char[] word1, char[] word2, int m, int n) {

		if (m == 0 || n == 0)
      		return 0;
    	if (word1[m-1] == word2[n-1])
      		return 1 + LCS_memorization(word1, word2, m-1, n-1);
    	else
      		return Math.max(LCS_memorization(word1, word2, m, n-1), LCS_memorization(word1, word2, m-1, n));
	}


	public static int LCS_tabulation(char[] word1, char[] word2, int m, int n) {
		int L[][] = new int[m+1][n+1];


		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// fill the buffer with 0s 
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				}
				// common character between X and Y 
				else if (word1[i-1] == word2[j-1]) {
					L[i][j] = L[i-1][j-1] + 1;
				}
				else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}

		return L[m][n];
	}



	public static void main(String[] args) {
		// String s1 = "AGGTAB";
  //   	String s2 = "GXTXAYB";
 		

 		String s1 = "AEDFHR";
 		String s2 = "ABCDGH";

    	char[] X=s1.toCharArray();
    	char[] Y=s2.toCharArray();
    	int m = X.length;
    	int n = Y.length;



    	System.out.println("Length of LCS is" + " " + LCS_memorization(X, Y, m, n));
    	
    	System.out.println("Length of LCS is" + " " + LCS_tabulation(X, Y, m, n));
	}


}