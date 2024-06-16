// undirected graphs
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<>(); // [] 
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>()); // [[], [], [], ...., []] for n nodes
        
        for (int[] edge : edges) {
            int u = edge[0]; int v = edge[1]; // each others adjacent
            adj.get(u).add(v); // at uth index add v vertex
            adj.get(v).add(u); // at vth index add u vertex
        }
        return adj;
    }
}