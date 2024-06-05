// Memoized
class Solution {
    public boolean isMatch(String s, String p) { // p -> pattern to match
        int m = s.length(), n = p.length();

        Boolean[][] dp = new Boolean[m + 1][n + 1]; // default -> null

        return f(m, n, s, p, dp);
    }
    boolean f(int m, int n, String s, String p, Boolean[][] dp) {
        if (m == 0 && n == 0) return true;
        if (n == 0) return false; //nothing left to match
        if (m == 0) { // p must me all *
            for (int i = n - 1; i >= 0; i--) if (p.charAt(i) != '*') return false;
            return true;
        }
        if (dp[m][n] != null) return dp[m][n];

        if (s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '?')
            return dp[m][n] = f(m - 1, n - 1, s, p, dp);
        if (p.charAt(n - 1) == '*') 
            return dp[m][n] = f(m - 1, n, s, p, dp) || f(m, n - 1, s, p, dp);
        return dp[m][n] = false; // !=
    }
}

// // Tabulation
// class Solution {
//     public boolean isMatch(String s, String p) { // p -> pattern to match
//         int m = s.length(), n = p.length();

//         Boolean[][] dp = new Boolean[m + 1][n + 1]; // default -> null
//         dp[0][0] = true;
//         for (int i = 1; i < m + 1; i++) dp[i][0] = false;
//         for (int j = 1; j < n + 1; j++) {
//             for (int i = j - 1; i >= 0; i--) if (p.charAt(i) != '*') dp[0][j] =  false; 
//             if (dp[0][j] == null) dp[0][j] = true;
//         }

//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
//                     dp[i][j] = dp[i - 1][j - 1];
//                 else if (p.charAt(j - 1) == '*') 
//                     dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//                 else dp[i][j] = false; // !=
//             }
//         }
//         return dp[m][n];
//     }
// }

// // SPACE OPT
// class Solution {
//     public boolean isMatch(String s, String p) { // p -> pattern to match
//         int m = s.length(), n = p.length();

//         Boolean[] prevR = new Boolean[n + 1]; // default -> null
//         prevR[0] = true;
//         for (int j = 1; j < n + 1; j++) {
//             for (int i = j - 1; i >= 0; i--) if (p.charAt(i) != '*') prevR[j] =  false; 
//             if (prevR[j] == null) prevR[j] = true;
//         }

//         for (int i = 1; i < m + 1; i++) {
//             Boolean[] currR = new Boolean[n + 1];
//             currR[0] = false;
//             for (int j = 1; j < n + 1; j++) {
//                 if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
//                     currR[j] = prevR[j - 1];
//                 else if (p.charAt(j - 1) == '*') 
//                     currR[j] = prevR[j] || currR[j - 1];
//                 else currR[j] = false; // !=
//             }
//             prevR = currR;
//         }
//         return prevR[n];
//     }
// }