///////////////////////////////////////////
//429. N-ary Tree Level Order Traversal
///////////////////////////////////////////

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList();
        
        if(root == null) {
            return result;
        }
        
        
                
        Queue<Node> queue = new LinkedList();
        
        queue.offer(root);
        
        List<Integer> list=new LinkedList();
        list.add(root.val);
        result.add(list);
        
        
        // iterate through the queue until it becomes empty
        while(!queue.isEmpty()) {
            
            list = new LinkedList();
            
            int size = queue.size();
            
            // iterate through all the nodes for that level
            for(int i = 0; i < size ; i++) {
                Node node = queue.poll();
                List<Node> children = node.children;
                
                for(int j = 0; j < children.size() ; j++) {
                    Node temp  = children.get(j);
                    list.add(temp.val);
                    queue.offer(temp);
                }
                
            }
            
            if(list.size() > 0)
                result.add(list);
        }
        
        return result;
        
    }
    
    
    
    
}