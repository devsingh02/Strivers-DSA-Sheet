class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] dp1 = new int[n]; Arrays.fill(dp1, 1); // LIS looking from LEFT
        int[] dp2 = new int[n]; Arrays.fill(dp2, 1); // LIS looking from RIGHT
        // LOOKING FROM LEFT
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp1[prev] > dp1[i])
                    dp1[i] = 1 + dp1[prev];
            }
        }
        // LOOKING FROM RIGHT
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = n - 1; prev > i; prev--) {
                if (nums[prev] < nums[i] && 1 + dp2[prev] > dp2[i])
                    dp2[i] = 1 + dp2[prev];
            }
        }
        
        int bit = 0; 
        for (int i = 0; i < n; i++) {
            if (dp1[i] == 1 || dp2[i] == 1) continue; // returns 0 if either ONLY strictly increasing or decreasing
            bit = Math.max(bit, dp1[i] + dp2[i] - 1); //element repeated twice (looking from both left & right)
        }
        return bit;
    }
}
