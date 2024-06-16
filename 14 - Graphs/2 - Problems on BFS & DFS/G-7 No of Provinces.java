// ADJACENCY MATRIX
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, isConnected);
            }
        }
        return count;
    }
    void dfs(int node, boolean[] vis, int[][] adjM) {
        vis[node] = true;
        for (int neig = 0; neig < adjM[0].length; neig++) {
            if (adjM[node][neig] == 1 && !vis[neig]) dfs(neig, vis, adjM);
        }
    }
}

//ADJACENCY LIST
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         // create Adjacency List out of Adj Matrix
//         int n = isConnected[0].length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (isConnected[i][j] == 1 && i != j) {
//                     adj.get(i).add(j);
//                     adj.get(j).add(i);
//                 }
//             }
//         }
//         // created
//         int count = 0;
//         boolean[] vis = new boolean[n];
        
//         for (int i = 0; i < n; i++) {
//             if (!vis[i]) {
//                 count++;
//                 dfs(i, vis, adj);
//             }
//         }
//         return count;
//     }
//     void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
//         vis[node] = true;
//         for (int neighbor : adj.get(node)) {
//             if (!vis[neighbor]) dfs(neighbor, vis, adj);
//         }
//     }
// }