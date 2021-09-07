<<<<<<< HEAD
///////////////////////////////////////////
//797. All Paths From Source to Target
///////////////////////////////////////////

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
            
        Map<Integer,List<Integer>> g = buildGraph(graph);

        processGraph(0, graph.length-1, 0, g, new ArrayList<Integer>(), result);
       
        return result;
    }
    
    private void processGraph(int source, int destination, int current,  Map<Integer,List<Integer>> graph,   List<Integer> list, List<List<Integer>> result) {
         list.add(current);
        
        if(current == destination) {
            result.add(new ArrayList(list));
            return;
        }
        
        List<Integer> adjnodes = graph.get(current);

        
        if(adjnodes==null || adjnodes.size()==0) {
            return;
        }
        
        for(int i=0; i<adjnodes.size(); i++) {
           
            processGraph(source, destination, adjnodes.get(i), graph, new ArrayList(list), result);
        }
        
        
    }
    
    
    private Map<Integer,List<Integer>> buildGraph(int[][] graph) {
         Map<Integer,List<Integer>> g = new HashMap();
        
        for(int i=0; i<graph.length;i++) {
            
            int[] nodes=graph[i];
            
            for(int j=0; j<nodes.length;j++) {

                if(g.get(i)==null) {
                    List ll = new LinkedList();
                    ll.add(nodes[j]);
                    g.put(i,ll);
                } else {
                     List ll = g.get(i);
                    ll.add(nodes[j]);
                    g.put(i,ll);
                }
            }
            
            
        }
        return g;
    }
=======
///////////////////////////////////////////
//797. All Paths From Source to Target
///////////////////////////////////////////

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
            
        Map<Integer,List<Integer>> g = buildGraph(graph);

        processGraph(0, graph.length-1, 0, g, new ArrayList<Integer>(), result);
       
        return result;
    }
    
    private void processGraph(int source, int destination, int current,  Map<Integer,List<Integer>> graph,   List<Integer> list, List<List<Integer>> result) {
         list.add(current);
        
        if(current == destination) {
            result.add(new ArrayList(list));
            return;
        }
        
        List<Integer> adjnodes = graph.get(current);

        
        if(adjnodes==null || adjnodes.size()==0) {
            return;
        }
        
        for(int i=0; i<adjnodes.size(); i++) {
           
            processGraph(source, destination, adjnodes.get(i), graph, new ArrayList(list), result);
        }
        
        
    }
    
    
    private Map<Integer,List<Integer>> buildGraph(int[][] graph) {
         Map<Integer,List<Integer>> g = new HashMap();
        
        for(int i=0; i<graph.length;i++) {
            
            int[] nodes=graph[i];
            
            for(int j=0; j<nodes.length;j++) {

                if(g.get(i)==null) {
                    List ll = new LinkedList();
                    ll.add(nodes[j]);
                    g.put(i,ll);
                } else {
                     List ll = g.get(i);
                    ll.add(nodes[j]);
                    g.put(i,ll);
                }
            }
            
            
        }
        return g;
    }
>>>>>>> c9a657537c4a10962f5426954865bacce8125cd6
}