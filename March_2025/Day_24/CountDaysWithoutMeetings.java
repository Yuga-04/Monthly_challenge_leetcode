//Question : https://leetcode.com/problems/count-days-without-meetings/description/
import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int count = 0, lastMeetingDay = 0;
        Set<Integer> meets = new HashSet<>();

        for (int[] arr : meetings) {
            int start = arr[0], end = arr[1];
            if (lastMeetingDay + 1 < start) {
                count += start - lastMeetingDay - 1;
            }
            lastMeetingDay = Math.max(lastMeetingDay, end);
        }
        if (lastMeetingDay < days) {
            count += days - lastMeetingDay;
        }

        return count;
    }
}
