// Multisource 
// Works for -ve cycle

// take unavailaible edge (-1) as inf = Integer.MAX_VALUE / 2 to prevent overflow
class Solution
{
    public void shortest_distance(int[][] matrix)
    {   // create operable matrix
        int[][] mat = matrix.clone();
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) mat[i][j] = Integer.MAX_VALUE / 2;
                if (i == j) mat[i][j] = 0; // not needed but hey...
            }
        }
        // Apply Floyd Warshall Algo
        for (int k = 0; k < n; k++) { // via e.g. 0->1 => 0->2 + 2->1. This {2} here is 'k' or 'via'
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        // Turn unreachable edges back to -1 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == Integer.MAX_VALUE / 2) mat[i][j] = -1;
            }
        }
        // Apparently we needed to modify the given matrix :-
        matrix = mat.clone();
    }
}