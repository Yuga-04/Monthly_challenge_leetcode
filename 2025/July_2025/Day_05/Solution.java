class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;

        // Check if number == its frequency
        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                max = Math.max(max, key);
            }
        }

        return max;
    }
} 
