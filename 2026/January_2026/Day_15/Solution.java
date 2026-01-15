 
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxConsecutiveHBars = 1;
        int maxConsecutiveVBars = 1;

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hLength = hBars.length;
        int vLength = vBars.length;

        int tempH = 1;
        int tempV = 1;

        for (int i = 1; i < Math.max(hLength, vLength); i++) {

            if (i < hLength && hBars[i] - hBars[i - 1] == 1) {
                tempH++;
            } else if (i < hLength) {
                maxConsecutiveHBars = Math.max(maxConsecutiveHBars, tempH);
                tempH = 1;
            }

            if (i < vLength && vBars[i] - vBars[i - 1] == 1) {
                tempV++;
            } else if (i < vLength) {
                maxConsecutiveVBars = Math.max(maxConsecutiveVBars, tempV);
                tempV = 1;
            }
        }

        maxConsecutiveHBars = Math.max(maxConsecutiveHBars, tempH);
        maxConsecutiveVBars = Math.max(maxConsecutiveVBars, tempV);

        int squareLen = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;

        return squareLen * squareLen;
    }
}
