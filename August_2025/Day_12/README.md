# 📌 Day 12: 2787. Ways to Express an Integer as Sum of Powers 🎯

**🔗 LeetCode Link:** [2787. Ways to Express an Integer as Sum of Powers](https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/)

---

## 🧩 Problem Description

<p>Given two <strong>positive</strong> integers <code>n</code> and <code>x</code>.</p>

<p>Return <em>the number of ways </em><code>n</code><em> can be expressed as the sum of the </em><code>x<sup>th</sup></code><em> power of <strong>unique</strong> positive integers, in other words, the number of sets of unique integers </em><code>[n<sub>1</sub>, n<sub>2</sub>, ..., n<sub>k</sub>]</code><em> where </em><code>n = n<sub>1</sub><sup>x</sup> + n<sub>2</sub><sup>x</sup> + ... + n<sub>k</sub><sup>x</sup></code><em>.</em></p>

<p>Since the result can be very large, return it modulo <code>10<sup>9</sup> + 7</code>.</p>

<p>For example, if <code>n = 160</code> and <code>x = 3</code>, one way to express <code>n</code> is <code>n = 2<sup>3</sup> + 3<sup>3</sup> + 5<sup>3</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Dynamic Programming
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, x = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> We can express n as the following: n = 3<sup>2</sup> + 1<sup>2</sup> = 10.
It can be shown that it is the only way to express 10 as the sum of the 2<sup>nd</sup> power of unique integers.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 4, x = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can express n in the following ways:
- n = 4<sup>1</sup> = 4.
- n = 3<sup>1</sup> + 1<sup>1</sup> = 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>1 &lt;= x &lt;= 5</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1; 
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int power = (int) Math.pow(i, x);
            for (int sum = n; sum >= power; sum--) {
            dp[sum] = (dp[sum] + dp[sum - power]) % MOD;
            }
        } return (int) dp[n];
    }
}

```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, x = 2
<strong>Output:</strong> 1
</pre>

<p><strong class="example">


