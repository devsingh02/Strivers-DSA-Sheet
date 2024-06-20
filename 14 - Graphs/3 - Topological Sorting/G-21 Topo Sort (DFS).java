// Just add 'i' to Stack when its DFS is complete.

class Solution
{   //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) dfs(i, vis, st, adj);
        }
        
        int[] ans = new int[V];
        for (int i = 0; i < V; i++) {
            ans[i] = st.pop();
        }
        return ans;
    }
    static void dfs(int i, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        for (int neig : adj.get(i)) {
            if (!vis[neig]) dfs(neig, vis, st, adj);
        }
        st.push(i);
    }
}