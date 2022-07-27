class Solution {
    
    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	
    static class State {
        int row;
        int col;
        int removed;
        
        State(int r, int c, int removed) {
            this.row = r;
            this.col = c;
            this.removed = removed;
        }
    }
    
	public int minimumObstacles(int[][] grid) {
        
		int R = grid.length;
        
		int C = grid[0].length;
        
		//PriorityQueue keeps minimum removal states on the front
        Queue<State> pq = new PriorityQueue<>((a, b) -> a.removed - b.removed);
        
        pq.add(new State(0, 0, 0));
        
        boolean[][] visited = new boolean[R][C];
        
        visited[0][0] = true;
        
        //BFS Starts
        while (!pq.isEmpty()) {
          
        	State state = pq.poll();
            
            //did we reach the destination
            if (state.row == R - 1 && state.col == C - 1)
                return state.removed;
            
            for (int[] d : dirs) {
               
            	int new_row = state.row + d[0];
               
            	int new_col = state.col + d[1];
                
                //checking if we are inside the grid and the new cell is not visited already
                if (new_row < 0 || new_col < 0 || new_row == R || new_col == C || visited[new_row][new_col])
                    continue;
                
                visited[new_row][new_col] = true;
                
                State next = new State(new_row, new_col, state.removed);
                
                if (grid[new_row][new_col] == 1)
                    next.removed++;
                
                pq.add(next);
            }
        }
        
        return -1;
    }
    
    
}