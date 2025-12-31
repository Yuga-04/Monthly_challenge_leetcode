//Question : https://leetcode.com/problems/minimum-index-of-a-valid-split/description/

class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> mpp = new HashMap<>(), left = new HashMap<>();
        for (int i : nums)
            mpp.put(i, mpp.getOrDefault(i, 0) + 1);

        for (int i = 0; i < nums.size() - 1; i++) {
            left.put(nums.get(i), left.getOrDefault(nums.get(i), 0) + 1);
            mpp.put(nums.get(i), mpp.get(nums.get(i)) - 1);

            if (left.get(nums.get(i)) * 2 > (i + 1) && mpp.get(nums.get(i)) * 2 > (nums.size() - i - 1))
                return i;
        }
        return -1;
    }
}
