///////////////////////////////////////////
//1985. Find the Kth Largest Integer in the Array
///////////////////////////////////////////

import java.math.BigInteger;

class Solution {
  
    
      public String kthLargestNumber(String[] nums, int k) {
                
        int N = nums.length;
        
        PriorityQueue<BigInteger> pq = new PriorityQueue();
        
          
        for(int i=0; i < N ; i++) {
            pq.offer(new BigInteger(nums[i]));
        }
               
        BigInteger number=null;
        int limit=(N-k+1);
        
        int i=0;
          
        while(i< limit) {
            number = pq.poll();  
            i++;
        }
        
        return number.toString();
        
    }
    
}