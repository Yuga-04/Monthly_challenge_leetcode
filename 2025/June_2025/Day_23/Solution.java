class Solution {
    public long kMirror(int k, int n) {
        // Step 1: Initialize sum
        long sum = 0;

        // Step 1: Initialize counter
        int found = 0;

        // Step 2: Loop over increasing decimal palindrome lengths
        for (int len = 1; found < n; len++) {
            int start = (int) Math.pow(10, (len - 1) / 2); // Start of half
            int end = (int) Math.pow(10, (len + 1) / 2); // End of half

            // Step 3: Generate decimal palindromes using half and mirroring
            for (int half = start; half < end; half++) {
                long pal = createPalindrome(half, len % 2 == 1); // Step 3

                // Step 4: Check if the number is also a base-k palindrome
                if (isBaseKPalindrome(pal, k)) {
                    // Step 5: Add to sum
                    sum += pal;

                    // Step 5: Increment count
                    found++;

                    // Step 6: If enough numbers found, return
                    if (found == n) {
                        return sum;
                    }
                }
            }
        }

        return sum; // Final return
    }

    // Step 3 helper: Create full decimal palindrome from half
    private long createPalindrome(int half, boolean odd) {
        long pal = half;
        if (odd) {
            half /= 10; // Drop last digit for odd-length palindromes
        }

        while (half > 0) {
            pal = pal * 10 + (half % 10); // Mirror digit
            half /= 10;
        }

        return pal;
    }

    // Step 4 helper: Check if number is palindrome in base-k
    private boolean isBaseKPalindrome(long num, int k) {
        long rev = 0;
        long orig = num;
        while (num > 0) {
            rev = rev * k + (num % k); // Reconstruct reverse of base-k
            num /= k;
        }

        return rev == orig;
    }
} 
