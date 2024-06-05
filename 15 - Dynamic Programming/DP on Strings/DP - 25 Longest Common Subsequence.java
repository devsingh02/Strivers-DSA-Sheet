/*
LOGIC :-
We take 2 pointers i1 and i2.
-> if i1 == i2 => move both pointers ahead +1
-> else check all possibilities : first move i1, then i2. Take max of both.
*/

// MEOMOIZED
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(m, n, text1, text2, dp);
    }
    int f(int m, int n, String s1, String s2, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] =  1 + f(m - 1, n - 1, s1, s2, dp);
        else return dp[m][n] = Math.max(f(m - 1, n, s1, s2, dp), f(m, n - 1, s1, s2, dp));
    }
}

// // TABULIZED
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length(), n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
        
//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1))
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//             }
//         }
//         return dp[m][n];
//     }
// }