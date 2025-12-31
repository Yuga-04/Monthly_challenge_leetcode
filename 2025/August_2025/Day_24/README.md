# 📌 Day 24: 1493. Longest Subarray of 1's After Deleting One Element 🎯

**🔗 LeetCode Link:** [1493. Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)

---

## 🧩 Problem Description

<p>Given a binary array <code>nums</code>, you should delete one element from it.</p>

<p>Return <em>the size of the longest non-empty subarray containing only </em><code>1</code><em>&#39;s in the resulting array</em>. Return <code>0</code> if there is no such subarray.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
- Sliding Window
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,0,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1&#39;s.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1,1,0,1,1,0,1]
<strong>Output:</strong> 5
<strong>Explanation:</strong> After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1&#39;s is [1,1,1,1,1].
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You must delete one element.
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
    public int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, res = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            
            while (zeros > 1) {
                if (nums[left] == 0) zeros--;
                left++;
            }
            
            res = Math.max(res, right - left);
        }
        
        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,0,1]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">


