# 📌 Day 11: 1550. Three Consecutive Odds 🎯

**🔗 LeetCode Link:** [1550. Three Consecutive Odds](https://leetcode.com/problems/three-consecutive-odds/description/)

---

## 🧩 Problem Description

Given an integer array <code>arr</code>, return <code>true</code>&nbsp;if there are three consecutive odd numbers in the array. Otherwise, return&nbsp;<code>false</code>.
<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [2,6,4,1]
<strong>Output:</strong> false
<b>Explanation:</b> There are no three consecutive odds.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [1,2,34,3,4,5,7,23,12]
<strong>Output:</strong> true
<b>Explanation:</b> [5,7,23] are three consecutive odds.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if ((arr[i] % 2 != 0) && (arr[i+1] % 2 != 0) && (arr[i+2] % 2 != 0))
                return true;
        }
        return false;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [2,6,4,1]
<strong>Output:</strong> false
</pre>
<p><strong class="example">


