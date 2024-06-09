// Cooldown = 1 day

// Copy Paste code from Infinite Transactions

// MEMOIZED 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n+1 + 1][2 + 1]; // +1 for cooldown
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(0, 1, n, prices, dp);
    }
    int f(int i, int buy, int n, int[] p, int[][] dp) {
        if (i >= n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-p[i] + f(i + 1, 0, n, p, dp), 
                                f(i + 1, 1, n, p, dp));     
        } 
        else {
            profit = Math.max(p[i] + f(i+1 + 1, 1, n, p, dp), //*** +1 day cooldown
                                f(i + 1, 0, n, p, dp));     
        }   
        return dp[i][buy] = profit;
    }
} 

// // TABULATION 
// class Solution {
//     public int maxProfit(int[] p) {
//         int n = p.length;
//         int [][] dp = new int[n+1 + 1][2 + 1]; // +1 for cooldown
        
//         for (int i = n - 1; i >= 0; i--) {
//             for (int buy = 0; buy <= 1; buy++) {
//                 int profit = 0;
//                 if (buy == 1) {
//                     profit = Math.max(-p[i] + dp[i + 1][0], 
//                                 dp[i + 1][1]);     
//                 } 
//                 else {
//                     profit = Math.max(p[i] + dp[i+1 + 1][1], //*** +1 day cooldown
//                                 dp[i + 1][0]);     
//                 }   
//                 dp[i][buy] = profit;
//             }
//         }
//         return dp[0][1];
//     }
// } 

// CANT BE SPACE OPTM since +2 in some cases