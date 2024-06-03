// NEW - BRILLIANT

// // MEMOIZED
// class Solution{
    
//     public final int MOD = (int)1e9 + 7;
    
// 	public int perfectSum(int arr[],int n, int sum) 
// 	{ 
// 	    int[][] dp = new int[n + 1][sum + 1];
// 	    for (int[] row : dp) Arrays.fill(row, -1);
	    
// 	    return f(n, sum, arr, dp);
// 	} 
	
// 	int f(int n, int sum, int[] arr, int[][] dp) {
//         if (n == 0) return sum == 0 ? 1 : 0; // Base case: return 1 if sum is 0, else 0
        
//         if (dp[n][sum] != -1) return dp[n][sum];

//         int curr = arr[n - 1];
//         int take = (curr <= sum) ? f(n - 1, sum - curr, arr, dp) : 0;
//         int leave = f(n - 1, sum, arr, dp);
//         return dp[n][sum] = (take + leave) % MOD;
//     }
// }

// TABULIZED
class Solution{
    
    public final int MOD = (int)1e9 + 7;
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[][] dp = new int[n + 1][sum + 1];
	    
	    dp[0][0] = 1;
	    for (int j = 1; j < sum + 1; j++) dp[0][j] = 0;
	    
	    for (int i = 1; i < n + 1; i++) {
	        for (int j = 0; j < sum + 1; j++) {
	            int curr = arr[i - 1];
                int take = (curr <= j) ? dp[i - 1][j - curr] : 0;
                int leave = dp[i - 1][j];
                dp[i][j] = (take + leave) % MOD;
	        }
	    }
	    return dp[n][sum];
	} 
}

//-----------------------------------------------------------------------------------------------------------

// OLD - DONT EVEN LOOK AT IT

/* Learn to take modulos :-
    10 ^ 9 + 7 = 1000000007
*/
// // Memo
// public class Solution {
//     public static int findWays(int num[], int tar) {
//         int n = num.length, k = tar;
//         int[][] dp = new int[n + 1][k + 1]; for (int[] row : dp) Arrays.fill(row, -1);
//         return f(n, k, num, dp);
//     }
//     static int f(int n, int k, int[] nums, int[][] dp) {
//         // if (k == 0) return 1; // cant since will not take 0s
//         if (n == 0 || k < 0) return 0;
//         if (dp[n][k] != -1) return dp[n][k];

//         int curr = nums[n - 1]; int take = 0;
//         if (curr == k) take += 1;
//         take += f(n - 1, k - curr, nums, dp);
//         int leave = f(n - 1, k, nums, dp);
//         return dp[n][k] = (take + leave) % 1000000007;
//     }
// }

// /* For k == 0 -> We have to calculate -> so start from j = 0 */
// // Tabulation
// public class Solution {
//     public static int findWays(int nums[], int tar) {
//         int n = nums.length, k = tar;
//         int[][] dp = new int[n + 1][k + 1];
        
//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 0; j < k + 1; j++) {
//                 int curr = nums[i - 1]; int take = 0;
//                 if (curr == j ) take += 1;
//                 take += (j - curr >= 0) ? dp[i - 1][j - curr] : 0; // handled k < 0 dont take
//                 int leave = dp[i - 1][j];
//                 dp[i][j] = (take + leave) % 1000000007;
//             }
//         }
//         return dp[n][k];
//     }
// }

// // Space Optm.
// public class Solution {
//     public static int findWays(int nums[], int tar) {
//         int n = nums.length, k = tar;
//         int[] prevRow = new int[k + 1];

//         for (int i = 1; i < n + 1; i++) {
//             int[] currRow = new int[k + 1];
//             for (int j = 0; j < k + 1; j++) {
//                 int curr = nums[i - 1]; int take = 0;
//                 if (curr == j) take += 1;
//                 take += (j - curr >= 0) ? prevRow[j - curr] : 0; // handled k < 0
//                 int leave = prevRow[j];
//                 currRow[j] = (take + leave) % 1000000007;
//             }
//             prevRow = currRow;
//         }
//         return prevRow[k];
//     }
// }