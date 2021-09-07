///////////////////////////////////////////
//1768. Merge Strings Alternately
///////////////////////////////////////////

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int first=0;
        int second=0;
        
        StringBuilder sb = new StringBuilder();
        
        while(first<word1.length() || second < word2.length()) {
            
            if(first<word1.length()) {
                sb.append(word1.charAt(first++));
            }
             if(second<word2.length()) {
                sb.append(word2.charAt(second++));
            }
            
        }
        
        return sb.toString();
    }
}