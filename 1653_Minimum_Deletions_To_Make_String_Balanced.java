///////////////////////////////////////////
//Leetcode 1653 Minimum Deletions to Make String Balanced
///////////////////////////////////////////

class Solution {
    
	public static int minimumDeletions(String s) {
		
		int L = s.length();
		
		int prefix = 0;
		
		int total_deletions = 0;
		
		for (int i = 0; i < L; i++) {
		
			if (s.charAt(i) == 'b')
				prefix++;
			else if (s.charAt(i) == 'a' && prefix > 0) {
				prefix--;
				total_deletions++;
			}
		
		}
		
		return total_deletions;
	}
}