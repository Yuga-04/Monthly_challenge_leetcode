class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long prefixProfit [] = new long[n+1];
        long prefixPrice[] = new long[n+1];
        for(int i=0; i<n; i++){
            prefixProfit[i+1] = prefixProfit[i] + (prices[i] * strategy[i]);
            prefixPrice[i+1] = prefixPrice[i] + prices[i];
        }
        long maxGain = 0;
        for(int i=0; i+k <=n; i++){
            long oldGain = prefixProfit[i+k] - prefixProfit[i];
            long newGain = prefixPrice[i+k] - prefixPrice[i+k/2];
            maxGain = Math.max(maxGain, newGain - oldGain);
        }
        return prefixProfit[n] + maxGain;
    }
} 
