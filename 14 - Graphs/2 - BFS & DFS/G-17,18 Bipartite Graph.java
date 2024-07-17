class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // number of nodes
        int[] vis = new int[n]; Arrays.fill(vis, -1); // initialize all nodes as unvisited

        for (int i = 0; i < n; i++) { // to check all component cycles
            if (vis[i] == -1 && !dfs(i, 0, graph, vis)) {
                return false; // if any component is not bipartite, return false
            }
        }
        return true; // if all components are bipartite, return true
    }

    private boolean dfs(int i, int col, int[][] graph, int[] vis) {
        vis[i] = col; // color the current node
        for (int neig : graph[i]) {
            if (vis[neig] == -1) {
                if (!dfs(neig, (col + 1) % 2, graph, vis)) {
                    return false; 
                }
            } else if (vis[neig] == col) {
                return false; // if the neighbor is colored with the same color, return false
            }
        }
        return true; // if no conflicts found, return true
    }
}