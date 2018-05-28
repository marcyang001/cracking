

#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "ctype.h"
char *solution(char *S, int K) {
    
    int n = strlen(S);
    int i;
    int i2;
    int totalChars = 0;
    int numDashes;

    // only count the needed characters, a-z, A-Z, 0-9
    for (i = 0; i < n; i++) {
        if (S[i] != '-') {
            totalChars += 1;
        }
    }
    // n/K groups needed, 
    numDashes = n/K;

    // e.g 8/(K = 3)  ==> 2 dashes 
    // 8 / (K = 2) ==> 1 dash only 
    if (n % 2 == 0) {
        numDashes = numDashes -1;
    }

    // if the word is shorter than the break points, no dash needed at all
    if (n <= K) {
    	numDashes = 0;
    }
    
    // create a returned memory
    char *resultChar = (char *) malloc (sizeof(char) * (totalChars + numDashes));

    // the end of input word 
    i = n -1;
    // the end of returned memory 
    i2 = totalChars + numDashes - 1;

    int count = K;
    while (i >= 0) {

    	if (S[i] != '-') {

    		if (count > 0) {
    			if (S[i] >= 'a' && S[i] <= 'z') {
    				*(resultChar + i2) = toupper(S[i]);
    			}
    			else if (S[i] >= 'A' && S[i] <= 'Z') {
    				*(resultChar + i2) = S[i];
    				
    			}
    			else if (S[i] >= '0' && S[i] <= '9') {
    				*(resultChar + i2) = S[i];
    			}

    			i2--;
    			i--;
    			count--;
    		}
    		else {
    			*(resultChar + i2) = '-';
    			count = K;
    			i2--;
    		}
    	}
    	else {
    		// skip the character
    		i--;
    	}
    }
    *(resultChar + totalChars + numDashes) = '\0';

    return resultChar;
}

int main() {

	char *s1 = solution("2-4A0r7-4k", 4);
	char *s2 = solution("2-4A0r7-4k", 3);
	char *s3 = solution("r", 1);
	printf("%s\n", s1);
	printf("%s\n", s2);
	printf("%s\n", s3);
	return 0;
}