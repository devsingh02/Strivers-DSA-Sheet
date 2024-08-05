class DisjointSet {
    int[] par, rank;
    DisjointSet(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    int findPar(int x) {
        if (par[x] != x) {
            par[x] = findPar(par[x]); // Path Compression
        }
        return par[x];
    }

    void union(int x, int y) {
        int px = findPar(x);
        int py = findPar(y);

        if (px != py) {
            if (rank[px] < rank[py]) par[px] = py;
            else if (rank[py] < rank[px]) par[py] = px;
            else {
                par[py] = px;
                rank[px]++;
            }
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int mR = -1, mC = -1; // max Row, max Col
        for (int[] stone : stones) {
            int r = stone[0], c = stone[1];
            mR = Math.max(mR, r);
            mC = Math.max(mC, c);
        }
        DisjointSet ds = new DisjointSet((mC + mR + 1) + 1); // last node : mC+mR+1 (0-indexing)
        // Building DS
        for (int[] stone : stones) {
            int r = stone[0], c = stone[1];
            ds.union(r, c + mR + 1);
        }
        // Finding valid Components
        int comps = 0;
        for (int i = 0; i < mC + mR + 1; i++) {
            if (ds.par[i] == i && ds.rank[i] != 0) {
                comps++;
            }
        }

        return stones.length - comps;
    }
}

// // OR :- (making use of constraint)
// class Solution {
//     public int removeStones(int[][] stones) {
//         DisjointSet ds = new DisjointSet((10000-0 + 1)*2);
//         // Building DS
//         for (int[] stone : stones) {
//             int r = stone[0], c = stone[1];
//             ds.union(r, c + 10001);
//         }
//         // Finding valid Components
//         int comps = 0;
//         for (int i = 0; i < 20002; i++) {
//             if (ds.par[i] == i && ds.rank[i] != 0) {
//                 comps++;
//             }
//         }

//         return stones.length - comps;
//     }
// }