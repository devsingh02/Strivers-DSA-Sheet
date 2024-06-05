// Logic imp :- Refer Notes Register

// MEMOIZED
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(m, n, word1, word2, dp);
    }
    int f(int m, int n, String s1, String s2, int[][] dp) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (dp[m][n] != -1) return dp[m][n];

        int op = 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            op = 0 + f(m - 1, n - 1, s1, s2, dp);
        else {
            int ins = 1 + f(m, n - 1, s1, s2, dp); //s2 matched
            int del = 1 + f(m - 1, n, s1, s2, dp); //look for another
            int rep = 1 + f(m - 1, n - 1, s1, s2, dp); //both matched
            op = Math.min(Math.min(ins, del), rep);
        }
        return dp[m][n] = op;
    }
}

// // TABULATION
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m = word1.length(), n = word2.length();
//         int[][] dp = new int[m + 1][n + 1];
        
//         for (int i = 0; i < m + 1; i++) dp[i][0] = i;
//         for (int j = 0; j < n + 1; j++) dp[0][j] = j;

//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (word1.charAt(i - 1) == word2.charAt(j - 1))
//                     dp[i][j] = 0 + dp[i - 1][j - 1];
//                 else {
//                     int ins = 1 + dp[i][j - 1];
//                     int del = 1 + dp[i - 1][j];
//                     int rep = 1 + dp[i - 1][j - 1];
//                     dp[i][j] = Math.min(Math.min(ins, del), rep);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }

// // SPACE OPT.
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m = word1.length(), n = word2.length();

//         int[] prevR = new int[n + 1];
//         for (int j = 0; j < n + 1; j++) prevR[j] = j;

//         for (int i = 1; i < m + 1; i++) {
//             int[] currR = new int[n + 1];
//             currR[0] = i;
//             for (int j = 1; j < n + 1; j++) {
//                 if (word1.charAt(i - 1) == word2.charAt(j - 1))
//                     currR[j] = 0 + prevR[j - 1];
//                 else {
//                     int ins = 1 + currR[j - 1];
//                     int del = 1 + prevR[j];
//                     int rep = 1 + prevR[j - 1];
//                     currR[j] = Math.min(Math.min(ins, del), rep);
//                 }
//             }
//             prevR = currR;
//         }
//         return prevR[n];
//     }
// }