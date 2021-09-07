///////////////////////////////////////////
//198_House_Robber
///////////////////////////////////////////

class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1) {
            return nums[0];
        }
        
        int max = 0;
        int N = nums.length;
        
        int dp[] = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2 ; i < N ; i++) {
            dp[i] = Math.max( dp[i-1] ,  dp[i-2] + nums[i]);
        }
        
        return dp[N-1];
        
    }
}