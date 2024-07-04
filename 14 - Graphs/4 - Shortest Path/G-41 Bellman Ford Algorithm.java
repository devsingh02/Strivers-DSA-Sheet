/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[S] = 0;
        // N-1 iterations : Relax all edges
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
                if (dist[u] != (int)1e8 && dist[u] + wt < dist[v]) { // imp for -ve wt to check if u is inf
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth iteration check for -ve cycle : if any update on Nth iteration => -ve cycle exists
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
            if (dist[u] != (int)1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }            
        }
        // No -ve cycle : return answer
        return dist;
    }
}