// NEW - BETTER

// Boolean since default -> null. Some answers would also store false.
// Memo
class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0; for (int I : nums) target += I;
        int n = nums.length; int sum = target / 2;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        if (target % 2 == 0) return f(n, sum, nums, dp);
        else return false;
    }
    boolean f(int n, int sum, int[] nums, Boolean[][] dp) {
        if (n == 0) return sum == 0 ? true : false;
        if (dp[n][sum] != null) return dp[n][sum];

        boolean take = (nums[n - 1] <= sum) ? f(n - 1, sum - nums[n - 1], nums, dp) : false;
        boolean leave = f(n - 1, sum, nums, dp);
        return dp[n][sum] = take || leave;
    }
}

// // Tabulation
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int target = 0; for (int I : nums) target += I;
//         if (target % 2 != 0) return false;
//         int n = nums.length, sum = target / 2;
//         Boolean[][] dp = new Boolean[n + 1][sum + 1];
        
        
//         dp[0][0] = true;
//         for (int j = 1; j < sum + 1; j++) dp[0][j] = false;

//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 0; j < sum + 1; j++) {
//                 boolean take = (nums[i - 1] <= j) ? dp[i - 1][j - nums[i - 1]] : false;
//                 boolean leave = dp[i - 1][j];
//                 dp[i][j] = take || leave;
//             }
//         }
//         return dp[n][sum];
//     }
// }

//------------------------------------------------------------------------------------------

// OLD

// // Recursive
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int target = 0; for (int I : nums) target += I;
//         int n = nums.length;

//         if (target % 2 == 0) return f(n, target / 2, nums);
//         else return false;
//     }
//     boolean f(int n, int k, int[] nums) {
//         if (k == 0) return true;
//         if (n == 0 || k < 0) return false;

//         int curr = nums[n - 1];
//         boolean take = f(n - 1, k - curr, nums);
//         boolean leave = f(n - 1, k, nums);
//         return take || leave;
//     }
// }

// // Memo
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int target = 0; for (int I : nums) target += I;
//         int n = nums.length; int k = target / 2;
//         boolean[][] dp = new boolean[n + 1][k + 1];
//         if (target % 2 == 0) return f(n, k, nums, dp);
//         else return false;
//     }
//     boolean f(int n, int k, int[] nums, boolean[][] dp) {
//         if (k == 0) return true;
//         if (n == 0 || k < 0) return false;
//         if (dp[n][k] != false) return dp[n][k];

//         int curr = nums[n - 1];
//         boolean take = f(n - 1, k - curr, nums, dp);
//         boolean leave = f(n - 1, k, nums, dp);
//         return dp[n][k] = take || leave;
//     }
// }

// // Tabulation
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int target = 0; for (int I : nums) target += I;
//         int n = nums.length; int k = target / 2;
//         if (target % 2 != 0) return false;

//         boolean[][] dp = new boolean[n + 1][k + 1];
//         for (int i = 0; i < n + 1; i++) dp[i][0] = true;

//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 1; j < k + 1; j++) {
//                 int curr = nums[i - 1];
//                 boolean take = (j - curr >= 0) ? dp[i - 1][j - curr] : false;
//                 boolean leave = dp[i - 1][j];
//                 dp[i][j] = take || leave;
//             }
//         }
//         return dp[n][k];
//     }
// }

// // Space Optm.
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int target = 0; for (int I : nums) target += I;
//         int n = nums.length; int k = target / 2;
//         if (target % 2 != 0) return false;

//         boolean[] prevRow = new boolean[k + 1];
//         prevRow[0] = true;

//         for (int i = 1; i < n + 1; i++) {
//             boolean[] currRow = new boolean[k + 1]; currRow[0] = true;
//             for (int j = 1; j < k + 1; j++) {
//                 int curr = nums[i - 1];
//                 boolean take = (j - curr >= 0) ? prevRow[j - curr] : false;
//                 boolean leave = prevRow[j];
//                 currRow[j] = take || leave;
//             }
//             prevRow = currRow;
//         }
//         return prevRow[k];
//     }
// }


