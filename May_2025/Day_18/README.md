# 📌 Day 18: 1931. Painting a Grid With Three Different Colors 🎯

**🔗 LeetCode Link:** [1931. Painting a Grid With Three Different Colors](https://leetcode.com/problems/painting-a-grid-with-three-different-colors/description/)

---

## 🧩 Problem Description

<p>You are given two integers <code>m</code> and <code>n</code>. Consider an <code>m x n</code> grid where each cell is initially white. You can paint each cell <strong>red</strong>, <strong>green</strong>, or <strong>blue</strong>. All cells <strong>must</strong> be painted.</p>

<p>Return<em> the number of ways to color the grid with <strong>no two adjacent cells having the same color</strong></em>. Since the answer can be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Dynamic Programming
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/colorthegrid.png" style="width: 200px; height: 50px;">
<pre><strong>Input:</strong> m = 1, n = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong> The three possible colorings are shown in the image above.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/copy-of-colorthegrid.png" style="width: 321px; height: 121px;">
<pre><strong>Input:</strong> m = 1, n = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> The six possible colorings are shown in the image above.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre><strong>Input:</strong> m = 5, n = 5
<strong>Output:</strong> 580986
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= m &lt;= 5</code></li>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int colorTheGrid(int m, int n) {
        final int mod = 1_000_000_007;
        int total = 1;
        for (int i = 0; i < m; i++) total *= 3;
        int[][] dp = new int[n+1][total];
        int[][] rowValid = new int[total][total];
        List<Integer> good = new ArrayList<>();
        List<Integer>[] pattern = new ArrayList[total];
        for (int i = 0; i < total; i++) pattern[i] = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            int val = i, valid = 1;
            for (int j = 0; j < m; j++) {
                pattern[i].add(val % 3);
                val /= 3;
            }
            for (int j = 1; j < m; j++) if (pattern[i].get(j).equals(pattern[i].get(j-1))) valid = 0;
            if (valid == 1) good.add(i);
        }
        for (int i : good) dp[1][i] = 1;
        for (int i : good) {
            for (int j : good) {
                rowValid[i][j] = 1;
                for (int k = 0; k < m; k++) if (pattern[i].get(k).equals(pattern[j].get(k))) rowValid[i][j] = 0;
            }
        }
        for (int col = 2; col <= n; col++) {
            for (int i : good) {
                long sum = 0;
                for (int j : good) if (rowValid[i][j] == 1) sum += dp[col-1][j];
                dp[col][i] = (int)(sum % mod);
            }
        }
        long ans = 0;
        for (int i = 0; i < total; i++) ans += dp[n][i];
        return (int)(ans % mod);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<pre><strong>Input:</strong> m = 1, n = 1
<strong>Output:</strong> 3
</pre>

<p><strong class="example">


