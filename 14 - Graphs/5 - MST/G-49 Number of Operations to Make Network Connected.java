// 1. DS Soln (Much Faster than DFS)
class DisjointSet {
    int[] par, rank;
    DisjointSet(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    int findPar(int x) {
        if (par[x] != x) {
            par[x] = findPar(par[x]); // Path Compression
        }
        return par[x];
    }

    void union(int x, int y) {
        int px = findPar(x);
        int py = findPar(y);
        if (px != py) {
            if (rank[px] < rank[py]) par[px] = py;
            else if (rank[py] < rank[px]) par[py] = px;
            else {
                par[py] = px;
                rank[px]++;
            }
        }
    }

    boolean isConnected(int x, int y) {
        return findPar(x) == findPar(y);
    }
}
// EITHER :-
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        // Find extra Edges
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];

            if (ds.isConnected(u, v)) extraEdges++;
            else ds.union(u, v);
        }
        // Find no. of Components (not connected)
        int comps = 0;
        for (int i = 0; i < n; i++) {
            if (i == ds.par[i]) comps++;
        }
        // Return no. of changes to be made : min edges req to connect components = comps - 1
        if (extraEdges >= comps - 1) return comps - 1;
        else return -1;
    }
}
// OR :- (no need to find extra edges)
class Solution {
    public int makeConnected(int n, int[][] connections) {
        // only case when not possible is when {T.edges < n - 1}
        if (connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            ds.union(u, v);
        }
        // Find no. of Components (not connected)
        int comps = 0;
        for (int i = 0; i < n; i++) {
            if (i == ds.par[i]) comps++;
        }
        // Return no. of changes to be made : min edges req to connect components = comps - 1
        return comps - 1;
    }
}

// // 2. DFS Soln
// class Solution {
//     public int makeConnected(int n, int[][] connections) {
//         // Check the only cond. when not possible
//         if (connections.length < n - 1)
//             return -1;
//         // Create Adj List
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
//         for (int[] edge : connections) {
//             int u = edge[0], v = edge[1];
//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }
//         // Perform DFS to find all connected/visited nodes + Calc components
//         int comps = 0;
//         boolean[] vis = new boolean[n];
//         for (int i = 0; i < n; i++) {
//             if (!vis[i]) {
//                 dfs(i, vis, adj);
//                 comps++;
//             }
//         }
//         // return ans
//         return comps - 1;
//     }

//     void dfs(int i, boolean[] vis, List<List<Integer>> adj) {
//         vis[i] = true;
//         for (int neig : adj.get(i)) {
//             if (!vis[neig]) dfs(neig, vis, adj);
//         }
//     }
// }