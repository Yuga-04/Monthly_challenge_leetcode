# 📌 Day 23: 3197. Find the Minimum Area to Cover All Ones II 🎯

**🔗 LeetCode Link:** [3197. Find the Minimum Area to Cover All Ones II](https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-ii/)

---

## 🧩 Problem Description

<p>You are given a 2D <strong>binary</strong> array <code>grid</code>. You need to find 3 <strong>non-overlapping</strong> rectangles having <strong>non-zero</strong> areas with horizontal and vertical sides such that all the 1&#39;s in <code>grid</code> lie inside these rectangles.</p>

<p>Return the <strong>minimum</strong> possible sum of the area of these rectangles.</p>

<p><strong>Note</strong> that the rectangles are allowed to touch.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Matrix
- Enumeration
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,0,1],[1,1,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/05/14/example0rect21.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 280px; height: 198px;" /></p>

<ul>
	<li>The 1&#39;s at <code>(0, 0)</code> and <code>(1, 0)</code> are covered by a rectangle of area 2.</li>
	<li>The 1&#39;s at <code>(0, 2)</code> and <code>(1, 2)</code> are covered by a rectangle of area 2.</li>
	<li>The 1 at <code>(1, 1)</code> is covered by a rectangle of area 1.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,0,1,0],[0,1,0,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/05/14/example1rect2.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 356px; height: 198px;" /></p>

<ul>
	<li>The 1&#39;s at <code>(0, 0)</code> and <code>(0, 2)</code> are covered by a rectangle of area 3.</li>
	<li>The 1 at <code>(1, 1)</code> is covered by a rectangle of area 1.</li>
	<li>The 1 at <code>(1, 3)</code> is covered by a rectangle of area 1.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= grid.length, grid[i].length &lt;= 30</code></li>
	<li><code>grid[i][j]</code> is either 0 or 1.</li>
	<li>The input is generated such that there are at least three 1&#39;s in <code>grid</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minimumSum(int[][] A) {
        int res = Integer.MAX_VALUE;

        for (int rot = 0; rot < 4; rot++) {
            int n = A.length, m = A[0].length;
            for (int i = 1; i < n; i++) {
                int a1 = minimumArea(Arrays.copyOfRange(A, 0, i));
                for (int j = 1; j < m; j++) {
                    int[][] part2 = new int[n - i][j];
                    int[][] part3 = new int[n - i][m - j];
                    for (int r = 0; r < n - i; r++) {
                        part2[r] = Arrays.copyOfRange(A[i + r], 0, j);
                        part3[r] = Arrays.copyOfRange(A[i + r], j, m);
                    }
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
                for (int i2 = i + 1; i2 < n; i2++) {
                    int[][] part2 = Arrays.copyOfRange(A, i, i2);
                    int[][] part3 = Arrays.copyOfRange(A, i2, n);
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
            }
            A = rotate(A);
        }
        return res;
    }

    private int minimumArea(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        int n = A.length, m = A[0].length;
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
        int right = -1, bottom = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    left = Math.min(left, j);
                    top = Math.min(top, i);
                    right = Math.max(right, j);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        if (right == -1) return 0;
        return (right - left + 1) * (bottom - top + 1);
    }

    private int[][] rotate(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = A[i][j];
            }
        }
        return rotated;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,0,1],[1,1,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

</div>

<p><strong class="example">


