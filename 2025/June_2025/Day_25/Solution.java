class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L;
        long right = 10000000000L;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countProducts(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private long countProducts(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int num1 : nums1) {
            if (num1 == 0) {
                if (target >= 0) count += nums2.length;
                continue;
            }
            
            int low = 0, high = nums2.length;
            while (low < high) {
                int mid = low + (high - low) / 2;
                long product = (long) num1 * nums2[mid];
                if (product <= target) {
                    if (num1 > 0) low = mid + 1;
                    else high = mid;
                } else {
                    if (num1 > 0) high = mid;
                    else low = mid + 1;
                }
            }
            
            count += (num1 > 0) ? low : nums2.length - low;
        }
        return count;
    }
} 
