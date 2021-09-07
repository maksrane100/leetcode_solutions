<<<<<<< HEAD
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
=======
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
>>>>>>> c9a657537c4a10962f5426954865bacce8125cd6
}