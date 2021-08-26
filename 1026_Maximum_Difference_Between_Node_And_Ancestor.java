///////////////////////////////////////////
//1026. Maximum Difference Between Node and Ancestor
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
    
    int maxdiff = Integer.MIN_VALUE;
    
    public int maxAncestorDiff(TreeNode root) {
        
        LinkedList<Integer> list = new LinkedList();
        findMaxDifference(root, list);
        return maxdiff;
    }
    
    
    public void findMaxDifference(TreeNode root, List<Integer> list){
                
        if(root == null)  {           
            return;
        }
            
        if(root.left == null && root.right ==null)  {
             list.add(root.val);
           
            Collections.sort(list);
            maxdiff=Math.max(maxdiff,Math.abs(list.get(0)-list.get(list.size()-1)));
            return;
        }
            
        list.add(root.val);
                
        findMaxDifference(root.left, new ArrayList(list));
        findMaxDifference(root.right, new ArrayList(list));
        
    }

}