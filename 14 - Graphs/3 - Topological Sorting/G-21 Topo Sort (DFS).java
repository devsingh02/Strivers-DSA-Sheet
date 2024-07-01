// Topo Sort (DFS) => Just add 'i' to Stack when its DFS is complete.
// Topo Sort only possible for ***DAGs (Directed Acyclic Graphs)***

class Solution {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V]; // need path since if a cycle, topo sort not possible => return empty array
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) if (dfsCycle(i, vis, path, st, adj)) return new int[0]; // if cycle found => return empty array
        }
        // No cycle found => means stack answer is correct
        int[] topo = new int[st.size()];
        for (int i = 0; i < topo.length; i++) topo[i] = st.pop();
        return topo;
    }
    boolean dfsCycle(int i, boolean[] vis, boolean[] path, Stack<Integer> st, List<List<Integer>> adj) {
        vis[i] = true;
        path[i] = true;
        for (int neig : adj.get(i)) {
            if (!vis[neig]) {
                if (dfsCycle(neig, vis, path, st, adj)) return true; // cycle found in future, end here
            }
            else if (vis[neig] && path[neig]) return true; // cycle found here
        }
        path[i] = false;
        st.push(i);
        return false; // no cycle
    }
}



// BASIC :-
// // This will not work for !DAGs.
// // Will have to store path[] and check for cycle in that case. (refer G-24.2 Course Schedule.java)

// class Solution
// {   //Function to return list containing vertices in Topological order. 
//     static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean[] vis = new boolean[V];
//         // boolean[] path = new boolean[V]; no path since no need to detect cycle => if cycle exists then already topo sort will give wrong answer.

//         Stack<Integer> st = new Stack<>();
        
//         for (int i = 0; i < V; i++) {
//             if (!vis[i]) dfs(i, vis, st, adj);
//         }
        
//         int[] ans = new int[V];
//         for (int i = 0; i < V; i++) {
//             ans[i] = st.pop();
//         }
//         return ans;
//     }
//     static void dfs(int i, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
//         vis[i] = true;
//         for (int neig : adj.get(i)) {
//             if (!vis[neig]) dfs(neig, vis, st, adj);
//         }
//         st.push(i);
//     }
// }