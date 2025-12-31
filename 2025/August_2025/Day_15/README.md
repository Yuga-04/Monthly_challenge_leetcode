# 📌 Day 15: Unknown. Power of Four 🎯

**🔗 LeetCode Link:** [Unknown. Power of Four](https://leetcode.com/problems/power-of-four/)

---

## 🧩 Problem Description

<p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of four. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of four, if there exists an integer <code>x</code> such that <code>n == 4<sup>x</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Bit Manipulation
- Recursion
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<pre><strong>Input:</strong> n = 16
<strong>Output:</strong> true
</pre><p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> false
</pre><p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it without loops/recursion?

---

## ✅ Code (Java)

```java
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) n /= 4;
        return n == 1;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<pre><strong>Input:</strong> n = 16
<strong>Output:</strong> true
</pre><p><strong class="example">


