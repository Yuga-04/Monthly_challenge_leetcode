//Question : https://leetcode.com/problems/count-symmetric-integers/description/

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0, mid, left, right;
        for (; low <= high; low++) {
            String str = Integer.toString(low);
            int l = str.length();
            if (l % 2 == 1)
                continue;
            mid = l / 2;
            left = 0;
            right = 0;
            for (int i = 0; i < mid; i++) {
                left += str.charAt(i) - '0';
                right += str.charAt(i + mid) - '0';
            }
            if (left == right)
                count++;
        }
        return count;
    }
}
