# 📌 Day 30: 2419. Longest Subarray With Maximum Bitwise AND 🎯

**🔗 LeetCode Link:** [2419. Longest Subarray With Maximum Bitwise AND](https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code> of size <code>n</code>.</p>

<p>Consider a <strong>non-empty</strong> subarray from <code>nums</code> that has the <strong>maximum</strong> possible <strong>bitwise AND</strong>.</p>

<ul>
	<li>In other words, let <code>k</code> be the maximum value of the bitwise AND of <strong>any</strong> subarray of <code>nums</code>. Then, only subarrays with a bitwise AND equal to <code>k</code> should be considered.</li>
</ul>

<p>Return <em>the length of the <strong>longest</strong> such subarray</em>.</p>

<p>The bitwise AND of an array is the bitwise AND of all the numbers in it.</p>

<p>A <strong>subarray</strong> is a contiguous sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Bit Manipulation
- Brainteaser
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,3,2,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
The maximum possible bitwise AND of a subarray is 3.
The longest subarray with that value is [3,3], so we return 2.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The maximum possible bitwise AND of a subarray is 4.
The longest subarray with that value is [4], so we return 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 1. Find the maximum value in the array.
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        // 2. Find the length of the longest subarray of maxVal.
        int maxLen = 0;
        int currentLen = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                currentLen++;
            } else {
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 0;
            }
        }
        
        // 3. Final check for a trailing streak.
        return Math.max(maxLen, currentLen);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,3,2,2]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">


