// // Recursive
// public class Solution {
//     public static int ninjaTraining(int n, int points[][]) {
//         return f(n, 3, points);
//     }
//     static int f(int n, int prev, int pts[][]) {
//         if (n == 0) return 0;
        
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < 3; i++) {
//             if (i == prev) continue;
//             int take = pts[n - 1][i] + f(n - 1, i, pts);
//             max = Math.max(max, take);
//         }
//         return max;
//     }
// }

// // Memo
// public class Solution {
//     public static int ninjaTraining(int n, int points[][]) {
//         int[][] dp = new int[n + 1][3 + 1];
//         for (int i = 0; i < n + 1; i++) for (int j = 0; j < 4; j++) dp[i][j] = -1;
//         return f(n, 3, points, dp);
//     }
//     static int f(int n, int prev, int pts[][], int[][] dp) {
//         if (n == 0) return 0;
//         if (dp[n][prev] != -1) return dp[n][prev];
        
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < 3; i++) {
//             if (i == prev) continue;
//             int take = pts[n - 1][i] + f(n - 1, i, pts, dp);
//             max = Math.max(max, take);
//         }
//         return dp[n][prev] = max;
//     }
// }

// // Tabulation
// public class Solution {
//     public static int ninjaTraining(int n, int points[][]) {
//         int[][] dp = new int[n + 1][3 + 1];

//         //** First make all changing variable for loops
//         for (int i = 1; i < n + 1; i++) {
//             for (int prev = 0; prev < 4; prev++) {

//                 //** Then copy paste memo code as it is
//                 int max = Integer.MIN_VALUE;
//                 for (int j = 0; j < 3; j++) {
//                     if (j == prev) continue;
//                     int take = points[i - 1][j] + dp[i - 1][j];
//                     max = Math.max(max, take);
//                 }
//                 dp[i][prev] = max;
//             }
//         }
//         return dp[n][3];
//     }
// }

// Space Optm.
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
       int[] prevRow = new int[3 + 1]; //BC (already 0s)
       int[] currRow = new int[3 + 1];

        //** First make all changing variable for loops
        for (int i = 1; i < n + 1; i++) {
            for (int prev = 0; prev < 4; prev++) {
                
                //** Then copy paste memo code as it is
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < 3; j++) {
                    if (j == prev) continue;
                    int take = points[i - 1][j] + prevRow[j];
                    max = Math.max(max, take);
                }
                currRow[prev] = max;
            }
            prevRow = currRow.clone(); //**Way of putting one array into another
        }
        return currRow[3];
    }
}