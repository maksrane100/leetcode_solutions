package com.codeforces1;

public class Leetcode_2125 {

	public static int numberOfBeams(String[] bank) {
		int total = 0;
		int previous = 0;
		int current = 0;

		for (String next : bank) {
			
			current = 0;
			
			for (char nextChar : next.toCharArray()) {
				if (nextChar == '1')
					current++;
			}
			
			total += (current * previous);
			
			if (current != 0)
				previous = current;
		}

		return total;
	}

	public static void main(String[] args) throws java.lang.Exception {
		String[] bank = { "011001", "000000", "010100", "001000" };
		int result = numberOfBeams(bank);

		System.out.println(result);
	}

}
