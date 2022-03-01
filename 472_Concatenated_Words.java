///////////////////////////////////////////
//Leetcode 472 Concatenated Words - Hard Problem
///////////////////////////////////////////

class Solution {
    	static class TrieNode {
		boolean isWord = false;
		TrieNode[] children;

		TrieNode() {
			children = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new TrieNode();
				}
				node = node.children[c - 'a'];
			}
			node.isWord = true;
		}

		public boolean search(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null) {
					return false;
				}
				node = node.children[c - 'a'];
			}
			return node.isWord;
		}

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Trie trie = new Trie();
		
		//first we will insert all the words in a Trie
		for (String s : words) {
			trie.insert(s);
		}
		
		
		List<String> result = new ArrayList<>();

		//we will check for every word, if it can be splitted into multiple words such that each of the splitted word
		//exits in Trie. if it's the case, we found a concatenated word.
		for (String s : words) {
			if (util(trie, s, false))
				result.add(s);
		}
		return result;
	}

	//we will use "cutWordPossible" to check if the given word can be splitted into more than one words.
	//Because  if we can split the  given word into multiple words, then only it's a concatenated word.
	private boolean util(Trie trie, String s, boolean cutWordPossible) {
		
		if (s.equals("") && cutWordPossible)
			return true;
		
		if (s.equals(""))
			return false;
		
		for (int i = 0; i < s.length(); i++) {
		
			String prefix = s.substring(0, i + 1);
			
			System.out.println("prefix:"+prefix);
			
			if (i == s.length() - 1 && !cutWordPossible)
				return false;
			
			if (trie.search(prefix)) {
				// cut = true;
				if (util(trie, s.substring(i + 1), true))
					return true;
			}
		}
		
		return false;
	}
}