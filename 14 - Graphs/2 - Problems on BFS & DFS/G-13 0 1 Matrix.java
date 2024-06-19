// Since we have to reach 0 :- 0s distance from itself is 0. So 
// We treat 0 as starting pt. in BFS

// No diagonals allowed

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        // graph will spread BFSly in all direction from all 0s at the same time
        // => BFS happen from all 0s (since just from one 0 give incorrect dist (dist from that one only) so look from all 0s equally)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] {i, j, 0});
                    vis[i][j] = true;
                }
            }
        }
        // Added all 0s (starting points) in queue

        // Neighbors : up, left, down, right
        int[] dx = {-1,  0, 1, 0};
        int[] dy = { 0, -1, 0, 1};

        // BFS
        while (!q.isEmpty()) {
            int[] node = q.poll();
            dist[node[0]][node[1]] = node[2];
            for (int i = 0; i < 4; i++) {
                int r = node[0] + dx[i];
                int c = node[1] + dy[i];
                if (r >= 0 && r < m && c >= 0 && c < n && !vis[r][c]) {
                    q.offer(new int[] {r, c, node[2] + 1});
                    vis[r][c] = true;
                }
            }
        }
        return dist;
    }
}