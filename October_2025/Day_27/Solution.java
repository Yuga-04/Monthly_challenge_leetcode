class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        if (n == 0) return 0;

        int[] sd = new int[n];
        int row = 0;

        for (String it : bank) {
            int count = 0;
            for (int i = 0; i < bank[0].length(); i++) {
                if (it.charAt(i) == '1') count++;
            }
            sd[row++] = count;
        }

        List<Integer> sdwz = new ArrayList<>();
        for (int i = 0; i < sd.length; i++) {
            if (sd[i] != 0) sdwz.add(sd[i]);
        }

        int ans = 0;
        if (sdwz.size() <= 1) return ans;

        for (int i = 0; i < sdwz.size() - 1; i++) {
            ans += sdwz.get(i) * sdwz.get(i + 1);
        }

        return ans;
    }
} 
