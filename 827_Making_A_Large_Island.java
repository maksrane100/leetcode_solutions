///////////////////////////////////////////
//Leetcode 827 Making A Large Island - Hard Problem
///////////////////////////////////////////

class Solution {
    
	private Map<Integer, Integer> islandSizeMap;

	private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, };

	private int color_id;

	public int largestIsland(int[][] grid) {

		color_id = 2;

		int rows = grid.length;

		int cols = grid[0].length;

		islandSizeMap = new HashMap<>();

		int maxCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				//we will mark this cell as part of an island and then we will do DFS in 4
				//directions to check  what other cells are part of this island
				if (grid[i][j] == 1) {
					int size = markIslandDFS(grid, i, j, color_id);

					islandSizeMap.put(color_id, size);
					
					maxCount = Math.max(maxCount, size);

					color_id += 1;
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (grid[i][j] == 0) {
					maxCount = Math.max(maxCount, countIslands(grid, i, j) + 1);
				}
			}
		}

		return maxCount;
	}

	/*
	 * we will go in 4 directions for the current cell if it's 0. And check if the current cell is surrounded by islands.
	 * if it's surrounded by islands, then we will total sum of all the surrounded islands and add 1 to it (assuming that
	 * we are converting current 0 cell to 1). Then we will return the size of the so called merged island.
	 */
	private int countIslands(int[][] grid, int row, int col) {

		Set<Integer> visited = new HashSet<>();

		int count = 0;

		for (int[] dir : directions) {

			int x = row + dir[0];

			int y = col + dir[1];

			if (insideBoundary(grid, x, y) && grid[x][y] > 1 && visited.add(grid[x][y])) {
				count += islandSizeMap.get(grid[x][y]);
			}
		}

		return count;
	}

	//we will mark this cell as part of an island and then we will do DFS in 4
	//directions to check  what other cells are part of this island
	
	private int markIslandDFS(int[][] grid, int row, int col, int id) {

		if (!insideBoundary(grid, row, col) || grid[row][col] != 1) {
			return 0;
		}

		grid[row][col] = id;

		return 1 + markIslandDFS(grid, row + 1, col, id) + markIslandDFS(grid, row - 1, col, id)
				+ markIslandDFS(grid, row, col + 1, id) + markIslandDFS(grid, row, col - 1, id);
	}

	private boolean insideBoundary(int[][] grid, int row, int col) {
		
		return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
	
	}
}