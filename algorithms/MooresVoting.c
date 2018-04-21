
#include <stdio.h> 


int findCandidate(int *votes, int size) {

	int i;
	int majority = 0, count = 0; 

	for (i = 1; i < size; i++) {

		if (votes[majority] == votes[i]) {
			count++;
		}
		else {
			count--;
		}

		if (count == 0) {
			// reset the count and update the majority
			majority = i;
			count = 1;
		}
	}

	return votes[majority];
}



int isMajority(int votes[], int size, int cand) {

	int count = 0;
	for (int i = 0; i < size; i++) {
		if (votes[i] == cand)
			count++;
	}
	
	if (count > size/2)
		return 1;
	else
		return 0;

}




int main() {

	int size = 19;
	int votes[19]  = {1,1,2,1,2,2,3,3,3,3,3,4,2,2,2,2,2,2,2};
	int candidate = findCandidate(votes, size);
	if (isMajority(votes, size, candidate)) {
		printf("%d\n", candidate);	
	}
	else {
		printf("no majority candidate\n");
	}

	

	return 0;
}

