# 📌 Day 23: 2054. Two Best Non-Overlapping Events 🎯

**🔗 LeetCode Link:** [2054. Two Best Non-Overlapping Events](https://leetcode.com/problems/two-best-non-overlapping-events/)

---

## 🧩 Problem Description

<p>You are given a <strong>0-indexed</strong> 2D integer array of <code>events</code> where <code>events[i] = [startTime<sub>i</sub>, endTime<sub>i</sub>, value<sub>i</sub>]</code>. The <code>i<sup>th</sup></code> event starts at <code>startTime<sub>i</sub></code><sub> </sub>and ends at <code>endTime<sub>i</sub></code>, and if you attend this event, you will receive a value of <code>value<sub>i</sub></code>. You can choose <strong>at most</strong> <strong>two</strong> <strong>non-overlapping</strong> events to attend such that the sum of their values is <strong>maximized</strong>.</p>

<p>Return <em>this <strong>maximum</strong> sum.</em></p>

<p>Note that the start time and end time is <strong>inclusive</strong>: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time <code>t</code>, the next event must start at or after <code>t + 1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Binary Search
- Dynamic Programming
- Sorting
- Heap (Priority Queue)
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/picture5.png" style="width: 400px; height: 75px;" />
<pre>
<strong>Input:</strong> events = [[1,3,2],[4,5,2],[2,4,3]]
<strong>Output:</strong> 4
<strong>Explanation: </strong>Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="Example 1 Diagram" src="https://assets.leetcode.com/uploads/2021/09/21/picture1.png" style="width: 400px; height: 77px;" />
<pre>
<strong>Input:</strong> events = [[1,3,2],[4,5,2],[1,5,5]]
<strong>Output:</strong> 5
<strong>Explanation: </strong>Choose event 2 for a sum of 5.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/picture3.png" style="width: 400px; height: 66px;" />
<pre>
<strong>Input:</strong> events = [[1,5,3],[1,5,1],[6,6,5]]
<strong>Output:</strong> 8
<strong>Explanation: </strong>Choose events 0 and 2 for a sum of 3 + 5 = 8.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= events.length &lt;= 10<sup>5</sup></code></li>
	<li><code>events[i].length == 3</code></li>
	<li><code>1 &lt;= startTime<sub>i</sub> &lt;= endTime<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= value<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int nextMaxEvent(int l, int r, int end, int[] sufMax, int[][] events) {
        int max = 0;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(events[m][0] > end) {
                max = sufMax[m];
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return max;
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));
        int n = events.length;
        int[] sufMax = new int[n];
        sufMax[n-1] = events[n-1][2];
        for(int i=n-2;i>=0;i--)
            sufMax[i] = Math.max(sufMax[i+1], events[i][2]);
        int ans=0;
        for(int i=0;i<n;i++) {
            int sum = events[i][2];
            sum += nextMaxEvent(i+1, n-1, events[i][1], sufMax, events);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/09/21/picture5.png" style="width: 400px; height: 75px;" />
<pre>
<strong>Input:</strong> events = [[1,3,2],[4,5,2],[2,4,3]]
<strong>Output:</strong> 4
<strong>Explanation: </strong>Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
</pre>

<p><strong class="example">


