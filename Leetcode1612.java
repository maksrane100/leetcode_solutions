package com.example;

/**
 * LeetCode 1612. Check If Two Expression Trees are Equivalent
 * 
 * A binary expression tree is a kind of binary tree used to represent
 * arithmetic expressions. Each node of a binary expression tree has either zero
 * or two children. Leaf nodes (nodes with 0 children) correspond to operands
 * (variables), and internal nodes (nodes with two children) correspond to the
 * operators. In this problem, we only consider the '+' operator (i.e.
 * addition).
 * 
 * You are given the roots of two binary expression trees, root1 and root2.
 * Return true if the two binary expression trees are equivalent. Otherwise,
 * return false.
 * 
 * Two binary expression trees are equivalent if they evaluate to the same value
 * regardless of what the variables are set to.
 *
 * 
 */
public class Leetcode1612 {

	static class Node {
		public Node left;
		public Node right;
		public char val;

		public Node() {

		}

		public Node(char val) {
			this.left = this.right = null;
			this.val = val;
		}
	}

	public boolean checkEquivalence(Node root1, Node root2) {

		int[] count = new int[26];

		// add 1 in count for character's (a-z) that are present
		dfs(root1, count, 1);

		// subtract 1 from count for character's (a-z) that are present
		dfs(root2, count, -1);

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}

	private void dfs(Node cur, int[] count, int difference) {

		if (cur == null) {
			return;
		}

		if (cur.val != '+') {
			count[cur.val - 'a'] += difference;
		}

		dfs(cur.left, count, difference);

		dfs(cur.right, count, difference);
	}

	public static void main(String[] args) {
		Leetcode1612 obj = new Leetcode1612();

		Node root1 = new Node();
		root1.val = '+';

		Node one_1 = new Node();
		one_1.val = 'a';

		Node one_2 = new Node();
		one_2.val = '+';

		Node one_3 = new Node();
		one_3.val = 'b';

		Node one_4 = new Node();
		one_4.val = 'c';

		root1.left = one_1;

		root1.right = one_2;

		root1.right.left = one_3;

		root1.right.right = one_4;

		Node root2 = new Node();
		root2.val = '+';

		Node two_1 = new Node();
		two_1.val = 'a';

		Node two_2 = new Node();
		two_2.val = '+';

		Node two_3 = new Node();
		two_3.val = 'b';

		

		root2.left = two_2;

		root2.right = two_1;

		root2.left.left = two_3;

		

		boolean result = obj.checkEquivalence(root1, root2);

		System.out.println(result);
	}
}
