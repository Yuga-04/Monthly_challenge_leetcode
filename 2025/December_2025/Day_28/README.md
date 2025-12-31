# 📌 Day 28: 1351. Count Negative Numbers in a Sorted Matrix 🎯

**🔗 LeetCode Link:** [1351. Count Negative Numbers in a Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)

---

## 🧩 Problem Description

<p>Given a <code>m x n</code> matrix <code>grid</code> which is sorted in non-increasing order both row-wise and column-wise, return <em>the number of <strong>negative</strong> numbers in</em> <code>grid</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Binary Search
- Matrix
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
<strong>Output:</strong> 8
<strong>Explanation:</strong> There are 8 negatives number in the matrix.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[3,2],[1,0]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-100 &lt;= grid[i][j] &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you find an <code>O(n + m)</code> solution?

---

## ✅ Code (Java)

```java
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int countNegs = 0;
        int row = 0;
        int col = n - 1;

        while(row < m && col >= 0) {
            if(grid[row][col] < 0) {
                countNegs += (m - row);
                col--;
            } else {
                row++;
            }
        }

        return countNegs;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
<strong>Output:</strong> 8
<strong>Explanation:</strong> There are 8 negatives number in the matrix.
</pre>

<p><strong class="example">


