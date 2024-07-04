// // int[] Method
// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         // create adj list
//         List<List<int[]>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
//         for (int[] edge : times) {
//             int u = edge[0], v = edge[1], w = edge[2];
//             adj.get(u).add(new int[]{v, w});
//         }
//         // dijkstra on time
//         int[] time = new int[n]; // 0 index -> 1 // accessed as i - 1
//         Arrays.fill(time, Integer.MAX_VALUE);
//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//         time[k - 1] = 0; // kth index
//         pq.offer(new int[]{k, 0});

//         while (!pq.isEmpty()) {
//             int[] node = pq.poll();
//             int u = node[0], tt = node[1]; // tt -> total time
            
//             if (tt > time[u - 1]) continue;
//             for (int[] neig : adj.get(u)) {
//                 int v = neig[0], t = neig[1];
//                 if (tt + t < time[v - 1]) {
//                     time[v - 1] = tt + t;
//                     pq.offer(new int[]{v, tt + t});
//                 }
//             }
//         }

//         int maxTime = 0; 
//         for (int i = 0; i < n; i++) {
//             if (time[i] == Integer.MAX_VALUE) return -1;
//             if (maxTime < time[i]) maxTime = time[i];
//         }
//         return maxTime;
//     }
// }

// class Method : Better than array int[] method
class Pair {
    int node;
    int time;
    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create adj list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }
        // dijkstra on time
        int[] time = new int[n]; // 0 index -> 1 // accessed as i - 1
        Arrays.fill(time, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        time[k - 1] = 0; // kth index
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node, tt = curr.time; // tt -> total time
            
            if (tt > time[u - 1]) continue;
            for (Pair neig : adj.get(u)) {
                int v = neig.node, t = neig.time;
                if (tt + t < time[v - 1]) {
                    time[v - 1] = tt + t;
                    pq.offer(new Pair(v, tt + t));
                }
            }
        }

        int maxTime = 0; 
        for (int i = 0; i < n; i++) {
            if (time[i] == Integer.MAX_VALUE) return -1;
            if (maxTime < time[i]) maxTime = time[i];
        }
        return maxTime;
    }
}