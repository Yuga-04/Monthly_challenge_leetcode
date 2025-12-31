# 📌 Day 25: 498. Diagonal Traverse 🎯

**🔗 LeetCode Link:** [498. Diagonal Traverse](https://leetcode.com/problems/diagonal-traverse/)

---

## 🧩 Problem Description

<p>Given an <code>m x n</code> matrix <code>mat</code>, return <em>an array of all the elements of the array in a diagonal order</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Matrix
- Simulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/10/diag1-grid.jpg" style="width: 334px; height: 334px;" />
<pre>
<strong>Input:</strong> mat = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [1,2,4,7,5,3,6,8,9]
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> mat = [[1,2],[3,4]]
<strong>Output:</strong> [1,2,3,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= mat[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<List<Integer>> v = new ArrayList<>();
        int flag = 0;

        // Traverse diagonals starting from each row of first column
        for (int i = 0; i < m; i++) {
            int j = i, k = 0;
            List<Integer> temp = new ArrayList<>();
            while (j >= 0 && k < n) {
                temp.add(mat[j][k]);
                j--;
                k++;
            }
            if (flag % 2 == 0) {
                v.add(temp);
            } else {
                Collections.reverse(temp);
                v.add(temp);
            }
            flag++;
        }

        // Adjust flag for diagonals starting from columns
        flag = (m % 2 == 0) ? 0 : 1;

        // Traverse diagonals starting from columns of last row
        for (int i = 0; i < n - 1; i++) {
            int j = m - 1, k = i + 1;
            List<Integer> temp = new ArrayList<>();
            while (j >= 0 && k < n) {
                temp.add(mat[j][k]);
                j--;
                k++;
            }
            if (flag % 2 == 0) {
                v.add(temp);
            } else {
                Collections.reverse(temp);
                v.add(temp);
            }
            flag++;
        }

        // Merge all diagonals into single result array
        List<Integer> ansList = new ArrayList<>();
        for (List<Integer> diag : v) {
            ansList.addAll(diag);
        }

        // Convert to int[]
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/10/diag1-grid.jpg" style="width: 334px; height: 334px;" />
<pre>
<strong>Input:</strong> mat = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [1,2,4,7,5,3,6,8,9]
</pre>

<p><strong class="example">


