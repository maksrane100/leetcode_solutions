///////////////////////////////////////////
//1377. Frog Position After T Seconds
///////////////////////////////////////////

class Solution {
   
    

	public double frogPosition(int n, int[][] edges, int t, int target) {
		
        List<Integer>[] graph = (List<Integer>[]) new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		boolean[] visited = new boolean[n + 1];

		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { 1, 1 });

		visited[1] = true;

		int step = 0;

        //BFS Starts
		while (!queue.isEmpty() && step <= t) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {

				int[] current = queue.poll();

				int b = 0;

				for (int w : graph[current[0]]) {
					if (!visited[w])
						b++;
				}
				
				//frog reached target and (b is zero or t seconds has elapsed)
				if (current[0] == target && (b == 0 || step == t)) {
					//we will calculate the probability and return it.
					return 1.0 / current[1];

				}
				
				for (int w : graph[current[0]]) {

					if (!visited[w]) {
						visited[w] = true;

						int temp = current[1] * b;

						queue.offer(new int[] { w, temp });
					}
				}
			}

			step++;
		}
        
		return 0.0;
	}

    
}