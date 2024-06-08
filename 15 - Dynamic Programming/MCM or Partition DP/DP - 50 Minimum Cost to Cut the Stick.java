// MEMOIZED
class Solution {
    public int minCost(int n, int[] cut) {
        int N = cut.length + 2; // adding 0 and n
        int[] cuts = new int[N];
        Arrays.sort(cut);

        for (int i = 0; i < cut.length; i++) cuts[i + 1] = cut[i];
        cuts[0] = 0; cuts[N - 1] = n; // made sorted cuts

        int[][] dp = new int[N + 1][N + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        // move i, j from original cuts index (i,j -> cuts)
        return f(1, N - 1 - 1, cuts, dp);
    }
    int f(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0; //no cuts left, no cutting, no cost.
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1]
                + f(k + 1, j, cuts, dp) + f(i, k - 1, cuts, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}

// // TABULATION
// class Solution {
//     public int minCost(int n, int[] cut) {
//         int N = cut.length + 2; // adding 0 and n
//         int[] cuts = new int[N];
//         Arrays.sort(cut);

//         for (int i = 0; i < cut.length; i++) cuts[i + 1] = cut[i];
//         cuts[0] = 0; cuts[N - 1] = n; // made sorted cuts

//         int[][] dp = new int[N + 1][N + 1];
//         // since in memo 'i' moves from 1 to N - 2. In tab its opp + j alwyas >= i
//         for (int i = N - 2; i >= 1; i--) {
//             for (int j = i; j <= N - 2; j++) {
//                 int min = Integer.MAX_VALUE;
//                 for (int k = i; k <= j; k++) {
//                     int cost = cuts[j + 1] - cuts[i - 1]
//                         + dp[k + 1][j] + dp[i][k - 1];
//                     min = Math.min(min, cost);
//                 }
//                 dp[i][j] = min;
//             }
//         }
//         return dp[1][N - 2];
//     }
// }


// // // MY OWN LOGIC
// // class Solution {
// //     public int minCost(int n, int[] cuts) {
// //         return f(0, n, cuts);
// //     }

// //     int f(int i, int j, int[] cuts) {
// //         int min = Integer.MAX_VALUE;
// //         boolean cutMade = false;

// //         for (int k : cuts) {
// //             if (k > i && k < j) {
// //                 cutMade = true;
// //                 int temp = (j - i) + f(i, k, cuts) + f(k, j, cuts);
// //                 min = Math.min(temp, min);
// //             }
// //         }

// //         // If no cuts can be made, the cost is 0
// //         if (!cutMade) return 0;
// //         return min;
// //     }
// // }