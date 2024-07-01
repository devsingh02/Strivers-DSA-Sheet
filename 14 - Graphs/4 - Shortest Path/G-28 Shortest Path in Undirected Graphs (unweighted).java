// BFS only good for Unweighted Graphs. For Weighted => Dijkstra's Algorithm
class Solution {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // creating adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // creating dist array
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neig : adj.get(node)) {
                if (dist[neig] == -1) { // unvisited
                    dist[neig] = dist[node] + 1;
                    q.offer(neig);
                }
            }
        }
        
        return dist;
    }
}

// PUTTING DIST = LEVEL
// class Solution {
//     public int[] shortestPath(int[][] edges, int n, int m, int src) {
//         // creating adj list
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>()); // n -> nodes
//         for (int[] edge : edges) {
//             int u = edge[0], v = edge[1];
//             adj.get(u).add(v);
//             adj.get(v).add(u); // undirected
//         }
        
//         int[] dist = new int[n];
//         Arrays.fill(dist, -1);
        
//         // BFS from source
//         boolean[] vis = new boolean[n];
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(src); // source
//         vis[src] = true;
        
        
//         int lvl = 0;
//         while (!q.isEmpty()) {
//             int depth = q.size();
//             for (int i = 0; i < depth; i++) {
//                 int node = q.poll();
//                 dist[node] = lvl;
            
//                 for (int neig : adj.get(node)) {
//                     if (!vis[neig]) {
//                         q.offer(neig);
//                         vis[neig] = true;
//                     }
//                 }
//             }
//             lvl++;
//         }
        
//         return dist;
//     } 
// }