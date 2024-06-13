class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; Arrays.fill(dp, 1);
        int[] ct = new int[n]; Arrays.fill(ct, 1);

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) { // LIS of higher length found
                    dp[i] = 1 + dp[prev]; //update
                    ct[i] = ct[prev];
                } else if (nums[prev] < nums[i] && 1 + dp[prev] == dp[i]) { // LIS of same length => BOTH LISs
                    // no need to update
                    ct[i] += ct[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }
        // COUNT ALL POSSIBLE LISs
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) count += ct[i];
        }
        return count;
    }
}

/* 
for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {

Also a possbile iteration
*/