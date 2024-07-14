// // Valid Window : windowlength - maxfreq char <= k

// Noobie's Approach : O(n) + O(26*n)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // counts frequencies of all
        int l = 0, r = 0, maxlen = 0, maxfreq = -1;

        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++; // inc freq by one
            maxfreq = Math.max(maxfreq, freq[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxfreq > k) { // shrink till valid
                freq[s.charAt(l) - 'A']--;
                maxfreq = 0; // recalculate maxfreq
                for (int i = 0; i < 26; i++) maxfreq = Math.max(maxfreq, freq[i]);
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}

// Valid Window : windowlength - maxfreq char <= k

// // Master's Approach : O(n)
// class Solution {
//     public int characterReplacement(String s, int k) {
//         int[] freq = new int[26]; // counts frequencies of all
//         int l = 0, r = 0, maxlen = 0, maxfreq = -1;

//         while (r < s.length()) {
//             freq[s.charAt(r) - 'A']++; // inc freq by one
//             maxfreq = Math.max(maxfreq, freq[s.charAt(r) - 'A']);
//             if ((r - l + 1) - maxfreq > k) { // shrink till valid
//                 freq[s.charAt(l) - 'A']--;
//                 // no need to calc new [smaller] maxfreq since next ans/maxfreq would be either greater or equal to current one
//                 l++;
//             }
//             if ((r - l + 1) - maxfreq <= k) maxlen = Math.max(maxlen, r - l + 1);
//             r++;
//         }
//         return maxlen;
//     }
// }