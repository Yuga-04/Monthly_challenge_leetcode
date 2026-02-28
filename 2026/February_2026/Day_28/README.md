# 📌 Day 28: 1680. Concatenation of Consecutive Binary Numbers 🎯

**🔗 LeetCode Link:** [1680. Concatenation of Consecutive Binary Numbers](https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/)

---

## 🧩 Problem Description

<p>Given an integer <code>n</code>, return <em>the <strong>decimal value</strong> of the binary string formed by concatenating the binary representations of </em><code>1</code><em> to </em><code>n</code><em> in order, <strong>modulo </strong></em><code>10<sup>9 </sup>+ 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Bit Manipulation
- Simulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
<strong>Explanation: </strong>&quot;1&quot; in binary corresponds to the decimal value 1. 
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 27
<strong>Explanation: </strong>In binary, 1, 2, and 3 corresponds to &quot;1&quot;, &quot;10&quot;, and &quot;11&quot;.
After concatenating them, we have &quot;11011&quot;, which corresponds to the decimal value 27.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 12
<strong>Output:</strong> 505379714
<strong>Explanation</strong>: The concatenation results in &quot;1101110010111011110001001101010111100&quot;.
The decimal value of that is 118505380540.
After modulo 10<sup>9</sup> + 7, the result is 505379714.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
  public int concatenatedBinary(int n) {
    final int MOD = 1_000_000_007;
    long ans = 0;

    for (int i = 1; i <= n; ++i)
      ans = ((ans << numberOfBits(i)) % MOD + i) % MOD;

    return (int) ans;
  }

  private int numberOfBits(int n) {
    return (int) (Math.log(n) / Math.log(2)) + 1;
  }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
<strong>Explanation: </strong>&quot;1&quot; in binary corresponds to the decimal value 1. 
</pre>

<p><strong class="example">


