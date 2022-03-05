package com.exercises.general;

import java.util.Arrays;

/**
 * Leetcode 1024 Video Stitching
 * 
 * Problem Statement: You are given a series of video clips from a sporting
 * event that lasted time seconds. These video clips can be overlapping with
 * each other and have varying lengths.
 * 
 * Each video clip is described by an array clips where clips[i] = [starti,
 * endi] indicates that the ith clip started at starti and ended at endi.
 * 
 * We can cut these clips into segments freely.
 * 
 * For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 * Return the minimum number of clips needed so that we can cut the clips into
 * segments that cover the entire sporting event [0, time]. If the task is
 * impossible, return -1.
 * 
 */
public class Leetcode1024 {

	public Leetcode1024() {

	}

	public int videoStitching(int[][] arr, int time) {

		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		// [[0, 2], [1, 9], [1, 5], [4, 6], [5, 9], [8, 10]]
		int start = 0;
		int end = 0;
		int result = 0;

		int i = 0;

		while (start < time) {

			for (; i < arr.length && arr[i][0] <= start; i++) {
				end = Math.max(end, arr[i][1]);
			}

			if (end == start)
				return -1;

			System.out.println("start:" + start + " end:" + end);

			start = end;

			result++;
		}

		return result;
	}

	public static void main(String[] args) {
		Leetcode1024 obj = new Leetcode1024();

		// int[][] clips = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 }
		// };
		// int time = 10;

		int[][] clips = { { 0, 2 }, { 4, 6 }, { 2, 6 }, { 8, 10 }, { 10, 19 }, { 1, 5 }, { 18, 20 } };
		int time = 20;

		// int[][] clips = { { 0, 2 }, { 4, 6 }, { 8, 10 }, {6,18},{ 10, 19 }, { 1, 5 },
		// { 18, 20 } };
		// int time = 20;

		int result = obj.videoStitching(clips, time);

		System.out.println(result);
	}

}
