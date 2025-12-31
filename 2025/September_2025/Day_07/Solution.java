class Solution {
    public int[] sumZero(int n) {
        int[] a = new int[n];
        int idx = 0;

        if (n % 2 != 0) {
            a[idx++] = 0;
        }

        for (int i = 1; i <= n / 2; i++) {
            a[idx++] = i;
            a[idx++] = -i;
        }

        return a;
    }
} 
