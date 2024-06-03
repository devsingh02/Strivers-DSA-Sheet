/* Perform :-
    Integer.MAX_VALUE / 2 : to prevent overflow 
*/

// // Recursive
// class Solution {
//     public int minPathSum(int[][] grid) {
//         iint = grid.length;
//         int n = grid[0].length;
//         return (int)f(m, n, grid);
//     }
//     int f(int m, int n, int[][] grid) {
//         if (m == 1 && n == 1) return grid[0][0];
//         if (m < 1 || n < 1) return Integer.MAX_VALUE / 2;

//         int up = grid[m - 1][n - 1] + f(m - 1, n , grid);
//         int left = grid[m - 1][n - 1] + f(m, n - 1, grid);

//         return Math.min(up, left);
//     }
// }

// // Memo
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length; int n = grid[0].length;
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i < m + 1; i++) for (int j = 0; j < n + 1; j++) dp[i][j] = -1;
//         return f(m, n, grid, dp);
//     }
//     int f(int m, int n, int[][] grid, int[][] dp) {
//         if (m == 1 && n == 1) return grid[0][0];
//         if (m < 1 || n < 1) return Integer.MAX_VALUE / 2;
//         if (dp[m][n] != -1) return dp[m][n];

//         int up = grid[m - 1][n - 1] + f(m - 1, n , grid, dp);
//         int left = grid[m - 1][n - 1] + f(m, n - 1, grid, dp);

//         return dp[m][n] = Math.min(up, left);
//     }
// }

// // Tabulation
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length; int n = grid[0].length;
//         int[][] dp = new int[m + 1][n + 1];

//         // BCs
//         dp[1][1] = grid[0][0];
//         for (int i = 0; i < m + 1; i++) dp[i][0] = Integer.MAX_VALUE / 2;
//         for (int j = 0; j < n + 1; j++) dp[0][j] = Integer.MAX_VALUE / 2;


//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (i == 1 && j == 1) continue;

//                 int up = grid[i - 1][j - 1] + dp[i - 1][j];
//                 int left = grid[i - 1][j - 1] + dp[i][j - 1];
//                 dp[i][j] = Math.min(up, left);
//             }
//         }
//         return dp[m][n];
//     }
// }

// Space Optm.
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int[] prevRow = new int[n + 1]; int[] currRow = new int[n + 1];
        // BCs
        for (int j = 0; j < n + 1; j++) prevRow[j] = Integer.MAX_VALUE / 2;
        currRow[1] = grid[0][0]; currRow[0] = Integer.MAX_VALUE / 2; 

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) continue;
                
                int up = grid[i - 1][j - 1] + prevRow[j];
                int left = grid[i - 1][j - 1] + currRow[j - 1];
                currRow[j] = Math.min(up, left);
            }
            prevRow = currRow.clone();
        }
        return currRow[n];
    }
}