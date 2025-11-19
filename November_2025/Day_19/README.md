# 📌 Day 19: 2154. Keep Multiplying Found Values by Two 🎯

**🔗 LeetCode Link:** [2154. Keep Multiplying Found Values by Two](https://leetcode.com/problems/keep-multiplying-found-values-by-two/)

---

## 🧩 Problem Description

<p>You are given an array of integers <code>nums</code>. You are also given an integer <code>original</code> which is the first number that needs to be searched for in <code>nums</code>.</p>

<p>You then do the following steps:</p>

<ol>
	<li>If <code>original</code> is found in <code>nums</code>, <strong>multiply</strong> it by two (i.e., set <code>original = 2 * original</code>).</li>
	<li>Otherwise, <strong>stop</strong> the process.</li>
	<li><strong>Repeat</strong> this process with the new number as long as you keep finding the number.</li>
</ol>

<p>Return <em>the <strong>final</strong> value of </em><code>original</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Sorting
- Simulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,3,6,1,12], original = 3
<strong>Output:</strong> 24
<strong>Explanation:</strong> 
- 3 is found in nums. 3 is multiplied by 2 to obtain 6.
- 6 is found in nums. 6 is multiplied by 2 to obtain 12.
- 12 is found in nums. 12 is multiplied by 2 to obtain 24.
- 24 is not found in nums. Thus, 24 is returned.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,7,9], original = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong>
- 4 is not found in nums. Thus, 4 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i], original &lt;= 1000</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] memo = new boolean[1001];
        
        for (int x : nums) {
            if (x <= 1000) memo[x] = true;
        }

        int x = original;
        while (x <= 1000) {
            if (memo[x]) x *= 2;
            else break;
        }

        return x;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,3,6,1,12], original = 3
<strong>Output:</strong> 24
<strong>Explanation:</strong> 
- 3 is found in nums. 3 is multiplied by 2 to obtain 6.
- 6 is found in nums. 6 is multiplied by 2 to obtain 12.
- 12 is found in nums. 12 is multiplied by 2 to obtain 24.
- 24 is not found in nums. Thus, 24 is returned.
</pre>

<p><strong class="example">


