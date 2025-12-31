# 📌 Day 16: 3201. Find the Maximum Length of Valid Subsequence I 🎯

**🔗 LeetCode Link:** [3201. Find the Maximum Length of Valid Subsequence I](https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/)

---

## 🧩 Problem Description

You are given an integer array <code>nums</code>.
<p>A <span data-keyword="subsequence-array">subsequence</span> <code>sub</code> of <code>nums</code> with length <code>x</code> is called <strong>valid</strong> if it satisfies:</p>

<ul>
	<li><code>(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.</code></li>
</ul>

<p>Return the length of the <strong>longest</strong> <strong>valid</strong> subsequence of <code>nums</code>.</p>

<p>A <strong>subsequence</strong> is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The longest valid subsequence is <code>[1, 2, 3, 4]</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,1,1,2,1,2]</span></p>

<p><strong>Output:</strong> 6</p>

<p><strong>Explanation:</strong></p>

<p>The longest valid subsequence is <code>[1, 2, 1, 2, 1, 2]</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The longest valid subsequence is <code>[1, 3]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>7</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int maximumLength(int[] nums) {
        int oddCnt = 0, evenCnt = 0, cnt = 0;
        boolean flag = nums[0] % 2 == 1;

        for (int num : nums) {
            if (num % 2 == 1) {
                if (flag) {
                    flag = !flag;
                    cnt++;
                }
                oddCnt++;
            } else {
                if (!flag) {
                    flag = !flag;
                    cnt++;
                }
                evenCnt++;
            }
        }

        return Math.max(cnt, Math.max(oddCnt, evenCnt));
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

</div>

<p><strong class="example">


