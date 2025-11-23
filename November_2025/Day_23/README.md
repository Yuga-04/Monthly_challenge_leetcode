# 📌 Day 23: 1262. Greatest Sum Divisible by Three 🎯

**🔗 LeetCode Link:** [1262. Greatest Sum Divisible by Three](https://leetcode.com/problems/greatest-sum-divisible-by-three/)

---

## 🧩 Problem Description

<p>Given an integer array <code>nums</code>, return <em>the <strong>maximum possible sum </strong>of elements of the array such that it is divisible by three</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
- Greedy
- Sorting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,6,5,1,8]
<strong>Output:</strong> 18
<strong>Explanation:</strong> Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [4]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Since 4 is not divisible by 3, do not pick any number.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,4]
<strong>Output:</strong> 12
<strong>Explanation:</strong> Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 4 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min11 = Integer.MAX_VALUE;
        int min22 = Integer.MAX_VALUE;

        for (int x : nums) {
            sum += x;
            int r = x % 3;

            if (r == 1) {
                if (x < min1) { min11 = min1; min1 = x; }
                else if (x < min11) min11 = x;
            } 
            else if (r == 2) {
                if (x < min2) { min22 = min2; min2 = x; }
                else if (x < min22) min22 = x;
            }
        }

        int rem = sum % 3;

        if (rem == 0) return sum;

        if (rem == 1) {
            int remove1 = min1;
            int remove2 = (min2 == Integer.MAX_VALUE || min22 == Integer.MAX_VALUE)
                            ? Integer.MAX_VALUE : min2 + min22;
            int remove = Math.min(remove1, remove2);
            return (remove == Integer.MAX_VALUE) ? 0 : sum - remove;
        } 
        else {
            int remove1 = min2;
            int remove2 = (min1 == Integer.MAX_VALUE || min11 == Integer.MAX_VALUE)
                            ? Integer.MAX_VALUE : min1 + min11;
            int remove = Math.min(remove1, remove2);
            return (remove == Integer.MAX_VALUE) ? 0 : sum - remove;
        }
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,6,5,1,8]
<strong>Output:</strong> 18
<strong>Explanation:</strong> Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).</pre>

<p><strong class="example">


