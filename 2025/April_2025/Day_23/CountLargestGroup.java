// Question : https://leetcode.com/problems/count-largest-group/description/

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxSize = Math.max(maxSize, map.get(sum));
        }
        int count = 0;
        for (int size : map.values()) {
            if (size == maxSize) {
                count++;
            }
        }
        return count;
    }
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
