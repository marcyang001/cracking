/*

	Dynamic programming: edit distance

	Calculate the minimum of operations required to 
	change from one word to another 

	The operations are insert, remove and replace 

	e.g 

	sunday --> saturday ===> minimum 3 operations required 
	saunday
	satunday
	saturday

	abaaba ---> bababaa === ??? 
 	bababaa
*/

public class EditDistance {


	public static void main(String[] args) {

		// String str1 = "sunday";
		// String str2 =  "saturday";
		String str1 = "abaaba";
		String str2 =  "bababaa";


		System.out.println(editDistance(str1,str2, str1.length(), str2.length()));

	}


	public static int editDistance(String str1, String str2, int m, int n) {


		if (m == 0) return n; 

		if (n == 0) return m;


		if (str1.charAt(m-1) == str2.charAt(n-1)) {
			return editDistance(str1.substring(0, m-1), str2.substring(0, n-1), m-1, n-1);
		}

		else {

			// the current characters are not equal 

			int insertOp = 1 + editDistance(str1.substring(0, m), str2.substring(0, n-1), m, n-1);
			int removeOp = 1 + editDistance(str1.substring(0, m-1), str2.substring(0, n), m-1, n);
			int replaceOp = 1+ editDistance(str1.substring(0, m-1), str2.substring(0, n-1), m-1, n-1);

			return Math.min(Math.min(insertOp, removeOp), Math.min(removeOp, replaceOp)); 

		}

	}

	// program the dp in tabulation 
	// store the results of the subproblems 
	


}



