class MST {
    static int MSTSum(int V, int E, List<List<int[]>> adj) {

        List<List<Integer>> MST = new ArrayList<>(); // store MST edges : [parent, node]
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // edges pushed [node, parent, wt]
        pq.offer(new int[]{0, -1, 0}); // [node, parent, wt]

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // shortest edge (greedy)
            int u = curr[0], par = curr[1], wt = curr[2];

            if (vis[u]) continue;
            vis[u] = true; // Mark as visited when adding to MST

            if (par != -1) {
                List<Integer> edge = new ArrayList<>(); // Add edge to MST
                edge.add(par); edge.add(u);
                MST.add(edge);
                sum += wt;
            }

            for (int[] neig : adj.get(u)) {
                int v = neig[0], edgeWt = neig[1];
                if (!vis[v]) pq.offer(new int[]{v, u, edgeWt});
            }
        }

        // Print MST edges
        System.out.println(MST);
        return sum;
    }
    public static void main(String[] args) {
        // Number of vertices and edges
        int V = 5;
        int E = 6;

        // Create adjacency list
        List<List<int[]>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);

        // Find minimum spanning tree
        int minWeight = MSTSum(V, E, adj);

        System.out.println("Weight of Minimum Spanning Tree: " + minWeight);
    }

    // Helper method to add an undirected edge
    private static void addEdge(List<List<int[]>> adj, int u, int v, int wt) {
        adj.get(u).add(new int[]{v, wt});
        adj.get(v).add(new int[]{u, wt});
    }
}