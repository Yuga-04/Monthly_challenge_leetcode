# 📌 Day 7: 3341. Find Minimum Time to Reach Last Room I

**LeetCode Link:** [3341. Find Minimum Time to Reach Last Room I](https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/)

---

## 🧩 Problem

There is a dungeon with n x m rooms arranged as a grid.


You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes exactly one second.


Return the minimum time to reach the room (n - 1, m - 1).


Two rooms are adjacent if they share a common wall, either horizontally or vertically.


### Example:

```
Input: moveTime = [[0,4],[4,4]]
Output: 6
Explanation:
The minimum time required is 6 seconds.
At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in one second.
```

---

## 🧠 Topics

- Array
- Graph
- Heap (Priority Queue)
- Matrix
- Shortest Path

---

## ✅ Code (Java)

```Java
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> minh = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minh.add(new int[]{0, 0, 0});
        moveTime[0][0] = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!minh.isEmpty()) {
            int[] current = minh.poll();
            int currTime = current[0];
            int currRow = current[1];
            int currCol = current[2];
            if (currTime >= dp[currRow][currCol]) continue;
            if (currRow == n - 1 && currCol == m - 1) return currTime;
            dp[currRow][currCol] = currTime;
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < n &&
                    nextCol >= 0 && nextCol < m &&
                    dp[nextRow][nextCol] == Integer.MAX_VALUE) {
                    int nextTime = Math.max(moveTime[nextRow][nextCol], currTime) + 1;
                    minh.add(new int[]{nextTime, nextRow, nextCol});
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
Output: 6
```

---


