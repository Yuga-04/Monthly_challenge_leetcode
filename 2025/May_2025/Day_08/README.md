# 📌 Day 8: 3342. Find Minimum Time to Reach Last Room II

**LeetCode Link:** [3342. Find Minimum Time to Reach Last Room II](https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/)

---

## 🧩 Problem

TThere is a dungeon with n x m rooms arranged as a grid.


You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.


Return the minimum time to reach the room (n - 1, m - 1).


Two rooms are adjacent if they share a common wall, either horizontally or vertically.


### Example:

```
Input: moveTime = [[0,4],[4,4]]
Output: 7
Explanation:
The minimum time required is 7 seconds.
- At time t == 4, move from room (0, 0) to room (1, 0) in one second.
- At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.
```

---

## 🧠 Topics

- Array
- Graph
- Heap (Priority Queue)
- Matrix
- Shortest Pathh

---

## ✅ Code (Java)

```Java
class Solution {
    public int minTimeToReach(final int[][] moveTime) {
        final int n = moveTime.length, m = moveTime[0].length;
        final Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        final int[][] dp = new int[n][m];
        final int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for(final int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        queue.offer(new int[] { 0, 0, 0, 1 });
        moveTime[0][0] = 0;

        while(!queue.isEmpty()) {
            final int[] curr = queue.poll();
            final int i = curr[0], j = curr[1], t = curr[2], cost = curr[3];

            if(i == n - 1 && j == m - 1)
                return t;

            if(dp[i][j] <= t)
                continue;

            dp[i][j] = t;

            for(final int[] direction : directions) {
                final int x = i + direction[0], y = j + direction[1];

                if(x < n && y < m && x >= 0 && y >= 0 && dp[x][y] == Integer.MAX_VALUE) {
                    final int newTime = Math.max(t, moveTime[x][y]) + cost;
                    queue.offer(new int[] { x, y, newTime, cost == 1 ? 2 : 1 });
                }
            }
        }

        return -1;
    }
}
```

---

## 🧪 Sample Test Case

```Java
Input: moveTime = [[0,4],[4,4]]
Output: 7
```

---


