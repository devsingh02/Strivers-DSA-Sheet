// Mother Code :-
package _11_Graphs;
import java.util.*;

public class Dijkstra {
    public static int[] dijkstra(List<List<int[]>> adj, int V, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // compare wrt to second index in array
        // for pushing ArrayList :-                                        // a -> a.get(1)
        // for using Pair class :-
     // PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.dist - b.dist); // compare wrt to dist in Pair class
        // where a & b are two elements in Pair class => compare wrt their dist
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // filled all with infinity
        dist[src] = 0;
        pq.offer(new int[]{src, 0}); // new ArrayList<>(Arrays.asList(src, 0))

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], d = node[1]; // d -> dist from source
            if (d > dist[u]) continue; // skip (don't check neigs) if dist from src greater than already calculated

            for (int[] neig : adj.get(u)) {
                int v = neig[0], wt = neig[1];
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    pq.offer(new int[]{v, d + wt});
                }
            }
        }

        return dist;
    }

    public static List<Integer> shortestPath(int start, int stop, int V, List<List<int[]>> adj) {
       // Creating prev[] array to backtrack in future
        List<Integer> path = new ArrayList<>();
        int[] prev = new int[V];
        prev[start] = start; // stop here

        // Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], d = node[1];
            if (d > dist[u]) continue;

            for (int[] neig : adj.get(u)) {
                int v = neig[0], wt = neig[1];
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    pq.offer(new int[]{v, d + wt});
                    prev[v] = u; // where that shortest path comes from
                }
            }
        }

        // Backtracking the path
        if (dist[stop] == Integer.MAX_VALUE) return new ArrayList<>(Arrays.asList(-1));

        int i = stop;
        while (prev[i] != i) {
            path.add(i);
            i = prev[i];
        }
        path.add(i); // add 1 also

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Example graph represented as adjacency list
        List<List<int[]>> adj = new ArrayList<>();

        // Number of vertices
        int V = 6;

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph in Copy Notes
        // Edge from vertex 0 to 1 with weight 4
        adj.get(0).add(new int[]{1, 4});
        adj.get(0).add(new int[]{2, 4});
        adj.get(1).add(new int[]{0, 4});
        adj.get(1).add(new int[]{2, 2});
        adj.get(2).add(new int[]{3, 3});
        adj.get(2).add(new int[]{4, 1});
        adj.get(2).add(new int[]{5, 6});
        adj.get(3).add(new int[]{2, 3});
        adj.get(3).add(new int[]{5, 2});
        adj.get(4).add(new int[]{2, 1});
        adj.get(4).add(new int[]{5, 3});
        adj.get(5).add(new int[]{2, 6});
        adj.get(5).add(new int[]{3, 2});
        adj.get(5).add(new int[]{4, 3});

        // Source vertex
        int src = 0;

        // Call the dijkstra function
        int[] ans = dijkstra(adj, V, src);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        // Printing Path
        System.out.println("Path from start = 0 to stop = 5 is : " + shortestPath(0, 5, V, adj));
    }
}

// G-35 Problem 
// link :- https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // creating adj list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        
        // Creating prev[] array to backtrack in future
        List<Integer> path = new ArrayList<>();
        int[] prev = new int[n + 1];
        prev[1] = 1; // stop here
        
        // Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1]; // 1 to n
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], d = node[1];
            if (d > dist[u]) continue;
            
            for (int[] neig : adj.get(u)) {
                int v = neig[0], wt = neig[1];
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    pq.offer(new int[]{v, d + wt});
                    prev[v] = u; // where that shortest path comes from
                }
            }
        }
        
        // Backtracking the path
        if (dist[n] == Integer.MAX_VALUE) return new ArrayList<>(Arrays.asList(-1));
        
        int i = n;
        while (prev[i] != i) {
            path.add(i);
            i = prev[i];
        }
        path.add(i); // add 1 also
        path.add(dist[n]); // add the wt of the path as first element also
        
        Collections.reverse(path);
        return path;
    }
}