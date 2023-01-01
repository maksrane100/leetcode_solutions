///////////////////////////////////////////
//501. Find Mode in Binary Search Tree
///////////////////////////////////////////

import java.util.Map.Entry;

class Solution {
    
    class Element {
        int val;
        int freq;
        
        public Element(int v, int f) {
            this.val=v;
            this.freq=f;
        }
    }
    
    PriorityQueue<Element> pq =new PriorityQueue<Element>(  
    (a,b) -> b.freq - a.freq
    );
    
    Map<Integer,Integer> map =new HashMap();
    
    public int[] findMode(TreeNode root) {
               
        traverse(root);
        
       
        Iterator<Entry<Integer,Integer>> iter = map.entrySet().iterator();
       
        while(iter.hasNext()) {
            Entry<Integer,Integer> e=iter.next();
            pq.offer(new Element(e.getKey(),e.getValue()));
        }
        
        List<Integer> list=new ArrayList();
        
        Element el= pq.poll();
        int v=el.val;
        int f=el.freq;
        list.add(v);
        
        while(!pq.isEmpty()) {
            Element curr = pq.poll();
            int current=curr.freq;
           
            if(current==f) {
               list.add(curr.val);
            } else {
                break;
            }
        }
        
        int[] result = new int[list.size()];
        for (int i=0; i < result.length; i++)
        {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    public void traverse(TreeNode root) {
        if(root==null) {
            return;
        }
        
        int v = root.val;
        
        if(map.get(v)!=null) {
            map.put(v, map.get(v)+1);
        } else {
            map.put(v, 1);
        }
        
        traverse(root.left);
        traverse(root.right);
        
        
    }
}