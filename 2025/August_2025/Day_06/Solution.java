class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int N = 1;
        while(N <= n) N <<= 1;
        // Build the segment tree
        int[] segTree = new int[N << 1];
        for (int i = 0; i < n; i++)
        segTree[N + i] = baskets[i];
        for (int i = N - 1; i > 0; i--) 
        segTree[i] = Math.max(segTree[2 * i], segTree[2 * i + 1]);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int x = fruits[i];
            int index = 1; // Start from the root of the segment tree
            if (segTree[index] < x) {
                count++;
                continue;
            }
            // Query the first valid basket
            while (index < N) {
                if (segTree[index * 2] >= x) 
                index *= 2;
                else
                index = index * 2 + 1;
            }
            // Mark the found basket as used and update the segment tree
            segTree[index] = -1;
            while (index > 1) {
                index >>= 1;
                segTree[index] = Math.max(segTree[2 * index], segTree[2 * index + 1]);
            }
        }
        return count;     
    }
} 
