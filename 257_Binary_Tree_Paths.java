///////////////////////////////////////////
//257. Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList();
        
        List<List<String>> list = new ArrayList<List<String>>();
        
        traverse(root, new ArrayList<String>(), list);
       
        
        for(List<String> l : list) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< l.size(); i++) {
                sb.append(l.get(i)+"->");
            }
            
            result.add(sb.toString().substring(0,sb.toString().length()-2));
        }
                
        return result;
    }
        
        
    private void traverse(TreeNode root, List<String> list, List<List<String>> output)      {
        
        if(root == null) {
            return;
        }
        
        //once we reach the leaf node
        if(root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            
            List<String> newlist=new ArrayList<String>(list);
            
            output.add(newlist);
            
            list.remove(list.size()-1); // before we return, backtrack for last added element
            
            return;
        }
        
        list.add(String.valueOf(root.val));
        
        traverse(root.left, list, output);
        traverse(root.right, list, output);
         
        list.remove(list.size()-1);       // backtracking
    }    
}