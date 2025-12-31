# 📌 Day 27: 2894. Divisible and Non-divisible Sums Difference 🎯

**🔗 LeetCode Link:** [2894. Divisible and Non-divisible Sums Difference](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/)

---

## 🧩 Problem Description

<p>You are given positive integers <code>n</code> and <code>m</code>.</p>

<p>Define two integers as follows:</p>

<ul>
	<li><code>num1</code>: The sum of all integers in the range <code>[1, n]</code> (both <strong>inclusive</strong>) that are <strong>not divisible</strong> by <code>m</code>.</li>
	<li><code>num2</code>: The sum of all integers in the range <code>[1, n]</code> (both <strong>inclusive</strong>) that are <strong>divisible</strong> by <code>m</code>.</li>
</ul>

<p>Return <em>the integer</em> <code>num1 - num2</code>.</p>

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
<strong>Input:</strong> n = 10, m = 3
<strong>Output:</strong> 19
<strong>Explanation:</strong> In the given example:
- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
We return 37 - 18 = 19 as the answer.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 5, m = 6
<strong>Output:</strong> 15
<strong>Explanation:</strong> In the given example:
- Integers in the range [1, 5] that are not divisible by 6 are [1,2,3,4,5], num1 is the sum of those integers = 15.
- Integers in the range [1, 5] that are divisible by 6 are [], num2 is the sum of those integers = 0.
We return 15 - 0 = 15 as the answer.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 5, m = 1
<strong>Output:</strong> -15
<strong>Explanation:</strong> In the given example:
- Integers in the range [1, 5] that are not divisible by 1 are [], num1 is the sum of those integers = 0.
- Integers in the range [1, 5] that are divisible by 1 are [1,2,3,4,5], num2 is the sum of those integers = 15.
We return 0 - 15 = -15 as the answer.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n, m &lt;= 1000</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int differenceOfSums(int n, int m) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, m = 3
<strong>Output:</strong> 19
</pre>

<p><strong class="example">


