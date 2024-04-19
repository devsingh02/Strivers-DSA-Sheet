import java.util.Arrays;
public class Solution {
    // // RECURSION
    // public static int minimizeCost(int n, int k, int []height) {
    //     return f(n-1, k, height);
    // }
    // static int f(int n, int k, int[] h) {
    //     if (n == 0) return 0;
    //     int min = Integer.MAX_VALUE;
    //     for (int i = 1; i <= k; i++) {
    //         if (n-i < 0) break;
    //         int jump = Math.abs(h[n] - h[n-i]) + f(n-i, k, h);
    //         if (jump < min) min = jump;
    //     }
    //     return min;
    // }

    // // MEMOIZED
    // public static int minimizeCost(int n, int k, int []height) {
    //     int[] memo = new int[n];
    //     Arrays.fill(memo, -1);
    //     return f(n-1, k, height, memo);
    // }
    // static int f(int n, int k, int[] h, int[] memo) {
    //     if (n == 0) return 0;
    //     if (memo[n] != -1) return memo[n];
    //     int min = Integer.MAX_VALUE;
    //     for (int i = 1; i <= k; i++) {
    //         if (n-i < 0) break;
    //         int jump = Math.abs(h[n] - h[n-i]) + f(n-i, k, h, memo);
    //         if (jump < min) min = jump;
    //     }
    //     return memo[n] = min;
    // }

    // TABULATION
    public static int minimizeCost(int n, int k, int []height) {
        return f(n, k, height);
    }
    static int f(int n, int k, int[] h) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i-j < 0) break;
                int jump = Math.abs(h[i] - h[i-j]) + dp[i-j];
                if (jump < min) min = jump;
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}