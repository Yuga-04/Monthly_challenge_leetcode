class Solution {
    public int minimumDeletions(String s) {
        int res = 0;
        int count = 0; // Tracks the number of 'b's seen so far
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                count++;
            } else if (count != 0) {
                // Found an 'a' after 'b's.
                // We need to delete one character to resolve this "ba" pair.
                res++;
                count--;
            }
        }
        
        return res;
    }
} 
