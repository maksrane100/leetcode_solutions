///////////////////////////////////////////
//1791_Find_Center_of_Star_Graph
///////////////////////////////////////////

import java.util.Map.Entry;

class Solution {
    public int findCenter(int[][] edges) {
        int r=0;
        
        Map<Integer,Integer> map=new HashMap();
       
        // number of nodes
        int N =0;
        
        for(int i=0;i<edges.length;i++) {
		
            int[] e = edges[i];
            int from = e[0];
            int to = e[1];
            
            N = Math.max(N, from);
            N = Math.max(N, to);
            
            if(map.get(from)==null) {
                map.put(from, 1);
            } else{
                map.put(from, map.get(from)+1);
            }
            
            if(map.get(to)==null) {
                map.put(to, 1);
            } else{
                map.put(to, map.get(to)+1);
            }
            
        }
        
        Iterator<Entry<Integer,Integer>> iter = map.entrySet().iterator(); 
      
        while(iter.hasNext()) {
            Entry<Integer,Integer> e= iter.next();
            int key=e.getKey();
            int value=e.getValue();
            
            if(value == N-1) {
                r=key;
            }
            
            
        }
      
        return r;
    }
}