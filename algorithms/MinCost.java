
/*

Given a N X N  matrix Matrix[N][N] of positive integers.  There are only three possible moves from a cell Matrix[r][c].

1. Matrix[r+1][c] (down)

2. Matrix[r][c+1] (right)

3. Matrix[r+1][c+1] (diagonal)

Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.

	{1, 2, 3},
	{4, 8, 2},
	{1, 5, 3}

	==> the path with minimal cost is {1, 2  2, 3 }
	===> return 8; 
	

	current state = current cost + MinState(move diagonal cost, move right cost, move down cost)
*/

import java.util.*;


public class MinCost {


	public static void main(String[] args) {

		int[][] matrix = {
			{1, 2, 3},
			{4, 8, 2},
			{1, 5, 3}
		};

		int m = matrix.length; 
		int n = matrix[0].length;

		System.out.println(minCostPathDp(matrix));

		System.out.println(minCostPath(matrix, m-1, n-1));


	}



	// Use Dynamic programming (tabulation) 

	public static int minCostPathDp(int[][] matrix) {

		int row = matrix.length;

		if (row == 0) return 0;

		int column = matrix[0].length;

		if (column == 0) return 0;


		int[][] dp = new int[row][column];

		

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {

				
				if (i == 0 && j == 0) {
					dp[0][0] = matrix[0][0];
				}
				else if (i == 0 && j > 0) {
					dp[i][j] = dp[i][j-1] + matrix[i][j];
				}
				else if (i > 0 && j == 0) {
					
					dp[i][j] = dp[i-1][j] + matrix[i][j];					

				}
				else {
					int moveDown = dp[i-1][j];
					int moveRight = dp[i][j-1];
					int moveDiagonal = dp[i-1][j-1]; 
					dp[i][j] = matrix[i][j] + Math.min(Math.min(moveDown, moveRight), Math.min(moveRight, moveDiagonal));
				}

			}
		}

		return dp[row-1][column-1]; 
	}


	static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    } 

	// Recursion
	public static int minCostPath(int[][] matrix, int m, int n) {

		if (m < 0 || n < 0) return Integer.MAX_VALUE;


		else if ( m == 0 && n == 0) {
			return matrix[m][n];
		}
		else {

			return matrix[m][n] + min(
				minCostPath(matrix, m-1, n), // move down
				minCostPath(matrix, m, n-1), // move right
				minCostPath(matrix, m-1, n-1)); // move diagonal
		}


	}




}

