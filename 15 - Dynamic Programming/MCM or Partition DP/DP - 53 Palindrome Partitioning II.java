// MEMO => FRONT PARTITION (barely accepting)
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(0, n, s, dp);
    }
    int f(int i, int n, String s, int[] dp) {
        if (i == n || isPalin(i, n - 1, s)) return 0;
        if (dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {
            int cuts = 0;
            if (isPalin(i, k, s)) {
                cuts = 1 + f(k + 1, n, s, dp);
                min = Math.min(min, cuts); // update min also when made a cut
            }
        }
        return dp[i] = min;
    }
    boolean isPalin(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}