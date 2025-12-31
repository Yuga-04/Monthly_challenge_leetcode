# 📌 Day 25: 1015. Smallest Integer Divisible by K 🎯

**🔗 LeetCode Link:** [1015. Smallest Integer Divisible by K](https://leetcode.com/problems/smallest-integer-divisible-by-k/)

---

## 🧩 Problem Description

<p>Given a positive integer <code>k</code>, you need to find the <strong>length</strong> of the <strong>smallest</strong> positive integer <code>n</code> such that <code>n</code> is divisible by <code>k</code>, and <code>n</code> only contains the digit <code>1</code>.</p>

<p>Return <em>the <strong>length</strong> of </em><code>n</code>. If there is no such <code>n</code>, return -1.</p>

<p><strong>Note:</strong> <code>n</code> may not fit in a 64-bit signed integer.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Hash Table
- Math
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 1
<strong>Output:</strong> 1
<strong>Explanation:</strong> The smallest answer is n = 1, which has length 1.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 2
<strong>Output:</strong> -1
<strong>Explanation:</strong> There is no such positive integer n divisible by 2.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> The smallest answer is n = 111, which has length 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0)
            return -1;

        int rem = 0;
        for (int len = 1; len <= k; len++) {
            rem = (rem * 10 + 1) % k;
            if (rem == 0)
                return len;
        }
        return -1;
    }

}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 1
<strong>Output:</strong> 1
<strong>Explanation:</strong> The smallest answer is n = 1, which has length 1.
</pre>

<p><strong class="example">


