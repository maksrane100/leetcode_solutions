///////////////////////////////////////////
//557. Reverse Words in a String III
///////////////////////////////////////////

import java.util.StringTokenizer;  

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder sb = new StringBuilder();
         
        while (st.hasMoreTokens()) {  
            String str = st.nextToken();  
            sb.append(new StringBuilder(str).reverse().toString()+" ");                 
        }  
        
        return sb.toString().substring(0,sb.toString().length()-1);
        
    }
}