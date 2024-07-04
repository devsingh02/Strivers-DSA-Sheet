class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) { // travel on 0s
        int n = grid.length;
        if (grid[0][0] == 1) return -1; // starting pt. doesn't exist
        // {i, j, d}
        // PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // no need of pq since just +1 (unweighted)
        Queue<int[]> pq = new LinkedList<>();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int r = node[0], c = node[1], d = node[2];
            if (d > dist[r][c]) continue;
            // neigs
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int R = r + i, C = c + j;
                    if ((i == 0 && j == 0) || !isSafe(R, C, n, grid)) continue; // skip 
                    if (d + 1 < dist[R][C]) {
                        dist[R][C] = d + 1;
                        pq.offer(new int[]{R, C, d + 1});
                    }
                }
            }
        }
        
        return dist[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1][n - 1] + 1;
    }
    private boolean isSafe(int i, int j, int n, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 1) return false;
        return true; 
    }
}