package dp;

public class Tabulation {

	
	public int getCoinNumbers(int sum, int coins[]) {
		
		int[] lookup = new int[sum+1];
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (sum == 0) {
			lookup[0] = 0; 
		}
		else {
			
			for (int index = 0; index < lookup.length; index++) {
				lookup[index] = 0;
			}
			
			for (int i = 1; i<= sum; i++) {
				int tempMin = Integer.MAX_VALUE;
				for (int j = 0; j < coins.length; j++) {
					if (i == coins[j]) {
						tempMin = 1;
						break;
					}
					else if (i > coins[j] && lookup[i-coins[j]] != 0) {
						tempMin = Math.min(tempMin, lookup[i-coins[j]] +1);
					}
				}
				if (tempMin < Integer.MAX_VALUE)
					lookup[i] = tempMin;
			}	
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		for (int n = 0; n < lookup.length; n++) {
			System.out.print(lookup[n] + " ");	
		}
		System.out.println();
		for (int n = 0; n < lookup.length; n++) {
			System.out.print(n + " ");	
		}
		System.out.println();
		
		
		return lookup[sum];
	}
	
	
}
