///////////////////////////////////////////
//Leetcode 1604 Alert Using Same Key Card Three or More Times in a One Hour Period
///////////////////////////////////////////

class Solution {
    
	public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        HashMap<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < keyName.length; i++) {

			String s = keyName[i];

			map.putIfAbsent(s, new ArrayList<>());

			String[] arr = keyTime[i].split(":");

			String time = arr[0] + arr[1];

			map.get(s).add(Integer.parseInt(time));
		}

		Set<String> result = new TreeSet<>();

		for (Map.Entry<String, List<Integer>> e : map.entrySet()) {

			List<Integer> list = new ArrayList<>(e.getValue());

			Collections.sort(list);

			int count = 1;

			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {

					if (list.get(j) - list.get(i) <= 100)
						count++;
					else {
						count = 1;
						break;
					}

					if (count >= 3)
						break;
				}

				if (count >= 3) {
					result.add(e.getKey());
					break;
				}
			}
		}

		return new ArrayList<>(result);
        
    }
	
}