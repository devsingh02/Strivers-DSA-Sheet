// FRONT PARTITIONING

// MEMOIZED
// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int[] dp = new int[arr.length + 1];
//         Arrays.fill(dp, -1);
//         return f(0, k, arr, dp);
//     }
//     int f(int i, int k, int[] a, int[] dp) {
//         if (i == a.length) return 0;
//         if (dp[i] != -1) return dp[i];

//         int maxAns = Integer.MIN_VALUE;
//         int len = 0; int maxEl = Integer.MIN_VALUE;
//         for (int j = i; j < Math.min(a.length, i + k); j++) {
//             len++;
//             maxEl = Math.max(maxEl, a[j]);
//             int ans = maxEl * len + f(j + 1, k, a, dp);
//             maxAns = Math.max(maxAns, ans);
//         }
//         return dp[i] = maxAns;
//     }
// }

// TABULATION
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int maxAns = Integer.MIN_VALUE;
            int len = 0; int maxEl = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                maxEl = Math.max(maxEl, arr[j]);
                int ans = maxEl * len + dp[j + 1];
                maxAns = Math.max(maxAns, ans);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}