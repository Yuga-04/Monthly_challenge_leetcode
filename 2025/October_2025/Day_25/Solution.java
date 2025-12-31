class Solution {
    public int totalMoney(int n) {
        int monday = 0, count = 0, sum = 0;

        for(int i = 1; i <= n; i++) {
            if(count == 7) {
                monday = i / 7 + 1;
                count = 0;
            } else {
                monday++;
            }
            sum += monday;
            count++;
        }
        return sum;
    }
} 
