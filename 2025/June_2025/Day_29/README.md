# 📌 Day 29: 1498. Number of Subsequences That Satisfy the Given Sum Condition 🎯

**🔗 LeetCode Link:** [1498. Number of Subsequences That Satisfy the Given Sum Condition](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)

---

## 🧩 Problem Description

<p>You are given an array of integers <code>nums</code> and an integer <code>target</code>.</p>

<p>Return <em>the number of <strong>non-empty</strong> subsequences of </em><code>nums</code><em> such that the sum of the minimum and maximum element on it is less or equal to </em><code>target</code>. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Two Pointers
- Binary Search
- Sorting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,5,6,7], target = 9
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 subsequences that satisfy the condition.
[3] -&gt; Min value + max value &lt;= target (3 + 3 &lt;= 9)
[3,5] -&gt; (3 + 5 &lt;= 9)
[3,5,6] -&gt; (3 + 6 &lt;= 9)
[3,6] -&gt; (3 + 6 &lt;= 9)
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,3,6,8], target = 10
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,3,4,6,7], target = 12
<strong>Output:</strong> 61
<strong>Explanation:</strong> There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= target &lt;= 10<sup>6</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007 , n = nums.length;
        Arrays.sort(nums);
        
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int left = 0 , right = n - 1 , result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,5,6,7], target = 9
<strong>Output:</strong> 4
</pre>

<p><strong class="example">


