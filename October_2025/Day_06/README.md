# 📌 Day 6: 778. Swim in Rising Water 🎯

**🔗 LeetCode Link:** [778. Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/)

---

## 🧩 Problem Description

<p>You are given an <code>n x n</code> integer matrix <code>grid</code> where each value <code>grid[i][j]</code> represents the elevation at that point <code>(i, j)</code>.</p>

<p>It starts raining, and water gradually rises over time. At time <code>t</code>, the water level is <code>t</code>, meaning <strong>any</strong> cell with elevation less than equal to <code>t</code> is submerged or reachable.</p>

<p>You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most <code>t</code>. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.</p>

<p>Return <em>the minimum time until you can reach the bottom right square </em><code>(n - 1, n - 1)</code><em> if you start at the top left square </em><code>(0, 0)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Binary Search
- Depth-First Search
- Breadth-First Search
- Union Find
- Heap (Priority Queue)
- Matrix
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/29/swim1-grid.jpg" style="width: 164px; height: 165px;" />
<pre>
<strong>Input:</strong> grid = [[0,2],[1,3]]
<strong>Output:</strong> 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/29/swim2-grid-1.jpg" style="width: 404px; height: 405px;" />
<pre>
<strong>Input:</strong> grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
<strong>Output:</strong> 16
<strong>Explanation:</strong> The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;&nbsp;n<sup>2</sup></code></li>
	<li>Each value <code>grid[i][j]</code> is <strong>unique</strong>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int lo = grid[0][0], hi = 0;
        for (int[] row : grid)
            for (int val : row)
                hi = Math.max(hi, val);
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (possible(grid, mid, m, n, directions)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    private boolean possible(int[][] grid, int mid, int m, int n, int[][] directions) {
        if (grid[0][0] > mid) return false;
        boolean[][] seen = new boolean[m][n];
        return dfs(grid, 0, 0, mid, seen, m, n, directions);
    }
    
    private boolean dfs(int[][] grid, int r, int c, int mid, boolean[][] seen, int m, int n, int[][] directions) {
        if (r == m-1 && c == n-1) return true;
        seen[r][c] = true;
        
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen[nr][nc]) {
                if (grid[nr][nc] <= mid) {
                    if (dfs(grid, nr, nc, mid, seen, m, n, directions)) return true;
                }
            }
        }
        return false;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/29/swim1-grid.jpg" style="width: 164px; height: 165px;" />
<pre>
<strong>Input:</strong> grid = [[0,2],[1,3]]
<strong>Output:</strong> 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
</pre>

<p><strong class="example">


