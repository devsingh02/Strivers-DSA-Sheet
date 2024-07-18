// No Rank / Size required acc to the preoblem statement
class GfG
{   
    // A : initialised to itself (contains 1 to N) == parent array (each its own parent)
    // A : will evevtually be modified to the 'parent' array after some unionSet operations
	int find(int A[], int X)
    {   if (A[X] != X) {
            A[X] = find(A, A[X]); // ultimate parent + Path compression
        }
        return A[X];
	}
	void unionSet(int A[], int X, int Z)
    {   int parX = find(A, X);
        int parZ = find(A, Z);
        
        A[parX] = parZ;
	}
}