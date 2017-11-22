
#include <stdio.h>

void print_all_coins_combination(int target, int* multiply,int k, int len,int*output);
void printCombination(int *coins, int *counts, int startIndex, int totalAmount, int len);
int minCoins(int coins[], int m, int V);

int main () {

	int a[3];
	a[1] = 2;
	a[2] = 3;
	a[0] = 5;
	int b[10];

	//print_all_coins_combination(13, a, 0, 3,b);
	
	printf("\n\n\n---------------------\n\n");

	printCombination(a, b, 0, 17, 3);

	int d = minCoins(a, 3, 17);

	printf("%d\n", d);
}


void print_all_coins_combination(int target, int* multiply,int k, int len,int*output)
{
    if(target==0 && k==len){
        for(int i=0;i<len;i++){
            printf("%d : %d\t",multiply[i],output[i]);
        }
        printf("\n");
        return;
    }
    if(target<0 ||k>len) return;
    if(target>0 && k<len){
        int tmp = multiply[k];
        int bound = target/tmp+1;
        //printf("bound %d ", bound);
        for(int i=0;i<bound;i++){
            output[k]=i;
            //printf("loop: output[k] = %d. k= %d, i = %d\n", output[k], k, i);
            print_all_coins_combination(target-i*tmp,multiply,k+1,len,output);
        }
    }
}

// coins are the sorted coins the descending 
// counts record the number of coins at certain location
// start index is to keep tracking of from which coin we start processing after choosing one larger coin amount
// total amount keep track of remaining amount of left processing

void printCombination(int *coins, int *counts, int startIndex, int totalAmount, int len){
	// first decide if we should process or not by track startIndex 
	if (startIndex >= len) {
		// we have processed all the coins 
		// format the print out as "amount=?* 25 + ? * 10+..."
		int i;
		// printf("%d = \n", totalAmount);
		for (i = 0; i< len; i++) {
			printf("%d : %d\t",coins[i],counts[i]);
		}
		printf("\n");
		return;
 	}

 	//otherwise we need to proceed
 	// but notice if startIndex is the last one, we need to check if it can be divided by the smallest coin
 	// if so, this is good combination, otherwise this is not possible combination thus discard
 	if (startIndex == len-1)
 	{
 		

 		if (totalAmount % coins[startIndex] == 0) {
 			// set the counts of coins at start index
 			counts[startIndex] = totalAmount/ coins[startIndex];
 			// proceed to recursive call 
 			printCombination(coins, counts, startIndex+1, 0, len);
 		}
 	}
 	else {
 		// we still have the option to choose 0-N larger coins 
 		int i;
 		for (i = 0; i<=totalAmount/coins[startIndex]; i++) 
 		{
 			//for every cycle in a loop, we choose an arbitrary number of coins and proceed next 
 			counts[startIndex] = i;
            int rest = totalAmount-coins[startIndex] * i;
 			printCombination(coins, counts, startIndex+1, rest, len);
 			// notice we need to update the remaining amount

 		}
 	}
}


// m is size of coins array (number of different coins)
int minCoins(int coins[], int m, int V)
{
    // table[i] will be storing the minimum number of coins
    // required for i value.  So table[V] will have result
    int table[V+1];
 
    // Base case (If given value V is 0)
    table[0] = 0;
 	int INT_MAX = 1000000000;
    // Initialize all table values as Infinite
    for (int i=1; i<=V; i++)
        table[i] = INT_MAX;
 
    // Compute minimum coins required for all
    // values from 1 to V
    for (int i=1; i<=V; i++)
    {
        // Go through all coins smaller than i
        for (int j=0; j<m; j++)
          if (coins[j] <= i)
          {
              int sub_res = table[i-coins[j]];

              if (sub_res != INT_MAX && sub_res + 1 < table[i])
                  table[i] = sub_res + 1;
          }
    }
    return table[V];
}
