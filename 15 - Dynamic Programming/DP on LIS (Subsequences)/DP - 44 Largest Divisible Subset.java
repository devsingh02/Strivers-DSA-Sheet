// Sort of like make a sequence of divisors of a number == LIS

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n]; Arrays.fill(dp, 1);
        int[] hash = new int[n]; // stores the previous of ith lis

        int max_ind = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i; // ith previous is itself
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) { // condition change
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (dp[max_ind] < dp[i]) max_ind = i;
        }

        List<Integer> lis = new ArrayList<>();
        int i = max_ind;
        while (hash[i] != i) {
            lis.add(nums[i]);
            i = hash[i];
        }
        lis.add(nums[i]);

        Collections.reverse(lis);
        return lis;
    }
}