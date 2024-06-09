// INIFINTE TRANSACTIONS
// // MEMOIZED 
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int [][] dp = new int[n + 1][2 + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);
//         return f(0, 1, n, prices, dp); // i, buy (if buy == 1 we can buy)
//     }
//     int f(int i, int buy, int n, int[] p, int[][] dp) {
//         if (i == n) return 0;
//         if(dp[i][buy] != -1) return dp[i][buy];

//         int profit = 0;
//         if (buy == 1) {
//             profit = Math.max(-p[i] + f(i + 1, 0, n, p, dp), // buy 
//                                 f(i + 1, 1, n, p, dp));     // or dont buy
//         } 
//         else {
//             profit = Math.max(p[i] + f(i + 1, 1, n, p, dp), // sell 
//                                 f(i + 1, 0, n, p, dp));     // or dont sell
//         }   
//         return dp[i][buy] = profit;
//     }
// } 

// // TABULATION 
// class Solution {
//     public int maxProfit(int[] p) {
//         int n = p.length;
//         int [][] dp = new int[n + 1][2 + 1];
        
//         for (int i = n - 1; i >= 0; i--) {
//             for (int buy = 0; buy <= 1; buy++) {
//                 int profit = 0;
//                 if (buy == 1) {
//                     profit = Math.max(-p[i] + dp[i + 1][0], // buy 
//                                 dp[i + 1][1]);     // or dont buy
//                 } 
//                 else {
//                     profit = Math.max(p[i] + dp[i + 1][1], // sell 
//                                 dp[i + 1][0]);     // or dont sell
//                 }   
//                 dp[i][buy] = profit;
//             }
//         }
//         return dp[0][1];
//     }
// } 

// SPACE OPTM.
class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;
        int[] nextR = new int[2 + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int[] currR = new int[2 + 1];
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    profit = Math.max(-p[i] + nextR[0], // buy 
                                nextR[1]);     // or dont buy
                } 
                else {
                    profit = Math.max(p[i] + nextR[1], // sell 
                                nextR[0]);     // or dont sell
                }   
                currR[buy] = profit;
            }
            nextR = currR;
        }
        return nextR[1];
    }
}