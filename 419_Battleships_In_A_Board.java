<<<<<<< HEAD
///////////////////////////////////////////
//419. Battleships in a Board
///////////////////////////////////////////

class Solution {
    public int countBattleships(char[][] board) {
        int battleships=0;
        
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='X') {
                    battleships++;
                    dfs(board, i, j);
                }
                
            }
        }
        
        return battleships;
    }
    
    
    public void dfs(char[][] board, int i, int j) {
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
			return;
		}
        
        board[i][j]='*';
        
        //will make sure that we are changing whole island to some other character recursively so that it won't count again
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        
    }
    
=======
///////////////////////////////////////////
//419. Battleships in a Board
///////////////////////////////////////////

class Solution {
    public int countBattleships(char[][] board) {
        int battleships=0;
        
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='X') {
                    battleships++;
                    dfs(board, i, j);
                }
                
            }
        }
        
        return battleships;
    }
    
    
    public void dfs(char[][] board, int i, int j) {
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
			return;
		}
        
        board[i][j]='*';
        
        //will make sure that we are changing whole island to some other character recursively so that it won't count again
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        
    }
    
>>>>>>> c9a657537c4a10962f5426954865bacce8125cd6
}