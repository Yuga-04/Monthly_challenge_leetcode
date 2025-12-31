class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans =numBottles;
        while(numBottles>=numExchange){
            int k = numBottles/numExchange;
            ans += k;
            numBottles = k + (numBottles%numExchange);
        }
        return ans;
    }
} 
