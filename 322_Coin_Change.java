///////////////////////////////////////////
//322. Coin Change
///////////////////////////////////////////

class Solution {
    public int coinChange(int[] coins, int amount) {
        		int[][] dp = new int[coins.length+1][amount+1];
		
		boolean possible=true;
            if(amount==0) {
                return 0;
            }
            else if(coins.length==1 && (coins[0]>amount || amount%coins[0]!=0 )) {
                possible=false;
                
            }
        
        
        if(!possible) {
            return -1;
        }
        
		for(int i=1;i<=amount;i++) {
			dp[0][i]=i;
		}
		for(int i=0;i<=coins.length;i++) {
			dp[i][0]=0;
		}
		
		//populating remaining dp array
		for(int i=1;i<=coins.length;i++) {
			for(int j=1;j<=amount;j++) {

                if (j < coins[i-1]) {
					dp[i][j] = dp [i-1][j];
					
				} else {
					dp[i][j] = Math.min(dp [i-1][j] ,  dp[i][j-coins[i-1]] +1 ) ;
				}
			
			}
			
			
			
		}
		
		
		return dp[coins.length][amount];
    }
}