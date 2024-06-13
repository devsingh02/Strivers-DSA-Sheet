class Solution {

    Comparator<String> comp = (s1, s2) -> s1.length() - s2.length(); // Sort the strings in ASCENDING order

    public int longestStrChain(String[] words) {
        Arrays.sort(words, comp); //***

        int n = words.length;
        int[] dp = new int[n]; Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (subseq(words[prev], words[i]) && 1 + dp[prev] > dp[i])
                    dp[i] = 1 + dp[prev];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    boolean subseq(String s1, String s2) { // s1 < s2  
        int n1 = s1.length(), n2 = s2.length();
        if (n1 + 1 != n2) return false;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (s1.charAt(i) == s2.charAt(j)) i++; // matched => match others
            j++; // move longer string's pointer ahead
        }
        return i == n1; // check if all characters of s1 have been matched
    }
    // IMAGINE : s1 = abc ; s2 = abcd
}