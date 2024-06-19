class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        // Check each vertex, as the graph may be disconnected.
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, -1, vis, adj)) {
                return true;
            }
        }
        return false;
    }

    // Helper function to perform DFS
    private boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (int neig : adj.get(node)) {
            if (!vis[neig]) {
                if (dfs(neig, node, vis, adj)) {
                    return true;
                }
            } else if (neig != parent) {
                return true;
            }
        }
        return false;
    }
}