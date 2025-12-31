 
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum = numBottles, bottle = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            numExchange++;
            sum++;
            bottle++;
        }
        return sum;
    }

}
