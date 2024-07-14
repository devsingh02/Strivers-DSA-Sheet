// // Noobie's Approach I : O(2n) => l also shrink to last
// class Solution {
//     public static int totalFruits(int N, int[] fruits) {
//         HashMap<Integer, Integer> hm = new HashMap<>(); // num -> count
//         int l = 0, r = 0, maxlen = 0;
        
//         while (r < fruits.length) {
//             hm.put(fruits[r], hm.getOrDefault(fruits[r], 0) + 1); // give 0 if not present
//             while (hm.size() > 2) {
//                 hm.put(fruits[l], hm.get(fruits[l]) - 1);
//                 if (hm.get(fruits[l]) == 0) hm.remove(fruits[l]);
//                 l++;
//             }
//             maxlen = Math.max(maxlen, r - l + 1);
//             r++;
//         }
//         return maxlen;
//     }
// }

// Master's Approach II : O(n) => window size remains same till other max found
class Solution {
    public static int totalFruits(int N, int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // num -> count
        int l = 0, r = 0, maxlen = 0;
        
        while (r < fruits.length) {
            hm.put(fruits[r], hm.getOrDefault(fruits[r], 0) + 1); // give 0 if not present
            if (hm.size() > 2) { // shrink by one
                hm.put(fruits[l], hm.get(fruits[l]) - 1);
                if (hm.get(fruits[l]) == 0) hm.remove(fruits[l]);
                l++;
            }
            if (hm.size() == 2) maxlen = Math.max(maxlen, r - l + 1);
            r++; // move ahead one => maintaining same length of window
        }
        return maxlen;
    }
}



// // Best if not choose EVERY tree from left to right (contiguous subarray)
// class Solution {
//     public static int totalFruits(int N, int[] fruits) {
//         HashMap<Integer, Integer> map = new HashMap<>(); // number -> count
//         for (int I : fruits) {
//             if (!map.containsKey(I)) {
//                 map.put(I, 1);
//             } else {
//                 map.put(I, map.get(I) + 1); // update by one
//             }
//         }
//         int max1 = -1, max2 = -1;
//         for (int V : map.values()) {
//             if (max1 < V) {
//                 max2 = max1;
//                 max1 = V;
//             }
//             else if (V <= max1 && V > max2) max2 = V;
//         }
//         return max1 + max2;
//     }
// }