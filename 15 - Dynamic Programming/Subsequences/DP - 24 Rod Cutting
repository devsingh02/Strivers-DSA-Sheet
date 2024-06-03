// // MEMOIZATION
    // class Solution{
    //     public int cutRod(int price[], int N) {
    //         //code here
    //         int sum = n;
    //         int[][] dp = new int[price.length + 1][sum + 1];
    //         for (int[] row : dp) Arrays.fill(row, -1);
            
    //         return f(price.length, sum, price, dp);
    //     }
    //     // n -> wt[]
    //     int f(int n, int sum, int[] price, int[][] dp) {
    //         if (n == 0) return sum == 0 ? 0 : Integer.MIN_VALUE; //take sum : dont take sum
    //         if (dp[n][sum] != -1) return dp[n][sum];
            
    //         int take = (n <= sum) ? price[n - 1] + f(n, sum - n, price, dp) : 0;
    //         int leave = f(n - 1, sum, price, dp);
    //         return dp[n][sum] = Math.max(take, leave);
    //     }
    // }
    
    // TABULATION
    class Solution{
        public int cutRod(int price[], int N) {
            //code here
            int n = price.length, sum = N;
            
            int[][] dp = new int[n + 1][sum + 1];
            
            for (int j = 0; j < n + 1; j++) dp[0][j] = Integer.MIN_VALUE;
            dp[0][0] = 0;
             
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    int take = (i <= j) ? price[i - 1] + dp[i][j - i] : 0;
                    int leave = dp[i - 1][j];
                    dp[i][j] = Math.max(take, leave);
                }
            }
            return dp[n][sum];
        }
    }