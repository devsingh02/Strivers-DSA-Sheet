// Through obs => (m - lcs) + (n - lcs)
// (only same when = LCS both)

class Solution {
    public int minDistance(String word1, String word2) {
        String s1 = word1, s2 = word2;
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return m + n - 2*dp[m][n];
    }
}