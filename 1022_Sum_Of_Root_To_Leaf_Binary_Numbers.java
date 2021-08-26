///////////////////////////////////////////
//1022. Sum of Root To Leaf Binary Numbers
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
    public int sumRootToLeaf(TreeNode root) {
        
        int sum = 0;
        List<List<String>> list = new ArrayList<List<String>>();
        traverse(root, new ArrayList<String>(), list);
        //System.out.println("list : "+list);
        
        
        for(List<String> l : list) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< l.size(); i++) {
                sb.append(l.get(i));
            }
            
            sum+= Integer.parseInt(sb.toString(), 2);
        }
        
        return sum;
        
    }
    
    private void traverse(TreeNode root, List<String> list, List<List<String>> output) {
        
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            
            List<String> newlist=new ArrayList<String>(list);
            
            output.add(newlist);
            
            list.remove(list.size()-1);
            
            return;
        }
        
        list.add(String.valueOf(root.val));
        
        traverse(root.left, list, output);
        traverse(root.right, list, output);
         
        list.remove(list.size()-1);       // backtracking
    }
    
}