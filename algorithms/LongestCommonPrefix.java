
/*
Find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

	Input: ["flower","flow","flight"]
	Output: "fl"

Example 2:

	Input: ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.


Example 3:

	Input: ["dog","dogg","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.

*/



public class LongestCommonPrefix {


	public static String LongestCommonPrefix(String[] strs) {

		if (strs.length == 0 ) return "";
		String prefix = strs[0];
		int size = strs.length; 
		int prefixLength = prefix.length();
		for (int i = 1; i < size; i++) {

			// try to match the potential prefix, 
			// if the current prefix does not match, 
			// we deduce the last character of prefix and compare again
			// if the prefix is "", that means we have already compared 
			// with all the possible prefices, thus we return ""
			// once we found a common prefix between two words, we compare the next word.
			// LCP{1, 2} --> LCP{1, 3} --> LCP{1, 4} --> LCP{1, 5} --> ... --> LCP {1, n}
			while (strs[i].indexOf(prefix) != 0) {
				prefixLength--;
				prefix = prefix.substring(0, prefixLength);
				if (prefix.isEmpty()) return "";
			}
		}

		return prefix;
	}


	public static void main(String[] args) {

		String[] strs = {"flower","flow","flight"};

		System.out.println(LongestCommonPrefix(strs));


	}



}