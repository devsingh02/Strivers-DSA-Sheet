class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return lessThanEqualTo(nums, k) - lessThanEqualTo(nums, k - 1);
    }
    private int lessThanEqualTo(int[] nums, int k) {
        int l = 0, r = 0, odds = 0, ans = 0;

        while (r < nums.length) {
            if (nums[r] % 2 != 0) odds++;
            while (odds > k) { // create valid window
                if (nums[l] % 2 != 0) odds--;
                l++;
            }
            ans += r - l + 1; // <= means window length
            r++;
        }

        return ans;
    }
}