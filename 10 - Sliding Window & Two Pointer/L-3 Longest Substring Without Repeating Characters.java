class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxlen = 0;
        int[] memo = new int[256]; // Hashmap : char -> index
        Arrays.fill(memo, -1); // not reached
        
        while (r < s.length()) {
            if (memo[s.charAt(r)] >= l) { // means != -1 naturally  // l must not move backward  // l is responsible for shrinking
                l = memo[s.charAt(r)] + 1;
            }
            memo[s.charAt(r)] = r;
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }
}