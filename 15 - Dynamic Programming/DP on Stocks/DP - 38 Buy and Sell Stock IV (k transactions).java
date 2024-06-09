// // MEMOIZED
// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n + 1][2 * k + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);
//         return f(0, 2 * k, n, prices, dp); 
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
//     public int maxProfit(int k, int[] p) {
//         int n = p.length;
//         int trans = 2 * k;
//         int[][] dp = new int[n + 1][trans + 1];
        
//         for (int i = n - 1; i >= 0; i--) {
//             for (int K = trans; K >= 1; K--) {
//                 int profit = 0;
//                 if (K % 2 == 0) { // BUY  (at k = 4 buy)
//                     profit = Math.max(-p[i] + dp[i + 1][K - 1],
//                                     dp[i + 1][K]);
//                 }
//                 else {
//                     profit = Math.max(p[i] + dp[i + 1][K - 1],
//                                     dp[i + 1][K]);
//                 }
//                 dp[i][K] = profit;                
//             }
//         }
//         return dp[0][trans];
//     }
// }

// SPACE OPTM
class Solution {
    public int maxProfit(int k, int[] p) {
        int n = p.length;
        int trans = 2 * k;
        int[] nextR = new int[trans + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int[] currR = new int[trans + 1];
            for (int K = trans; K >= 1; K--) {
                int profit = 0;
                if (K % 2 == 0) { // BUY  (at k = 4 buy)
                    profit = Math.max(-p[i] + nextR[K - 1],
                                    nextR[K]);
                }
                else {
                    profit = Math.max(p[i] + nextR[K - 1],
                                    nextR[K]);
                }
                currR[K] = profit;                
            }
            nextR = currR;
        }
        return nextR[trans];
    }
}