package com.codeforces1;

public class Leetcode_2130 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static int size(ListNode head) {
		if (head == null) {
			return 0;
		}
		return 1 + size(head.next);
	}

	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode a = head;
		ListNode b = head.next;
		if (b == null) {
			return head;
		}
		ListNode c = b.next;
		a.next = null;
		while (c != null) {
			b.next = a;
			a = b;
			b = c;
			c = c.next;
		}
		b.next = a;
		return b;
	}

	public static int pairSum(ListNode head) {
		int n = size(head);
		int p = n / 2;
		// reverse second half of list
		ListNode curr = head;
		for (int i = 0; i < p - 1; i++) {
			curr = curr.next;
		}
		ListNode x = curr.next;
		curr.next = null;
		ListNode otherHead = reverse(x);
		// compute the max sum
		int max = 0;
		while (head != null) {
			int sum = head.val + otherHead.val;
			if (sum > max) {
				max = sum;
			}
			head = head.next;
			otherHead = otherHead.next;
		}
		return max;
	}

	public static void main(String[] args) throws java.lang.Exception {

		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);

		head.next = second;
		second.next = third;
		third.next = fourth;

		int sum = pairSum(head);

		System.out.println("sum:" + sum);
	}

}
