class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (vis[i]) continue; // Skip if the vertex is already visited
            
            // BFS
            q.offer(new int[] {i, -1}); vis[i] = true; // Start BFS from this vertex
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int node = curr[0], parent = curr[1];
                for (int neig : adj.get(node)) {
                    if (!vis[neig]) {
                        q.offer(new int[] {neig, node});
                        vis[neig] = true;
                    }
                    else if(vis[neig] && parent != neig) return true;
                }
            }
        }
        
        return false;
    }
}