// Since constraint on k-Stops :- we apply dijkstra on stops.
// And since stops +1, +1, +1 => We can use Queue also instead of PQ

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // creating adj list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], p = flight[2];
            adj.get(u).add(new int[]{v, p});
        }
        // {node, price, stop}
        Queue<int[]> q = new LinkedList<>();
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        q.offer(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int u = node[0], tp = node[1], stops = node[2]; // total price
            if (stops > k) continue; // constraint***
            
            for (int[] neig : adj.get(u)) {
                int v = neig[0], p = neig[1];
                if (tp + p < price[v]) {
                    price[v] = tp + p;
                    q.offer(new int[]{v, price[v], stops + 1});
                }
            }
        }

        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}