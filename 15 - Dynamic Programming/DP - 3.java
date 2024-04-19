import java.util.* ;
import java.io.*; 
public class Solution {
    // // RECURSIVE
    // public static int frogJump(int n, int heights[]) {
    //     if (n == 2) return Math.abs(heights[1] - heights[0]);
    //     if (n == 1) return 0;
    //     int one = Math.abs(heights[n-1] - heights[n-2]) + frogJump(n-1, heights);
    //     int two = Math.abs(heights[n-1] - heights[n-3]) + frogJump(n-2, heights);
    //     return Math.min(one, two);
    // }

    // MEMOIZED
    public static int frogJump(int n, int heights[]) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) memo[i] = -1;
        return f(n, heights, memo);
    }
    static int f(int n, int[] heights, int[] memo) {
        if (n == 2) return Math.abs(heights[1] - heights[0]);
        if (n == 1) return 0;
        if (memo[n] != -1) return memo[n];
    
        int one = Math.abs(heights[n-1] - heights[n-2]) + f(n-1, heights, memo);
        int two = Math.abs(heights[n-1] - heights[n-3]) + f(n-2, heights, memo);
        return memo[n] = Math.min(one, two);
    }
}