///////////////////////////////////////////
//Leetcode 2133 Check if Every Row and Column Contains All Numbers
///////////////////////////////////////////

class Solution {
    
	public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
		
        for (int r = 0; r < n; ++r) {
		
            Set<Integer> row = new HashSet<>();
			Set<Integer> col = new HashSet<>();
			
            for (int c = 0; c < n; ++c) {
				row.add(matrix[r][c]);
				col.add(matrix[c][r]);
			}
            
			if (row.size() < n || col.size() < n) {
				return false;
			}
		}
		return true;
    }
	
}