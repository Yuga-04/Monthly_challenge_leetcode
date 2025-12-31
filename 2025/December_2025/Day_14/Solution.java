class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1_000_000_007;
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                pos.add(i);
            }
        }

        if (pos.size() % 2 == 1 || pos.size() == 0) {
            return 0;
        }

        long res = 1;
        for (int i = 2; i < pos.size(); i += 2) {
            int len_of_gap = pos.get(i) - pos.get(i - 1);
            res = (res * len_of_gap) % mod;
        }

        return (int) res;
    }
} 
