//* array by default -> false
import java.util.* ;
import java.io.*; 

// // Memo
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         boolean[][] dp = new boolean[n + 1][k + 1];
//         for (boolean[] row : dp) Arrays.fill(row, false);
//         return f(n, k, arr, dp);
//     }
//     static boolean f(int n, int k, int arr[], boolean[][] dp) {
//         if (k == 0) return true;
//         if (n == 0 || k < 0) return false;
//         if (dp[n][k] != false) return dp[n][k];
        
//         int curr = arr[n - 1];
//         boolean take = f(n - 1, k - curr, arr, dp);
//         boolean leave = f(n - 1, k, arr, dp);
//         return dp[n][k] = take || leave;
//     }
// }

// //Tabulation
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         boolean[][] dp = new boolean[n + 1][k + 1];
//         for (int i = 0; i < n + 1; i++ ) dp[i][0] = true;

//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 1; j < k + 1; j++) {
//                 int curr = arr[i - 1];
//                 boolean take = (j - curr >= 0) ? dp[i - 1][j - curr] : false;
//                 boolean leave = dp[i - 1][j];
//                 dp[i][j] = take || leave;
//             }
//         }
//         return dp[n][k];
//     }
// }

//Spae Optm.
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[] prevRow = new boolean[k + 1];
        prevRow[0] = true;

        for (int i = 1; i < n + 1; i++) {
            boolean[] currRow = new boolean[k + 1]; currRow[0] = true;
            for (int j = 1; j < k + 1; j++) {
                int curr = arr[i - 1];
                boolean take = (j - curr >= 0) ? prevRow[j - curr] : false;
                boolean leave = prevRow[j];
                currRow[j] = take || leave;
            }
            prevRow = currRow;
        }
        return prevRow[k];
    }
}