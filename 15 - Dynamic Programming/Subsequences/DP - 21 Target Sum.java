// // MEMOIZATION
// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int range = 0; for (int I : nums) range += I;

//         target = Math.abs(target); // given in constraint it can be -ve
//         if ((range + target) % 2 != 0) return 0;

//         int n = nums.length, sum = (range + target) / 2;
//         int[][] dp = new int[n + 1][sum + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);

//         return f(n, sum, nums, dp);
//     }
//     int f(int n, int sum, int[] nums, int[][] dp) {
//         if (n == 0) return sum == 0 ? 1 : 0;
//         if (dp[n][sum] != -1) return dp[n][sum];

//         int take = (nums[n - 1] <= sum) ? f(n - 1, sum - nums[n - 1], nums, dp) : 0;
//         int leave = f(n - 1, sum, nums, dp);
//         return dp[n][sum] = take + leave;
//     }
// }

// TABULATION
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int range = 0; for (int I : nums) range += I;

        target = Math.abs(target); // given in constraint it can be -ve
        if ((range + target) % 2 != 0) return 0;

        int n = nums.length, sum = (range + target) / 2;
        int[][] dp = new int[n + 1][sum + 1];
        
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int take = (nums[i - 1] <= j) ? dp[i - 1][j - nums[i - 1]] : 0;
                int leave = dp[i - 1][j];
                dp[i][j] = take + leave;
            }
        }
        return dp[n][sum];
    }
}