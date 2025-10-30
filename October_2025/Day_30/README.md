# 📌 Day 30: 1526. Minimum Number of Increments on Subarrays to Form a Target Array 🎯

**🔗 LeetCode Link:** [1526. Minimum Number of Increments on Subarrays to Form a Target Array](https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>target</code>. You have an integer array <code>initial</code> of the same size as <code>target</code> with all elements initially zeros.</p>

<p>In one operation you can choose <strong>any</strong> subarray from <code>initial</code> and increment each value by one.</p>

<p>Return <em>the minimum number of operations to form a </em><code>target</code><em> array from </em><code>initial</code>.</p>

<p>The test cases are generated so that the answer fits in a 32-bit integer.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
- Stack
- Greedy
- Monotonic Stack
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> target = [1,2,3,2,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We need at least 3 operations to form the target array from the initial array.
[<strong><u>0,0,0,0,0</u></strong>] increment 1 from index 0 to 4 (inclusive).
[1,<strong><u>1,1,1</u></strong>,1] increment 1 from index 1 to 3 (inclusive).
[1,2,<strong><u>2</u></strong>,2,1] increment 1 at index 2.
[1,2,3,2,1] target array is formed.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> target = [3,1,1,2]
<strong>Output:</strong> 4
<strong>Explanation:</strong> [<strong><u>0,0,0,0</u></strong>] -&gt; [1,1,1,<strong><u>1</u></strong>] -&gt; [<strong><u>1</u></strong>,1,1,2] -&gt; [<strong><u>2</u></strong>,1,1,2] -&gt; [3,1,1,2]
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> target = [3,1,5,4,2]
<strong>Output:</strong> 7
<strong>Explanation:</strong> [<strong><u>0,0,0,0,0</u></strong>] -&gt; [<strong><u>1</u></strong>,1,1,1,1] -&gt; [<strong><u>2</u></strong>,1,1,1,1] -&gt; [3,1,<strong><u>1,1,1</u></strong>] -&gt; [3,1,<strong><u>2,2</u></strong>,2] -&gt; [3,1,<strong><u>3,3</u></strong>,2] -&gt; [3,1,<strong><u>4</u></strong>,4,2] -&gt; [3,1,5,4,2].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= target.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= target[i] &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minNumberOperations(int[] target) {
        if (target == null || target.length == 0) return 0;
        int n = target.length;
        long ans = target[0];
        for (int i = 1; i < n; i++) {
            if (target[i] > target[i - 1]) {
                ans += (long)(target[i] - target[i - 1]);
            }
        }
        return (int) ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> target = [1,2,3,2,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We need at least 3 operations to form the target array from the initial array.
[<strong><u>0,0,0,0,0</u></strong>] increment 1 from index 0 to 4 (inclusive).
[1,<strong><u>1,1,1</u></strong>,1] increment 1 from index 1 to 3 (inclusive).
[1,2,<strong><u>2</u></strong>,2,1] increment 1 at index 2.
[1,2,3,2,1] target array is formed.
</pre>

<p><strong class="example">


