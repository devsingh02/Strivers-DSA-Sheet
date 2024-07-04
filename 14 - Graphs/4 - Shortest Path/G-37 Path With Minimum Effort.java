class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // [i, j, e] => {e} is the constraint
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] efforts = new int[m][n];
        for (int[] row : efforts) Arrays.fill(row, Integer.MAX_VALUE);
        efforts[0][0] = 0; // start
        pq.offer(new int[]{0, 0, 0});

        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int r = node[0], c = node[1], e = node[2];
            // stop will be popped only when its the min remaining effort. Therefore no need to calc further
            if (r == m - 1 && c == n - 1) return e; // We reached the target cell
            if (e > efforts[r][c]) continue;

            for (int i = 0; i < 4; i++) {
                int R = r + dr[i], C = c + dc[i];
                if (!isSafe(R, C, m, n)) continue;

                int neweff = Math.max(Math.abs(heights[R][C] - heights[r][c]), e); // keep track of max effort for each path
                if (neweff < efforts[R][C]) {
                    efforts[R][C] = neweff;
                    pq.offer(new int[]{R, C, neweff});
                }
            }
        }

        return 0; // should never reach here
    }
    private boolean isSafe(int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        return true;
    }
}