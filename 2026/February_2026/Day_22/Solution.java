class Solution {
    public int binaryGap(int n) {
        int maxdist = 0;
        int currdist = 0;
        boolean found = false;
        
        while (n > 0) {
            int bit = n % 2;
            
            if (bit == 1) {
                if (found) {
                    maxdist = Math.max(maxdist, currdist);
                }
                currdist = 1;
                found = true;
            } else {
                if (found) {
                    currdist++;
                }
            }
            
            n /= 2;
        }
        
        return maxdist;
    }
} 
