// MEMOIZED
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(n, amount, coins, dp);
    }
    int f(int n, int amt, int[] coins, int[][] dp) {
        if (n == 0) return amt == 0 ? 1 : 0;
        if (dp[n][amt] != -1) return dp[n][amt];

        int take = (coins[n - 1] <= amt) ? f(n, amt - coins[n - 1], coins, dp) : 0;
        int leave = f(n - 1, amt, coins, dp);
        return dp[n][amt] = take + leave;
    }
}

// // TABULIZED
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n + 1][amount + 1];
//         dp[0][0] = 1;
        
//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 0; j < amount + 1; j++) {
//                 int take = (coins[i - 1] <= j) ? dp[i][j - coins[i - 1]] : 0;
//                 int leave = dp[i - 1][j];
//                 dp[i][j] = take + leave;
//             }
//         }

//         return dp[n][amount];
//     }
// }

// // GENERIC
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[] dp = new int[amount + 1];
//         dp[0] = 1;
        
//         for (int c : coins) {
//             for (int j = 1; j < amount + 1; j++) {
//                 if (c <= j) dp[j] += dp[j - c];
//             }
//         }

//         return dp[amount];
//     }
// }