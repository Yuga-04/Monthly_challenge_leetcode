# 📌 Day 6: 3578. Count Partitions With Max-Min Difference at Most K 🎯

**🔗 LeetCode Link:** [3578. Count Partitions With Max-Min Difference at Most K](https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>. Your task is to partition <code>nums</code> into one or more <strong>non-empty</strong> contiguous segments such that in each segment, the difference between its <strong>maximum</strong> and <strong>minimum</strong> elements is <strong>at most</strong> <code>k</code>.</p>

<p>Return the total number of ways to partition <code>nums</code> under this condition.</p>

<p>Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
- Queue
- Sliding Window
- Prefix Sum
- Monotonic Queue
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [9,4,1,3,7], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<p>There are 6 valid partitions where the difference between the maximum and minimum elements in each segment is at most <code>k = 4</code>:</p>

<ul>
	<li><code>[[9], [4], [1], [3], [7]]</code></li>
	<li><code>[[9], [4], [1], [3, 7]]</code></li>
	<li><code>[[9], [4], [1, 3], [7]]</code></li>
	<li><code>[[9], [4, 1], [3], [7]]</code></li>
	<li><code>[[9], [4, 1], [3, 7]]</code></li>
	<li><code>[[9], [4, 1, 3], [7]]</code></li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,3,4], k = 0</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>There are 2 valid partitions that satisfy the given conditions:</p>

<ul>
	<li><code>[[3], [3], [4]]</code></li>
	<li><code>[[3, 3], [4]]</code></li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length, MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        java.util.Deque<Integer> mx = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> mn = new java.util.ArrayDeque<>();
        long sum = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[r]) mx.pollLast();
            while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[r]) mn.pollLast();
            mx.add(r);
            mn.add(r);

            while (nums[mx.peek()] - nums[mn.peek()] > k) {
                if (mx.peek() == l) mx.poll();
                if (mn.peek() == l) mn.poll();
                sum = (sum - dp[l] + MOD) % MOD;
                l++;
            }

            sum = (sum + dp[r]) % MOD;
            dp[r + 1] = sum;
        }
        return (int) dp[n];
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [9,4,1,3,7], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<p>There are 6 valid partitions where the difference between the maximum and minimum elements in each segment is at most <code>k = 4</code>:</p>

<ul>
	<li><code>[[9], [4], [1], [3], [7]]</code></li>
	<li><code>[[9], [4], [1], [3, 7]]</code></li>
	<li><code>[[9], [4], [1, 3], [7]]</code></li>
	<li><code>[[9], [4, 1], [3], [7]]</code></li>
	<li><code>[[9], [4, 1], [3, 7]]</code></li>
	<li><code>[[9], [4, 1, 3], [7]]</code></li>
</ul>
</div>

<p><strong class="example">


