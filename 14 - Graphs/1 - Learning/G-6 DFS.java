class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0, vis, adj, dfs); // starting point => 0
        return dfs;
    }
    // Adj List
    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        vis[node] = true; dfs.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj, dfs); // it will first wrok upon its neighbor/child => recursive
            }
        }
    }
    // Adj Matrix
    void dfs(int node, boolean[] vis, int[][] adjM) {
        vis[node] = true;
        for (int neig = 0; neig < adjM[0].length; neig++) {
            if (adjM[node][neig] == 1 && !vis[neig]) dfs(neig, vis, adjM);
        }
    }
}
// No queue required in DFS, as it uses recursion to go deep into the graph.