///////////////////////////////////////////
//513. Find Bottom Left Tree Value
///////////////////////////////////////////

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
    public int findBottomLeftValue(TreeNode root) {
        
        
        int result = 0;
        
        Queue<TreeNode> q = new LinkedList();
        
        q.offer(root);
        
        while(!q.isEmpty()) {         
           
            int size = q.size();
            
            boolean flag= true;
            
            for(int i = 0; i < size; i++) {
                
                 TreeNode node = q.poll();
                  if(flag) {
                      result=node.val;
                      flag=false;
                  }
                
                if(node.left!=null)
                    q.offer(node.left);
                
                if(node.right!=null)
                    q.offer(node.right);
                                    
            }            
            
        }
        
        return result;
    }
}