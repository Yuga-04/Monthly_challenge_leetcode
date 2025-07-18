class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 3;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            maxHeap.offer(nums[i]);
            sum += nums[i];
        }
        prefix[0] = sum;

        for (int i = n; i < 2 * n; i++) {
            if (!maxHeap.isEmpty() && nums[i] < maxHeap.peek()) {
                sum -= maxHeap.poll();
                maxHeap.offer(nums[i]);
                sum += nums[i];
            }
            prefix[i - n + 1] = sum;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sum = 0;
        long[] suffix = new long[n + 1];

        for (int i = 3 * n - 1; i >= 2 * n; i--) {
            minHeap.offer(nums[i]);
            sum += nums[i];
        }
        suffix[n] = sum;

        for (int i = 2 * n - 1; i >= n; i--) {
            if (!minHeap.isEmpty() && nums[i] > minHeap.peek()) {
                sum -= minHeap.poll();
                minHeap.offer(nums[i]);
                sum += nums[i];
            }
            suffix[i - n] = sum;
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, prefix[i] - suffix[i]);
        }

        return (int) ans;
    }
} 
