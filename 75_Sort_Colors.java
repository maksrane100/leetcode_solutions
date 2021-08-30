///////////////////////////////////////////
//75. Sort Colors
///////////////////////////////////////////

class Solution {
    public void sortColors(int[] nums) {
        
         for(int i=0; i<nums.length;i++) {
            
            for(int j=0; j<nums.length;j++) {
                if(nums[i]<nums[j]) {
                    int temp = nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
            
            
        }
        
        
    }
}