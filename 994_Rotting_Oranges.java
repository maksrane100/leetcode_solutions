///////////////////////////////////////////
//994. Rotting Oranges
///////////////////////////////////////////

class Solution {
    
    class Position {
        int i;
        int j;
        int state;
        
        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
         public Position(int i, int j, int s) {
            this.i = i;
            this.j = j;
            this.state = s;
        }
    }
    
    
    public int orangesRotting(int[][] grid) {
               
        int total =0;
        int fresh = 0;
        
        Queue<Position> queue=new LinkedList();
                
        for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    fresh++;
                }
                if(grid[i][j]==2) {                  
                   
                        queue.offer(new Position(i,j,2));
                }
            }			
		}
        
        if(fresh == 0) {
            return 0;
        }
        
        int min = -1;
        
        while(!queue.isEmpty()) {
            
            int size=queue.size();
            
            if(fresh==0) {
                break;
            }
            
            for(int i=0;i<size;i++) {
                Position p = queue.poll();

                if(grid[p.i][p.j]==1) {
                    grid[p.i][p.j]=2;
                    fresh--;
                    
                }
                
                if(isValidCell(grid,p.i-1,p.j)){
                    queue.offer(new Position(p.i-1,p.j));
                }
                
                 if(isValidCell(grid,p.i,p.j+1)){
                    queue.offer(new Position(p.i,p.j+1));
                 }
                
                if(isValidCell(grid,p.i+1,p.j)){
                    queue.offer(new Position(p.i+1,p.j));
                }
                
                if(isValidCell(grid,p.i,p.j-1)){
                    queue.offer(new Position(p.i,p.j-1));
                }
                    
                
            }
            min++;
            
        }
        
        return fresh == 0 ? min : -1;
        
    }
    
    private boolean isValidCell(int[][] grid, int i, int j) {
         if( (i<0 || i >=grid.length || j<0 || j>=grid[0].length ) || grid[i][j]!=1 ) {
             return false;
         }
        return true;
    }
}