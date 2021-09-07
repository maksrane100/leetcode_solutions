<<<<<<< HEAD
///////////////////////////////////////////
//1980. Find Unique Binary String
///////////////////////////////////////////

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String result="";
        
        Set<String> givenNumbersSet = new HashSet();
        
        for(int i =0; i<nums.length; i++) {
            givenNumbersSet.add(nums[i]);
        }
        
        Set<String> allBinaryStrSet = new HashSet();
		
        generateBinaryStrings("", "", nums[0].length(), allBinaryStrSet, givenNumbersSet);
        
        return allBinaryStrSet.stream().findFirst().get();
    }
    
    
    // generate binary strings of length "l". if it finds a string of length "l" which is not
    // in given input strings, it add it to result set and returns.
    
    private static void generateBinaryStrings(String s, String t, int l, Set<String> set, Set<String> givenNumbersSet) {
		
		if(s.length()>l) {
			return;
		}
		
		if(s.length()==l) {
			 if(!givenNumbersSet.contains(s)) {
                set.add(s);
                return;
            }
		}
		
		s= s+t;
		
		generateBinaryStrings(s, "1", l, set, givenNumbersSet);
		generateBinaryStrings(s, "0", l, set, givenNumbersSet);
	}
	
=======
///////////////////////////////////////////
//1980. Find Unique Binary String
///////////////////////////////////////////

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String result="";
        
        Set<String> givenNumbersSet = new HashSet();
        
        for(int i =0; i<nums.length; i++) {
            givenNumbersSet.add(nums[i]);
        }
        
        Set<String> allBinaryStrSet = new HashSet();
		
        generateBinaryStrings("", "", nums[0].length(), allBinaryStrSet, givenNumbersSet);
        
        return allBinaryStrSet.stream().findFirst().get();
    }
    
    
    // generate binary strings of length "l". if it finds a string of length "l" which is not
    // in given input strings, it add it to result set and returns.
    
    private static void generateBinaryStrings(String s, String t, int l, Set<String> set, Set<String> givenNumbersSet) {
		
		if(s.length()>l) {
			return;
		}
		
		if(s.length()==l) {
			 if(!givenNumbersSet.contains(s)) {
                set.add(s);
                return;
            }
		}
		
		s= s+t;
		
		generateBinaryStrings(s, "1", l, set, givenNumbersSet);
		generateBinaryStrings(s, "0", l, set, givenNumbersSet);
	}
	
>>>>>>> c9a657537c4a10962f5426954865bacce8125cd6
}