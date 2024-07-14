// Problem Link :-
// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

// // Noobie's Approach : O(2n)
// class Solution {
//     public int longestkSubstr(String s, int k) {
//         char[] str = s.toCharArray();
//         HashMap<Character, Integer> hm = new HashMap<>();
//         int l = 0, r = 0, maxlen = -1;
        
//         while (r < str.length) {
//             hm.put(str[r], hm.getOrDefault(str[r], 0) + 1);
//             while (hm.size() > k) {
//                 hm.put(str[l], hm.get(str[l]) - 1);
//                 if (hm.get(str[l]) == 0) hm.remove(str[l]);
//                 l++;
//             }
//             if (hm.size() == k) maxlen = Math.max(maxlen, r - l + 1); // only take when exact K unique characters
//             r++;
//         }
        
//         return maxlen;
//     }
// }

// Master's Approach : O(n)
class Solution {
    public int longestkSubstr(String s, int k) {
        char[] str = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0, r = 0, maxlen = -1;
        
        while (r < str.length) {
            hm.put(str[r], hm.getOrDefault(str[r], 0) + 1);
            if (hm.size() > k) {
                hm.put(str[l], hm.get(str[l]) - 1);
                if (hm.get(str[l]) == 0) hm.remove(str[l]);
                l++;
            }
            if (hm.size() == k) maxlen = Math.max(maxlen, r - l + 1); // only take when exact K unique characters
            r++;
        }
        
        return maxlen;
    }
}