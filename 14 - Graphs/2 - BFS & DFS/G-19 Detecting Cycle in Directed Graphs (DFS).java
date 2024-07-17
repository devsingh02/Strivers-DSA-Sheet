// GFG PROBLEM :-
// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph

// return T -> if cycle exists

// Directed graph : when it meets a vis vertex in its own path

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V]; // if a V is visited && lies on same path => cycle
        // We backtrack the path to signify a new path
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, path, adj)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int i, boolean[] vis, boolean[] path, ArrayList<ArrayList<Integer>> adj) {
        
        vis[i] = true; path[i] = true;
        for (int neig : adj.get(i)) {
            if (!vis[neig]) {
                if (dfs(neig, vis, path, adj)) return true;
            }
            else if (vis[neig] && path[neig]) return true;
        }
        path[i] = false;
        return false;
    }
}