// https://www.geeksforgeeks.org/problems/eventual-safe-states/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states

// safe node : every possible path starting from that node leads to a terminal node.
// A node is a terminal node if there are no outgoing edges. 

class Solution {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        boolean[] safe = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) dfs(i, vis, path, safe, adj); // no need to return
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) ans.add(i);
        }
        return ans;
    }
    
    boolean dfs(int i, boolean[] vis, boolean[] path, boolean[] safe, List<List<Integer>> adj) {
        vis[i] = true;
        path[i] = true;
        
        for (int neig : adj.get(i)) {
            if (!vis[neig]) {
                if (dfs(neig, vis, path, safe, adj)) return true;
            } // This bracket is imp. or else-if will be applied on latest/just upper if loop
            else if (vis[neig] && path[neig]) return true; // Cycle detected
        }
        // Will return in this for loop only if cycle detected
        
        // If no cycle detected, this portion will run & node will be marked safe
        path[i] = false; // backtrack
        safe[i] = true; // This node is safe since no cycles were found in its DFS path
        return false;
    }
}