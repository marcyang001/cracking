
import java.util.*;

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



	

	public static void main(String[] args) {
		// String s1 = "AGGTAB";
  //   	String s2 = "GXTXAYB";
 		

 		String s1 = "AEDFHR";
 		String s2 = "ABCDGH";

    	char[] X=s1.toCharArray();
    	char[] Y=s2.toCharArray();
    	int m = X.length;
    	int n = Y.length;
 		int[] lookup = new int[Math.min(m, n)+1];

 		initialize_Array(lookup, -1);



    	System.out.println("Length of LCS is" + " " + LCS_memorization(X, Y, m, n));
	}


}