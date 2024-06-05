// Length => m + n - lcs

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        
        int[][] dp = LCS(m, n, str1, str2);
        String scs = SCS(m, n, str1, str2, dp);

        return scs;        
    }

// "StringBuilder" takes far less time than normal String "Concatenation"
    String SCS(int m, int n, String str1, String str2, int[][] dp) {
        StringBuilder sb = new StringBuilder(); // stores the scs

        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                sb.append(str1.charAt(m - 1));
                m--; n--; // go to dp[m - 1][n - 1]
            }
            else {
                if (dp[m - 1][n] >= dp[m][n - 1]) { // move up -> str1 removed
                    sb.append(str1.charAt(m - 1));
                    m--;
                }
                else {
                    sb.append(str2.charAt(n - 1));
                    n--;
                }
            }
        }
        // Take remaining strings
        while (m > 0) {
            sb.append(str1.charAt(m - 1));
            m--;
        }
        while (n > 0) {
            sb.append(str2.charAt(n - 1));
            n--;
        }
        return sb.reverse().toString();
    }

    int[][] LCS(int m, int n, String str1, String str2) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp;
    }
}

// // Method to print LCS :-
// String giveAnyLCS(int m, int n, String str1, String str2, int[][] dp) {
//     String lcs = "";
//     while (m > 0 && n > 0) {
//         if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
//             lcs = str1.charAt(m - 1) + lcs;
//             m--; n--; // go to dp[m - 1][n - 1]
//         }
//         else {
//             if (dp[m - 1][n] >= dp[m][n - 1]) m--;
//             else n--;
//         }
//     }
//     return lcs;
// }