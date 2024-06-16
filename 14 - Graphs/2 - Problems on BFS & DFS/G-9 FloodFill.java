class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image; int scol = image[sr][sc]; // source color
        int m = ans.length, n = ans[0].length;
        if (scol != color) dfs(sr, sc, scol, color, ans); // to avoid the worst possible scenario => to search the entire image
        return ans;
    }
    private void dfs(int i, int j, int scol, int fill, int[][] ans) {
        if (i < 0 || i >= ans.length || j < 0 || j >= ans[0].length || ans[i][j] != scol) 
            return;
        
        ans[i][j] = fill;
        dfs(i - 1, j, scol, fill, ans);
        dfs(i, j - 1, scol, fill, ans);
        dfs(i + 1, j, scol, fill, ans);
        dfs(i, j + 1, scol, fill, ans);
    }
}
// if (scol == color) return image;
// if (i - 1 >= 0 && ans[i - 1][j] == scol && ans[i - 1][j] != fill) dfs(i - 1, j, scol, fill, ans);
// if (j - 1 >= 0 && ans[i][j - 1] == scol&& ans[i][j - 1] != fill) dfs(i, j - 1, scol, fill, ans);
// if (i + 1 < ans.length && ans[i + 1][j] == scol && ans[i + 1][j] != fill) dfs(i +1, j, scol, fill, ans);
// if (j + 1 < ans[0].length && ans[i][j + 1] == scol && ans[i][j + 1] != fill) dfs(i, j + 1, scol, fill, ans);