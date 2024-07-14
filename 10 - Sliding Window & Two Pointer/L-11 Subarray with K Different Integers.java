class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return lessThanEqualTo(nums, k) - lessThanEqualTo(nums, k - 1);
    }
    private int lessThanEqualTo(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int l = 0, r = 0, count = 0;

        while (r < nums.length) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            while (hm.size() > k) { // Valid window
                hm.put(nums[l], hm.get(nums[l]) - 1);
                if (hm.get(nums[l]) == 0) hm.remove(nums[l]);
                l++;
            }
            count += r - l + 1; // all <= k counted
            r++;
        }
        
        return count;
    }
}

// // Optmized according to constraints :-
// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         return lessThanEqualTo(nums, k) - lessThanEqualTo(nums, k - 1);
//     }
//     private int lessThanEqualTo(int[] nums, int k) {
//         int[] hm = new int[nums.length + 1]; // start with 1
//         int l = 0, r = 0, count = 0, uni = 0;

//         while (r < nums.length) {
//             if (hm[nums[r]] == 0) uni++;
//             hm[nums[r]]++;
//             while (uni > k) { // Valid window
//                 hm[nums[l]]--;
//                 if (hm[nums[l]] == 0) uni--;
//                 l++;
//             }
//             count += r - l + 1; // all <= k counted
//             r++;
//         }
        
//         return count;
//     }
// }