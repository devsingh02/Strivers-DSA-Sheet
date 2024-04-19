// // Recursive
// class Solution {
//     public int rob(int[] nums) {
//         return f(nums.length - 1, nums);
//     }
//     int f(int n, int[] nums) {
//         if (n < 0) return 0;
//         int either = nums[n] + f(n - 2, nums);
//         int or = 0 + f(n - 1, nums);
//         return Math.max(either, or);
//     }
// }

// // Memo
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length - 1;
//         int[] dp = new int[n + 1];
//         for (int i = 0; i < n + 1; i++) dp[i] = -1;
//         return f(n, nums, dp);
//     }
//     int f(int n, int[] nums, int[] dp) {
//         if (n < 0) return 0;
//         if (dp[n] != -1) return dp[n];
//         int either = nums[n] + f(n - 2, nums, dp);
//         int or = 0 + f(n - 1, nums, dp);
//         return dp[n] = Math.max(either, or);
//     }
// }

// // Tabulation
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length - 1;
//         int[] dp = new int[n + 1];
//         // dp[0] = nums[0]; NO BASE CASE GIVEN SO i = 0
//         for (int i = 0; i < n + 1; i++) {
//             int either = nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0);
//             int or = 0 + (i - 1 >= 0 ? dp[i - 1] : 0);
//             dp[i] = Math.max(either, or);
//         }
//         return dp[n];
//     }
// }

// Space Optm.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length - 1;
        int prev1 = 0, prev2 = 0; //BOTH NOT GIVEN
        for (int i = 0; i < n + 1; i++) {
            int either = nums[i] + (i - 2 >= 0 ? prev2 : 0);
            int or = 0 + (i - 1 >= 0 ? prev1 : 0);
            int curr = Math.max(either, or);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}