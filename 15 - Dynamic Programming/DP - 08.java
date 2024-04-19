// // Recursive
// class Solution {
//     public int uniquePaths(int m, int n) {
//         return f(m, n);
//     }
//     int f(int m, int n) {
//         if (m == 1 && n == 1) return 1;
//         if (m < 1 || n < 1) return 0;

//         int up = f(m - 1, n);
//         int left = f(m, n - 1);
//         return up + left;
//     }
// }

// // Memo
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i < m + 1; i++) for (int j = 0; j < n + 1; j++) dp[i][j] = -1;
//         return f(m, n, dp);
//     }
//     int f(int m, int n, int[][] dp) {
//         if (m == 1 && n == 1) return 1;
//         if (m < 1 || n < 1) return 0;
//         if (dp[m][n] != -1) return dp[m][n];

//         int up = f(m - 1, n, dp);
//         int left = f(m, n - 1, dp);
//         return dp[m][n] = up + left;
//     }
// }

// // Tabulation
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m + 1][n + 1];
//         dp[1][1] = 1; //BC
//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (i == 1 && j == 1) continue;
//                 int up = dp[i - 1][j]; // becoz only till -1 => only prev row req.
//                 int left = dp[i][j - 1];
//                 dp[i][j] = up + left;
//             }
//         }
//         return dp[m][n];
//     }
// }

// Space Optm.
class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n + 1];
        int[] currRow = new int[n + 1]; 
        currRow[1] = 1; // BC
        //** All same as tabulation
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) continue;
                int up = prevRow[j]; 
                int left = currRow[j - 1];
                currRow[j] = up + left;
            }
            prevRow = currRow; //** updation */
        }
        return currRow[n];
    }
}