class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        long base = nums[0];
        int kSmall = k - 1;
        if (kSmall <= 0) 
            return base;

        TreeMap<Integer, Integer> small = new TreeMap<>();
        TreeMap<Integer, Integer> big = new TreeMap<>();

        long[] sumSmall = new long[]{0};
        int[] cntSmall = new int[]{0};

        Runnable rebalance = () -> {
            while (cntSmall[0] > kSmall) {
                int x = small.lastKey();
                sumSmall[0] -= x;
                cntSmall[0]--;

                small.merge(x, -1, Integer::sum);
                if (small.get(x) == 0) 
                    small.remove(x);
                big.merge(x, 1, Integer::sum);
            }
            while (cntSmall[0] < kSmall && !big.isEmpty()) {
                int x = big.firstKey();
                sumSmall[0] += x;
                cntSmall[0]++;
                big.merge(x, -1, Integer::sum);
                if (big.get(x) == 0) 
                    big.remove(x);
                small.merge(x, 1, Integer::sum);
            }
        };

        int windowSize = dist + 1;
        for (int i = 1; i <= windowSize && i < nums.length; i++) {
            small.merge(nums[i], 1, Integer::sum);
            sumSmall[0] += nums[i];
            cntSmall[0]++;
        }
        rebalance.run();

        long res = base + sumSmall[0];

        for (int l = 1, r = windowSize + 1; r < nums.length; l++, r++) {
            int out = nums[l];
            if (small.containsKey(out)) {
                sumSmall[0] -= out;
                cntSmall[0]--;
                small.merge(out, -1, Integer::sum);
                if (small.get(out) == 0) 
                    small.remove(out);
            } else {
                big.merge(out, -1, Integer::sum);
                if (big.get(out) == 0) 
                    big.remove(out);
            }

            int in = nums[r];
            if (small.isEmpty() || in <= small.lastKey()) {
                small.merge(in, 1, Integer::sum);
                sumSmall[0] += in;
                cntSmall[0]++;
            } else {
                big.merge(in, 1, Integer::sum);
            }

            rebalance.run();
            res = Math.min(res, base + sumSmall[0]);
        }

        return res;
    }
} 
