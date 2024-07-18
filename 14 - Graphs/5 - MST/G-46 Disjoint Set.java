// MOTHER CODE
// Time Complexity : O(4*α)  == constant time (alpha)

public class DisjointSet {
    int[] parent, rank, size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            rank[i] = 0;
            size[i] = 1; // itself
            parent[i] = i;
        }
    }

    // Path Compression to avoid extra calc next time
    private int findPar(int x) {
        if (parent[x] != x) {
            parent[x] = findPar(parent[x]);
        }
        return parent[x];
    }

    // Union by Rank
    private void union(int x, int y) {
        int px = findPar(x);
        int py = findPar(y);

        if (px != py) { // belong to different subsets
            // Lower Rank tree gets connected to Higher Rank tree (parents)
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } 
            else if (rank[py] < rank[px]) {
                parent[py] = px;
            } 
            else { // same rank => Rank will increase
                parent[py] = px;
                rank[px]++; // Join to the first one
            }
        }
    }

//    // Union by Size
//    private void union(int x, int y) {
//        int px = findPar(x);
//        int py = findPar(y);
//
//        if (px != py) {
//            // Join Lower Size tree to Larger one
//            if (size[px] < size[py]) {
//                parent[px] = py;
//                size[py] += size[px];
//            } else { // size increases anyways
//                parent[py] = px;
//                size[px] += size[py];
//            }
//        }
//    }

    public boolean isConnected(int x, int y) {
        if (findPar(x) == findPar(y)) return true;
        return false;
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        System.out.println(ds.isConnected(3, 7));
        ds.union(3, 7);
        System.out.println(ds.isConnected(3, 7));
    }
}