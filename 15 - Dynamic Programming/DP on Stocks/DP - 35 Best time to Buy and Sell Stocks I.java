// // Brute Force (for loop)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;

//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int profit = prices[j] - prices[i];
//                 max = Math.max(max, profit);
//             }
//         }
//         return max;
//     }
// }

/*
    If you are selling on 'i'th  day,
    you buy on min price from 0 to i - 1 day.
*/

// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int max = Integer.MIN_VALUE; int minBuy = prices[0];
//         for (int i = 0; i < n; i++) {
//             int profit = prices[i] - minBuy;
//             max = Math.max(max, profit);
//             minBuy = Math.min(minBuy, prices[i]);
//         }
//         return max;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0; int min = Integer.MAX_VALUE;
        for (int I : prices) {
            min = Math.min(min, I);
            ans = Math.max(ans, I - min);
        }
        return ans;
    }
}