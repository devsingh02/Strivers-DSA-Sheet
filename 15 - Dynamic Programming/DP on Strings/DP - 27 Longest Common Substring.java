/*
I)
Memoized version doesn't work for substring sinve it is npt able to iterate over the strings on != case
So Start directly with LCS Tabulisation.
When s1 != s2 => return 0 since substring not subsequence.

II)
Return the max from the table
*/
class Solution {
    int longestCommonSubstr(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        
        int max = -1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = 0; //string stopped, start with 0 again
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}