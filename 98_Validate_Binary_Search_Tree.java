///////////////////////////////////////////
//98. Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
       // return valid(root, null, null);
        
        if(root==null) {
            return true;
        }
        
        if(root.left==null && root.right==null) {
            return true;
        }
        
         return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
  
    
     public boolean valid(TreeNode root, Long min, Long max) {
        if(root==null) {
            return true;
        }
         
         if(root.val <= min || root.val >= max) {
             return false;
         }
         
         boolean l = valid(root.left,min, (long)root.val );
         boolean r = valid(root.right, (long)root.val , max);
          
         return l && r ;
         
    }
    
    
}