# 📌 Day 7: 1304. Find N Unique Integers Sum up to Zero 🎯

**🔗 LeetCode Link:** [1304. Find N Unique Integers Sum up to Zero](xhttps://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/)

---

## 🧩 Problem Description

<p>Given an integer <code>n</code>, return <strong>any</strong> array containing <code>n</code> <strong>unique</strong> integers such that they add up to <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> [-7,-1,1,3,4]
<strong>Explanation:</strong> These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> [-1,0,1]
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int[] sumZero(int n) {
        int[] a = new int[n];
        int idx = 0;

        if (n % 2 != 0) {
            a[idx++] = 0;
        }

        for (int i = 1; i <= n / 2; i++) {
            a[idx++] = i;
            a[idx++] = -i;
        }

        return a;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> [-7,-1,1,3,4]
</pre>

<p><strong class="example">


