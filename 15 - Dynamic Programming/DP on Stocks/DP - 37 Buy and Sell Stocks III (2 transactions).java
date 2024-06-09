// // Approach I : 3 changing variables
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         return f(0, 1, 2, n, prices); 
//     }
//     int f(int i, int buy, int trans, int n, int[] p) {
//         if (i == n) return 0;
//         if (trans == 0) return 0;
//         // transaction complete when sold the share
//         int profit = 0;
//         if (buy == 1) {
//             profit = Math.max(-p[i] + f(i + 1, 0, trans, n, p),
//                             f(i + 1, 1, trans, n, p));
//         }
//         else {
//             profit = Math.max(p[i] + f(i + 1, 1, trans - 1, n, p),
//                             f(i + 1, 0, trans, n, p));
//         }
//         return profit;
//     }
// }

// Approach II : 2 changing variables
// for n transaction = k = 2 * n
// k = 1, 2, 3, 4 => even : buy , odd : sell  +  no. of transactions = 2 * 2 = 4 ✔
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return f(0, 4, n, prices); 
    }
    int f(int i, int k, int n, int[] p) {
        if (i == n) return 0;
        if (k == 0) return 0;
        // transaction complete when sold the share
        int profit = 0;
        if (k % 2 == 0) { // BUY  (at k = 4 buy)
            profit = Math.max(-p[i] + f(i + 1, k - 1, n, p),
                            f(i + 1, k, n, p));
        }
        else {
            profit = Math.max(p[i] + f(i + 1, k - 1, n, p),
                            f(i + 1, k, n, p));
        }
        return profit;
    }
}

// // MEMOIZATION
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n + 1][4 + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);
//         return f(0, 4, n, prices, dp); 
//     }
//     int f(int i, int k, int n, int[] p, int[][] dp) {
//         if (i == n || k == 0) return 0;
//         if (dp[i][k] != -1) return dp[i][k];

//         // transaction complete when sold the share
//         int profit = 0;
//         if (k % 2 == 0) { // BUY  (at k = 4 buy)
//             profit = Math.max(-p[i] + f(i + 1, k - 1, n, p, dp),
//                             f(i + 1, k, n, p, dp));
//         }
//         else {
//             profit = Math.max(p[i] + f(i + 1, k - 1, n, p, dp),
//                             f(i + 1, k, n, p, dp));
//         }
//         return dp[i][k] = profit;
//     }
// }

// // TABULATION
// class Solution {
//     public int maxProfit(int[] p) {
//         int n = p.length;
//         int[][] dp = new int[n + 1][4 + 1];
        
//         for (int i = n - 1; i >= 0; i--) {
//             for (int k = 4; k >= 1; k--) {
//                 int profit = 0;
//                 if (k % 2 == 0) { // BUY  (at k = 4 buy)
//                     profit = Math.max(-p[i] + dp[i + 1][k - 1],
//                                     dp[i + 1][k]);
//                 }
//                 else {
//                     profit = Math.max(p[i] + dp[i + 1][k - 1],
//                                     dp[i + 1][k]);
//                 }
//                 dp[i][k] = profit;                
//             }
//         }
//         return dp[0][4];
//     }
// }

// // SPACE OPTM
// class Solution {
//     public int maxProfit(int[] p) {
//         int n = p.length;
//         int[] nextR = new int[4 + 1];
        
//         for (int i = n - 1; i >= 0; i--) {
//             int[] currR = new int[4 + 1];
//             for (int k = 4; k >= 1; k--) {
//                 int profit = 0;
//                 if (k % 2 == 0) { // BUY  (at k = 4 buy)
//                     profit = Math.max(-p[i] + nextR[k - 1],
//                                     nextR[k]);
//                 }
//                 else {
//                     profit = Math.max(p[i] + nextR[k - 1],
//                                     nextR[k]);
//                 }
//                 currR[k] = profit;                
//             }
//             nextR = currR;
//         }
//         return nextR[4];
//     }
// }