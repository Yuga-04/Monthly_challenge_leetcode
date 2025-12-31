//Question : https://leetcode.com/problems/count-good-triplets-in-an-array/description/

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            mpp.put(nums1[i], i);
        int n = nums2.length;
        long total = 0;
        ArrayList<Integer> st = new ArrayList<>();
        for (int x : nums2) {
            int idx = mpp.get(x);
            int left = orderOfKey(st, idx);
            int right = (n - 1 - idx) - (st.size() - left);
            total += (long) left * right;
            int pos = Collections.binarySearch(st, idx);
            if (pos < 0)
                pos = -pos - 1;
            st.add(pos, idx);
        }
        return total;
    }

    private int orderOfKey(ArrayList<Integer> st, int key) {
        int pos = Collections.binarySearch(st, key);
        return pos < 0 ? -pos - 1 : pos;
    }
}
