class Solution {
    public int countHillValley(int[] nums) {
        int[] unique = new int[nums.length];
        int idx = 0;

        for (int num : nums) {
            if (idx == 0 || unique[idx - 1] != num) {
                unique[idx++] = num;
            }
        }

        if (idx < 3)
            return 0;

        int count = 0;
        for (int i = 1; i < idx - 1; i++) {
            if ((unique[i] > unique[i - 1] && unique[i] > unique[i + 1]) ||
                    (unique[i] < unique[i - 1] && unique[i] < unique[i + 1])) {
                count++;
            }
        }

        return count;
    }

} 
