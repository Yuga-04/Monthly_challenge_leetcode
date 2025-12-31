# 📌 Day 20: 1277. Count Square Submatrices with All Ones 🎯

**🔗 LeetCode Link:** [1277. Count Square Submatrices with All Ones](https://leetcode.com/problems/count-square-submatrices-with-all-ones/)

---

## 🧩 Problem Description

<p>Given a <code>m * n</code> matrix of ones and zeros, return how many <strong>square</strong> submatrices have all ones.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
- Matrix
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> matrix =
[
&nbsp; [0,1,1,1],
&nbsp; [1,1,1,1],
&nbsp; [0,1,1,1]
]
<strong>Output:</strong> 15
<strong>Explanation:</strong> 
There are <strong>10</strong> squares of side 1.
There are <strong>4</strong> squares of side 2.
There is  <strong>1</strong> square of side 3.
Total number of squares = 10 + 4 + 1 = <strong>15</strong>.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
<strong>Output:</strong> 7
<strong>Explanation:</strong> 
There are <b>6</b> squares of side 1.  
There is <strong>1</strong> square of side 2. 
Total number of squares = 6 + 1 = <b>7</b>.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length&nbsp;&lt;= 300</code></li>
	<li><code>1 &lt;= arr[0].length&nbsp;&lt;= 300</code></li>
	<li><code>0 &lt;= arr[i][j] &lt;= 1</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int cnt = 0;
        int[][] dp = new int[n][m];

        // Initialize first column
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }
        // Initialize first row
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                    Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // Count all squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += dp[i][j];
            }
        }

        return cnt;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> matrix =
[
&nbsp; [0,1,1,1],
&nbsp; [1,1,1,1],
&nbsp; [0,1,1,1]
]
<strong>Output:</strong> 15
</pre>

<p><strong class="example">


