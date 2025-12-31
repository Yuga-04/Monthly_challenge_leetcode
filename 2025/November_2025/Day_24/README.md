# 📌 Day 24: 1018. Binary Prefix Divisible By 5 🎯

**🔗 LeetCode Link:** [1018. Binary Prefix Divisible By 5](https://leetcode.com/problems/binary-prefix-divisible-by-5)

---

## 🧩 Problem Description

<p>You are given a binary array <code>nums</code> (<strong>0-indexed</strong>).</p>

<p>We define <code>x<sub>i</sub></code> as the number whose binary representation is the subarray <code>nums[0..i]</code> (from most-significant-bit to least-significant-bit).</p>

<ul>
	<li>For example, if <code>nums = [1,0,1]</code>, then <code>x<sub>0</sub> = 1</code>, <code>x<sub>1</sub> = 2</code>, and <code>x<sub>2</sub> = 5</code>.</li>
</ul>

<p>Return <em>an array of booleans </em><code>answer</code><em> where </em><code>answer[i]</code><em> is </em><code>true</code><em> if </em><code>x<sub>i</sub></code><em> is divisible by </em><code>5</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Bit Manipulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1]
<strong>Output:</strong> [true,false,false]
<strong>Explanation:</strong> The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
Only the first number is divisible by 5, so answer[0] is true.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1]
<strong>Output:</strong> [false,false,false]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>(nums.length);
        int cur = 0;

        for (int bit : nums) {
            cur = ((cur << 1) + bit) % 5;
            res.add(cur == 0);
        }

        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1]
<strong>Output:</strong> [true,false,false]
<strong>Explanation:</strong> The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
Only the first number is divisible by 5, so answer[0] is true.
</pre>

<p><strong class="example">


