class Solution {
    	
    int ROWS, COLS;

	public int numEnclaves(int[][] grid) {
		ROWS = grid.length;
		COLS = grid[0].length;
        
		int count = 0;
		
        for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				// if we find 1 on the boundary of the matrix, we will do dfs
				if ((i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1) && grid[i][j] == 1) {
					dfs(grid, i, j);
				}
			}
		}

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				// if we still have 1 remaining inside of the matrix, it means that we cannot
				// walk off the boundary of the grid
				// from those cells, so we will coun them
				if (grid[i][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}

    
	private void dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= ROWS || j >= COLS || grid[i][j] == 0) {
			return;
		}

		grid[i][j] = 0;
		
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);

	}

}