// NOT a LCS ==> STRING MATCHING
// Purely a DP on Strings Question
// Pointers at end of both strings. 

// // MEMOIZED
// class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length(), n = t.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);

//         return f(m, n, s, t, dp);
//     }
//     int f(int m, int n, String s, String t, int[][] dp) {
//         if (n == 0) return 1; // s2 empty => all matched once
//         if (m == 0) return 0; // && n != 0
//         if (dp[m][n] != -1) return dp[m][n];
//         // Two choices => 1. == take the superseq char or look for another (find all cases)
//         if (s.charAt(m - 1) == t.charAt(n - 1)) 
//             return dp[m][n] = f(m - 1, n - 1, s, t, dp) + f(m - 1, n, s, t, dp);
//         // 2. != look for another
//         else return dp[m][n] = f(m - 1, n, s, t, dp);
//     }
// }

// // TABULIZATION
// class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length(), n = t.length();
//         int[][] dp = new int[m + 1][n + 1];
        
//         for (int i = 0; i < m + 1; i++) dp[i][0] = 1;

//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (s.charAt(i - 1) == t.charAt(j - 1))
//                     dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                 else dp[i][j] = dp[i - 1][j];
//             }
//         }
//         return dp[m][n];
//     }
// }

// // SPACE OPTM
// class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length(), n = t.length();
        
//         int[] prevR = new int[n + 1];
//         prevR[0] = 1; 

//         for (int i = 1; i < m + 1; i++) {
//             int[] currR = new int[n + 1];
//             currR[0] = 1;
//             for (int j = 1; j < n + 1; j++) {
//                 if (s.charAt(i - 1) == t.charAt(j - 1))
//                     currR[j] = prevR[j - 1] + prevR[j]; //we can apply 1D optm. also
//                 else currR[j] = prevR[j];
//             }
//             prevR = currR;
//         }
//         return prevR[n];
//     }
// }

// 1D OPTM
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        
        int[] prevR = new int[n + 1];
        prevR[0] = 1; 

        for (int i = 1; i < m + 1; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    prevR[j] = prevR[j - 1] + prevR[j]; 
                else prevR[j] = prevR[j];
            }
        }
        return prevR[n];
    }
}


// // code for printing all LCSs (even repitions)
    // int count(int m, int n, String s1, String s2, int[][] dp) {
    //     if (m == 0 || n == 0) return 1;

    //     int ct = 0;
    //     if (s1.charAt(m - 1) == s2.charAt(n - 1))
    //         ct += count(m - 1, n - 1, s1, s2, dp);
    //     else {
    //         if (dp[m - 1][n] >= dp[m][n - 1]) ct += count(m - 1, n, s1, s2, dp);
    //         if (dp[m - 1][n] <= dp[m][n - 1]) ct += count(m, n - 1, s1, s2, dp);
    //     }
    //     return ct;
    // }