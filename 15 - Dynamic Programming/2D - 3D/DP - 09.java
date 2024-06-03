// // Recursion
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         return f(m, n, obstacleGrid);
//     }
//     int f(int m, int n, int[][] grid) {
//         if (m == 1 && n == 1) return 1;
//         if (m < 1 || n < 1) return 0;
//         if (grid[m - 1][n - 1] == 1) return 0;

//         int up = f(m - 1, n, grid);
//         int left = f(m, n - 1, grid);
//         return up + left;
//     }
// }

// // Memo
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i < m + 1; i++) for (int j = 0; j < n + 1; j++) dp[i][j] = -1;
//         return f(m, n, obstacleGrid, dp);
//     }
//     int f(int m, int n, int[][] grid, int[][] dp) {
//         if (m == 1 && n == 1) return 1;
//         if (m < 1 || n < 1) return 0;
//         if (grid[m - 1][n - 1] == 1) return 0;
//         if (dp[m][n] != -1) return dp[m][n];

//         int up = f(m - 1, n, grid, dp);
//         int left = f(m, n - 1, grid, dp);
//         return dp[m][n] = up + left;
//     }
// }

// // Tabulation
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] dp = new int[m + 1][n + 1];
//         dp[1][1] = 1;
//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (i == 1 && j == 1) continue;
//                 if (obstacleGrid[i - 1][j - 1] == 1) {dp[i][j] = 0; continue;}

//                 int up = dp[i - 1][j];
//                 int left = dp[i][j - 1];
//                 dp[i][j] = up + left;
//             }
//         }
//         return dp[m][n];
//     }
// }

// Space Optm.
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //**Edge Case
        if (obstacleGrid[0][0] == 1) return 0;
        //
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prevRow = new int[n + 1];
        int[] currRow = new int[n + 1];
        currRow[1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) continue;
                if (obstacleGrid[i - 1][j - 1] == 1) {currRow[j] = 0; continue;}

                int up = prevRow[j];
                int left = currRow[j - 1];
                currRow[j] = up + left;
            }
            prevRow = currRow;
        }
        return currRow[n];
    }
}