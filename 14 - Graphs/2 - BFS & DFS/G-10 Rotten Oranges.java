class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>(); // {row, col, time}
        int m = grid.length, n = grid[0].length;

        // fill all rotting oranges in the queue
        int fo = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[] {i, j, 0}); // t = 0
                else if (grid[i][j] == 1) fo++;
            }
        }
        // coordinates of neighbors
        int[] di = {-1,  0, 1, 0};
        int[] dj = { 0, -1, 0, 1};

        // BFS
        int time = 0;
        while (!q.isEmpty()) { // imp. since if fo = 0 it will still execute once more
            int[] rot = q.poll(); // {i, j}
            time = rot[2];
            for (int j = 0; j < 4; j++) { //neighbors
                int r = rot[0] + di[j];
                int c = rot[1] + dj[j];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    q.offer(new int[] {r, c, time + 1});
                    grid[r][c] = 2; //rotted the fresh orange
                    fo--;
                }
            }
        }
        return fo == 0 ? time : -1;
    }
}