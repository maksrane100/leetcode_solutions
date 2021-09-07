///////////////////////////////////////////
//1957. Delete Characters to Make Fancy String
///////////////////////////////////////////

class Solution {
    public String makeFancyString(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        int i =0;
        char prev = '*';
        
        int prev_count = 0;

        while(i < s.length()) {
            
            char current = s.charAt(i);

            if(current == prev) {
                if(prev_count < 1) {
                    sb.append(current);
                }
                prev_count++;
            } else {
                sb.append(current);
                prev_count=0;
                prev=current;
            }
            
            i++;
            
        }
        
        return sb.toString();
        
    }
}