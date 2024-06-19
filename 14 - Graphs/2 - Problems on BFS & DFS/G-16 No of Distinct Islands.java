class Solution {
    int countDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> islands = new HashSet<>(); // stores unique islands : {xRLRLz, xRLzDDLz, xRLDDLz}
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid, sb, 'x');
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }
    void dfs(int i, int j, int[][] grid, StringBuilder sb, char dir) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        
        sb.append(dir);
        grid[i][j] = 0; // visited
        dfs(i - 1, j, grid, sb, 'U');
        dfs(i, j - 1, grid, sb, 'L');
        dfs(i + 1, j, grid, sb, 'D');
        dfs(i, j + 1, grid, sb, 'R');
        sb.append('z'); // the current dfs call has stopped (imp for correct sequence of island)
    }
}
// [x] [RLRL] [LLRR] ...  => xRLRLLLRR  (Different from)
// [x] [RLRLz] [LLRRz] ...=> xRLRLzLLRRz (We clearly know which call wnded where and what dfs call is actually working)