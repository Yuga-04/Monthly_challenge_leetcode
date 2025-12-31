# 📌 Day 10: 869. Reordered Power of 2 🎯

**🔗 LeetCode Link:** [869. Reordered Power of 2](https://leetcode.com/problems/reordered-power-of-2/)

---

## 🧩 Problem Description

<p>You are given an integer <code>n</code>. We reorder the digits in any order (including the original order) such that the leading digit is not zero.</p>

<p>Return <code>true</code> <em>if and only if we can do this so that the resulting number is a power of two</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Hash Table
- Math
- Sorting
- Counting
- Enumeration
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    // Count digit frequencies of a non-negative integer n
    private int[] digitFreq(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        return freq;
    }

    // Compare two frequency arrays (length 10)
    private boolean equalFreq(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public boolean reorderedPowerOf2(int N) {
        int[] target = digitFreq(N);

        // Check all powers of two up to 2^30 (fits in 32-bit signed int ie till limit ie 10^9)
        for (int i = 0; i <= 30; i++) {
            int powerof2 = (int) Math.pow(2, i); // 2^i
            if (equalFreq(target, digitFreq(powerof2)))
                return true;
        }
        return false;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>

<p><strong class="example">


