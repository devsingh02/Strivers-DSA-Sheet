// O(n)
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastScene = {-1, -1, -1}; // for 'a', 'b', 'c'

        int count = 0;
        for (int i = 0; i < n; i++) {
            lastScene[s.charAt(i) - 'a'] = i;
            count += 1 + Math.min(lastScene[0], Math.min(lastScene[1], lastScene[2]));
            // automatically wont count if eiter is -1 (min window not formed)
        }
        return count;
    }
}