// // if gives a cycle => dont take

// DFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        boolean[] ans = new boolean[V]; // stores ans such taht no need to sort
        for (int i = 0; i < V; i++) {
            if (!vis[i]) dfs(i, vis, path, ans, graph);
        }

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < V; i++) if (ans[i]) A.add(i);
        return A; 
    }
    boolean dfs(int i, boolean[] vis, boolean[] path, boolean[] ans, int[][] graph) {
        vis[i] = true;
        path[i] = true;
        for (int neig : graph[i]) {
            if (!vis[neig]) {
                if (dfs(neig, vis, path, ans, graph)) return true; // cycle found in future in any path => not safe, exit here
            }
            else if (vis[neig] && path[neig]) return true; // cycle found here
        }
        // no cycle found => terminal node => safe
        path[i] = false;
        ans[i] = true; // ans stored
        return false;
    }
}

// // BFS : Reverse the edges => terminal nodes indg = 0 => Topo sort (kahn's Algo)
// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length;
//         List<List<Integer>> adjR = new ArrayList<>();
//         for (int i = 0; i < V; i++) adjR.add(new ArrayList<>());
//         for (int i = 0; i < V; i++) {
//             for (int neig : graph[i]) {
//                 adjR.get(neig).add(i); // reverse the edges
//             }
//         }
//         // BFS
//         Queue<Integer> q = new LinkedList<>();
//         List<Integer> ans = new ArrayList<>();
//         int[] indg = new int[V];
//         for (int i = 0; i < V; i++) {
//             for (int neig : adjR.get(i)) indg[neig]++;
//         }
//         for (int i = 0; i < V; i++) if (indg[i] == 0) q.offer(i);

//         while (!q.isEmpty()) {
//             int node = q.poll();
//             ans.add(node);
//             for (int neig : adjR.get(node)) {
//                 indg[neig]--;
//                 if (indg[neig] == 0) q.offer(neig);
//             }
//         }
        
//         Collections.sort(ans);
//         return ans;
//     }
// }