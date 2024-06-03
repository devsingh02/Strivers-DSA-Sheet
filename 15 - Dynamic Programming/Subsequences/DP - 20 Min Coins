// // MY METHOD :- (16 ms)

// Memoized
class Solution {
    public final int MAX = Integer.MAX_VALUE / 2; //prevent overflow
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = f(n, amount, coins, dp);
        if (ans > amount) return -1; // atmost all coins 1 -> max ans = amt
        else return ans;
    }
    int f(int n, int amt, int[] coins, int[][] dp) {
        if (n == 0) return amt == 0 ? 0 : MAX;
        if (dp[n][amt] != -1) return dp[n][amt];

        int take = (coins[n - 1] <= amt) ? 1 + f(n, amt - coins[n - 1], coins, dp) : MAX;
        int leave = f(n - 1, amt, coins, dp);
        return dp[n][amt] = Math.min(take, leave);
    }
}

// // // Tabulized
// // class Solution {
// //     public final int MAX = Integer.MAX_VALUE / 2; //prevent overflow
// //     public int coinChange(int[] coins, int amount) {
// //         int n = coins.length;
// //         int[][] dp = new int[n + 1][amount + 1];
        
// //         dp[0][0] = 0;
// //         for (int j = 1; j < amount + 1; j++) dp[0][j] = MAX;

// //         for (int i = 1; i < n + 1; i++) {
// //             for (int j = 0; j < amount + 1; j++) {
// //                 int take = (coins[i - 1] <= j) ? 1 + dp[i][j - coins[i - 1]] : MAX;
// //                 int leave = dp[i - 1][j];
// //                 dp[i][j] = Math.min(take, leave);
// //             }
// //         }

// //         int ans = dp[n][amount];
// //         if (ans > amount) return -1; // atmost all coins 1 -> max ans = amt
// //         else return ans;
// //     }
// // }

// // GENERIC :- (15 ms)

// // Tabulized
// class Solution {
//     public final int MAX = Integer.MAX_VALUE / 2; //prevent overflow
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         //index -> amount  |  value -> coins
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, MAX);
//         dp[0] = 0; //an amount of 0 requires 0 coins

//         for (int j = 1; j < amount + 1; j++) {
//             for (int c : coins) {
//                 if (c <= j) dp[j] = Math.min(dp[j], 1 + dp[j - c]); //leave, take the coins
//             }
//         }

//         int ans = dp[amount];
//         if (ans > amount) return -1; // atmost all coins 1 -> max ans = amt
//         else return ans;
//     }
// }