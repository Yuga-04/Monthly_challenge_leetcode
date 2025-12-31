class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1_000_000_007L;
        java.util.HashMap<Integer, Long> map = new java.util.HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0L) + 1);
        }
        java.util.ArrayList<Long> seg = new java.util.ArrayList<>();
        for (long k : map.values()) {
            if (k >= 2) seg.add((k * (k - 1) / 2) % MOD);
        }
        long sum = 0, ans = 0;
        for (long v : seg) {
            ans = (ans + v * sum) % MOD;
            sum = (sum + v) % MOD;
        }
        return (int) ans;
    }
} 
