import java.util.*;
class Printing_LIS {
    public void LIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; Arrays.fill(dp, 1);
        // dp[i] => LIS till i-th index
        int[] hash = new int[n]; // stores the index of prev (subsequence)

        int max_ind = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i; // firstly initialize it with its own index
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev]; //update if larger subsequence found
                    hash[i] = prev;
                }
            }
            if (dp[max_ind] < dp[i]) max_ind = i; 
        }

        List<Integer> lis = new ArrayList<>();
        int i = max_ind;
        while (hash[i] != i) { //stops at last, but still we have to add the last
            lis.add(nums[i]);
            i = hash[i]; // i becomes the prev index of nums[i]
        }
        lis.add(nums[i]); // add the last element

        Collections.reverse(lis);
        System.out.println(lis);
    }

    public static void main(String[] args) {
        Printing_LIS obj = new Printing_LIS();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {5, 4, 11, 1, 16, 8};
        obj.LIS(nums1);
    }
}