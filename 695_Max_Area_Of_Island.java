<<<<<<< HEAD
///////////////////////////////////////////
//695. Max Area of Island
///////////////////////////////////////////

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea= Integer.MIN_VALUE;
        
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) {
                    
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
                
            }
        }
        
        return maxArea==Integer.MIN_VALUE? 0 : maxArea;
    }
    
    
    
    public int dfs(int[][] grid, int i, int j) {
        
        //make sure if it's a valid cell for DFS
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
			return 0;
		}
        
        // changing the cell value to 0 to avoid going in loop
        grid[i][j]=0;
        
      
        return 1 +
            dfs(grid, i-1, j) +
        dfs(grid, i, j+1) +
        dfs(grid, i+1, j) +
        dfs(grid, i, j-1);
        
    }
=======
///////////////////////////////////////////
//695. Max Area of Island
///////////////////////////////////////////

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea= Integer.MIN_VALUE;
        
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) {
                    
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
                
            }
        }
        
        return maxArea==Integer.MIN_VALUE? 0 : maxArea;
    }
    
    
    
    public int dfs(int[][] grid, int i, int j) {
        
        //make sure if it's a valid cell for DFS
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
			return 0;
		}
        
        // changing the cell value to 0 to avoid going in loop
        grid[i][j]=0;
        
      
        return 1 +
            dfs(grid, i-1, j) +
        dfs(grid, i, j+1) +
        dfs(grid, i+1, j) +
        dfs(grid, i, j-1);
        
    }
>>>>>>> c9a657537c4a10962f5426954865bacce8125cd6
}