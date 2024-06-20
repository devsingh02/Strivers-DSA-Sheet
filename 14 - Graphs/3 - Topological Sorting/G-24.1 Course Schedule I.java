// looking through examples, we conclude that graph must not be cyclic
// Therefore != DAG

// I) DFS (faster)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        // creating adj list
        List<List<Integer>> adj = new ArrayList<>(); 
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1], v = prerequisites[i][0];
            adj.get(u).add(v);
        }
        // DFS
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfsCycle(i, vis, path, adj)) return false; // if cycle exists, not possible
            }
        }
        // No cycle detected
        return true;
    }
    boolean dfsCycle(int i, boolean[] vis, boolean[] path, List<List<Integer>> adj) {
        vis[i] = true;
        path[i] = true;
        for (int neig : adj.get(i)) {
            if (!vis[neig]) {
                if (dfsCycle(neig, vis, path, adj)) return true; // cycle detected in future
            }
            else if (vis[neig] && path[neig]) return true; // cycle detected right here
        }
        path[i] = false;
        return false; // no cycle detected
    }
}

// // II) BFS : Kahn's Algo
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int V = numCourses;
//         // creating adj list
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
//         for (int i = 0; i < prerequisites.length; i++) {
//             int u = prerequisites[i][1], v = prerequisites[i][0];
//             adj.get(u).add(v);
//         }
//         // Kahn's Algo
//         List<Integer> topo = new ArrayList<>();
//         Queue<Integer> q = new LinkedList<>();
//         int[] indg = new int[V];
//         // store indegrees for all
//         for (int i = 0; i < V; i++) {
//             for (int neig : adj.get(i)) indg[neig]++;
//         }
//         // offer all indegrees = 0 in Queue
//         for (int i = 0; i < V; i++) if (indg[i] == 0) q.offer(i);
//         // BFS
//         while (!q.isEmpty()) {
//             int node = q.poll();
//             topo.add(node);
//             for (int neig : adj.get(node)) {
//                 indg[neig]--;
//                 if (indg[neig] == 0) q.offer(neig);
//             }
//         }
//         // DAG if topo.size() == V
//         return topo.size() == V;
//     }
// }