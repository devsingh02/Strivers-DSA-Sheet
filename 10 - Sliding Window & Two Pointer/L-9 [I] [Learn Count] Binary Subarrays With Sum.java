// == goal : <= goal - <= goal-1

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return lessThanEqualTo(nums, goal) - lessThanEqualTo(nums, goal - 1);
    }
    private int lessThanEqualTo(int[] nums, int goal) { // finding no. of subarrays <= goal is possible
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal && l <= r) { // make a valid window
                sum -= nums[l];
                l++;
            }
            count += r - l + 1; // All possible subarrays with sum <= goal == window length
            r++;
        }
        
        return count;
    }
}