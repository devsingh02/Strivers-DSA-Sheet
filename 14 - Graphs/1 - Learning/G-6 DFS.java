class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0, vis, adj, dfs);
        return dfs;
    }
    
    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        vis[node] = true; dfs.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj, dfs); // it will first wrok upon its neighbor/child => recursive
            }
        }
    }
}