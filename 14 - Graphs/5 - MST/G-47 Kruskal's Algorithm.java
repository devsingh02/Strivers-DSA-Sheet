// Kruskal's Algorithm : 1) Greedy Algo + 2) No Cycle => Not same subset

// means class 'Edge' is only comparable/compared-to other 'Edge' objects => To sort edges wrt to edgeWt
class Edge implements Comparable<Edge> { 
    int u, v, wt;
    public Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
    // Function Definition which implements the comparasion b/w edges
    @Override
    public int compareTo(Edge other) {
        return this.wt - other.wt;
    }
}

// Create Disjoint Set data structure
class DisjointSet {
    int[] par, rank;
    public DisjointSet(int V) { // 0-based indexing
        par = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            par[i] = i; // each parent of itself at first
            rank[i] = 0;
        }
    }
    
    public int findPar(int x) {
        if (par[x] != x) {
            par[x] = findPar(par[x]); // Path Compression
        }
        return par[x];
    }
    // Union by Rank
    public void union(int x, int y) {
        int px = findPar(x);
        int py = findPar(y);
        
        if (px != py) { // different subset
            if (rank[px] < rank[py]) {
                par[px] = py;
            }
            else if (rank[py] < rank[px]) {
                par[py] = px;
            }
            else {
                par[py] = px;
                rank[px]++;
            }
        }
    }
    
    public boolean isConnected(int x, int y) {
        return findPar(x) == findPar(y);
    }
}

// GFG funtion
// adj -> 0 : [1, 5]  =>  u : [v, wt]
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // convert adjList to edgeList : O(V + E)
        List<Edge> edgeList = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int[] edge : adj.get(u)) {
                int v = edge[0], wt = edge[1];
                edgeList.add(new Edge(u, v, wt));
            }
        }
        // O(ElogE)
        Collections.sort(edgeList); // sort wrt to 'wt's => Build tree with min paths
        
        DisjointSet ds = new DisjointSet(V); // initialise the DS data structure
        
        List<Edge> MST = new ArrayList<>(); // Store all MST Edges
        int MSTwt = 0;
        
        // O(E*4*alhpa*2)
        for (Edge edge : edgeList) {
            int u = edge.u, v = edge.v, wt = edge.wt;
            
            if (!ds.isConnected(u, v)) {
                MSTwt += wt;
                MST.add(new Edge(u, v, wt));
                ds.union(u, v); // build the MST
            }
        }
        
        return MSTwt;
    }
}