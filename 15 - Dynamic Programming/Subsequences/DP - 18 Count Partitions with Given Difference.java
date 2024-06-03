// // MEMOIZATION
// class Solution {
// // public static final int MOD = 1000000007;
//     public static final int MOD = (int)1e9 + 7;
//     public static int countPartitions(int n, int d, int[] arr) {
//         // code here
//         int range = 0; for (int I : arr) range += I;
//         if ((range + d) % 2 != 0) return 0;
//         int sum = (range + d) / 2;

//         int[][] dp = new int[n + 1][sum + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);

//         return f(n, sum, arr, dp);
//     }

//     static int f(int n, int sum, int[] arr, int[][] dp) {
//         if (n == 0) return sum == 0 ? 1 : 0;
//         if (dp[n][sum] != -1) return dp[n][sum];
        
//         int take = (arr[n - 1] <= sum) ? f(n - 1, sum - arr[n - 1], arr, dp) : 0;
//         int leave = f(n - 1, sum, arr, dp);
//         return dp[n][sum] = (take + leave) % MOD;
//     }
// }

// TABULATION
class Solution {
    // public static final int MOD = 1000000007;
    public static final int MOD = (int)1e9 + 7;

    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int range = 0; for (int I : arr) range += I;
        if ((range + d) % 2 != 0) return 0;
        int sum = (range + d) / 2;

        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int take = (arr[i - 1] <= j) ? dp[i - 1][j - arr[i - 1]] : 0;
                int leave = dp[i - 1][j];
                dp[i][j] = (take + leave) % MOD;
            }
        }
        return dp[n][sum];
    }
}
