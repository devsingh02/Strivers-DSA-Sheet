import java.util.* ;
import java.io.*; 

// // Recursion
// public class Solution {
// 	public static int maximumChocolates(int r, int c, int[][] grid) {
// 		return f(0, 0, c - 1, grid);
// 	}
// 	static int f(int i, int j1, int j2, int[][] g) {
// 		if (j1 < 0 || j1 > g[0].length - 1 || j2 < 0 || j2 > g[0].length - 1) return Integer.MIN_VALUE / 2;
// 		if (i == g.length) return 0;

// 		int max = Integer.MIN_VALUE;
// 		for (int d1 = -1; d1 <= 1; d1++) {
// 			for (int d2 = -1; d2 <= 1; d2++) {
// 				int take = f(i + 1, j1 + d1, j2 + d2, g);
// 				int val = 0;
// 				if (j1 == j2) val += g[i][j1];
// 				else val += g[i][j1] + g[i][j2];
// 				val += take;
// 				max = Math.max(max, val);
// 			}
// 		}
// 		return max;
// 	}
// }

// // Memo
// public class Solution {
// 	public static int maximumChocolates(int r, int c, int[][] grid) {
// 		int[][][] dp = new int[r][c][c];
// 		for (int[][] arr : dp) for(int[] row : arr) Arrays.fill(row, -1);
// 		return f(0, 0, c - 1, grid, dp);
// 	}
// 	static int f(int i, int j1, int j2, int[][] g, int[][][] dp) {
// 		if (j1 < 0 || j1 > g[0].length - 1 || j2 < 0 || j2 > g[0].length - 1) return Integer.MIN_VALUE / 2;
// 		if (i == g.length) return 0;
// 		if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

// 		int max = Integer.MIN_VALUE;
// 		for (int d1 = -1; d1 <= 1; d1++) {
// 			for (int d2 = -1; d2 <= 1; d2++) {
// 				int take = f(i + 1, j1 + d1, j2 + d2, g, dp);
// 				int val = 0;
// 				if (j1 == j2) val += g[i][j1];
// 				else val += g[i][j1] + g[i][j2];
// 				val += take;
// 				max = Math.max(max, val);
// 			}
// 		}
// 		return dp[i][j1][j2] = max;
// 	}
// }

// // Tabulation
// public class Solution {
// 	public static int maximumChocolates(int r, int c, int[][] g) {
// 		int[][][] dp = new int[r + 1][c + 1][c + 1];

// 		for (int i = r - 1; i >= 0; i--) {
// 			for (int j1 = 0; j1 < c; j1 ++) {
// 				for (int j2 = 0; j2 < c; j2++) {

// 					int max = Integer.MIN_VALUE;
// 					for (int d1 = -1; d1 <= 1; d1++) {
// 						for (int d2 = -1; d2 <= 1; d2++) {
// 							int take = (j1 + d1 < 0 || j1 + d1 > c - 1 || j2 + d2 < 0 || j2 + d2 > c - 1) ? Integer.MIN_VALUE : dp[i + 1][j1 + d1][j2 + d2];
// 							int val = 0;
// 							if (j1 == j2) val += g[i][j1];
// 							else val += g[i][j1] + g[i][j2];
// 							val += take;
// 							max = Math.max(max, val);
// 						}
// 					}
// 					dp[i][j1][j2] = max;
// 				}
// 			}
// 		}
// 		return dp[0][0][c - 1];
// 	}
// }

// Space Optm.
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] g) {
		int[][] nextArr = new int[c][c];

		for (int i = r - 1; i >= 0; i--) {
			int[][] currArr = new int[c][c]; //new calc for each
			for (int j1 = 0; j1 < c; j1 ++) {
				for (int j2 = 0; j2 < c; j2++) {

					int max = Integer.MIN_VALUE;
					for (int d1 = -1; d1 <= 1; d1++) {
						for (int d2 = -1; d2 <= 1; d2++) {
							int take = (j1 + d1 < 0 || j1 + d1 > c - 1 || j2 + d2 < 0 || j2 + d2 > c - 1) ? Integer.MIN_VALUE : nextArr[j1 + d1][j2 + d2];
							int val = (j1 == j2) ? g[i][j1] : g[i][j1] + g[i][j2];
							val += take;
							max = Math.max(max, val);
						}
					}
					currArr[j1][j2] = max;
				}
			}
			nextArr = currArr;
		}
		return nextArr[0][c - 1];
	}
}