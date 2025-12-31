//Question : https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/

class Solution {
    static boolean isDistinct(List<Integer> arr) {
        Set<Integer> sarr = new HashSet<>(arr);
        return sarr.size() == arr.size();
    }

    public int minimumOperations(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int n : nums)
            arr.add(n);
        int count = 0, rcount;
        while (!isDistinct(arr)) {
            rcount = Math.min(3, arr.size());
            for (int i = 0; i < rcount; i++)
                arr.remove(0);
            count++;
        }
        return count;
    }
}
