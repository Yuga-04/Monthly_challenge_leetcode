class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] count = new int[n];
        long[] timer = new long[n];

        int itr = 0;

        while (itr < meetings.length) {
            int[] curr = meetings[itr];
            int start = curr[0];
            int end = curr[1];
            long dur = end - start;

            int room = -1;
            long earliest = Long.MAX_VALUE;
            int earliestRoom = -1;

            for (int i = 0; i < n; i++) {
                if (timer[i] < earliest) {
                    earliest = timer[i];
                    earliestRoom = i;
                }
                if (timer[i] <= start) {
                    room = i;
                    break;
                }
            }

            if (room != -1) {
                timer[room] = end;
                count[room]++;
            } else {
                timer[earliestRoom] += dur;
                count[earliestRoom]++;
            }

            itr++;
        }

        int max = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }

        return idx;
    }
}
