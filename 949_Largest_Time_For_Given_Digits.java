///////////////////////////////////////////
//1315. Sum of Nodes with Even-Valued Grandparent
///////////////////////////////////////////


class Solution {
    public String largestTimeFromDigits(int[] arr) {
        
        Map<Integer, Integer> freqmap = new HashMap();
        
        for(int i = 0 ; i < arr.length ; i++) {
            if(freqmap.get(arr[i]) != null) {
                freqmap.put(arr[i], freqmap.get(arr[i]) + 1);
            } else {
                freqmap.put(arr[i],1);
            }
                
        }
        
        // start with maximum minutes and keep decrementing it to find maximum valid time that 
        // can be formed with given digits
        int time = 23*60 + 59;
        
         String h = "";
         String m = "";
        
        boolean found=false;
        
        while(time>=0) {
            
            int hours = time/60;
            int minutes = time %60;

            
            h = String.valueOf(hours);
            m = String.valueOf(minutes);
            
            if(h.length()<2) {
                h="0"+h;
            }
             if(m.length()<2) {
                m="0"+m;
            }
            
            Map<Integer, Integer> map = new HashMap();
        
        
            for(int i = 0 ; i < h.length() ; i++) {
                int key = Integer.valueOf(h.charAt(i)-'0');
                
                if(map.get(key) != null) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key,1);
                }
            }
           
            for(int i = 0 ; i < m.length() ; i++) {
                int key = Integer.valueOf(m.charAt(i)-'0');
                
                if(map.get(key) != null) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key,1);
                }
            }
            
           
            
            if(freqmap.equals(map)) {
                found=true;
                break;
            }
            time--;            
        }
        
        if(!found) {
            return "";
        }

        String s = h+":"+m;
        return s;
        
    }
}