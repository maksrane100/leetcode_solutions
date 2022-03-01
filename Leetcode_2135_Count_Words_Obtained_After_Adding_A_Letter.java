///////////////////////////////////////////
//Leetcode 2135 Count Words Obtained After Adding a Letter
///////////////////////////////////////////

class Solution {
    
	public int wordCount(String[] startWords, String[] targetWords) {
        	
            HashSet<String> set = new HashSet<>();
	        
	        for(String word: startWords){
	            char[] c = word.toCharArray();
	            
	            Arrays.sort(c);
	            
	            word = "";
	            
	            for(char ch: c)
	                word += ch;
	            
	            set.add(word);
	        }
	        
	        int count = 0;
	        
	        for(String s: targetWords){
	            char[] c = s.toCharArray();
	            
	            Arrays.sort(c);
	            
	            for(int i=0; i<c.length; i++){
	                String str = "";
	                
	                for(int j=0; j<i; j++)
	                    str += c[j];
	                
	                for(int j=i+1; j<c.length; j++)
	                    str += c[j];
	                
	                //System.out.println("checking:"+str);
	               
	                if(set.contains(str)){
	                	
	                	//System.out.println("found");
	                    count++;
	                    break;
	                }
	            }
	        }
	        return count;
    }
	
}