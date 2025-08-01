# 📌 Day 10: 3440. Reschedule Meetings for Maximum Free Time II 🎯

**🔗 LeetCode Link:** [3440. Reschedule Meetings for Maximum Free Time II](https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/)

---

## 🧩 Problem Description

<p>You are given an integer <code>eventTime</code> denoting the duration of an event. You are also given two integer arrays <code>startTime</code> and <code>endTime</code>, each of length <code>n</code>.</p>

<p>These represent the start and end times of <code>n</code> <strong>non-overlapping</strong> meetings that occur during the event between time <code>t = 0</code> and time <code>t = eventTime</code>, where the <code>i<sup>th</sup></code> meeting occurs during the time <code>[startTime[i], endTime[i]].</code></p>

<p>You can reschedule <strong>at most </strong>one meeting by moving its start time while maintaining the <strong>same duration</strong>, such that the meetings remain non-overlapping, to <strong>maximize</strong> the <strong>longest</strong> <em>continuous period of free time</em> during the event.</p>

<p>Return the <strong>maximum</strong> amount of free time possible after rearranging the meetings.</p>

<p><strong>Note</strong> that the meetings can <strong>not</strong> be rescheduled to a time outside the event and they should remain non-overlapping.</p>

<p><strong>Note:</strong> <em>In this version</em>, it is <strong>valid</strong> for the relative ordering of the meetings to change after rescheduling one meeting.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Greedy
- Enumeration
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">eventTime = 5, startTime = [1,3], endTime = [2,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/12/22/example0_rescheduled.png" style="width: 375px; height: 123px;" /></p>

<p>Reschedule the meeting at <code>[1, 2]</code> to <code>[2, 3]</code>, leaving no meetings during the time <code>[0, 2]</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/12/22/rescheduled_example0.png" style="width: 375px; height: 125px;" /></p>

<p>Reschedule the meeting at <code>[0, 1]</code> to <code>[8, 9]</code>, leaving no meetings during the time <code>[0, 7]</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]</span></p>

<p><strong>Output:</strong> 6</p>

<p><strong>Explanation:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2025/01/28/image3.png" style="width: 375px; height: 125px;" /></strong></p>

<p>Reschedule the meeting at <code>[3, 4]</code> to <code>[8, 9]</code>, leaving no meetings during the time <code>[1, 7]</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 4

Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no time during the event not occupied by meetings.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= eventTime &lt;= 10<sup>9</sup></code></li>
	<li><code>n == startTime.length == endTime.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= startTime[i] &lt; endTime[i] &lt;= eventTime</code></li>
	<li><code>endTime[i] &lt;= startTime[i + 1]</code> where <code>i</code> lies in the range <code>[0, n - 2]</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution 
{
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) 
    {
        int n = startTime.length;

        // Step 1: Combine start and end times into intervals
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) 
        {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
        }

        // Step 2: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Calculate free time gaps (before, between, and after meetings)
        List<Integer> gaps = new ArrayList<>();
        gaps.add(intervals[0][0]); // gap before the first meeting
        for (int i = 1; i < n; i++) 
        {
            gaps.add(intervals[i][0] - intervals[i - 1][1]); // between meetings
        }
        gaps.add(eventTime - intervals[n - 1][1]); // after last meeting

        // Step 4: Precompute max gaps before and after each meeting
        int[] maxBefore = new int[n + 2];
        int[] maxAfter = new int[n + 2];
        for (int i = 1; i <= n; i++) 
        {
            maxBefore[i] = Math.max(maxBefore[i - 1], gaps.get(i - 1));
        }
        
        for (int i = n; i >= 1; i--) 
        {
            maxAfter[i] = Math.max(maxAfter[i + 1], gaps.get(i));
        }

        int maxFree = 0;

        // Step 5: Try removing each meeting and see the result
        for (int i = 0; i < n; i++) 
        {
            int duration = intervals[i][1] - intervals[i][0];
            int leftGap = gaps.get(i);
            int rightGap = gaps.get(i + 1);
            int combinedGap = leftGap + rightGap;

            int bestGap = Math.max(
                i > 0 ? maxBefore[i] : 0,
                i < n - 1 ? maxAfter[i + 2] : 0
            );

            if (duration <= bestGap) 
            {
                maxFree = Math.max(maxFree, combinedGap + duration);
            } 
            else 
            {
                maxFree = Math.max(maxFree, combinedGap);
            }
        }

        // Step 6: Consider original gaps without rescheduling
        for (int gap : gaps) 
        {
            maxFree = Math.max(maxFree, gap);
        }

        // Step 7: Return the max free time
        return maxFree;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">eventTime = 5, startTime = [1,3], endTime = [2,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>
</div>

<p><strong class="example">


