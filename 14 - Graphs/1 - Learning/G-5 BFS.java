// In BFS : We vis[i] = true together with adding it to the queue. In DFS : We vis[i] = true after adding it to the stack (recursion).

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        // starting from 0 node
        q.offer(0); vis[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);
            for (int neighbor : adj.get(node)) { // adj stores the node's adjacent nodes (neighbors)
                if (vis[neighbor]) continue; // if already visited, skip
                q.offer(neighbor);
                vis[neighbor] = true;
            }
        }
        return bfs;
    }
}