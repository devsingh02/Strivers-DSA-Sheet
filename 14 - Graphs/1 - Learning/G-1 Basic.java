class Solution {
    static long count(int n) {
        // Calculate number of edges possible : nC2
        int numEdges = (n * (n - 1)) / 2; 
        
        // Calculate the number of graphs, which is 2^numEdges
        long numberOfGraphs = (long)Math.pow(2, numEdges);
        
        return numberOfGraphs;
    }
}