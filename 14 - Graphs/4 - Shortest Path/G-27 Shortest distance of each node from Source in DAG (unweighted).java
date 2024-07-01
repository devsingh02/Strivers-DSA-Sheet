// NOTE :- Topo sort better than Djastra for DAG
class Solution {

	public int[] shortestPath(int N, int M, int[][] edges) {
		// creating adj list
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int dist = edges[i][2];
		    adj.get(u).add(new int[] {v, dist});
		}
		// Topo sort (dfs)
		boolean[] vis = new boolean[N]; // no need of path since already DAG
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < N; i++) {
		    if (!vis[i]) topoSort(i, vis, st, adj);
		}
		// Stack formed
		// Topo Sort order :- a -> b -> c -> ...  => if source is 'c' then it can never reach 'a' or 'b'
		// So basically what comes first in topo sort is closer to source => ideally to reach all nodes the first node after topo sort should be the source, else it might be unreachable
		
		// forming the distance array
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0; // ***SOURCE***
		
		// start updating dist from the ideal source node i.e. first node in stack
		while (!st.isEmpty()) {
		    int u = st.pop();
		    if (dist[u] == Integer.MAX_VALUE) continue; // unreachable (node before given source)
		    for (int[] neig : adj.get(u)) {
		        int v = neig[0], d = neig[1];
		        if (dist[u] + d < dist[v]) dist[v] = dist[u] + d; // new dist from that node to its neigs is shorter, then update
		    }
		}
		// make inf -> -1
		for (int i = 0; i < N; i++) {
		    if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
		}
		return dist;
	}
	
	void topoSort(int i, boolean[] vis, Stack<Integer> st, List<List<int[]>> adj) {
	    vis[i] = true;
	    for (int[] neig : adj.get(i)) {
	        if (!vis[neig[0]]) topoSort(neig[0], vis, st, adj); // neig[1] = dist.
	    }
	    st.push(i);
	}
}