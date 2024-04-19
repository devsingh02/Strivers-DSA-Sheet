/* Learn to take modulos :-
    10 ^ 9 + 7 = 1000000007
*/

import java.util.*;
import java.io.*;

/* Good for POSITIVE INTEGERS but NOT if CONTAINING 0s */
// // Recursive
// public class Solution {
//     public static int findWays(int num[], int tar) {
//         int n = num.length;
//         return f(n, tar, num);
//     }
//     static int f(int n, int k, int[] nums) {
//         if (k == 0) return 1;
//         if(n == 0 || k < 0) return 0;
        
//         int curr = nums[n - 1];
//         int take = f(n - 1, k - curr, nums);
//         int leave = f(n - 1, k, nums);
//         return take + leave;
//     }
// }

// // Memo
// public class Solution {
//     public static int findWays(int num[], int tar) {
//         int n = num.length, k = tar;
//         int[][] dp = new int[n + 1][k + 1]; for (int[] row : dp) Arrays.fill(row, -1);
//         return f(n, k, num, dp);
//     }
//     static int f(int n, int k, int[] nums, int[][] dp) {
//         // if (k == 0) return 1; // cant since will not take 0s
//         if (n == 0 || k < 0) return 0;
//         if (dp[n][k] != -1) return dp[n][k];

//         int curr = nums[n - 1]; int take = 0;
//         if (curr == k) take += 1;
//         take += f(n - 1, k - curr, nums, dp);
//         int leave = f(n - 1, k, nums, dp);
//         return dp[n][k] = (take + leave) % 1000000007;
//     }
// }

// /* For k == 0 -> We have to calculate -> so start from j = 0 */
// // Tabulation
// public class Solution {
//     public static int findWays(int nums[], int tar) {
//         int n = nums.length, k = tar;
//         int[][] dp = new int[n + 1][k + 1];
        
//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 0; j < k + 1; j++) {
//                 int curr = nums[i - 1]; int take = 0;
//                 if (curr == j ) take += 1;
//                 take += (j - curr >= 0) ? dp[i - 1][j - curr] : 0; // handled k < 0 dont take
//                 int leave = dp[i - 1][j];
//                 dp[i][j] = (take + leave) % 1000000007;
//             }
//         }
//         return dp[n][k];
//     }
// }

// Space Optm.
public class Solution {
    public static int findWays(int nums[], int tar) {
        int n = nums.length, k = tar;
        int[] prevRow = new int[k + 1];

        for (int i = 1; i < n + 1; i++) {
            int[] currRow = new int[k + 1];
            for (int j = 0; j < k + 1; j++) {
                int curr = nums[i - 1]; int take = 0;
                if (curr == j) take += 1;
                take += (j - curr >= 0) ? prevRow[j - curr] : 0; // handled k < 0
                int leave = prevRow[j];
                currRow[j] = (take + leave) % 1000000007;
            }
            prevRow = currRow;
        }
        return prevRow[k];
    }
}