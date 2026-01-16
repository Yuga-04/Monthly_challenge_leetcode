class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // 1. Add implicit boundary fences to new lists
        // We use Arrays to facilitate sorting and resizing
        int[] h = Arrays.copyOf(hFences, hFences.length + 2);
        h[hFences.length] = 1;
        h[hFences.length + 1] = m;
        
        int[] v = Arrays.copyOf(vFences, vFences.length + 2);
        v[vFences.length] = 1;
        v[vFences.length + 1] = n;

        // 2. Sort arrays
        Arrays.sort(h);
        Arrays.sort(v);

        // 3. Store all possible horizontal gaps
        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hGaps.add(h[j] - h[i]);
            }
        }

        // 4. Check vertical gaps
        long maxSide = -1;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int currentGap = v[j] - v[i];
                if (hGaps.contains(currentGap)) {
                    maxSide = Math.max(maxSide, currentGap);
                }
            }
        }

        if (maxSide == -1) return -1;

        // 5. Return result modulo 10^9 + 7
        long MOD = 1_000_000_007;
        return (int) ((maxSide * maxSide) % MOD);
    }
} 
