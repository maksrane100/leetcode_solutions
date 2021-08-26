///////////////////////////////////////////
//229. Majority Element II
///////////////////////////////////////////

import java.util.Map.Entry;

class Solution {
    
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList();
        
        Map<Integer,Double> map = new HashMap();
        
        double threshold = nums.length / 3;
        
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])==null) {
                map.put(nums[i],1d);
            } else {
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        
        
        Iterator<Entry<Integer,Double>> iter  = map.entrySet().iterator();
        
        while(iter.hasNext()) {
            Entry<Integer,Double> e = iter.next();
            
            if(e.getValue() > threshold) {
                result.add(e.getKey());
            }
        }
        
        return result;
        
    }
}