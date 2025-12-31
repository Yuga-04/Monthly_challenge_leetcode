class Solution {
    public int countTriples(int n) {
        int cnt = 0;
        // Iterate a from 1 to n
        for (int a = 1; a < n; a++) {
            // Iterate b from a + 1 to n to avoid duplicates in loop logic
            for (int b = a + 1; b < n; b++) {
                int sumSquares = a * a + b * b;
                int c = (int) Math.sqrt(sumSquares);
                
                // Check if c is a perfect square and within range
                if (c * c == sumSquares && c <= n) {
                    cnt += 2; // Count both (a, b, c) and (b, a, c)
                }
            }
        }
        return cnt;
    }
}

 
