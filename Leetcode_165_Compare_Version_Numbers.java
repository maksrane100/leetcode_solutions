///////////////////////////////////////////
//Leetcode 165 Compare Version Numbers
///////////////////////////////////////////

class Solution {
    
	public int compareVersion(String version1, String version2) {
        
        String arr1[] = version1.split("[.]");

		String arr2[] = version2.split("[.]");

		int N = Math.min(arr1.length, arr2.length);

		for (int i = 0; i < N; i++) {

			int a = Integer.parseInt(arr1[i]);

			int b = Integer.parseInt(arr2[i]);

			if (a > b)
				return 1;

			if (a < b)
				return -1;

		}

		if (arr1.length > arr2.length) {

			int i = N;

			while (i < arr1.length) {
				int a = Integer.parseInt(arr1[i]);
				if (a != 0)
					return 1;
				i++;
			}

			return 0;
		}

		if (arr1.length < arr2.length) {

			int i = N;

			while (i < arr2.length) {
				int a = Integer.parseInt(arr2[i]);
				if (a != 0)
					return -1;
				i++;
			}
			return 0;

		}

		return 0;
        
    }
	
}