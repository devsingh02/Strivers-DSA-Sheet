// I) MAX-LENGTH
class Solution {
    public int slidingWindow(int[] arr) {
        int l = 0, r = 0, maxlen = 0;

        // Noobie's Approach : O(2n) => Complete Shrinkage
        while (r < arr.length) {
            // *1. DO whatever operation on r
            // *2. Then CORRECT the condtition (make the cond valid) of the window
            while (!valid cond) {...; l++;}
            // 3. Update max-length since cond IS satisfied
            maxlen = Math.max(maxlen, r - l + 1);
            r++; // 4. Move ahead
        }

        // Master's Approach : O(n) => Maintaing the size of window till next valid max found
        while (r < arr.length) {
            // *1. Do whatever operation on r
            // *2. IF cond invalid move l++ (shrink the window)
            if (!valid cond) {...; l++;}
            // 3. Update max-length since IF cond is satisfied
            if (valid cond) maxlen = Math.max(maxlen, r - l + 1);
            r++; // 4. Move ahead
        }

        return maxlen;
    }
}

// * While loop doesn't run if cond already valid


// II) Number/Count of Subarrays with ... == k

// Since only valid window can be created :- Approach used is
// <= k - <= k-1
// count of <= : length of the valid window i.e. r - l + 1

// e.g. :- L-9
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