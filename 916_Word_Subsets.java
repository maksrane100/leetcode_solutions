///////////////////////////////////////////
//916. Word Subsets
///////////////////////////////////////////

class Solution {

        
    public List<String> wordSubsets(String[] words1, String[] words2) {

		int[] combinedFreqArray = new int[26];
		
		List<String> result = new ArrayList<>();
		
		for (String word : words2) {
			int[] chars = new int[26];
			
			for (char c : word.toCharArray()) {
				chars[c - 'a']++;
			}
			
			for (int i = 0; i < 26; i++) {
				combinedFreqArray[i] = Math.max(chars[i], combinedFreqArray[i]);
			}
		}
		
		for (String word : words1) {
			int[] chars = new int[26];
			
			for (char c : word.toCharArray()) {
				chars[c - 'a']++;
			}
			
			if (checkSubset(combinedFreqArray, chars)) {
				result.add(word);
			}
		}
		
		return result;
	}

	private boolean checkSubset(int[] combined, int[] chars) {
		for (int i = 0; i < 26; i++) {
			if (chars[i] < combined[i])
				return false;
		}
		return true;
	}
}