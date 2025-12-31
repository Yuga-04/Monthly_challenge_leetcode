# 📌 Day 28: 3354. Make Array Elements Equal to Zero 🎯

**🔗 LeetCode Link:** [3354. Make Array Elements Equal to Zero](https://leetcode.com/problems/make-array-elements-equal-to-zero/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code>.</p>

<p>Start by selecting a starting position <code>curr</code> such that <code>nums[curr] == 0</code>, and choose a movement <strong>direction</strong> of&nbsp;either left or right.</p>

<p>After that, you repeat the following process:</p>

<ul>
	<li>If <code>curr</code> is out of the range <code>[0, n - 1]</code>, this process ends.</li>
	<li>If <code>nums[curr] == 0</code>, move in the current direction by <strong>incrementing</strong> <code>curr</code> if you are moving right, or <strong>decrementing</strong> <code>curr</code> if you are moving left.</li>
	<li>Else if <code>nums[curr] &gt; 0</code>:
	<ul>
		<li>Decrement <code>nums[curr]</code> by 1.</li>
		<li><strong>Reverse</strong>&nbsp;your movement direction (left becomes right and vice versa).</li>
		<li>Take a step in your new direction.</li>
	</ul>
	</li>
</ul>

<p>A selection of the initial position <code>curr</code> and movement direction is considered <strong>valid</strong> if every element in <code>nums</code> becomes 0 by the end of the process.</p>

<p>Return the number of possible <strong>valid</strong> selections.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Simulation
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,0,2,0,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The only possible valid selections are the following:</p>

<ul>
	<li>Choose <code>curr = 3</code>, and a movement direction to the left.

	<ul>
		<li><code>[1,0,2,<strong><u>0</u></strong>,3] -&gt; [1,0,<strong><u>2</u></strong>,0,3] -&gt; [1,0,1,<strong><u>0</u></strong>,3] -&gt; [1,0,1,0,<strong><u>3</u></strong>] -&gt; [1,0,1,<strong><u>0</u></strong>,2] -&gt; [1,0,<strong><u>1</u></strong>,0,2] -&gt; [1,0,0,<strong><u>0</u></strong>,2] -&gt; [1,0,0,0,<strong><u>2</u></strong>] -&gt; [1,0,0,<strong><u>0</u></strong>,1] -&gt; [1,0,<strong><u>0</u></strong>,0,1] -&gt; [1,<strong><u>0</u></strong>,0,0,1] -&gt; [<strong><u>1</u></strong>,0,0,0,1] -&gt; [0,<strong><u>0</u></strong>,0,0,1] -&gt; [0,0,<strong><u>0</u></strong>,0,1] -&gt; [0,0,0,<strong><u>0</u></strong>,1] -&gt; [0,0,0,0,<strong><u>1</u></strong>] -&gt; [0,0,0,0,0]</code>.</li>
	</ul>
	</li>
	<li>Choose <code>curr = 3</code>, and a movement direction to the right.
	<ul>
		<li><code>[1,0,2,<strong><u>0</u></strong>,3] -&gt; [1,0,2,0,<strong><u>3</u></strong>] -&gt; [1,0,2,<strong><u>0</u></strong>,2] -&gt; [1,0,<strong><u>2</u></strong>,0,2] -&gt; [1,0,1,<strong><u>0</u></strong>,2] -&gt; [1,0,1,0,<strong><u>2</u></strong>] -&gt; [1,0,1,<strong><u>0</u></strong>,1] -&gt; [1,0,<strong><u>1</u></strong>,0,1] -&gt; [1,0,0,<strong><u>0</u></strong>,1] -&gt; [1,0,0,0,<strong><u>1</u></strong>] -&gt; [1,0,0,<strong><u>0</u></strong>,0] -&gt; [1,0,<strong><u>0</u></strong>,0,0] -&gt; [1,<strong><u>0</u></strong>,0,0,0] -&gt; [<strong><u>1</u></strong>,0,0,0,0] -&gt; [0,0,0,0,0].</code></li>
	</ul>
	</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,3,4,0,4,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>There are no possible valid selections.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
	<li>There is at least one element <code>i</code> where <code>nums[i] == 0</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] a = nums.clone();
        int curr = start;
        while (curr >= 0 && curr < n) {
            if (a[curr] == 0) {
                curr += dir;
            } else {
                a[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int v : a)
            if (v != 0)
                return false;
        return true;
    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0)
                continue;
            if (simulate(nums, i, -1))
                ans++;
            if (simulate(nums, i, +1))
                ans++;
        }
        return ans;
    }

}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,0,2,0,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The only possible valid selections are the following:</p>

<ul>
	<li>Choose <code>curr = 3</code>, and a movement direction to the left.

	<ul>
		<li><code>[1,0,2,<strong><u>0</u></strong>,3] -&gt; [1,0,<strong><u>2</u></strong>,0,3] -&gt; [1,0,1,<strong><u>0</u></strong>,3] -&gt; [1,0,1,0,<strong><u>3</u></strong>] -&gt; [1,0,1,<strong><u>0</u></strong>,2] -&gt; [1,0,<strong><u>1</u></strong>,0,2] -&gt; [1,0,0,<strong><u>0</u></strong>,2] -&gt; [1,0,0,0,<strong><u>2</u></strong>] -&gt; [1,0,0,<strong><u>0</u></strong>,1] -&gt; [1,0,<strong><u>0</u></strong>,0,1] -&gt; [1,<strong><u>0</u></strong>,0,0,1] -&gt; [<strong><u>1</u></strong>,0,0,0,1] -&gt; [0,<strong><u>0</u></strong>,0,0,1] -&gt; [0,0,<strong><u>0</u></strong>,0,1] -&gt; [0,0,0,<strong><u>0</u></strong>,1] -&gt; [0,0,0,0,<strong><u>1</u></strong>] -&gt; [0,0,0,0,0]</code>.</li>
	</ul>
	</li>
	<li>Choose <code>curr = 3</code>, and a movement direction to the right.
	<ul>
		<li><code>[1,0,2,<strong><u>0</u></strong>,3] -&gt; [1,0,2,0,<strong><u>3</u></strong>] -&gt; [1,0,2,<strong><u>0</u></strong>,2] -&gt; [1,0,<strong><u>2</u></strong>,0,2] -&gt; [1,0,1,<strong><u>0</u></strong>,2] -&gt; [1,0,1,0,<strong><u>2</u></strong>] -&gt; [1,0,1,<strong><u>0</u></strong>,1] -&gt; [1,0,<strong><u>1</u></strong>,0,1] -&gt; [1,0,0,<strong><u>0</u></strong>,1] -&gt; [1,0,0,0,<strong><u>1</u></strong>] -&gt; [1,0,0,<strong><u>0</u></strong>,0] -&gt; [1,0,<strong><u>0</u></strong>,0,0] -&gt; [1,<strong><u>0</u></strong>,0,0,0] -&gt; [<strong><u>1</u></strong>,0,0,0,0] -&gt; [0,0,0,0,0].</code></li>
	</ul>
	</li>
</ul>
</div>

<p><strong class="example">


