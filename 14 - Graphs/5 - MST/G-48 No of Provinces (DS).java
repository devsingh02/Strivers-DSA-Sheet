// Dijoint Set Solution
class DisjointSet {
    int[] par, rank;
    DisjointSet(int V) {
        par = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }
    
    int findPar(int x) {
        if (par[x] != x) {
            par[x] = findPar(par[x]);
        }
        return par[x];
    }
    
    void union(int x, int y) {
        int px = findPar(x);
        int py = findPar(y);
        
        if (px != py) { // not same subset
            if (rank[px] < rank[py]) par[px] = py;
            else if (rank[py] < rank[px]) par[py] = px;
            else {
                par[py] = px;
                rank[px]++;
            }
        }
    }
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);
        
        // accessing all edges => creating provinces
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (adj.get(u).get(v) == 1) {
                    ds.union(u, v);
                }
            }
        }
        int bosses = 0;
        for (int u = 0; u < V; u++) {
            if (ds.par[u] == u) bosses++;
        }
        
        return bosses;
    }
}