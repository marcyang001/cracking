

import java.util.*;

public class StringManipulate {

	/* 
 	   
 	   a word is a set of chars that terminates with either a space or a null pointer

	   word reversals:
	  
	   		helloworld  ---> dlrowolleh
	
	   word reversal in a sentence: 

	   		hello world ---> world hello 

	 */

	public static void reverseString (char[] word, int start, int end) {

		int j;
		int len = (end - start);
		int counter = 0;
		for (j = start; j<len/2 + start; j++) {

			char temp = word[end - 1 - counter];
			word[end - 1 - counter] = word[j];
			word[j] = temp;
			counter++;

		}
	}

	public static char[] reverseWordsInSentence(char[] word) {

		int i = 0, j;
		int n = word.length;
		int start = 0;
		int len; 
		while (i < n) {

			if (word[i] == ' ') {	
				reverseString (word, start, i);
				start = i + 1;
			}
			
			i++;
		}
		
		reverseString (word, start, i);

		return word;
	}

	public static String reverse(String s) {
		int n = s.length();
		if (n == 1) {
			return s;
		}

		return s.substring(n-1, n) + reverse(s.substring(0, n-1));
	} 


	public static void main(String[] args) {


		// char[] reversedChars = "hello world".toCharArray();
		// reverseString(reversedChars, 0, reversedChars.length);
		// String reversed = new String(reversedChars);

		// System.out.println(reversed);

		// String reverseWords = new String(reverseWordsInSentence(reversedChars));
		// System.out.println(reverseWords);

		System.out.println(reverse("hello"));


	}






}