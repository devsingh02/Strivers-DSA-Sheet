// // SOLN I
// class Solution {
//     int numEnclaves(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         boolean[][] vis = new boolean[m][n];
        
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
//                     if (grid[i][j] == 1) dfs(i, j, vis, grid);
//                 }
//             }
//         }
        
//         int count = 0; 
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (!vis[i][j] && grid[i][j] == 1) count++;
//             }
//         }
//         return count;
//     }
    
//     void dfs(int i, int j, boolean[][] vis, int[][] grid) {
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) return;
        
//         vis[i][j] = true;
//         dfs(i - 1, j, vis, grid);
//         dfs(i, j - 1, vis, grid);
//         dfs(i + 1, j, vis, grid);
//         dfs(i, j + 1, vis, grid);
//     }
// }

// OR we can make all boundary 1s -> 0s, then count the remaining 1s. Better Soln. but doesn't preseverve the orginal data.
// SOLN II
class Solution {
    int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 1) dfs(i, j, grid);
                }
            }
        }
        
        int count = 0; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    
    void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        
        grid[i][j] = 0;
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
    }
}