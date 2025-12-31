# 📌 Day 8: 1925. Count Square Sum Triples 🎯

**🔗 LeetCode Link:** [1925. Count Square Sum Triples](https://leetcode.com/problems/count-square-sum-triples/)

---

## 🧩 Problem Description

<p>A <strong>square triple</strong> <code>(a,b,c)</code> is a triple where <code>a</code>, <code>b</code>, and <code>c</code> are <strong>integers</strong> and <code>a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup></code>.</p>

<p>Given an integer <code>n</code>, return <em>the number of <strong>square triples</strong> such that </em><code>1 &lt;= a, b, c &lt;= n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Enumeration
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> 2
<strong>Explanation</strong>: The square triples are (3,4,5) and (4,3,5).
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 4
<strong>Explanation</strong>: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 250</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int countTriples(int n) {
        int cnt = 0;
        // Iterate a from 1 to n
        for (int a = 1; a < n; a++) {
            // Iterate b from a + 1 to n to avoid duplicates in loop logic
            for (int b = a + 1; b < n; b++) {
                int sumSquares = a * a + b * b;
                int c = (int) Math.sqrt(sumSquares);
                
                // Check if c is a perfect square and within range
                if (c * c == sumSquares && c <= n) {
                    cnt += 2; // Count both (a, b, c) and (b, a, c)
                }
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
<strong>Input:</strong> n = 5
<strong>Output:</strong> 2
<strong>Explanation</strong>: The square triples are (3,4,5) and (4,3,5).
</pre>

<p><strong class="example">


