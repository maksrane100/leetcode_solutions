/*************************************************************
1161. Maximum Level Sum of a Binary Tree
/*************************************************************

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxlevelsum = 0;
    
    public int maxLevelSum(TreeNode root) {
        bfs(root);
        return this.maxlevelsum;
    }
    
    private void bfs(TreeNode root) {

		Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();

		int level = 1;
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        int maxlevelsum = 0;

		queue.add(root);


		while (!queue.isEmpty()) {

			int size = queue.size();
            sum = 0;

            // iterate all  nodes in that level and calculate the sum
            for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				
                sum += n.val;
                
				if (n.left != null)
					queue.add(n.left);

				if (n.right != null)
					queue.add(n.right);
			}

            
            if(sum > maxsum) {
                maxsum = sum;
                this.maxlevelsum = level;
            }
             
           
            
			level++;
		}

		//System.out.println("maxlevelsum:" + maxlevelsum);

	}
    
}