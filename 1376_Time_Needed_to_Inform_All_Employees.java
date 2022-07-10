///////////////////////////////////////////
//1376. Time Needed to Inform All Employees
///////////////////////////////////////////

class Solution {
	
    int time_needed = 0 ;
	
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) 
    {
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i= 0 ; i<n ; i++)
        {
            if(manager[i]==-1)
                continue;
            if(!graph.containsKey(manager[i]))
            {
                ArrayList<Integer> list =  new ArrayList<>();
                list.add(i);
                graph.put(manager[i],list);                
            }
            else
            {
               ArrayList<Integer> list =  graph.get(manager[i]);
               list.add(i);
               graph.put(manager[i],list);
            }
        }     
        
        calculateTime(headID,graph,informTime,0);
        
        return time_needed;
    }
    
    // recursive dfs function
    private void calculateTime(int headID, Map<Integer,ArrayList<Integer>>graph, int[] informTime, int t)
    {
        // base case for recursion
        if(informTime[headID]==0) {
            return;
        }
        
        t = t + informTime[headID];
        
        ArrayList<Integer> temp = graph.get(headID);
        
        int s = temp.size();
        
        for(int i = 0 ; i<s; i++)
        {
            calculateTime(temp.get(i),graph,informTime,t);
            if(t > time_needed) {
                time_needed = t;
            }
        }            
    }
    
}