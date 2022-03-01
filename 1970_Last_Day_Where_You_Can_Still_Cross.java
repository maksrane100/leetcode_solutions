///////////////////////////////////////////
//Leetcode 1970 Last Day Where You Can Still Cross - Hard Problem
///////////////////////////////////////////

class Solution {
    
	int[] dir = new int[] { 0, 1, 0, -1, 0 };

	public int latestDayToCross(int row, int col, int[][] cells) {
		// Since in this we are having a range that
		// Last day could be in between 1 to cells.length
		// we will use binary search in addition with bfs
		// In bfs we will store the indexes
		// And since everything is 1 based subtract -1 from indexes
		
		int left = 1;
		
		int right = cells.length;
		
		int days = 0;
		
		//using binary search. 
		//1) when we know that we can cross at some day,  the last crossing day would  be  in the right half.
		//2) when we know that we can not cross at some day,  the last crossing day would  be  in the left half.
		
		//we will use BFS  to determine if we can do the crossing
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			System.out.println("left : "+left+ " right : "+right+ " mid : "+mid);
			
			//this is  the 1st case
			if (topToBottomWalkPossible(cells, row, col, mid)) {
				days = mid;
				left = mid + 1;
			} else {  //this is the second case
				right = mid - 1;
			}
		}
		return days;

	}

	public boolean topToBottomWalkPossible(int[][] cells, int row, int col, int dayAt) {
		int[][] grid = new int[row][col];

		//we will first create the grid how it looks like on that day.
		for (int i = 0; i < dayAt; i++) {
			grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		for (int c = 0; c < col; c++) {
			//row should be always zero and the cell value should be zero (that's when we can start from that cell to cross).
			//we will add those cells into the queue as starting point for the BFS.
			
			
			//once we add that cell into  the queue, we will change it's value to 1 (to avoid re - processing)
			if (grid[0][c] == 0) {
				queue.offer(new int[] { 0, c });
				grid[0][c] = 1;
			}
		}

		while (!queue.isEmpty()) {
			
			int current[] = queue.poll();
			
			int new_row = current[0];
			int new_col = current[1];
			
			//checking do we reach the last row
			if (new_row == row - 1)
				return true;
			
			//doing the BFS in 4 directions
			
			for (int i = 0; i < 4; i++) {
				int x = new_row + dir[i], y = new_col + dir[i + 1];
				
				if (x < 0 || x == row || y < 0 || y == col || grid[x][y] == 1)
					continue;

				grid[x][y] = 1;
				
				queue.offer(new int[] { x, y });
			}

		}
		return false;
	}
}