// like LIS!!!
/* 
Any node might have 'n' ways it could have reached. We need to take count of all.
For a destination node :-
1. if update => TAKE the no. of ways
2. if same => ADD the no. of ways
*/
class Pair {
    int node;
    long time;
    Pair (int node, long time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) { // 0 to n-1
        // create adj list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            long t = road[2];
            adj.get(u).add(new Pair(v, t));
            adj.get(v).add(new Pair(u, t));
        }
        // Dijkstra on time
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        long[] time = new long[n]; Arrays.fill(time, Long.MAX_VALUE);
        int[] ways = new int[n];
        time[0] = 0; ways[0] = 1; // start node
        pq.offer(new Pair(0, 0));

        int mod = (int)(1e9 + 7);
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long tt = curr.time; // total time
            if (tt > time[u]) continue; // no use of checking neigs

            for (Pair neig : adj.get(u)) {
                int v = neig.node;
                long t = neig.time;
                if (tt + t < time[v]) {
                    time[v] = tt + t;
                    pq.offer(new Pair(v, tt + t));
                    ways[v] = ways[u]; // ** 
                }
                else if (tt + t == time[v]) { // **
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}