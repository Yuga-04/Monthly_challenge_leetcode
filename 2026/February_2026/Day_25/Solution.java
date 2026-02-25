class Solution {
    public int[] sortByBits(int[] arr) {
        java.util.TreeMap<Integer, java.util.PriorityQueue<Integer>> bitmap = new java.util.TreeMap<>();
        
        for (int val : arr) {
            int bits = Integer.bitCount(val);
            bitmap.putIfAbsent(bits, new java.util.PriorityQueue<>());
            bitmap.get(bits).add(val);
        }
        
        int[] ans = new int[arr.length];
        int index = 0;
        
        for (int key : bitmap.keySet()) {
            java.util.PriorityQueue<Integer> pq = bitmap.get(key);
            while (!pq.isEmpty()) {
                ans[index++] = pq.poll();
            }
        }
        return ans;
    }
} 
