import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) free.offer(i);

        PriorityQueue<long[]> busy =
            new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1])
                                                        : Long.compare(a[0], b[0]));

        int[] cnt = new int[n];

        for (int[] m : meetings) {
            long start = m[0], end = m[1];

            while (!busy.isEmpty() && busy.peek()[0] <= start)
                free.offer((int) busy.poll()[1]);

            int room;
            long newEnd;
            if (!free.isEmpty()) {
                room = free.poll();
                newEnd = end;
            } else {
                long[] e = busy.poll();
                room = (int) e[1];
                newEnd = e[0] + (end - start);
            }
            busy.offer(new long[] {newEnd, room});
            cnt[room]++;
        }

        int best = 0;
        for (int i = 1; i < n; ++i)
            if (cnt[i] > cnt[best]) best = i;
        return best;
    }
} 
