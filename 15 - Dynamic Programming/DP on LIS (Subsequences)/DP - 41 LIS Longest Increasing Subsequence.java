// Approach I (Best for PRINTING):-
//--------------------------------------------------------------------------------------

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n]; Arrays.fill(dp, 1);
//         // dp[i] => LIS till i-th index

//         int max = 1;
//         for (int i = 1; i < n; i++) {
//             for (int prev = 0; prev < i; prev++) {
//                 if (nums[prev] < nums[i]) dp[i] = Math.max(dp[i], 1 + dp[prev]); //update if larger subsequence found
//             }
//             max = Math.max(max, dp[i]);
//         }
//         return max;
//     }
// }


// Approach II (Best for LENGTH):-
//--------------------------------------------------------------------------------------

/* Methodology: Greedy + Binary Search
    1. This approach intelligently builds the increasing subarray by maintaining a sorted arraylist. 
    2. for i = i .. n - 1 {
        if (nums[i] larger than all elements (last element) in sub) {
            append nums[i];
        } else {
            binary search to find the smalllest element in sub that is greater or equal to nums[i];
            replace that element with nums[i];
        }
        In this way, the list is maintained as sorted, and it is the logest increasing subarray. 
    }
    3. Return sub.size();
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int j = binarySearch(list, nums[i]);
                list.set(j, nums[i]);
            }
        }
        
        return list.size();
    }
    
    private int binarySearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num == list.get(mid)) return mid;
            if (num < list.get(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left; //** */
    }
}