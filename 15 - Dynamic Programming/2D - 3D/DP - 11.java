// // Recursive
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return f(0, 0, triangle);
//     }
//     int f(int i, int j, List<List<Integer>> tri) {
//         if (i == tri.size()) return 0;

//         int either = tri.get(i).get(j) + f(i + 1, j, tri);
//         int or = tri.get(i).get(j) + f(i + 1, j + 1, tri);
//         return Math.min(either, or);
//     }
// }

// Memo
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) for (int j = 0; j < n + 1; j++) dp[i][j] = -1;
        return f(0, 0, triangle, dp);
    }
    int f(int i, int j, List<List<Integer>> tri, int[][] dp) {
        if (i == tri.size()) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int either = tri.get(i).get(j) + f(i + 1, j, tri, dp);
        int or = tri.get(i).get(j) + f(i + 1, j + 1, tri, dp);
        return dp[i][j] = Math.min(either, or);
    }
}

/* Do Tabulation in opposite direction of Memoization
*/
// // Tabulation
// class Solution {
//     public int minimumTotal(List<List<Integer>> tri) {
//         int n = tri.size();
//         int[][] dp = new int[n + 1][n + 1];

//         for (int i = n - 1; i >= 0; i--) {
//             for (int j = 0; j <= i; j++) {
//                 int either = tri.get(i).get(j) + dp[i + 1][j];
//                 int or = tri.get(i).get(j) + dp[i + 1][j + 1];
//                 dp[i][j] = Math.min(either, or);
//             }
//         }
//         return dp[0][0];
//     }
// }

// // Space Optm.
// class Solution {
//     public int minimumTotal(List<List<Integer>> tri) {
//         int n = tri.size();
//         int[] currRow = new int[n + 1]; int[] nextRow = new int[n + 1];

//         for (int i = n - 1; i >= 0; i--) {
//             for (int j = 0; j <= i; j++) {
//                 int either = tri.get(i).get(j) + nextRow[j];
//                 int or = tri.get(i).get(j) + nextRow[j + 1];
//                 currRow[j] = Math.min(either, or);
//             }
//             nextRow = currRow.clone();
//         }
//         return currRow[0];
//     }
// }