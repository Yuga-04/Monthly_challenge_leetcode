class Solution {

    int cntSetBits(int num) {
        return Integer.bitCount(num);
    }

    String formatTime(int h, int m) {
        String formattedTime = h + ":";

        if (m < 10) {
            formattedTime += "0";
        }
        formattedTime += m;
        return formattedTime;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();

        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                if (cntSetBits(h) + cntSetBits(m) == turnedOn) {
                    times.add(formatTime(h, m));
                }
            }
        }
        return times;
    }
} 
