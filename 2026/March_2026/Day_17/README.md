# 📌 Day 17: 1727. Largest Submatrix With Rearrangements 🎯

**🔗 LeetCode Link:** [1727. Largest Submatrix With Rearrangements](https://leetcode.com/problems/largest-submatrix-with-rearrangements/)

---

## 🧩 Problem Description

<p>You are given a binary matrix <code>matrix</code> of size <code>m x n</code>, and you are allowed to rearrange the <strong>columns</strong> of the <code>matrix</code> in any order.</p>

<p>Return <em>the area of the largest submatrix within </em><code>matrix</code><em> where <strong>every</strong> element of the submatrix is </em><code>1</code><em> after reordering the columns optimally.</em></p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Greedy
- Sorting
- Matrix
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/29/screenshot-2020-12-30-at-40536-pm.png" style="width: 500px; height: 240px;" />
<pre>
<strong>Input:</strong> matrix = [[0,0,1],[1,1,1],[1,0,1]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/29/screenshot-2020-12-30-at-40852-pm.png" style="width: 500px; height: 62px;" />
<pre>
<strong>Input:</strong> matrix = [[1,0,1,0,1]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 3.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[1,1,0],[1,0,1]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>matrix[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max_area = 0;
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == 1 && i > 0) {
        			matrix[i][j] = matrix[i - 1][j] + 1;
        		}
        	} 
        	
        	int[] heights = matrix[i].clone();
        	
        	Arrays.sort(heights);
        	
        	for (int j = n - 1; j >= 0; j--) {
        		if (heights[j] == 0) break;
        		
        		int width = n - j;
        		int height = heights[j];
        		
        		max_area = Math.max(max_area, width * height);
        	}
        }
        
       return max_area;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/29/screenshot-2020-12-30-at-40536-pm.png" style="width: 500px; height: 240px;" />
<pre>
<strong>Input:</strong> matrix = [[0,0,1],[1,1,1],[1,0,1]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
</pre>

<p><strong class="example">


