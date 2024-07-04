class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // creating dist matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE / 2;;
            }
        }
        // filling dist matrix
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        // Apply Floyd Warshal
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        // Find city connected with smallest no of cities (city not connected -> Integer.MAX_VALUE/2)
        int min = n + 1;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int ct = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) ct++; // inf will not be counted
            }
            if (min >= ct) {
                min = ct;
                city = i;
            }
        }
        return city;
    }
}

