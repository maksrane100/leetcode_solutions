///////////////////////////////////////////
//Leetcode 2150 Find All Lonely Numbers in the Array
///////////////////////////////////////////

class Solution {
    
	public List<Integer> findLonely(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer> ans = new ArrayList<>();

		for (int num : nums) {
			// if map does not contains (num+1) and (num-1) number, num is a lonely number.
			// then we will add it to ans list
			
			if (map.get(num) == 1 && !map.containsKey(num + 1) && !map.containsKey(num - 1))             {
				ans.add(num);
			}
		}
        
		return ans;
	}
	
}