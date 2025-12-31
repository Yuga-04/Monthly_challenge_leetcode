//Question : https://leetcode.com/problems/count-of-interesting-subarrays/description/

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        long total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;

        for (int num : nums) {
            if (num % m == k) count++;
            int remainder = (count - k) % m;
            if (remainder < 0) remainder += m;
            total += map.getOrDefault(remainder, 0);
            map.put(count % m, map.getOrDefault(count % m, 0) + 1);
        }

        return total;
    }
}
