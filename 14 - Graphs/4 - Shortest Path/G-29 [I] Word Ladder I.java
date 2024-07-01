class Pair {
    String word;
    int steps;
    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); //***
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            String word = node.word;
            int steps = node.steps;

            if (word.equals(endWord)) return steps; //***

            for (int i = 0; i < word.length(); i++) {
                char[] charArray = word.toCharArray(); //***
                char ogChar = charArray[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == ogChar) continue;

                    charArray[i] = ch; // updated word
                    String newWord = new String(charArray);
                    if (wordSet.contains(newWord)) {
                        queue.add(new Pair(newWord, steps + 1));
                        wordSet.remove(newWord); // so that it doesn't repeat
                    }
                }
            }
        }
        return 0; // if endWord not found
    }
}


// // MyY OWN LOGIC
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         List<String> nodes = wordList;
//         if (!nodes.contains(beginWord)) {
//             nodes.add(0, beginWord); //src -> 0th index
//         } else {
//             nodes.remove(beginWord);
//             nodes.add(0, beginWord); // put goal at end
//         }
//         // System.out.println(nodes);
//         if (!nodes.contains(endWord)) {
//             return 0; // edge case
//         } else {
//             nodes.remove(endWord);
//             nodes.add(endWord);
//         }
//         int n = nodes.size();
//         // creating adj list (Undirectional graph)
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
//         for (int u = 0; u < n; u++) {
//             for (int v = u + 1; v < n; v++) {
//                 if (edgeExists(nodes.get(u), nodes.get(v))) {
//                     adj.get(u).add(v);
//                     adj.get(v).add(u);
//                 }
//             }
//         }
//         System.out.println(adj);
//         // BFS => for shortest path in undirected graph
//         int[] dist = new int[n];
//         Arrays.fill(dist, -1);
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(0);
//         dist[0] = 0;
        
//         while (!q.isEmpty()) {
//             int node = q.poll();
//             for (int neig : adj.get(node)) {
//                 if (dist[neig] == -1) {
//                     dist[neig] = dist[node] + 1;
//                     q.offer(neig);
//                 }
//             }
//         }
//         return dist[n - 1] + 1; // include itself also
//     }
//     boolean edgeExists(String s1, String s2) {
//         if (s1 == s2) return false; // if same word exists in dict, dont create edge
//         int diff = 0;
//         for (int i = 0; i < s1.length(); i++) if (s1.charAt(i) != s2.charAt(i)) diff++;
//         if (diff == 1) return true;
//         else return false;
//     }
// }