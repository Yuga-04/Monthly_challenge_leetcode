class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1; // we already include 1 in our result

        while (k > 0) {
            long count = getCount(curr, n);
            if (count <= k) {
                // skip current prefix subtree
                curr++;
                k -= count;
            } else {
                // go deeper in the tree
                curr *= 10;
                k -= 1;
            }
        }
        return (int) curr;
    }

    private long getCount(long prefix, long n) {
        long count = 0;
        long current = prefix;
        long next = prefix + 1;

        while (current <= n) {
            count += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return count;
    }
} 
