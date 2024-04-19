// // Recursive
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int min = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             int ans = f(0, j, matrix);
//             min = Math.min(min, ans);
//         }
//         return min;
//     }
//     int f(int i, int j, int[][] mat) {
//         if (i == mat.length) return 0;
//         if (j < 0 || j == mat.length) return Integer.MAX_VALUE / 2;

//         int d = mat[i][j] + f(i + 1, j, mat);
//         int ld = mat[i][j] + f(i + 1, j - 1, mat);
//         int rd = mat[i][j] + f(i + 1, j + 1, mat);

//         return Math.min(Math.min(d, ld), rd);
//     }
// }

// // Memo 
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int[][] dp = new int[n + 1][n + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);

//         int min = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             int ans = f(0, j, matrix, dp);
//             min = Math.min(min, ans);
//         }
//         return min;
//     }
//     int f(int i, int j, int[][] mat, int[][] dp) {
//         if (i == mat.length) return 0;
//         if (j < 0 || j > mat.length - 1) return Integer.MAX_VALUE / 2;
//         if (dp[i][j] != -1) return dp[i][j];

//         int d = mat[i][j] + f(i + 1, j, mat, dp);
//         int ld = mat[i][j] + f(i + 1, j - 1, mat, dp);
//         int rd = mat[i][j] + f(i + 1, j + 1, mat, dp);
//         return dp[i][j] = Math.min(Math.min(d, ld), rd);
//     }
// }

// // Tabulation
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int[][] dp = new int[n + 1][n + 1];
//         // 1) BCs (not initializable in dp array -> out of bounds)
//         // 2) Code
//         for (int i = n - 1; i >= 0; i--) {
//             for (int j = 0; j < n; j++) {
//                 int d = dp[i + 1][j];
//                 int ld = (j - 1 >= 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE / 2;
//                 int rd = (j + 1 <= n - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE / 2;
//                 dp[i][j] = matrix[i][j] + Math.min(Math.min(d, ld), rd);
//             }
//         }
//         // 3) Code Implementation
//         int min = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             int ans = dp[0][j];
//             min = Math.min(min, ans);
//         }
//         return min;
//     }
// }

// Space Optm.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] currRow = new int[n + 1]; int nextRow[] = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int d = nextRow[j];
                int ld = (j - 1 >= 0) ? nextRow[j - 1] : Integer.MAX_VALUE / 2;
                int rd = (j + 1 <= n - 1) ? nextRow[j + 1] : Integer.MAX_VALUE / 2;
                currRow[j] = matrix[i][j] + Math.min(Math.min(d, ld), rd);
            }
            nextRow = currRow.clone();
        }
        // 3) Code Implementation
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int ans = currRow[j];
            min = Math.min(min, ans);
        }
        return min;
    }
}