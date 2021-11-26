package com.exercises.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode_802 {

	public List<Integer> eventualSafeNodes(int[][] graph) {
		Map<Integer, Boolean> memoizationMap = new HashMap<>();
		for (int i = 0; i < graph.length; i++) {
			//terminal node
			if (graph[i].length == 0)
				memoizationMap.put(i, true);
		}

		for (int i = 0; i < graph.length; i++) {
			boolean result = dfs(i, graph, new HashSet<Integer>(), memoizationMap);
			memoizationMap.put(i, result);
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			if (memoizationMap.get(i))
				list.add(i);
		}

		return list;

	}

	public boolean dfs(int curr, int[][] graph, Set<Integer> visited, Map<Integer, Boolean> memoizationMap) {
		System.out.println("checking :"+curr);
		if (memoizationMap.containsKey(curr)) {
			return memoizationMap.get(curr);
		}

		// if node is already visited, it means multiple possible paths in that node, so
		// will return false
		if (visited.contains(curr)) {
			return false;
		}

		visited.add(curr);

		for (int i : graph[curr]) {
			boolean flag=dfs(i, graph, visited, memoizationMap);
			
			if (flag)
				memoizationMap.put(i, true);
			else
				return false;
		}

		// backtracking
		visited.remove(curr);

		return true;
	}

	
	 public int minSwap(int[] nums1, int[] nums2) {
	        int len = nums1.length;
	        int[][] dp = new int[2][len+1];
	        for(int i = 0; i < 2; i++)
	        {
	            dp[i][0] = 0;
	            dp[i][1] = i;
	        }
	        
	        for(int i = 2; i <= len; i++)
	        {
	            int pre1 = nums1[i-2];
	            int pre2 = nums2[i-2];
	            int cur1 = nums1[i-1];
	            int cur2 = nums2[i-1];
	            dp[0][i] = Integer.MAX_VALUE;
	            dp[1][i] = Integer.MAX_VALUE;
	            
	            System.out.println(pre1+" "+pre2+" "+cur1+" "+cur2);
	            
	            if(cur1>pre1 && cur2 > pre2)
	            {
	                dp[0][i] = Math.min(dp[0][i], dp[0][i-1]);
	                dp[1][i] = Math.min(dp[1][i], dp[1][i-1]+1);
	            }

	            if(cur1 > pre2 && cur2 > pre1)
	            {
	                dp[0][i] = Math.min(dp[0][i], dp[1][i-1]);
	                dp[1][i] = Math.min(dp[1][i], dp[0][i-1]+1);
	            }
	        }
	        
	        return Math.min(dp[0][len], dp[1][len]);
	    }
	 
	public static void main(String[] args) {
		Leetcode_802 obj = new Leetcode_802();

		int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		List<Integer> r = obj.eventualSafeNodes(graph);
		System.out.println(r);
		
		int[] nums1= {0,3,5,8,9};
		int[] nums2= {2,1,4,6,9};
		int result=obj.minSwap(nums1, nums2);
		System.out.println(result);
	}

}
