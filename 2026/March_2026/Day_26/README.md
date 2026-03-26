# 📌 Day 26: 3548. Equal Sum Grid Partition II 🎯

**🔗 LeetCode Link:** [3548. Equal Sum Grid Partition II](https://leetcode.com/problems/equal-sum-grid-partition-ii/)

---

## 🧩 Problem Description

<p>You are given an <code>m x n</code> matrix <code>grid</code> of positive integers. Your task is to determine if it is possible to make <strong>either one horizontal or one vertical cut</strong> on the grid such that:</p>

<ul>
	<li>Each of the two resulting sections formed by the cut is <strong>non-empty</strong>.</li>
	<li>The sum of elements in both sections is <b>equal</b>, or can be made equal by discounting <strong>at most</strong> one single cell in total (from either section).</li>
	<li>If a cell is discounted, the rest of the section must <strong>remain connected</strong>.</li>
</ul>

<p>Return <code>true</code> if such a partition exists; otherwise, return <code>false</code>.</p>

<p><strong>Note:</strong> A section is <strong>connected</strong> if every cell in it can be reached from any other cell by moving up, down, left, or right through other cells in the section.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Matrix
- Enumeration
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,4],[2,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.jpeg" style="height: 180px; width: 180px;" /></p>

<ul>
	<li>A horizontal cut after the first row gives sums <code>1 + 4 = 5</code> and <code>2 + 3 = 5</code>, which are equal. Thus, the answer is <code>true</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,2],[3,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/01/chatgpt-image-apr-1-2025-at-05_28_12-pm.png" style="height: 180px; width: 180px;" /></p>

<ul>
	<li>A vertical cut after the first column gives sums <code>1 + 3 = 4</code> and <code>2 + 4 = 6</code>.</li>
	<li>By discounting 2 from the right section (<code>6 - 2 = 4</code>), both sections have equal sums and remain connected. Thus, the answer is <code>true</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,2,4],[2,3,5]]</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2025/04/01/chatgpt-image-apr-2-2025-at-02_50_29-am.png" style="height: 180px; width: 180px;" /></strong></p>

<ul>
	<li>A horizontal cut after the first row gives <code>1 + 2 + 4 = 7</code> and <code>2 + 3 + 5 = 10</code>.</li>
	<li>By discounting 3 from the bottom section (<code>10 - 3 = 7</code>), both sections have equal sums, but they do not remain connected as it splits the bottom section into two parts (<code>[2]</code> and <code>[5]</code>). Thus, the answer is <code>false</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 4

Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[4,1,8],[3,2,6]]</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>No valid cut exists, so the answer is <code>false</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= m == grid.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= n == grid[i].length &lt;= 10<sup>5</sup></code></li>
	<li><code>2 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    private boolean canRemove(int r1, int c1, int r2, int c2, int i, int j) {
        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        if (rows * cols == 1) return false;

        if (rows == 1) {
            return (j == c1 || j == c2);
        }

        if (cols == 1) {
            return (i == r1 || i == r2);
        }

        return true;
    }

    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[] prefRow = new long[n];
        long[] prefCol = new long[m];

        Map<Long, List<int[]>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long val = 0;
            for (int j = 0; j < m; j++) {
                val += grid[i][j];
                long cellVal = (long) grid[i][j];
                mp.putIfAbsent(cellVal, new ArrayList<>());
                mp.get(cellVal).add(new int[]{i, j});
            }
            prefRow[i] = val + (i > 0 ? prefRow[i - 1] : 0);
        }

        for (int j = 0; j < m; j++) {
            long val = 0;
            for (int i = 0; i < n; i++) {
                val += grid[i][j];
            }
            prefCol[j] = val + (j > 0 ? prefCol[j - 1] : 0);
        }

        long total = prefRow[n - 1];

        for (int i = 0; i < n - 1; i++) {
            long top = prefRow[i];
            long bottom = total - top;

            if (top == bottom) return true;

            long diff = Math.abs(top - bottom);

            if (!mp.containsKey(diff)) continue;

            if (top > bottom) {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (x <= i && canRemove(0, 0, i, m - 1, x, y)) {
                        return true;
                    }
                }
            } else {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (x > i && canRemove(i + 1, 0, n - 1, m - 1, x, y)) {
                        return true;
                    }
                }
            }
        }

        for (int j = 0; j < m - 1; j++) {
            long left = prefCol[j];
            long right = total - left;

            if (left == right) return true;

            long diff = Math.abs(left - right);

            if (!mp.containsKey(diff)) continue;

            if (left > right) {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (y <= j && canRemove(0, 0, n - 1, j, x, y)) {
                        return true;
                    }
                }
            } else {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (y > j && canRemove(0, j + 1, n - 1, m - 1, x, y)) {
                        return true;
                    }
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

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,4],[2,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/03/30/lc.jpeg" style="height: 180px; width: 180px;" /></p>

<ul>
	<li>A horizontal cut after the first row gives sums <code>1 + 4 = 5</code> and <code>2 + 3 = 5</code>, which are equal. Thus, the answer is <code>true</code>.</li>
</ul>
</div>

<p><strong class="example">


