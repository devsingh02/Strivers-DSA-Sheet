//* array by default -> false
import java.util.* ;
import java.io.*; 

// // Memo
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         boolean[][] dp = new boolean[n + 1][k + 1];
//         for (boolean[] row : dp) Arrays.fill(row, false);
//         return f(n, k, arr, dp);
//     }
//     static boolean f(int n, int k, int arr[], boolean[][] dp) {
//         if (k == 0) return true;
//         if (n == 0 || k < 0) return false;
//         if (dp[n][k] != false) return dp[n][k];
        
//         int curr = arr[n - 1];
//         boolean take = f(n - 1, k - curr, arr, dp);
//         boolean leave = f(n - 1, k, arr, dp);
//         return dp[n][k] = take || leave;
//     }
// }

// //Tabulation
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         boolean[][] dp = new boolean[n + 1][k + 1];
//         for (int i = 0; i < n + 1; i++ ) dp[i][0] = true;

//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 1; j < k + 1; j++) {
//                 int curr = arr[i - 1];
//                 boolean take = (j - curr >= 0) ? dp[i - 1][j - curr] : false;
//                 boolean leave = dp[i - 1][j];
//                 dp[i][j] = take || leave;
//             }
//         }
//         return dp[n][k];
//     }
// }

//Spae Optm.
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[] prevRow = new boolean[k + 1];
        prevRow[0] = true;

        for (int i = 1; i < n + 1; i++) {
            boolean[] currRow = new boolean[k + 1]; currRow[0] = true;
            for (int j = 1; j < k + 1; j++) {
                int curr = arr[i - 1];
                boolean take = (j - curr >= 0) ? prevRow[j - curr] : false;
                boolean leave = prevRow[j];
                currRow[j] = take || leave;
            }
            prevRow = currRow;
        }
        return prevRow[k];
    }
}

// GFG //

//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG
    {
        public static void main(String args[])throws IOException
        {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0)
            {
                int N = Integer.parseInt(read.readLine());
                String input_line[] = read.readLine().trim().split("\\s+");
                int arr[]= new int[N];
                for(int i = 0; i < N; i++)
                    arr[i] = Integer.parseInt(input_line[i]);
                int sum = Integer.parseInt(read.readLine());
    
                Solution ob = new Solution();
                if(ob.isSubsetSum(N, arr, sum))
                System.out.println(1);
                else
                System.out.println(0);
    
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    
    // // MEMOIZATION
    // class Solution{
    
    
    //     static Boolean isSubsetSum(int N, int arr[], int sum){
    //         // code here
    //         Boolean[][] dp = new Boolean[N + 1][sum + 1];
    //         // for (Boolean[] row : dp) Arrays.fill(row, null); // by default its null
            
    //         return f(N, sum, arr, dp);
    //     }
        
    //     static Boolean f(int n, int sum, int[] arr, Boolean[][] dp) {
    //         if (sum == 0) return true;
    //         if (n == 0) return false;
    //         if (dp[n][sum] != null) return dp[n][sum];
            
    //         Boolean take = (arr[n - 1] <= sum) ? f(n - 1, sum - arr[n - 1], arr, dp) : false;
    //         Boolean leave = f(n - 1, sum, arr, dp);
    //         return dp[n][sum] = take || leave;
    //     }
    // }
    
    // TABULATION
    class Solution{
    
    
        static Boolean isSubsetSum(int N, int arr[], int sum){
            // code here
            Boolean[][] dp = new Boolean[N + 1][sum + 1];
            // for (Boolean[] row : dp) Arrays.fill(row, null); // by default its null
            for (int j = 0; j < sum + 1; j++) dp[0][j] = false;
            for (int i = 0; i < N + 1; i++) dp[i][0] = true;
            
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    Boolean take = (arr[i - 1] <= j) ? dp[i - 1][j - arr[i - 1]] : false;
                    Boolean leave = dp[i - 1][j];
                    dp[i][j] = take || leave;
                }
            }
            return dp[N][sum];
        }
    }