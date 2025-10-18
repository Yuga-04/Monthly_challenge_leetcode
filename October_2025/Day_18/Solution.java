class Solution {
    public int maxDistinctElements(int[] arr, int diff) {
        int prev = Integer.MIN_VALUE;
        Set<Integer> c = new HashSet<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int x = Math.max(prev + 1, arr[i] - diff);
            if (x <= arr[i] + diff) {
                c.add(x);
                prev = x;
            }
        }

        return c.size();
    }
}; 
