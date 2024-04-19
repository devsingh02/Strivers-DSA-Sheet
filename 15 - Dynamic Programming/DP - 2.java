// // Recursive
// class Solution {
//     public int climbStairs(int n) {
//         return f(n);
//     }
//     int f(int n) {
//         if (n == 0) return 1;
//         if (n < 0) return 0;
//         return f(n - 1) + f(n - 2);
//     }
// }

// // Memoization
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         for (int i = 0; i < n + 1; i++) dp[i] = -1;
//         return f(n, dp);
//     }
//     int f(int n, int[] dp) {
//         if (n == 0) return 1;
//         if (n < 0) return 0;
//         if (dp[n] != -1) return dp[n];
//         return dp[n] = f(n - 1, dp) + f(n - 2, dp);
//     }
// }

// // Tabulation
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         dp[0] = 1; //BC
//         for (int i = 1; i < n + 1; i++) {
//             dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 0);
//         }
//         return dp[n];
//     }
// }

// Space Optm.
class Solution {
    public int climbStairs(int n) {
        int prev1 = 1, prev2 = 0; //BC
        for (int i = 1; i < n + 1; i++) {
            int curr = prev1 + (i - 2 >= 0 ? prev2 : 0);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}