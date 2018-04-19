
#include "stdio.h"
#include "stdlib.h"



size_t trimwhitespace(char *out, size_t len, const char *str) {
	
  //clean up the spaces in front of the words
  int i, start = -1, end = -1, lenOut = 0;
  
  //"   hi   " len = 8
  //start = 3 
  for (i = 0; i < len; i++) {
  	if (str[i] != ' ') {
    	start = i;
      break;
    }
  }
  
  if (start == -1) {
  	out = "";
    return 0;
  }
  
  //iterate backwards to check for the ending character
  // i = 7 to 0 
  for (i = len-1; i >= 0; i--) {
  	if (str[i] != ' ') {
    	// i = 4
    	end = i;
      break;
    }
  }


  // append each character to out from the starting character till the end
  // out = "hi   " 
  for (i = start; i <= end; i++) {	
    *(out + (i-start)) = str[i];
  }
  

  
  //start = 3, end = 4
  
  lenOut = end - start + 1;
  *(out + lenOut) = '\0';
  
  return lenOut;

}

// optimized version. Reduce the time complexity by half
size_t trimWord_optimized(char *out, size_t len, const char* str) {


	int start = -1, end = -1, outLen = 0; 
	int startPointer = 0, endPointer = len -1;
	int i;
	// get the starting and ending point of the string, O(n/2)
	while (startPointer < endPointer && (start == -1 && end == -1)) {

		if (str[startPointer] != ' ') {
			start = startPointer;
		}

		if (str[endPointer] != ' ') {
			end = endPointer;
		}
		startPointer++;
		endPointer--;
	}

	// store the characters from start till end pointers into a memory
	for (i = start; i <= end; i++) {
		*(out + (i-start)) = str[i];
	}

	outLen = end - start + 1;
	*(out + outLen) = '\0';

	return outLen;

}


int main() {

	char *out = (char *) malloc(100 * sizeof(char));
	char *str = "   hi   ";
	//char *str = "    ";
	trimwhitespace(out, 8, str);
	// trimwhitespace(out, 4, str);
	printf("%s\n", out);
	return 0;
}


