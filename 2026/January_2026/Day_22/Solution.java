class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);

        int operations = 0;
        while (!isNonDecreasing(list)) {
            int minSum = list.get(0) + list.get(1);
            int index = 0;

            for (int i = 1; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            list.set(index, minSum);
            list.remove(index + 1);
            operations++;
        }
        return operations;
    }

    private boolean isNonDecreasing(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) return false;
        }
        return true;
    }
} 
