class Solution {
    public int minDeletionSize(String[] A) {
        int n = A.length;
        if(n == 0) {
            return 0;
        }
        int w = A[0].length();    /* length of each word */
        int truth = 1; /* we assume the last element is sorted (or first, depending on your code) */
        int j;
        boolean[] sorted = new boolean[n - 1]; /* tells us if we know if an element is sorted */
        int delete = 0;
        for(int i = 0; i < w; i++) {
            
            for(j = 0; j < n - 1; j++) {
                if(!sorted[j] && (A[j].charAt(i) > A[j + 1].charAt(i))) {
                    delete++;
                    break;  /* no need to continue checking, we know the column is not 100% in order */
                }
            }
            
            if(j < n - 1) {
                continue;
            }
            for(int k = 0; k < n - 1; k++) {
                if(!sorted[k] && A[k].charAt(i) < A[k + 1].charAt(i)) {
                    sorted[k] = true;
                    truth++;
                }
            }
            if(truth == n) {
                return delete;
            }
        }
        return delete;
    }
} 
