class Solution {
    public int repeatedNTimes(int[] nums) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) return x;
        }
        return -1;
    }
} 
