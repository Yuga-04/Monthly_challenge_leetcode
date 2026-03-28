# 📌 Day 28: 2946. Matrix Similarity After Cyclic Shifts 🎯

**🔗 LeetCode Link:** [2946. Matrix Similarity After Cyclic Shifts](https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/)

---

## 🧩 Problem Description

<p>You are given an <code>m x n</code> integer matrix <code>mat</code> and an integer <code>k</code>. The matrix rows are 0-indexed.</p>

<p>The following proccess happens <code>k</code> times:</p>

<ul>
	<li><strong>Even-indexed</strong> rows (0, 2, 4, ...) are cyclically shifted to the left.</li>
</ul>

<p>![Image](https://assets.leetcode.com/uploads/2024/05/19/lshift.jpg)</p>

<ul>
	<li><strong>Odd-indexed</strong> rows (1, 3, 5, ...) are cyclically shifted to the right.</li>
</ul>

<p>![Image](https://assets.leetcode.com/uploads/2024/05/19/rshift-stlone.jpg)</p>

<p>Return <code>true</code> if the final modified matrix after <code>k</code> steps is identical to the original matrix, and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
- Matrix
- Simulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).</p>

<p><img src="https://assets.leetcode.com/uploads/2024/05/19/t1-2.jpg" style="width: 857px; height: 150px;" /></p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2024/05/19/t1-3.jpg" style="width: 632px; height: 150px;" /></p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">mat = [[2,2],[2,2]], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>As all the values are equal in the matrix, even after performing cyclic shifts the matrix will remain the same.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= mat.length &lt;= 25</code></li>
	<li><code>1 &lt;= mat[i].length &lt;= 25</code></li>
	<li><code>1 &lt;= mat[i][j] &lt;= 25</code></li>
	<li><code>1 &lt;= k &lt;= 50</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (mat[i][j] != mat[i][(j - k % n + n) % n]) {
                        return false;
                    }
                } else {
                    if (mat[i][j] != mat[i][(j + k % n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).</p>

<p><img src="https://assets.leetcode.com/uploads/2024/05/19/t1-2.jpg" style="width: 857px; height: 150px;" /></p>
</div>

<p><strong class="example">


