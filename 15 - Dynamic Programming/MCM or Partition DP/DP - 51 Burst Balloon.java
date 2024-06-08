// MEMOIZED
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2]; // adding 1___1
        arr[0] = 1; arr[n+2 - 1] = 1;
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];

        int[][] dp = new int[n+2 + 1][n+2 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(1, n+2 - 2, arr, dp);
    }
    int f(int i, int j, int[] a, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int max = -1;
        for (int k = i; k <= j; k++) {
            int cost = a[i - 1] * a[k] * a[j + 1]
                + f(i, k - 1, a, dp) + f(k + 1, j, a, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
}

// // TABULATION
// class Solution {
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] a = new int[n + 2]; // adding 1___1
//         a[0] = 1; a[n+2 - 1] = 1;
//         for (int i = 0; i < n; i++) a[i + 1] = nums[i];

//         int[][] dp = new int[n+2 + 1][n+2 + 1];
//         // MEMO : i => 1 to n  |  j => j >= i
//         // TABL : i -> n to 1  |  j => j >= i
//         for (int i = n; i >= 1; i--) {
//             for (int j = i; j <= n; j++) {
//                 int max = -1;
//                 for (int k = i; k <= j; k++) {
//                     int cost = a[i - 1] * a[k] * a[j + 1]
//                         + dp[i][k - 1] + dp[k + 1][j];
//                     max = Math.max(max, cost);
//                 }
//                 dp[i][j] = max;
//             }
//         }
//         return dp[1][n]; //where i went, where j went
//     }
// }

// // MY OWN LOGIC :- BACKTRACKING [TOP-DOWN]
// class Solution {
//     public int maxCoins(int[] nums) {
//         List<Integer> arr = new ArrayList<>();
//         for (int I : nums) arr.add(I);

//         return f(arr);
//     }
//     int f(List<Integer> arr) {
//         if (arr.size() == 0) return 0;
        
//         int max = -1;
//         for (int i = 0; i < arr.size(); i++) {
//             int n1 = (i-1<0)?1:arr.get(i-1);
//             int n2 = arr.get(i);
//             int n3 = (i+1==arr.size())?1:arr.get(i+1);
//             int temp = n1*n2*n3;
//             arr.remove(i);
//             temp += f(arr);
//             arr.add(i, n2);
//             max = Math.max(max, temp);
//         }
//         return max;
//     }
// }