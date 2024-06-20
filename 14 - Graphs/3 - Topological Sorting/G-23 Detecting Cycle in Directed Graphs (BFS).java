// DFS : Backtracking using path[]
// BFS : Using indegree[] and queue

// BFS : Kahn's Algo
// if a cycle exist => topo[] < V (basically not giving the ans it should give)

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indg = new int[V];
        // filling indegree array
        for (int i = 0; i < V; i++) {
            for (int neig : adj.get(i)) indg[neig]++;
        }
        // Putting ALL indg == 0 in Queue
        for (int i = 0; i < V; i++) {
            if (indg[i] == 0) q.offer(i);
        }
        // BFS
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int neig : adj.get(node)) {
                indg[neig]--;
                if (indg[neig] == 0) q.offer(neig);
            }
        }
        if (topo.size() == V) return false; // doesn't contain a cycle
        else return true;
    }
}