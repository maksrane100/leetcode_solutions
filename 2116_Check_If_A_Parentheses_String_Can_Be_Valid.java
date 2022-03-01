///////////////////////////////////////////
//Leetcode 2116 Check if a Parentheses String Can Be Valid
///////////////////////////////////////////

class Solution {
    
	public boolean canBeValid(String s, String locked) {
        		
		int close_paranthesis = 0;
		int open_paranthesis = 0;
		int flip_allowed = 0;

		if (s.length() % 2 != 0) {
			return false;
		}

		for (int i = 0; i < s.length(); ++i) {

			if (locked.charAt(i) == '0') {
				flip_allowed++;
			} else {
				if (s.charAt(i) == '(') {
					open_paranthesis++;
				} else {
					close_paranthesis++;
				}
			}
			
			if (flip_allowed + open_paranthesis < close_paranthesis) {
				return false;
			}
		}

		close_paranthesis = 0;

		open_paranthesis = 0;

		flip_allowed = 0;

		for (int i = s.length() - 1; i >= 0; --i) {

			if (locked.charAt(i) == '0') {
				flip_allowed++;
			} else {

				if (s.charAt(i) == '(') {

					open_paranthesis++;
				} else {
					close_paranthesis++;
				}

			}
			
			if (flip_allowed + close_paranthesis < open_paranthesis) {
				return false;
			}
		}

		return true;
    }
	
}