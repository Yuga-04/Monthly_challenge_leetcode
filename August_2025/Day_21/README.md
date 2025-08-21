# 📌 Day 21: 1504. Count Submatrices With All Ones 🎯

**🔗 LeetCode Link:** [1504. Count Submatrices With All Ones](https://leetcode.com/problems/count-submatrices-with-all-ones/)

---

## 🧩 Problem Description

<p>Given an <code>m x n</code> binary matrix <code>mat</code>, <em>return the number of <strong>submatrices</strong> that have all ones</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
- Stack
- Matrix
- Monotonic Stack
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/10/27/ones1-grid.jpg" style="width: 244px; height: 245px;" />
<pre>
<strong>Input:</strong> mat = [[1,0,1],[1,1,0],[1,1,0]]
<strong>Output:</strong> 13
<strong>Explanation:</strong> 
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/10/27/ones2-grid.jpg" style="width: 324px; height: 245px;" />
<pre>
<strong>Input:</strong> mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
<strong>Output:</strong> 24
<strong>Explanation:</strong> 
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3. 
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2. 
There are 2 rectangles of side 3x1. 
There is 1 rectangle of side 3x2. 
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= m, n &lt;= 150</code></li>
	<li><code>mat[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int numSubmat(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[] h = new int[c];
        int ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                h[j] = (mat[i][j] == 0) ? 0 : h[j] + 1;
            }
            ans += count(h);
        }
        return ans;
    }

    private int count(int[] h) {
        int n = h.length, res = 0;
        int[] sum = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) st.pop();
            if (!st.isEmpty()) {
                int p = st.peek();
                sum[i] = sum[p] + h[i] * (i - p);
            } else {
                sum[i] = h[i] * (i + 1);
            }
            st.push(i);
            res += sum[i];
        }
        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/10/27/ones1-grid.jpg" style="width: 244px; height: 245px;" />
<pre>
<strong>Input:</strong> mat = [[1,0,1],[1,1,0],[1,1,0]]
<strong>Output:</strong> 13
</pre>

<p><strong class="example">


