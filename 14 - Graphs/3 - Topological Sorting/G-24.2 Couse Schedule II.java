// u1, u2, ..., un -> v : Topological Sort
// I) BFS : Kahn's Algo
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        // create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
        }
        // store indegrees
        int[] indg = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neig : adj.get(i)) indg[neig]++;
        }
        // offer all indg = 0 in Queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indg[i] == 0) q.offer(i);
        // BFS
        int[] topo = new int[V]; Arrays.fill(topo, -1);
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node;
            for (int neig : adj.get(node)) {
                indg[neig]--;
                if (indg[neig] == 0) q.offer(neig);
            } 
        }
        return (topo[topo.length - 1] == -1) ? new int[0] : topo; // return empty array 
    }
}

// // II) DFS Topo Sort
// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int V = numCourses;
//         // create adj list
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
//         for (int i = 0; i < prerequisites.length; i++) {
//             int u = prerequisites[i][1];
//             int v = prerequisites[i][0];
//             adj.get(u).add(v);
//         }
//         // DFS
//         boolean[] vis = new boolean[V];
//         boolean[] path = new boolean[V]; // need path since if a cycle, return empty array
//         Stack<Integer> st = new Stack<>();
//         for (int i = 0; i < V; i++) {
//             if (!vis[i]) if (dfs(i, vis, path, st, adj)) return new int[0]; // if cycle found
//         }
//         // No cycle found => means stack answer is correct
//         int[] topo = new int[st.size()];
//         for (int i = 0; i < topo.length; i++) topo[i] = st.pop();
//         return topo;
//     }
//     boolean dfs(int i, boolean[] vis, boolean[] path, Stack<Integer> st, List<List<Integer>> adj) {
//         vis[i] = true;
//         path[i] = true;
//         for (int neig : adj.get(i)) {
//             if (!vis[neig]) {
//                 if (dfs(neig, vis, path, st, adj)) return true; // cycle found in future, end here
//             }
//             else if (vis[neig] && path[neig]) return true; // cycle found here
//         }
//         path[i] = false;
//         st.push(i);
//         return false; // no cycle
//     }
// }