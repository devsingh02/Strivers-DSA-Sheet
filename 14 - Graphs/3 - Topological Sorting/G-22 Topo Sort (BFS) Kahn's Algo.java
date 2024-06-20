// Topo Sort (BFS) : Kahn's Algo

/*
    1. Store indegree of all nodes.
    2. Offer all nodes with indegree = 0 in Queue.
    3. Pop and reduce neighbours indegree by 1. [Repeat]
*/

class Solution
{   //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indg = new int[V];
        Queue<Integer> q = new LinkedList<>();
        // making indegree array
        for (int i = 0; i < V; i++) {
            for (int neig : adj.get(i)) indg[neig]++; // 0 -> 1 : 1's indegree increases
        }
        // Start BFS
        for (int i = 0; i < V; i++) {
            if (indg[i] == 0) q.offer(i); //  add ALL nodes with indegrees = 0 in Queue
        }
        int[] topo = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node; // add in ans
            for (int neig : adj.get(node)) {
                indg[neig]--;
                if (indg[neig] == 0) q.offer(neig); // no need to check all, since only they can become 0
            }
        }
        return topo;
    }
}