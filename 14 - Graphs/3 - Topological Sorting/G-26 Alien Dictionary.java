// https://www.geeksforgeeks.org/problems/alien-dictionary/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=alien-dictionary

// ** Adjacency List of Integers can be created only :- for String/char :- << -'a' >>

class Solution
{
    public String findOrder(String [] dict, int N, int K) {
        // create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) adj.add(new ArrayList<>());
        // fill adj list
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';
                if (u != v) { // 1st comparison is most imp. rest don't take
                    adj.get(u).add(v);
                    break;
                }
            }
        }
        // Topo Sort => fails if cycle exists
        boolean[] vis = new boolean[K];
        boolean[] path = new boolean[K];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < K; i++) {
            if (!vis[i]) if (dfsCycle(i, vis, path, st, adj)) return ""; // if cycle == true : No topo sort possible
        }
        String str = "";
        while (!st.isEmpty()) {
            str += (char)(st.pop() + 'a'); // (char)(int) => char
        }
        return str;
    }
    
    boolean dfsCycle(int i, boolean[] vis, boolean[] path, Stack<Integer> st, List<List<Integer>> adj) {
        vis[i] = true;
        path[i] = true;
        for (int neig : adj.get(i)) {
            if (!vis[neig]) {
                if (dfsCycle(neig, vis, path, st, adj)) return true; // cycle found in future
            } 
            else if (vis[neig] && path[neig]) return true; // cycle found right here
        }
        path[i] = false;
        st.push(i);
        return false; // no cycle found
    }
}