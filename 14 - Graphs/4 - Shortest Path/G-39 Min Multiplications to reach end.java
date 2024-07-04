// Minimum Steps => Dijkstra on Steps (+1 therefore queue)
// 0 - 99999 nodes

class Pair {
    int node;
    int steps;
    Pair(int node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        dist[start] = 0;
        q.offer(new Pair(start, 0));
        
        int mod = 100000;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.node, td = curr.steps;
            if (td > dist[u]) continue; // constraint
            
            if (u == end) return td; // We can terminate early if Queue (BFS)
            for (int neig : arr) {
                int v = (u * neig) % mod; // d = 1;
                if (td + 1 < dist[v]) {
                    dist[v] = td + 1;
                    q.offer(new Pair(v, td + 1));
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
}