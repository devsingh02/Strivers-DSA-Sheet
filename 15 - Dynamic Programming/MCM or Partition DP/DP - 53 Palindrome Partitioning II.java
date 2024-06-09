/*
    FRONT PARTITIONING :-
    is a concept where what to do (definintion, e.g. palindromes) is already given.
    MCM = calculate from scratch (no definition, just give calculations)
*/

// // MEMO (barely accepting)
// class Solution {
//     public int minCut(String s) {
//         int n = s.length();
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return f(0, n, s, dp);
//     }
//     int f(int i, int n, String s, int[] dp) {
//         if (i == n || isPalin(i, n - 1, s)) return 0;
//         if (dp[i] != -1) return dp[i];

//         int min = Integer.MAX_VALUE;
//         for (int k = i; k < n; k++) {
//             int cuts = 0;
//             if (isPalin(i, k, s)) {
//                 cuts = 1 + f(k + 1, n, s, dp);
//                 min = Math.min(min, cuts); // update min also when made a cut
//             }
//         }
//         return dp[i] = min;
//     }
//     boolean isPalin(int i, int j, String s) {
//         while (i < j) {
//             if (s.charAt(i++) != s.charAt(j--)) return false;
//         }
//         return true;
//     }
// }

// Tabulation (Best Solution)
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        boolean[][] pd = new boolean[n + 1][n + 1];

        // initialising pd memo (Bottom-up : from smallest string to largest)
        for (int j = 0; j < n; j++) { //end
            for (int i = 0; i <= j; i++) { //start
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || pd[i + 1][j - 1])) // j - i <= 2 written before to prevent ArrayIndexOutOfBounds error.
                    pd[i][j] = true;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (pd[i][n - 1]) {
                dp[i] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int k = i; k < n; k++) {
                if (pd[i][k]) {
                    int cuts = 1 + dp[k + 1];
                    min = Math.min(min, cuts); // update min also when made a cut
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }
}