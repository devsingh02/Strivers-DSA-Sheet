// // BFS
// class Solution{
//     static char[][] fill(int n, int m, char a[][]){
//         boolean[][] vis = new boolean[n][m];
//         Queue<int[]> q = new LinkedList<>();
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0 ; j < m; j++) { // Boundary
//                 if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
//                     if (a[i][j] == 'O') {
//                         q.offer(new int[] {i, j});
//                         vis[i][j] = true;
//                     }
//                 }
//             }
//         }
        
//         // neighbors : up, left, down, right
//         int[] dx = {-1,  0, 1, 0};
//         int[] dy = { 0, -1, 0, 1};
        
//         // BFS
//         while (!q.isEmpty()) {
//             int[] node = q.poll();
//             for (int i = 0; i < 4; i++) {
//                 int r = node[0] + dx[i];
//                 int c = node[1] + dy[i];
//                 if (r >= 0 && r < n && c >= 0 && c < m && !vis[r][c] && a[r][c] == 'O') {
//                     q.offer(new int[] {r, c});
//                     vis[r][c] = true;
//                 }
//             }
//         }
        
//         char[][] ans = new char[n][m];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (vis[i][j]) ans[i][j] = 'O';
//                 else ans[i][j] = 'X';
//             }
//         }
//         return ans;
//     }
// }

// DFS
class Solution{
    static char[][] fill(int n, int m, char a[][]){
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) { // Boundary
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (a[i][j] == 'O') dfs(i, j, vis, a);
                }
            }
        }
        
        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]) ans[i][j] = 'O';
                else ans[i][j] = 'X';
            }
        }
        return ans;
    }
    
    static void dfs(int i, int j, boolean[][] vis, char a[][]) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || vis[i][j] || a[i][j] == 'X') return;
        
        vis[i][j] = true;
        dfs(i - 1, j, vis, a);
        dfs(i, j - 1, vis, a);
        dfs(i + 1, j, vis, a);
        dfs(i, j + 1, vis, a);
    }
}