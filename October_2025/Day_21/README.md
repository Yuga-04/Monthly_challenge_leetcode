# 📌 Day 21: 3346. Maximum Frequency of an Element After Performing Operations I 🎯

**🔗 LeetCode Link:** [3346. Maximum Frequency of an Element After Performing Operations I](https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code> and two integers <code>k</code> and <code>numOperations</code>.</p>

<p>You must perform an <strong>operation</strong> <code>numOperations</code> times on <code>nums</code>, where in each operation you:</p>

<ul>
	<li>Select an index <code>i</code> that was <strong>not</strong> selected in any previous operations.</li>
	<li>Add an integer in the range <code>[-k, k]</code> to <code>nums[i]</code>.</li>
</ul>

<p>Return the <strong>maximum</strong> possible <span data-keyword="frequency-array">frequency</span> of any element in <code>nums</code> after performing the <strong>operations</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Binary Search
- Sliding Window
- Sorting
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,4,5], k = 1, numOperations = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>We can achieve a maximum frequency of two by:</p>

<ul>
	<li>Adding 0 to <code>nums[1]</code>. <code>nums</code> becomes <code>[1, 4, 5]</code>.</li>
	<li>Adding -1 to <code>nums[2]</code>. <code>nums</code> becomes <code>[1, 4, 4]</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [5,11,20,20], k = 5, numOperations = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>We can achieve a maximum frequency of two by:</p>

<ul>
	<li>Adding 0 to <code>nums[1]</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= numOperations &lt;= nums.length</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int maxFrequency(int[] nums, int k, int ops) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int n = mx + k + 2;
        int[] f = new int[n];
        for (int x : nums) f[x]++;

        int[] pre = new int[n];
        pre[0] = f[0];
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + f[i];

        int ans = 0;
        for (int t = 0; t < n; t++) {
            if (f[t] == 0 && ops == 0) continue;
            int l = Math.max(0, t - k), r = Math.min(n - 1, t + k);
            int tot = pre[r] - (l > 0 ? pre[l - 1] : 0);
            int adj = tot - f[t];
            int val = f[t] + Math.min(ops, adj);
            ans = Math.max(ans, val);
        }
        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,4,5], k = 1, numOperations = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>We can achieve a maximum frequency of two by:</p>

<ul>
	<li>Adding 0 to <code>nums[1]</code>. <code>nums</code> becomes <code>[1, 4, 5]</code>.</li>
	<li>Adding -1 to <code>nums[2]</code>. <code>nums</code> becomes <code>[1, 4, 4]</code>.</li>
</ul>
</div>

<p><strong class="example">


