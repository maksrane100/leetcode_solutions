///////////////////////////////////////////
//1817. Finding the Users Active Minutes
///////////////////////////////////////////

import java.util.Map.Entry;

class Solution {
    
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        
        Map<Integer, Set<Integer>> map = new HashMap();
        
        for(int i = 0; i < logs.length ; i++) {
            int[] uam_log = logs[i];
            int userid = uam_log[0];
            int minute = uam_log[1];
            
            if(map.get(userid)==null) {
                Set<Integer> s = new HashSet();
                s.add(minute);
                map.put(userid,s);
            } else {
                Set<Integer> s = map.get(userid);
                s.add(minute);
                map.put(userid,s);
            }
            
        }
        
       Iterator<Entry<Integer, Set<Integer>>> iter = map.entrySet().iterator();
        
        while(iter.hasNext()) {
            Entry<Integer, Set<Integer>> e= iter.next();
            Set<Integer> set=e.getValue();
            
            // as we start indexing result from 1
            result[set.size()-1]++;
        }
        
        
        return result;
    }
}