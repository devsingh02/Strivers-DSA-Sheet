// consecutive / subarray => Sliding Window
// Keep a window of max 2 zeros. Slide it.

// Since we need the maximum subarray => we dont need to shrink the window => Just slide with same maxlen till next biggest found

// Noobie's approach O(2n)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zeros = 0;
        int maxlen = 0;
        while (r < nums.length) {
            if (nums[r] == 0) zeros++; 
            while (zeros > k) { // make cond valid again
                if (nums[l++] == 0) zeros--;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++; // move ahead by one
        }
        return maxlen;
    }
}

// // Master's approach O(n)
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int l = 0, r = 0, zeros = 0;
//         int maxlen = 0;
//         while (r < nums.length) {
//             if (nums[r] == 0) zeros++; 
//             if (zeros > k) { // shrink by one
//                 if (nums[l++] == 0) zeros--;
//             }
//             if (zeros <= k) maxlen = Math.max(maxlen, r - l + 1); // valid cond.
//             r++; // move ahead by one
//             // combined sliding with same length if zeros > k
//         }
//         return maxlen;
//     }
// }