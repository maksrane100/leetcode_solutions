package com.exercises.interview;

/**
 * 
 * Find cost to traverse from top left of the matrix to bottom right of the matrix.
 * This uses dynamic programming.
 *
 */
public class MinimumMatrixCost {

	public static int calculateMinimumCostUsingDP(int[][] matrix) {
		int ROWS = matrix.length;
		int COLS = matrix[0].length;

		int[][] DP = new int[ROWS][COLS];

		// bottom-up fashion
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				DP[i][j] = matrix[i][j];

				if (i == 0 && j > 0) {
					DP[0][j] += DP[0][j - 1];
				}

				else if (j == 0 && i > 0) {
					DP[i][0] += DP[i - 1][0];
				}

				else if (i > 0 && j > 0) {
					DP[i][j] += Integer.min(DP[i - 1][j], DP[i][j - 1]);
				}
			}
		}

		return DP[ROWS - 1][COLS - 1];
	}

	public static void main(String[] args) {
		int[][] arr = { 
				{ 2,   4,  6,   10,  8 }, 
				{ 1,   4,  14,  20,  2 }, 
				{ 2,   3,  16,  30,  3 }, 
				{ 8,   4,   4,  40,  4 },
				{ 12, 10,   6,   2,  5 },

		};

		System.out.print("Minimum cost is " + calculateMinimumCostUsingDP(arr));
	}

}
