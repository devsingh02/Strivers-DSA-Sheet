// // Memoized
// class Solution{
//     static int matrixMultiplication(int N, int arr[])
//     {   int[][] dp = new int[N][N];
//         for (int[] row : dp) Arrays.fill(row, -1);
//         // i moves b/w : 1 -> N - 1
//         // j moves b/w : i + 1 -> N - 1   (since i==k & k < j)
//         return f(1, N - 1, arr, dp);
//     }
//     static int f(int i, int j, int[] a, int[][] dp) {
//         if (i == j) return 0;
//         if (dp[i][j] != -1) return dp[i][j];
        
//         int min = Integer.MAX_VALUE;
//         for (int k = i; k < j; k++) {
//             int temp = f(i, k, a, dp) + f(k + 1, j, a, dp) + a[i - 1]*a[k]*a[j];
//             min = Math.min(min, temp);
//         }
//         return dp[i][j] = min;
//     }
// }

// TABULATION : <Opposite>
// i moves b/w : N - 1 -> 1
// j moves b/w : i + 1 -> N - 1   (since i==k & k < j)
class Solution{
    static int matrixMultiplication(int N, int a[])
    {   int[][] dp = new int[N + 1][N + 1];
        
        for (int i = N - 1; i >= 1; i--) { // opp of 1 -> N - 1
            for (int j = i + 1; j <= N - 1; j++) { // always be more than 'i'
                
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = dp[i][k] + dp[k + 1][j] + a[i - 1]*a[k]*a[j];
                    min = Math.min(min, temp);
                }
                dp[i][j] = min;
            }
        }
        // Memo : i => 1 to N - 1
        // Tab  : i => N - 1 to 1
        return dp[1][N - 1]; 
    }
}