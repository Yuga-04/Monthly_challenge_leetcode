# 📌 Day 12: 2654. Minimum Number of Operations to Make All Array Elements Equal to 1 🎯

**🔗 LeetCode Link:** [2654. Minimum Number of Operations to Make All Array Elements Equal to 1](https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/)

---

## 🧩 Problem Description

<p>You are given a <strong>0-indexed</strong>&nbsp;array <code>nums</code> consisiting of <strong>positive</strong> integers. You can do the following operation on the array <strong>any</strong> number of times:</p>

<ul>
	<li>Select an index <code>i</code> such that <code>0 &lt;= i &lt; n - 1</code> and replace either of&nbsp;<code>nums[i]</code> or <code>nums[i+1]</code> with their gcd value.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of operations to make all elements of </em><code>nums</code><em> equal to </em><code>1</code>. If it is impossible, return <code>-1</code>.</p>

<p>The gcd of two integers is the greatest common divisor of the two integers.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
- Number Theory
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,6,3,4]
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can do the following operations:
- Choose index i = 2 and replace nums[2] with gcd(3,4) = 1. Now we have nums = [2,6,1,4].
- Choose index i = 1 and replace nums[1] with gcd(6,1) = 1. Now we have nums = [2,1,1,4].
- Choose index i = 0 and replace nums[0] with gcd(2,1) = 1. Now we have nums = [1,1,1,4].
- Choose index i = 2 and replace nums[3] with gcd(1,4) = 1. Now we have nums = [1,1,1,1].
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,10,6,14]
<strong>Output:</strong> -1
<strong>Explanation:</strong> It can be shown that it is impossible to make all the elements equal to 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minOperations(int[] nums) {
        int gcd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int ans = 0;
                for (int x : nums) {
                    if (x != 1) ans++;
                }
                return ans;
            }
            if (i < nums.length - 1)
                gcd = gcd(gcd, nums[i + 1]);
        }

        if (gcd != 1) return -1;

        int ans = (int) 1e9;
        for (int i = 0; i < nums.length; i++) {
            int g = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    ans = Math.min(ans, j - i - 1 + nums.length);
                    break;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,6,3,4]
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can do the following operations:
- Choose index i = 2 and replace nums[2] with gcd(3,4) = 1. Now we have nums = [2,6,1,4].
- Choose index i = 1 and replace nums[1] with gcd(6,1) = 1. Now we have nums = [2,1,1,4].
- Choose index i = 0 and replace nums[0] with gcd(2,1) = 1. Now we have nums = [1,1,1,4].
- Choose index i = 2 and replace nums[3] with gcd(1,4) = 1. Now we have nums = [1,1,1,1].
</pre>

<p><strong class="example">


