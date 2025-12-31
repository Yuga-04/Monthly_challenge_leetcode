class Solution {
    public long minCost(final int[] basket1, final int[] basket2) {
        final int n = basket1.length;
        final Map<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < n; ++i)
            counts.put(basket1[i], counts.getOrDefault(basket1[i], 0) + 1);

        for(int i = 0; i < n; ++i)
            counts.put(basket2[i], counts.getOrDefault(basket2[i], 0) - 1);

        final List<Integer> swaps = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for(final Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            final int num = entry.getKey(), count = entry.getValue();

            if(count % 2 > 0)
                return -1;

            min = Math.min(num, min);

            for(int i = 0; i < Math.abs(count) / 2; ++i)
                swaps.add(num);
        }

        Collections.sort(swaps);

        long result = 0;

        for(int i = 0; i < swaps.size() / 2; ++i)
            result += Math.min(swaps.get(i), min * 2);

        return result;
    }
} 
