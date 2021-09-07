///////////////////////////////////////////
//451. Sort Characters By Frequency
///////////////////////////////////////////

import java.util.Map.Entry;

class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> map = new HashMap();

		char[] chararr = s.toCharArray();
		for (int i = 0; i < chararr.length; i++) {
			char ch = chararr[i];

			if (map.get(ch) == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}


		Map<Integer, List<Character>> freqmap = new TreeMap(Collections.reverseOrder());

		for (Entry<Character, Integer> entry : map.entrySet()) {
            
			Integer val = entry.getValue();
			
			if(freqmap.get(val)==null) {
				 List<Character> list= new ArrayList();
				 list.add(entry.getKey());
				 freqmap.put(entry.getValue(), list);
			} else {
				List<Character> list= freqmap.get(val);
				 list.add(entry.getKey());
				 freqmap.put(entry.getValue(), list);
			}
		}

		//System.out.println(freqmap);
		
		StringBuilder sb = new StringBuilder();
		
        for (Entry<Integer, List<Character>> entry : freqmap.entrySet()) {

			int key = entry.getKey();
			List<Character> value = entry.getValue();

			
			for (Character c : value) {
				for (int k = 0; k < key; k++) {
					sb.append(c);
				}
			}
		}

		return sb.toString();
    }
}