// problem link :- https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find_the_number_of_islands

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        for (int dr = -1; dr <= 1; dr++) { // neighbors
            for (int dc = -1; dc <= 1; dc++) {
                int r = i + dr; int c = j + dc;
                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue;
                if (!vis[r][c] && grid[r][c] == '1') dfs(r, c, grid, vis);
            }
        }
    }
}