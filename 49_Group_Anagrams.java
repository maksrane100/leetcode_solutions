///////////////////////////////////////////
//49. Group Anagrams
///////////////////////////////////////////

import java.util.Map.Entry;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        
        Map<String, List<String>> map = new HashMap();
        
        for(int i = 0; i < strs.length; i++) {
            String s= strs[i];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
                        
            if(map.get(sorted)==null) {
                List<String> list=new ArrayList();
                list.add(s);
                map.put(sorted,list);
            }  else {
                List<String> list=map.get(sorted);
                list.add(s);
                map.put(sorted,list);
            }
            
        }
        
                
        Iterator<Entry<String, List<String>>> iter = map.entrySet().iterator();
        
        while(iter.hasNext()) {
            Entry<String, List<String>> e = iter.next();
            result.add(e.getValue());
        }
        
        
        return result;
    }
}