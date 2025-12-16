class Solution {
    public long getDescentPeriods(int[] prices) {
       int n = prices.length;
       long ct=1;
       int tmp=1;
        for (int j = 1; j<n; j++)
        {
            if(prices[j-1]-prices[j]==1)
            {
                tmp++;
            }
            else
            {
                tmp=1;
            }
            ct+=tmp;
            
        }
        return ct;  
       
    }
} 
