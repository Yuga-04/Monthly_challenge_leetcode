# 📌 Day 16: 1878. Get Biggest Three Rhombus Sums in a Grid 🎯

**🔗 LeetCode Link:** [1878. Get Biggest Three Rhombus Sums in a Grid](https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/)

---

## 🧩 Problem Description

<p>You are given an <code>m x n</code> integer matrix <code>grid</code>​​​.</p>

<p>A <strong>rhombus sum</strong> is the sum of the elements that form <strong>the</strong> <strong>border</strong> of a regular rhombus shape in <code>grid</code>​​​. The rhombus must have the shape of a square rotated 45 degrees with each of the corners centered in a grid cell. Below is an image of four valid rhombus shapes with the corresponding colored cells that should be included in each <strong>rhombus sum</strong>:</p>
![Image](https://assets.leetcode.com/uploads/2021/04/23/pc73-q4-desc-2.png)
<p>Note that the rhombus can have an area of 0, which is depicted by the purple rhombus in the bottom right corner.</p>

<p>Return <em>the biggest three <strong>distinct rhombus sums</strong> in the </em><code>grid</code><em> in <strong>descending order</strong></em><em>. If there are less than three distinct values, return all of them</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
- Sorting
- Heap (Priority Queue)
- Matrix
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/23/pc73-q4-ex1.png" style="width: 360px; height: 361px;" />
<pre>
<strong>Input:</strong> grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
<strong>Output:</strong> [228,216,211]
<strong>Explanation:</strong> The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
- Blue: 20 + 3 + 200 + 5 = 228
- Red: 200 + 2 + 10 + 4 = 216
- Green: 5 + 200 + 4 + 2 = 211
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/23/pc73-q4-ex2.png" style="width: 217px; height: 217px;" />
<pre>
<strong>Input:</strong> grid = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [20,9,8]
<strong>Explanation:</strong> The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
- Blue: 4 + 2 + 6 + 8 = 20
- Red: 9 (area 0 rhombus in the bottom right corner)
- Green: 8 (area 0 rhombus in the bottom middle)
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> grid = [[7,7,7]]
<strong>Output:</strong> [7]
<strong>Explanation:</strong> All three possible rhombus sums are the same, so return [7].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        TreeSet<Integer> top3 = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                top3.add(grid[i][j]);
                if (top3.size() > 3) {
                    top3.pollFirst(); // remove smallest
                }

                for (int k = 1; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; k++) {
                    int topR = i - k, topC = j;
                    int rightR = i, rightC = j + k;
                    int bottomR = i + k, bottomC = j;
                    int leftR = i, leftC = j - k;

                    long border = 0;

                    // top -> right   (\)
                    border += diag1[rightR + 1][rightC + 1] - diag1[topR][topC];

                    // right -> bottom (/)
                    border += diag2[bottomR + 1][bottomC] - diag2[rightR][rightC + 1];

                    // left -> bottom  (\)
                    border += diag1[bottomR + 1][bottomC + 1] - diag1[leftR][leftC];

                    // top -> left     (/)
                    border += diag2[leftR + 1][leftC] - diag2[topR][topC + 1];

                    // corners counted twice
                    border -= grid[topR][topC];
                    border -= grid[rightR][rightC];
                    border -= grid[bottomR][bottomC];
                    border -= grid[leftR][leftC];

                    top3.add((int) border);
                    if (top3.size() > 3) {
                        top3.pollFirst(); // remove smallest
                    }
                }
            }
        }

        int[] ans = new int[top3.size()];
        int idx = 0;
        for (int val : top3.descendingSet()) {
            ans[idx++] = val;
        }
        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/23/pc73-q4-ex1.png" style="width: 360px; height: 361px;" />
<pre>
<strong>Input:</strong> grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
<strong>Output:</strong> [228,216,211]
<strong>Explanation:</strong> The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
- Blue: 20 + 3 + 200 + 5 = 228
- Red: 200 + 2 + 10 + 4 = 216
- Green: 5 + 200 + 4 + 2 = 211
</pre>

<p><strong class="example">


