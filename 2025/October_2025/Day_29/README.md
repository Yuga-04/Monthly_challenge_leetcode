# 📌 Day 29: 3370. Smallest Number With All Set Bits 🎯

**🔗 LeetCode Link:** [3370. Smallest Number With All Set Bits](https://leetcode.com/problems/smallest-number-with-all-set-bits/)

---

## 🧩 Problem Description

<p>You are given a <em>positive</em> number <code>n</code>.</p>

<p>Return the <strong>smallest</strong> number <code>x</code> <strong>greater than</strong> or <strong>equal to</strong> <code>n</code>, such that the binary representation of <code>x</code> contains only <span data-keyword="set-bit">set bits</span></p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Bit Manipulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 7 is <code>&quot;111&quot;</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 10</span></p>

<p><strong>Output:</strong> <span class="example-io">15</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 15 is <code>&quot;1111&quot;</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 3 is <code>&quot;11&quot;</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int smallestNumber(int n) {
        int x = n;
        while ((x & (x + 1)) != 0){
            x++;
        }
        
        return x;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 7 is <code>&quot;111&quot;</code>.</p>
</div>

<p><strong class="example">


