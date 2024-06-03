// MEMOIZATION
// class Solution 
// { 
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//          // your code here 
//          int[][] dp = new int[n + 1][W + 1];
//          for (int[] row : dp) Arrays.fill(row, -1);
         
//          return f(n, W, val, wt, dp);
//     } 
    
//     static int f(int n, int W, int[] val, int[] wt, int[][] dp) {
//         if (n == 0 || W == 0) return 0;
//         if (dp[n][W] != -1) return dp[n][W];
        
//         int take = (wt[n - 1] <= W) ? val[n - 1] + f(n - 1, W - wt[n - 1], val, wt, dp) : 0;
//         int leave = f(n - 1, W, val, wt, dp);
//         return dp[n][W] = Math.max(take, leave);
//     }
// }

// TABULATION
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n + 1][W + 1];
         
         for (int i = 1; i < n + 1; i++) {
             for (int j = 1; j < W + 1; j++) {
                 int take = (wt[i - 1] <= j) ? val[i - 1] + dp[i - 1][j - wt[i - 1]] : 0;
                 int leave = dp[i - 1][j];
                 dp[i][j] = Math.max(take, leave);
             }
        }
        return dp[n][W];
    } 
}