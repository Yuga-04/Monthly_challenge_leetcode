# 📌 Day 1: 118. Pascal's Triangle 🎯

**🔗 LeetCode Link:** [118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)

---

## 🧩 Problem Description

<p>Given an integer <code>numRows</code>, return the first numRows of <strong>Pascal&#39;s triangle</strong>.</p>

<p>In <strong>Pascal&#39;s triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
![Image](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)
<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<pre><strong>Input:</strong> numRows = 5
<strong>Output:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre><p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<pre><strong>Input:</strong> numRows = 1
<strong>Output:</strong> [[1]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= numRows &lt;= 30</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = triangle.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<pre><strong>Input:</strong> numRows = 5
<strong>Output:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre><p><strong class="example">


