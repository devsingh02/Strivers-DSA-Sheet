// // Recursive
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] nums1 = new int[n - 1];
//         for (int i = 1; i < n; i++) nums1[i - 1] = nums[i];
//         int[] nums2 = new int[n - 1];
//         for (int i = 0; i < n - 1; i++) nums2[i] = nums[i];
//         if (n == 1) return nums[0];
//         return Math.max(f(nums1.length - 1, nums1), f(nums2.length - 1, nums2));
//     }
//     int f(int n, int[] nums) {
//         if (n < 0) return 0;
//         int either = nums[n] + f(n - 2, nums);
//         int or = 0 + f(n - 1, nums);
//         return Math.max(either, or);
//     }
// }

// Memo
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n - 1];
        for (int i = 1; i < n; i++) nums1[i - 1] = nums[i];
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) nums2[i] = nums[i];
        if (n == 1) return nums[0];
        int[] dp1 = new int[(n - 1) + 1];
        for (int i = 0; i < n; i++) dp1[i] = -1;
        int[] dp2 = new int[(n - 1) + 1];
        for (int i = 0; i < n; i++) dp2[i] = -1;
        return Math.max(f(nums1.length - 1, nums1, dp1), f(nums2.length - 1, nums2, dp2));
    }
    int f(int n, int[] nums, int[] dp) {
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        int either = nums[n] + f(n - 2, nums, dp);
        int or = 0 + f(n - 1, nums, dp);
        return dp[n] = Math.max(either, or);
    }
}