///////////////////////////////////////////
//796. Rotate String
///////////////////////////////////////////

class Solution {
    public boolean rotateString(String s, String goal) {
     
        if(s==null && goal==null) {
            return true;
        }
        
        if(s.length()!=goal.length()) {
            return false;
        }
        
        return (s+s).contains(goal)?true:false;
    }
}