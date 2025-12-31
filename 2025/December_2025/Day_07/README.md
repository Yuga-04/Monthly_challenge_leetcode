# 📌 Day 7: 1523. Count Odd Numbers in an Interval Range 🎯

**🔗 LeetCode Link:** [1523. Count Odd Numbers in an Interval Range](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/)

---

## 🧩 Problem Description

<p>Given two non-negative integers <code>low</code> and <code><font face="monospace">high</font></code>. Return the <em>count of odd numbers between </em><code>low</code><em> and </em><code><font face="monospace">high</font></code><em>&nbsp;(inclusive)</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> low = 3, high = 7
<strong>Output:</strong> 3
<b>Explanation: </b>The odd numbers between 3 and 7 are [3,5,7].</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> low = 8, high = 10
<strong>Output:</strong> 1
<b>Explanation: </b>The odd numbers between 8 and 10 are [9].</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= low &lt;= high&nbsp;&lt;= 10^9</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> low = 3, high = 7
<strong>Output:</strong> 3
<b>Explanation: </b>The odd numbers between 3 and 7 are [3,5,7].</pre>

<p><strong class="example">


