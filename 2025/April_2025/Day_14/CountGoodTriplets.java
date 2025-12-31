//Question : https://leetcode.com/problems/count-good-triplets/description/

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if ((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[i] - arr[k]) <= c)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
