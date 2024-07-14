class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = k - 1, r = n - 1;
        int sum = 0;
        for (int i = 0; i <= l; i++) {
            sum += cardPoints[i];
        }
        
        int maxSum = sum;
        while (k > 0) {
            sum = sum - cardPoints[l]  + cardPoints[r]; // remove one element from left window, add one on right
            maxSum = Math.max(maxSum, sum);
            l--; r--;
            k--;
        }
        return maxSum;
    }
}