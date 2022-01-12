package com.codeforces1;

import java.util.HashMap;

public class Leetcode_2131 {

	public static int longestPalindrome(String[] words) {
		HashMap<String, Integer> map = new HashMap<>();

		int max = 0;

		for (int i = 0; i < words.length; i++) {

			String reversed = words[i].charAt(1) + "" + words[i].charAt(0);

			if (map.containsKey(reversed)) {

				max += 4;

				// decrease count
				map.put(reversed, map.get(reversed) - 1);

				if (map.get(reversed) == 0)
					map.remove(reversed);

				continue;
			}

			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}

		for (String k : map.keySet()) {
			// handling words like "dd" where both characters are same. this can be put in
			// the middle
			// when forming a palindrome.
			// e.g. abddba

			if (map.get(k) == 1 && (k.charAt(1) + "" + k.charAt(0)).equals(k)) {
				max += 2;
				break;
			}
		}

		return max;
	}

	public static void main(String[] args) throws java.lang.Exception {
		String[] words = { "ab", "ty", "yt", "lc", "cl", "ab", "dd" };
		int result = longestPalindrome(words);

		System.out.println(result);
	}

}
