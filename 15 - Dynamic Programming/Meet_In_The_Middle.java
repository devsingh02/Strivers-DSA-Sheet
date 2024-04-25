// LC 1755. Closest Subsequence Sum

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length, mid = n / 2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        // 1. Split in half + create all possible subset sums
        createSums(left, 0, mid, nums, 0); // [i, mid)
        createSums(right, mid, n, nums, 0);// [mid, n)
        //2. sort right
        Collections.sort(right);
        //3. Check both : LS + BS
        // left => fixed    right => closest to remaining sum
        int closestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < left.size(); i++) {
            int l = left.get(i);
            int minAbsDiff = BS(right, goal - l);
            closestDiff = Math.min(closestDiff, minAbsDiff);
        }
        return closestDiff;
    }
    void createSums(List<Integer> sums, int i, int n, int[] nums, int sum) {
        if (i == n) {
            sums.add(sum);
            return;
        }
        createSums(sums, i + 1, n, nums, sum + nums[i]); //pick
        createSums(sums, i + 1, n, nums, sum); //dont-pick
    }
    int BS(List<Integer> list, int goal) {
        int b = 0, e = list.size() - 1;
        int ans = Integer.MAX_VALUE;
        while (b <= e) {
            int m = b + (e - b) / 2;
            int mid = list.get(m);
            ans = Math.min(ans, Math.abs(goal - mid));
            if (mid > goal) e = m - 1;
            else b = m + 1;
        }
        return ans;
    }
}