class Solution {
    
   public int[] findPeakGrid(int[][] mat) {
   		int startRow = 0;
	    int endRow = mat.length-1;


	    while(endRow >= startRow) {
	        int middleRow = startRow + (endRow - startRow)/2;
	       
            //System.out.println("startRow : "+startRow+"   endRow : "+endRow+"  middleRow:"+middleRow);
            
	        // will get max element position for that row
	        int rowmax = maxRowElementPosition(mat[middleRow], mat[middleRow].length-1);

	        // middle row is the first row
	        if (middleRow == 0) {
	            if (mat[middleRow][rowmax] > mat[middleRow + 1][rowmax]) {
	                return new int[]{middleRow, rowmax};
	            }
	        }
	        
	        //middle row is the last row
	        if (middleRow == mat.length - 1) {
	            if (mat[middleRow][rowmax] > mat[middleRow - 1][rowmax]) {
	                return new int[]{middleRow, rowmax};
	            }
	        }

	        //  checking max element of the row with it's upper and lower row
	        if (mat[middleRow][rowmax] > mat[middleRow + 1][rowmax] && mat[middleRow][rowmax] > mat[middleRow - 1][rowmax]) {
	            return new int[]{middleRow, rowmax};
	        }
	        
	        // if max is lesser than next rows same column element, will move startRow to the nextRow
	        if (mat[middleRow][rowmax] < mat[middleRow + 1][rowmax]) {
	            startRow = middleRow+1;
	        } else {                             // otherwise move the endRow to current row -1
	            endRow = middleRow -1;
	        }
	    }
	    
	    // we didn't find peak element in matrix
	    return new int[]{-1, -1};

	}
    
	private int maxRowElementPosition(int[] arr, int end) {
	    int max = 0;


	    for ( int i = 0; i <= end; i++){
	        if (arr[i] > arr[max]){
	            max = i;
	        }
	    }

	    return max;
	}
    
}