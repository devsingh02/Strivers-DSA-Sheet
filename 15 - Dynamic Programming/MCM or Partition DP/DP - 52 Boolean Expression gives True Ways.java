// RECURSIVE
class Solution{
    static int countWays(int n, String s){
        return f(0, n - 1, true, s);
    }
    static int f(int i, int j, boolean N, String s) {
        if (i > j) return 0;
        if (i == j) {
            if (N) return s.charAt(i) == 'T' ? 1 : 0; // agar no. of T ways 
            else return s.charAt(i) == 'F' ? 1 : 0; // agar no. of F ways
        }
        
        int ways = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            char op = s.charAt(k);
            int lt = f(i, k - 1, true, s);
            int lf = f(i, k - 1, false, s);
            int rt = f(k + 1, j, true, s);
            int rf = f(k + 1, j, false, s);
            if (N == 1) { // if 'f' needs True ways
                if (op == '|') ways += lt*rt + lt*rf + lf*rt;
                else if (op == '&') ways += lt*rt;
                else ways += lt*rf + lf*rt; // '^'
            }
            else { // if 'f' needs False ways
                if (op == '|') ways += lf*rf;
                else if (op == '&') ways += lf*rf + lt*rf + lf*rt;
                else ways += lt*rt + lf*rf; // '^'
            }
        return ways;
    }
}

// // *** else if is imp. or second if after first if will also run
// // MEMOIZED
// class Solution{
//     public static final int mod = (int)1e3 + 3; // take mod while returning only
//     static int countWays(int n, String s){
//         int[][][] dp = new int[n + 1][n + 1][2];
//         for (int i = 0; i < n + 1; i++) for (int j = 0; j < n + 1; j++) for (int k = 0; k < 2; k++) dp[i][j][k] = -1;
//         return f(0, n - 1, 1, s, dp);  // N => 1 means need True
//     }
//     static int f(int i, int j, int N, String s, int[][][] dp) {
//         if (i > j) return 0;
//         if (i == j) {
//             if (N == 1) return s.charAt(i) == 'T' ? 1 : 0; // agar no. of T ways 
//             else return s.charAt(i) == 'F' ? 1 : 0; // agar no. of F ways
//         }
//         if (dp[i][j][N] != -1) return dp[i][j][N];
        
//         int ways = 0;
//         for (int k = i + 1; k <= j - 1; k += 2) {
//             char op = s.charAt(k);
//             int lt = f(i, k - 1, 1, s, dp);
//             int lf = f(i, k - 1, 0, s, dp);
//             int rt = f(k + 1, j, 1, s, dp);
//             int rf = f(k + 1, j, 0, s, dp);
//             if (N == 1) {
//                 if (op == '|') ways += lt*rt + lt*rf + lf*rt;
//                 else if (op == '&') ways += lt*rt;
//                 else ways += lt*rf + lf*rt; // '^'
//             }
//             else {
//                 if (op == '|') ways += lf*rf;
//                 else if (op == '&') ways += lf*rf + lt*rf + lf*rt;
//                 else ways += lt*rt + lf*rf; // '^'
//             }
//         }
//         return dp[i][j][N] = ways % mod;
//     }
// }

https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article