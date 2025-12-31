class Solution {
    public int nextBeautifulNumber(int n) {
        List<Integer> list = new ArrayList<>();
        generate(0, new int[10], list);
        Collections.sort(list);
        for (int num : list) {
            if (num > n) return num;
        }
        return -1;
    }
    private void generate(long num, int[] count, List<Integer> list) {
        if (num > 0 && isBeautiful(count)) {
            list.add((int) num);
        }
        if (num > 1224444) return;

        for (int d = 1; d <= 7; d++) {
            if (count[d] < d) {
                count[d]++;
                generate(num * 10 + d, count, list);
                count[d]--;
            }
        }
    }
    private boolean isBeautiful(int[] count) {
        for (int d = 1; d <= 7; d++) {
            if (count[d] != 0 && count[d] != d) return false;
        }
        return true;
    }
} 
