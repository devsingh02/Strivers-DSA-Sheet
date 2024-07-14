// // I) Using a HashMap
// class Solution {
//     public String minWindow(String s, String t) {
//         // chars of String 't' stored as -ve 
//         HashMap<Character, Integer> hm = new HashMap<>();
//         for (int i = 0; i < t.length(); i++) {
//             char ch = t.charAt(i);
//             hm.put(ch, hm.getOrDefault(ch, 0) - 1);
//         }

//         int l = 0, r = 0, L = -1, R = -1, minlen = Integer.MAX_VALUE;
//         int count = 0; // if == t.length() => Valid Window

//         while (r < s.length()) {
//             char ch = s.charAt(r);
//             if (hm.getOrDefault(ch, 0) < 0) count++; // char of t found
//             hm.put(ch, hm.getOrDefault(ch, 0) + 1);
//             while (count == t.length()) { // window is valid
//                 if (minlen > r - l + 1) {
//                     minlen = r - l + 1;
//                     L = l; R = r;
//                 }
//                 hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
//                 if (hm.get(s.charAt(l)) < 0) count--; // t char removed
//                 l++;
//             }
//             r++;
//         }
//         return minlen == Integer.MAX_VALUE ? "" : s.substring(L, R + 1);
//     }
// }


// II) Using an Array
/*
[128] : used for all letters
[256] : used for all possible characters (letters, digits, special ch, etc.)
*/

class Solution {
    public String minWindow(String s, String t) {
        int[] hm = new int[128];
        // stored chars of t as -ve
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hm[ch]--;
        }

        int l = 0, r = 0, L = -1, R = -1, minlen = Integer.MAX_VALUE;
        int count = 0; // if == t.length() => Valid Window

        while (r < s.length()) {
            if (hm[s.charAt(r)] < 0) count++; // char of t found
            hm[s.charAt(r)]++;
            while (count == t.length()) { // window is valid
                if (minlen > r - l + 1) {
                    minlen = r - l + 1;
                    L = l; R = r;
                }
                hm[s.charAt(l)]--;
                if (hm[s.charAt(l)] < 0) count--; // t char removed : Only t can go -ve
                l++;
            }
            r++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(L, R + 1);
    }
}