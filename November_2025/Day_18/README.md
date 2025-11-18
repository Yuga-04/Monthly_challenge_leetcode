# 📌 Day 18: 717. 1-bit and 2-bit Characters 🎯

**🔗 LeetCode Link:** [717. 1-bit and 2-bit Characters](https://leetcode.com/problems/1-bit-and-2-bit-characters/)

---

## 🧩 Problem Description

<p>We have two special characters:</p>

<ul>
	<li>The first character can be represented by one bit <code>0</code>.</li>
	<li>The second character can be represented by two bits (<code>10</code> or <code>11</code>).</li>
</ul>

<p>Given a binary array <code>bits</code> that ends with <code>0</code>, return <code>true</code> if the last character must be a one-bit character.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> bits = [1,0,0]
<strong>Output:</strong> true
<strong>Explanation:</strong> The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> bits = [1,1,1,0]
<strong>Output:</strong> false
<strong>Explanation:</strong> The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= bits.length &lt;= 1000</code></li>
	<li><code>bits[i]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
   public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for (int i = 0; i < n; ++i) {
            if (i == n-1) return true;
            if (bits[i] == 1) ++i;
        }
        return false;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> bits = [1,0,0]
<strong>Output:</strong> true
<strong>Explanation:</strong> The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.
</pre>

<p><strong class="example">


